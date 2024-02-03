package com.banana.bananawhatsapp.util;

import java.sql.*;
import java.util.List;

public class DBUtil {

    private
    static String connUrl = "jdbc:mysql://localhost/bananawhatsappdb?user=bananauser&password=banana123";

    public static void reloadDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connUrl);
            conn.setAutoCommit(false);

            truncateTables(conn);
            insertUsuarios(conn);
            insertMensajes(conn);

            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    private static void truncateTables(Connection conn) throws SQLException {
        Statement stmt0 = conn.createStatement();
        stmt0.execute("SET FOREIGN_KEY_CHECKS=0");
        stmt0.close();

        List<String> truncateSqls = List.of(
                "TRUNCATE `mensaje`",
                "TRUNCATE `usuario`"
        );

        for (String aSql : truncateSqls) {
            PreparedStatement stmt = conn.prepareStatement(aSql);
            stmt.executeUpdate();
            stmt.close();
        }
        conn.commit();

    }

    private static void insertUsuarios(Connection conn) throws SQLException {
        String sql = new StringBuilder("INSERT INTO `usuario` (`id`, `activo`, `alta`, `email`, `nombre`) VALUES")
                .append("(1, 1, '2023-11-25', 'juana@j.com', 'Juana'),")
                .append("(2, 1, '2023-11-25', 'luis@l.com', 'Luis');")
                .toString();

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        conn.commit();

    }

    private static void insertMensajes(Connection conn) throws SQLException {
        String sql = new StringBuilder("INSERT INTO `mensaje` (`id`, `cuerpo`, `fecha`, `from_user`, `to_user`) VALUES")
                .append("(1, 'Hola, qué tal?', '2023-11-25', 1, 2),")
                .append("(2, 'Muy bien! y tu?', '2023-11-25', 2, 1),")
                .append("(3, 'Bien también...', '2023-11-25', 1, 2),")
                .append("(4, 'Chachi!', '2023-11-25', 2, 1);")
                .toString();

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        conn.commit();

    }


}
