package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.List;

@Setter
@Getter
public class MensajeJDBCRepo implements IMensajeRepository {
    private String db_url;

    @Override
    public Mensaje crear(Mensaje mensaje) throws SQLException {
        return null;
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
    public boolean borrarTodos(Usuario usuario) throws SQLException {
        return false;
    }
}
