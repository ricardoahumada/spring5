package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.ProductNotFoundException;
import com.myshoppingcart.model.Compra;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Setter
//@Component
@Repository("CompraDBRepository")
public class CompraDBRepository implements ICompraRepository {
    @Value("${db_url}")
    private String connUrl;

    @Override
    public Compra insertCompra(Compra nuevaCompra) throws Exception {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connUrl);
            conn.setAutoCommit(false);

            // OBTENEMOS EL PRODUCTO
            String sql = "SELECT * FROM producto WHERE pid = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, nuevaCompra.getProducto().getPid());

            ResultSet rs = pstm.executeQuery();
            double precio = 0;
            int existencias = 0;
            if (rs.next()) {
                precio = rs.getDouble("precio");
                existencias = rs.getInt("existencias");
            } else {
                throw new ProductNotFoundException();
            }
            pstm.close();

            // INSERTAR EN COMPRA
            sql = "INSERT INTO compra VALUES(NULL,?,?,?,?)";
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, nuevaCompra.getUsuario().getUid());
            pstm.setInt(2, nuevaCompra.getProducto().getPid());
            pstm.setInt(3, nuevaCompra.getCantidad());
            pstm.setString(4, nuevaCompra.getFecha().toString());

            int rows = pstm.executeUpdate();

            ResultSet generatedKeys = pstm.getGeneratedKeys();
            if (generatedKeys.next()) {
                nuevaCompra.setCid(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating compra failed, no ID obtained.");
            }
            pstm.close();

            System.out.println("Nueva compra:" + nuevaCompra);

            // ACTUALIZAR SALDO DE USUARIO
            sql = "UPDATE usuario u SET u.saldo = u.saldo - ? WHERE u.uid=?";
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, nuevaCompra.getCantidad() * precio);
            pstm.setInt(2, nuevaCompra.getUsuario().getUid());

            rows = pstm.executeUpdate();
            pstm.close();

            // ACTUALIZAR EXISTENCIAS DE PRODUCTO
            if (existencias < nuevaCompra.getCantidad()) {
                throw new Exception("Existencias insuficientes");
            }
            sql = "UPDATE producto p SET p.existencias=p.existencias - ? WHERE p.pid=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, nuevaCompra.getCantidad());
            pstm.setInt(2, nuevaCompra.getProducto().getPid());

            rows = pstm.executeUpdate();
            pstm.close();

            System.out.println("Transaccion exitosa!!");
            conn.commit();

        } catch (Exception e) {
            System.out.println("Transaccion rollback!!");
            conn.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) conn.close();
        }

        return nuevaCompra;
    }
}
