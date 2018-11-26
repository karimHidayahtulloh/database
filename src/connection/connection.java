/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class connection {

    static Connection con;
    Statement stment;
    PreparedStatement prStm;

    public connection() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres"; 
//        "postgres" itu nama db nya
        String pass = "karim";

        try {
            this.con = (Connection) DriverManager.getConnection(url, username, pass);
            stment = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void executeQuery(String query) {

        try {
            this.stment.execute(query);
            System.out.println("Query Sukses");
        } catch (SQLException ex) {
            System.out.println("Kesalahan Pada Query");
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getResult(String query) {
        ResultSet rs = null;
        try {
            rs = stment.executeQuery(query);
            System.out.println("Query Sukses");
        } catch (SQLException ex) {
            System.out.println("Kesaslahan Pada Query");
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public Connection getConnection() {
        return con;
    }

    public PreparedStatement executePreStment(String query) {
        PreparedStatement prepare = null;

        try {
            prepare = con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prepare;
    }

    public int getResultPreStm(PreparedStatement prStm) {
        int rs = 0;

        try {
            rs = prStm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static Connection Connection() {
        return con;
    }
}