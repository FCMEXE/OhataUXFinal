package com.example.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * A classe {@code User} é responsável por realizar a verificação de login e senha
 * de um usuário no banco de dados.
 * Ela utiliza JDBC para conectar ao banco de dados e verificar a existência do
 * usuário.
 */
public class User {

    /**
     * Construtor padrão para a classe {@code User}.
     * Este construtor cria uma instância da classe {@code User} sem parâmetros,
     * permitindo a criação do objeto sem a necessidade de fornecer dados iniciais.
     */
    public User() {
        // Nenhuma inicialização adicional necessária
    }

    /**
     * Estabelece uma conexão com o banco de dados MySQL.
     *
     * @return A conexão com o banco de dados ou {@code null} caso haja erro na
     *         conexão.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Caso ocorra um erro, retorna null
        }
        return conn;
    }

    /**
     * Nome do usuário que é retornado após a autenticação bem-sucedida.
     */
    public String nome = "";

    /**
     * Indica o resultado da verificação do usuário.
     * O valor padrão é {@code false}.
     */
    public boolean result = false;

    /**
     * Verifica se o usuário existe no banco de dados com o login e senha fornecidos.
     *
     * @param login O login do usuário.
     * @param senha A senha do usuário.
     * @return {@code true} se o usuário for autenticado com sucesso, {@code false}
     *         caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD(); // Obtém a conexão com o banco de dados.

        // Constrói a instrução SQL para consultar o usuário no banco de dados.
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";

        try {
            // Executa a consulta SQL e obtém o resultado.
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Se o usuário for encontrado, retorna true e atribui o nome do usuário.
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Caso ocorra erro, nenhuma ação é tomada.
        }
        return result;
    }
}
