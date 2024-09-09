package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Usuario;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Component
@Setter
@Repository("UsuarioDBRepository")
public class UsuarioDBRepository implements IUsuarioRepository {
    @Value("${db_url}")
    private String db_url = null;


    @Override
    public boolean existeUsuario(String email, String pass) throws Exception {
        boolean existe = false;

        String sql = "SELECT * FROM usuario u WHERE u.email=? AND password=?";

        try (
                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, email);
            stmt.setString(2, pass);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println(rs);
                existe = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return existe;
    }

    @Override
    public Usuario getUsuario(String email, String pass) throws UsuarioNotFoundException, Exception {
        Usuario user = null;

        try (
                Connection conn = DriverManager.getConnection(db_url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM usuario u WHERE u.email='" + email + "' AND password='" + pass + "' LIMIT 1")
        ) {
            if (rs.next()) {
                user = new Usuario(
                        rs.getInt("uid"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getInt("interes"),
                        rs.getDouble("saldo"),
                        rs.getString("password"),
                        rs.getDate("nacimiento").toLocalDate(),
                        rs.getBoolean("activo")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return user;
    }

    public List<Usuario> getUsuarios(String iniciales) throws Exception {

        List<Usuario> users = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario u WHERE u.nombre LIKE ?");
        ) {

            stmt.setString(1, "%" + iniciales + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                users.add(
                        new Usuario(
                                rs.getInt("uid"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getString("email"),
                                rs.getInt("interes"),
                                rs.getDouble("saldo"),
                                rs.getString("password"),
                                rs.getDate("nacimiento").toLocalDate(),
                                rs.getBoolean("activo")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return users;
    }

    @Override
    public Usuario insertUsuario(Usuario nuevoUsuario) throws Exception {

        String sql = "INSERT INTO usuario values (NULL,?,?,?,?,?,?,?,?)";

        try (
                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setString(1, nuevoUsuario.getNombre());
            stmt.setString(2, nuevoUsuario.getApellido());
            stmt.setString(3, nuevoUsuario.getEmail());
            stmt.setInt(4, nuevoUsuario.getInteres());
            stmt.setDouble(5, nuevoUsuario.getSaldo());
            stmt.setString(6, nuevoUsuario.getPassword());
            stmt.setString(7, nuevoUsuario.getNacimiento().toString());
            stmt.setInt(8, nuevoUsuario.isActivo() ? 1 : 0);

            int rows = stmt.executeUpdate();

            ResultSet genKeys = stmt.getGeneratedKeys();
            if (genKeys.next()) {
                nuevoUsuario.setUid(genKeys.getInt(1));
            } else {
                throw new SQLException("Usuario creado erroneamente!!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return nuevoUsuario;
    }

    @Override
    public Usuario updateUsuario(Usuario unUsuario) throws Exception {
        String sql = "UPDATE usuario set nombre=?, apellido=?, email=?, interes=?, saldo=?, password=?, nacimiento=?, activo=? WHERE uid=?";

        try (
                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, unUsuario.getNombre());
            stmt.setString(2, unUsuario.getApellido());
            stmt.setString(3, unUsuario.getEmail());
            stmt.setInt(4, unUsuario.getInteres());
            stmt.setDouble(5, unUsuario.getSaldo());
            stmt.setString(6, unUsuario.getPassword());
            stmt.setString(7, unUsuario.getNacimiento().toString());
            stmt.setInt(8, unUsuario.isActivo() ? 1 : 0);
            stmt.setInt(9, unUsuario.getUid());

            int rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return unUsuario;
    }

    @Override
    public boolean deleteUsuario(Integer uid) throws Exception {
       String sql = "DELETE FROM usuario WHERE uid=?";

        try (
                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, uid);

            int rows = stmt.executeUpdate();
            System.out.println(rows);

            if(rows<=0){
                throw new UsuarioNotFoundException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return true;
    }
}
