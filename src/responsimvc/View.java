/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsimvc;

import java.awt.Dimension;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class View extends JFrame {
    JFrame currentFrame;
    Dimension dimensiMain;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    JPanel panellogin = new JPanel();
    JPanel panelhome = new JPanel();
    JPanel paneltitle = new JPanel();
    JPanel paneltambah = new JPanel();
    JPanel paneltampil = new JPanel();
    JPanel paneledit = new JPanel();
    JPanel panelaboutus = new JPanel();
    
    //Halaman Login
    JButton jbexit = new JButton("Exit");
    JLabel jllogin = new JLabel("LOGIN");
    JLabel jlid = new JLabel("Username : ");
    JTextField jtid = new JTextField();
    JLabel jlpass = new JLabel("Password : ");
    JPasswordField jtpass = new JPasswordField();
    JButton jblogin = new JButton("Login");
    JButton jbdaftar = new JButton("Daftar");
    
    //Halaman Home
    JButton jbhome = new JButton("Home");
    JButton jbpinjam = new JButton("Pinjam");
    JButton jbtampil = new JButton("Tampil");
    JButton jbaboutus = new JButton("About Us");
    JButton jblogout = new JButton("Logout");
    JLabel jltitle = new JLabel ("Selamat Datang di Perpustakaan");
    
    //Halaman Tambah
    JLabel jlidanggota = new JLabel("ID Anggota : ");
    JLabel jlnama = new JLabel("Nama : ");
    JLabel jlidbuku = new JLabel("ID Buku : ");
    JLabel jljudulbuku = new JLabel("Judul Buku : ");
    JTextField jtidanggota = new JTextField();
    JTextField jtnama = new JTextField();
    JTextField jtidbuku = new JTextField();
    JTextField jtjudulbuku = new JTextField();
    JButton jbtambah = new JButton("Tambah");
    JButton jbbatal = new JButton("Batal");
    
    //Halaman Tampil
    JTable tabel;
    DefaultTableModel dtm;
    Object namaKolom[] = {"ID", "Nama", "ID Buku", "Judul Buku"};
    JButton jbhapus = new JButton("Hapus");
    JButton jbedit = new JButton("Edit");
    
    //Halaman Edit
    JLabel jlidanggota2 = new JLabel("ID Anggota : ");
    JLabel jlnama2 = new JLabel("Nama : ");
    JLabel jlidbuku2 = new JLabel("ID Buku : ");
    JLabel jljudulbuku2 = new JLabel("Judul Buku : ");
    JTextField jtidanggota2 = new JTextField();
    JTextField jtnama2 = new JTextField();
    JTextField jtidbuku2 = new JTextField();
    JTextField jtjudulbuku2 = new JTextField();
    JButton jbbatal2 = new JButton("Batal");
    JButton jbedit2 = new JButton("Edit");
    
    //Halaman About Us
    JTextPane jtabout = new JTextPane();
    
    public View(){
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        
        setTitle("PERPUSTAKAAN");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setLayout(null);
        setSize(500, 450);
        paneledit.setBackground(Color.YELLOW);
        
         //HALAMAN LOGIN
        getContentPane().add(panellogin);
        panellogin.setLayout(null);
        panellogin.add(jbexit);
        jbexit.setBounds(300, 20, 90, 20);
        panellogin.add(jllogin);
        jllogin.setBounds(170, 100, 90, 20);
        panellogin.add(jlid);
        jlid.setBounds(20, 140, 90, 20);
        panellogin.add(jlpass);
        jlpass.setBounds(20, 170, 90, 20);
        panellogin.add(jtid);
        jtid.setBounds(110, 140, 190, 20);
        panellogin.add(jtpass);
        jtpass.setBounds(110, 170, 190, 20);
        panellogin.add(jblogin);
        jblogin.setBounds(110, 200, 90, 20);
        panellogin.add(jbdaftar);
        jbdaftar.setBounds(210, 200, 90, 20);
        panellogin.setBounds(0, 0, 500, 411);
        panellogin.setBackground(Color.YELLOW);

        //HALAMAN HOME
        getContentPane().add(panelhome);
        panelhome.setLayout(null);
        panelhome.add(jblogout);
        jblogout.setBounds(370, 20, 90, 20);
        panelhome.add(jbhome);
        jbhome.setBounds(90, 130, 90, 35);
        panelhome.add(jbpinjam);
        jbpinjam.setBounds(90, 180, 90, 35);
        panelhome.add(jbtampil);
        jbtampil.setBounds(90, 230, 90, 35);
        panelhome.add(jbaboutus);
        jbaboutus.setBounds(90, 280, 90, 35);
        panelhome.setBounds(-80, 0, 200, 350);
        
        //HALAMAN TAMBAH
        getContentPane().add(paneltambah);
        paneltambah.setLayout(null);
        paneltambah.add(jlidanggota);
        jlidanggota.setBounds(41,53,68,14);
        paneltambah.add(jlnama);
        jlnama.setBounds(41,78,68,14);
        paneltambah.add(jlidbuku);
        jlidbuku.setBounds(41,103,68,14);
        paneltambah.add(jljudulbuku);
        jljudulbuku.setBounds(41,128,68,14);
        paneltambah.add(jtidanggota);
        jtidanggota.setBounds(119,53,180,14);
        paneltambah.add(jtnama);
        jtnama.setBounds(119,78,180,14);
        paneltambah.add(jtidbuku);
        jtidbuku.setBounds(119,103,180,14);
        paneltambah.add(jtjudulbuku);
        jtjudulbuku.setBounds(119,128,180,14);
        jbtambah.setBounds(119, 153, 80, 23);
        paneltambah.add(jbtambah);
        jbbatal.setBounds(219, 153, 80, 23);
        paneltambah.add(jbbatal);
        paneltambah.setBounds(121, 0, 363, 411);
        
        //HALAMAN TAMPIL
        getContentPane().add(paneltampil);
        paneltampil.setLayout(null);
        paneltampil.add(scrollPane);
        scrollPane.setBounds(10,40,343,360);
        paneltampil.add(jbhapus);
        jbhapus.setBounds(32,11,82,18);
        paneltampil.add(jbedit);
        jbedit.setBounds(237,11,82,18);
        paneltampil.setBounds(121, 0, 363, 411);
        
        //HALAMAN EDIT
        getContentPane().add(paneledit);
        paneledit.setLayout(null);
        paneledit.add(jlidanggota2);
        jlidanggota2.setBounds(41,53,68,14);
        paneledit.add(jlnama2);
        jlnama2.setBounds(41,78,68,14);
        paneledit.add(jlidbuku2);
        jlidbuku2.setBounds(41,103,68,14);
        paneledit.add(jljudulbuku2);
        jljudulbuku2.setBounds(41,128,68,14);
        paneledit.add(jtidanggota2);
        jtidanggota2.setBounds(119,53,180,14);
        paneledit.add(jtnama2);
        jtnama2.setBounds(119,78,180,14);
        paneledit.add(jtidbuku2);
        jtidbuku2.setBounds(119,103,180,14);
        paneledit.add(jtjudulbuku2);
        jtjudulbuku2.setBounds(119,128,180,14);
        jbbatal2.setBounds(119, 153, 80, 23);
        paneledit.add(jbbatal2);
        jbedit2.setBounds(219, 153, 80, 23);
        paneledit.add(jbedit2);
        paneledit.setBounds(121, 0, 363, 411);
        
        //TITLE HALAMAN
        getContentPane().add(paneltitle);
        paneltitle.setLayout(null);
        jltitle.setBounds(32, 68, 286, 150);
        paneltitle.add(jltitle);
        paneltitle.setBounds(123, 0, 351, 411);
        
        //HALAMAN ABOUT US
        getContentPane().add(panelaboutus);
        panelaboutus.setLayout(null);
        jtabout.setText("Perpustakaan ini berdiri sejak tahun 1989");
        jtabout.setEditable(false);
        jtabout.setBounds(32, 68, 286, 150);
        panelaboutus.add(jtabout);
        panelaboutus.setBounds(123, 0, 351, 411);
    }

    public void refresh(){
        dispose();
    }
    
    public String getIdanggota(){
        return jtidanggota.getText();
    }
    
    public String getNama(){
        return jtnama.getText();
    }
    
    public String getIdbuku(){
        return jtidbuku.getText();
    }
    public String getJudulbuku() {
    	return jtjudulbuku.getText();
    }
     public String geteditIdanggota(){
        return jtidanggota2.getText();
    }
    
    public String geteditNama(){
        return jtnama2.getText();
    }
    
    public String geteditIdbuku(){
        return jtidbuku2.getText();
    }
    public String geteditJudulbuku() {
    	return jtjudulbuku2.getText();
    }
    public String getuname() {
    	return jtid.getText();
    }
    @SuppressWarnings("deprecation")
	public String getpass() {
    	return jtpass.getText();
    }
}
