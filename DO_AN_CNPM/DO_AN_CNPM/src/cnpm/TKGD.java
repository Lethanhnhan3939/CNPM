/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnpm;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import tkgd.order;
public class TKGD {

    /**
     * @param args the command line arguments
     */
    void connectDatabase()
    {
        System.out.println("sadfsdf");
        System.out.println("con cac");
        try {
        String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
        Connection conn = DriverManager.getConnection(dbURL);
        if (conn != null) {
            System.out.println("Connected");
            DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
            System.out.println("Driver name: " + dm.getDriverName());
            System.out.println("Driver version: " + dm.getDriverVersion());
            System.out.println("Product name: " + dm.getDatabaseProductName());
            System.out.println("Product version: " + dm.getDatabaseProductVersion());
      
            System.out.println("con cac ne");
        }
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        order bangorder = new order();
        bangorder.setVisible(true);
    }
    
}
