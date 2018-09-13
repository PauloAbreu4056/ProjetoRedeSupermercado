package br.com.supermercado.dal;

import java.sql.*;
/**
 *
 * @author Paulo Abreu
 */
public class ModuloDeConexao {
       // Método responsável por estabelecer a conexão com o banco
public static Connection conector() {
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbsupermercado";
        String usuario = "root";
        String senha = ""; 
       try {
           
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
}
}