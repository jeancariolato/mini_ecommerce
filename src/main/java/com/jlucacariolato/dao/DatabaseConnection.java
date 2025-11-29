package com.jlucacariolato.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    //VARIAVEIS PARA CONEXÃO
    private static final String URL = "jdbc:mysql://localhost:3306/database";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private static Connection connection = null;

    // Construtor de Instancia de Conexão
    public static Connection getConnection(){
        //Estrutura de comparação para conexar banco
        if (connection == null){
            try{
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexão estabelecida com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao conectar:" + e.getMessage());
            }
        }
        return connection;
    }
}
