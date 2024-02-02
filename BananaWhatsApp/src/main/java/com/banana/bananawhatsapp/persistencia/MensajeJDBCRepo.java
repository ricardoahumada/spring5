package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.exceptions.MensajeException;
import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class MensajeJDBCRepo implements IMensajeRepository {
    private String db_url;

    @Override
    public Mensaje crear(Mensaje mensaje) throws SQLException {
        String sql = "INSERT INTO mensaje values (NULL,?,?,?,?)";

        try (
                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            mensaje.valido();
            stmt.setString(1, mensaje.getCuerpo());
            stmt.setDate(2, Date.valueOf(mensaje.getFecha()));
            stmt.setInt(3, mensaje.getRemitente().getId());
            stmt.setInt(4, mensaje.getDestinatario().getId());

            int rows = stmt.executeUpdate();

            ResultSet genKeys = stmt.getGeneratedKeys();
            if (genKeys.next()) {
                mensaje.setId(genKeys.getInt(1));
            } else {
                throw new MensajeException("No asignado");
            }
        } catch (MensajeException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
        return mensaje;
    }

    @Override
    public List<Mensaje> obtener(Usuario usuario) throws SQLException {
        List<Mensaje> messageList = null;
        String sql = "SELECT * FROM mensaje m WHERE m.from_user=? OR m.to_user=?";

        try (
                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            usuario.valido();
            stmt.setInt(1, usuario.getId());
            stmt.setInt(2, usuario.getId());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                messageList.add(
                        new Mensaje(
                                rs.getInt("id"),
                                new Usuario(rs.getInt("from_user"), null, null, null, true),
                                new Usuario(rs.getInt("to_user"), null, null, null, true),
                                rs.getString("cuerpo"),
                                rs.getDate("fecha").toLocalDate()
                        )
                );
            }

        } catch (UsuarioException e) {
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
        return messageList;
    }

    @Override
    public boolean borrarEntre(Usuario remitente, Usuario destinatario) throws Exception {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(db_url);
            conn.setAutoCommit(false);

            remitente.valido();
            destinatario.valido();
            List<Mensaje> messageList = new ArrayList<>();
            String sql = "DELETE FROM mensaje m WHERE (m.from_user=? AND m.to_user=?) OR (m.from_user=? AND m.to_user=?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, remitente.getId());
            stmt.setInt(2, destinatario.getId());
            stmt.setInt(3, destinatario.getId());
            stmt.setInt(4, remitente.getId());

            ResultSet rs = stmt.executeQuery();

            conn.commit();

        } catch (MensajeException e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) conn.close();
        }
        return true;
    }

    @Override
    public boolean borrarTodos(Usuario usuario) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(db_url);
            conn.setAutoCommit(false);

            String sql = "DELETE FROM mensaje WHERE from_user=? OR to_user=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            stmt.setInt(2, usuario.getId());

            int rows = stmt.executeUpdate();

            stmt.close();

            conn.commit();

        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) conn.close();
        }
        return true;
    }
}
