package login; // import packs

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User { // user class
    public Connection conectarBD() { // connection DB
        Connection conn = null; // start null
        try { // try connection
            Class.forName("com.mysql.Driver.Manager").newInstance(); // new : Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) { } // catch error e
        return conn;
    }

    public String nome = "";
    public boolean result = false; // por padrão o boolean ja vem false

    public boolean verificarUsuario(String login, String senha) { // consult user poderia ser utilizado um State, para setar o User
        String sql = "";
        Connection conn = conectarBD(); // get conn DB
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";
        try { // get const to set states
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) { }
        return result;
    }
} // BD Não fecha
// fim da class
