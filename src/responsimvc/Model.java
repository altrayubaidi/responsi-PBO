/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsimvc;

import java.sql.*;
import javax.swing.*;

public class Model {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost:3306/responsi_perpus";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;
    
    public Model(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/responsi_perpus?serverTimezone=UTC", "root", "");
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex+"Koneksi Gagal");
            System.out.println(this.koneksi);
        }
    }
    
    //Sign In
     public void daftar(String username, String password) {
    	int jmlData=0;
        try {
           String query = "Select * from accounts WHERE Username='" + username+"'";
           statement = (Statement) koneksi.createStatement();
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            if (jmlData==0) {
                query = "INSERT INTO accounts(Username, Password) VALUES ('"+username+"','"+password+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Berhasil menambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Akun telah terdaftar");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
     //Login
     public String[][] login(){
    	try {
    		int jmlData = 0;
            
            String data[][] = new String[getBanyakData2()][2];
            
            String query = "Select * from accounts"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("Username"); 
                data[jmlData][1] = resultSet.getString("Password");                
                jmlData++;
            }return data;
    	}
    	catch(SQLException e){
    		System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
    	}
    }
     
    //Create
    public void create(String idanggota, String namaanggota, String idbuku, String namabuku){
        int jmlData=0;
        try {
           
           
           String query = "Select * from transactions WHERE MemberId=" + idanggota; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
           
            if (jmlData==0) {
                query = "INSERT INTO transactions(MemberId, MemberName, BookId, BookName) VALUES ('"+idanggota+"','"+namaanggota+"','"+idbuku+"','"+namabuku+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Berhasil menambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data telah tersedia");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    //Read
    public String[][] read(){
        try{
            int jmlData = 0;
            String data[][] = new String[getBanyakData()][4];
            
            String query = "Select * from transactions"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("MemberId");
                data[jmlData][1] = resultSet.getString("MemberName");                
                data[jmlData][2] = resultSet.getString("BookId");
                data[jmlData][3] = resultSet.getString("BookName");
                jmlData++;
            }
            return data; 
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public int getBanyakData2(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from accounts";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    //Update
    public void update(String idanggota, String namaanggota, String idbuku, String namabuku){
        int jmlData=0;
         try {
           String query = "Select * from transactions WHERE MemberId=" + idanggota; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE transactions SET MemberName='" + namaanggota + "', BookId='" + idbuku +"', BookName='" + namabuku + "' WHERE MemberId=" + idanggota;
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Berhasil Update");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
             }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    //Delete
    public void delete (String idanggota) {
        try{
            String query = "DELETE FROM transactions WHERE MemberId = '"+idanggota+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    } 
}
  
      
