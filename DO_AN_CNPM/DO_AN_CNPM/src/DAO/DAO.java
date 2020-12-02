/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
/**
 *
 * @author Phong
 */
public class DAO {
    public static ResultSet select(String select_target, String table, String condition){//select_target= " * " ; condition="tenNV LIKE '%Tran%'"
        ResultSet res = null;
        try {
        String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;characterEncoding=utf8;user=sa;password=sa";
        Connection conn = DriverManager.getConnection(dbURL);
        Statement stm = conn.createStatement();
        String query=String.format("SELECT %s from %s", select_target, table);
        if (condition!=null)
            query=String.format("SELECT %s from %s WHERE %s", select_target, table, condition);
//        System.out.println(query);
        res = stm.executeQuery(query);
        }catch (SQLException ex) {
            System.err.println("Select from db error: " + ex);
        }
        return res;
    }
    
    public static void insert(String table, String insert_column, String insert_value){//insert_column= "idNV,tenNV,sdt" // insert_value= "1,N'Nguyen Van A','0123456789'"
        try {
        String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;characterEncoding=utf8;user=sa;password=sa";
        Connection conn = DriverManager.getConnection(dbURL);
//        System.out.println(String.format("INSERT INTO %s (%s) VALUES (%s)",table, insert_column, insert_value));
        Statement stm = conn.createStatement();
                        //insert into NHANVIEN(idNV,tenNV,sdt,ngaysinh,diachi) values (1,N'Nguyễn Công Phú','0123456789','1999/02/19',N'102 Trần Hưng Đạo')
        stm.executeQuery(String.format("INSERT INTO %s (%s) VALUES (%s)",table, insert_column, insert_value));
        stm.close();
        conn.close();
        }catch (SQLException ex) {
            System.err.println("Insert db error: " + ex);
        }
    }
    
    public static void update(String table, String set_value, String condition){//set_value= "tenNV=N'Nguyen Van A',sdt='0123456789'"
        try {
        String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;characterEncoding=utf8;user=sa;password=sa";
        Connection conn = DriverManager.getConnection(dbURL);
        Statement stm = conn.createStatement();
                                    //update NHANVIEN SET tenNV=N'Nguyễn văn phú',sdt='0147258369',diachi='123 abc' where idNV=1
//                                    System.out.print(String.format("UPDATE %s SET %s WHERE %s",table, set_value ,condition));
        stm.executeQuery(String.format("UPDATE %s SET %s WHERE %s",table, set_value ,condition));
        stm.close();
        conn.close();
        }catch (SQLException ex) {
//            System.err.println("Update database error: "+ex);
        }
    }
    
    public static void delete(String table, String target){//target="idNV = 1"
        try {
        String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;characterEncoding=utf8;user=sa;password=sa";
        Connection conn = DriverManager.getConnection(dbURL);
        Statement stm = conn.createStatement();
        stm.executeQuery(String.format("DELETE FROM %s WHERE %s",table, target));//DELETE FROM NHANVIEN WHERE idNV = 1
        stm.close();
        conn.close();
        }catch (SQLException ex) {
             //System.err.println("Cannot connect database" + ex);
        }
    }
    
    public static ResultSet sort(String select_target, String table, String compare){//compare="tenNV DESC"
        ResultSet res = null;
        try {
        String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;characterEncoding=utf8;user=sa;password=sa";
        Connection conn = DriverManager.getConnection(dbURL);
        Statement stm = conn.createStatement();
        res=stm.executeQuery(String.format("SELECT %s from %s ORDER BY %s", select_target, table, compare));//select * from NHANVIEN ORDER BY ngaysinh DESC
        }catch (SQLException ex) {
             //System.err.println("Cannot connect database" + ex);
        }
        return res;
    }
}
