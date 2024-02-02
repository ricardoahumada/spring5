package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.Set;

@Setter
@Getter
public class UsuarioJDBCRepo implements IUsuarioRepository {
    private String db_url;

    @Override
    public Usuario crear(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario values (NULL,?,?,?,?)";

        try (
                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            usuario.valido();

            stmt.setBoolean(1, usuario.isActivo());
            stmt.setDate(2, Date.valueOf(usuario.getAlta()));
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getNombre());

            int rows = stmt.executeUpdate();

            ResultSet genKeys = stmt.getGeneratedKeys();
            if (genKeys.next()) {
                usuario.setId(genKeys.getInt(1));
            } else {
                throw new SQLException("No id asignado");
            }
        } catch (UsuarioException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
        return usuario;
    }

    @Override
    public Usuario actualizar(Usuario usuario) throws SQLException {
        return null;
    }

    @Override
    public boolean borrar(Usuario usuario) throws SQLException {
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

            sql = "DELETE FROM usuario WHERE id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());

            rows = stmt.executeUpdate();

            if (rows <= 0) {
                throw new UsuarioException("Usuario no existe");
            }
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

    @Override
    public Set<Usuario> obtenerPosiblesDestinatarios(Integer id, Integer max) throws SQLException {
        return null;
    }


}
