/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastrobd;

import java.sql.*;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Missao_Pratica_DB_Loja;encrypt=true;trustServerCertificate=true";
        String user = "loja";
        String password = "loja";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexao bem-sucedida!");
        } catch (SQLException e) {
            System.out.println("Erro de conexao:");
            e.printStackTrace();
        }
    }
}

