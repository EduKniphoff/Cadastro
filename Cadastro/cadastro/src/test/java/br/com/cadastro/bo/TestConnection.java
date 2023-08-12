package br.com.cadastro.bo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) throws SQLException {
        
        String url = "jdbc:mysql://localhost:3306/cadastro";
        String username = "root";
        String password = "Kniphoff99!";

       
        Connection connection = DriverManager.getConnection(url, username, password);

        
        if (connection != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Connection failed!");
        }

        
        connection.close();
    }
}
