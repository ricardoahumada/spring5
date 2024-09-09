package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.ProductNotFoundException;
import com.myshoppingcart.model.Producto;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Component
@Setter
@Repository("ProductoDBRepository")
public class ProductoDBRepository implements IProductoRepository {
    @Value("${db_url}")
    private String connUrl;

    @Override
    public Producto getProduct(int id) throws Exception {
        Producto prod = null;
        String sql = "SELECT p.* FROM producto p WHERE pid=?";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                // ordenes sql
                PreparedStatement pstm = conn.prepareStatement(sql);
        ) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                prod = new Producto(rs.getInt("pid"), rs.getString("codigo"), rs.getString("marca"),
                        rs.getString("tipo"), rs.getInt("precio"), rs.getInt("existencias"));
            } else {
                throw new ProductNotFoundException();
            }
        }

        return prod;
    }

    @Override
    public List<Producto> getProducts() throws Exception {
        List<Producto> listADevolver = new ArrayList<>();
        String sql = "SELECT p.* FROM producto p WHERE 1";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                // ordenes sql
                PreparedStatement pstm = conn.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
        ) {
            while (rs.next()) {
                listADevolver.add(new Producto(rs.getInt("pid"), rs.getString("codigo"), rs.getString("marca"),
                        rs.getString("tipo"), rs.getInt("precio"), rs.getInt("existencias")));
            }
        }

        return listADevolver;
    }

    @Override
    public List<Producto> getUserProducts(int uid) throws Exception {
        List<Producto> listADevolver = new ArrayList<>();
        String sql = "SELECT p.* FROM producto p INNER JOIN compra c ON c.producto=p.pid WHERE c.usuario=?";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, uid);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                listADevolver.add(new Producto(
                        rs.getInt("pid"),
                        rs.getString("codigo"),
                        rs.getString("marca"),
                        rs.getString("tipo"),
                        rs.getInt("precio"),
                        rs.getInt("existencias")
                ));
            }
        }

        return listADevolver;
    }

    @Override
    public Producto insertarProducto(Producto prod) throws Exception {
        String sql = "INSERT INTO producto (`pid`, `codigo`, `marca`, `tipo`, `precio`, `existencias`)  values (NULL,?,?,?,?,?)";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setInt(1, Integer.parseInt(prod.getCodigo()));
            stmt.setString(2, prod.getMarca());
            stmt.setString(3, prod.getTipo());
            stmt.setDouble(4, prod.getPrecio());
            stmt.setInt(5, prod.getExistencias());

            int rows = stmt.executeUpdate();

            ResultSet genKeys = stmt.getGeneratedKeys();
            if (genKeys.next()) {
                prod.setPid(genKeys.getInt(1));
            } else {
                throw new SQLException("Usuario creado erroneamente!!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return prod;
    }

    @Override
    public Producto actualizarProducto(Producto prod) throws Exception {
        String sql = "UPDATE producto set codigo=?, marca=?, tipo=?, precio=?, existencias=? WHERE pid=?";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, Integer.parseInt(prod.getCodigo()));
            stmt.setString(2, prod.getMarca());
            stmt.setString(3, prod.getTipo());
            stmt.setDouble(4, prod.getPrecio());
            stmt.setInt(5, prod.getExistencias());
            stmt.setInt(6, prod.getPid());

            int rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return prod;
    }

    @Override
    public boolean borrarProducto(Producto prod) throws Exception {
        String sql = "DELETE FROM producto WHERE pid=?";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, prod.getPid());

            int rows = stmt.executeUpdate();
            System.out.println(rows);

            if (rows <= 0) {
                throw new ProductNotFoundException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return true;
    }


}

