/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsimvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Controller {
    Model m;
    View v;
    
    public Controller(Model m, View v){
        this.m = m;
        this.v = v;
        
        v.panelhome.setVisible(false);
        v.paneltitle.setVisible(false);
        v.paneltambah.setVisible(false);
        v.paneltampil.setVisible(false);
        v.paneledit.setVisible(false);
        v.panelaboutus.setVisible(false);
        
         if (m.getBanyakData() != 0) {
            String dataMahasiswa[][] = m.read();
            v.tabel.setModel((new JTable(dataMahasiswa, v.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
         
        v.jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                v.refresh();
            }
        });
        
        v.jblogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                v.panelhome.setVisible(false);
                v.panellogin.setVisible(true);
            }
        });

          v.jblogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		boolean valid = false;
        		String username = v.getuname();
        		String password = v.getpass();
        		if(v.getuname().equals("")||v.getpass().equals(""))JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
        		else {
        			String dataMember[][] = m.login();
            		for(int i =0 ; i<m.getBanyakData2();i++) {
            			if(dataMember[i][0].equals(username)) {
            				if(dataMember[i][1].equals(password)) {
            					valid=true;
            				}
            			}
            			System.out.print(dataMember[i][0]+" "+v.getuname());
            		}
            		if(valid == true) {
                                v.panelhome.setVisible(true);
                                v.paneltitle.setVisible(true);
                                v.panellogin.setVisible(false);
            		}
            		else JOptionPane.showMessageDialog(null, "Gagal Login");
        		}	
        	}
        }
          );
          
          v.jbdaftar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		boolean valid =true;
        		String username = v.getuname();
        		String password = v.getpass();
        		String dataAnggota[][] = m.login();
        		for(int i =0 ; i<m.getBanyakData2();i++) {
        			if(dataAnggota[i][0].equals(username)) {
        				valid=false;
        			}
        			System.out.print(dataAnggota[i][0]+" "+v.getuname());
        			
        		}
        		if(v.getuname().equals("")||v.getpass().equals(""))JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
        		else if(valid==false) JOptionPane.showMessageDialog(null, "Username Telah Terdaftar");
        		else m.daftar(username, password);
        	}
        });
          
          v.jbtambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	boolean valid=true;
            	if(v.getIdanggota().equals("")) valid=false;
            	if(v.getNama().equals("")) valid=false;
            	if(v.getIdbuku().equals("")) valid=false;
            	if(v.getJudulbuku().equals("")) valid=false;
            	
                String idanggota = v.getIdanggota();
                String nama = v.getNama();
                String idbuku = v.getIdbuku();
                String judulbuku = v.getJudulbuku();
                if(valid==true)m.create(idanggota, nama, idbuku, judulbuku);
                else JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
                
                String dataMahasiswa[][] = m.read();
                v.tabel.setModel(new JTable(dataMahasiswa, v.namaKolom).getModel());
            }
        });
          
          v.jbbatal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		v.jtidanggota.setText("");
                        v.jtnama.setText("");
                        v.jtidbuku.setText("");
                        v.jtjudulbuku.setText("");
                        v.paneltitle.setVisible(true);
        		v.paneltambah.setVisible(false);
        		v.paneltampil.setVisible(false); 
        	}
        });
          
          v.jbhome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		v.paneltitle.setVisible(true);
        		v.paneltambah.setVisible(false);
        		v.paneltampil.setVisible(false);
        		v.panelaboutus.setVisible(false);
        	}
        });
        
        v.jbpinjam.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		v.paneltitle.setVisible(false);
        		v.paneltambah.setVisible(true);
        		v.paneltampil.setVisible(false);
        		v.panelaboutus.setVisible(false);
        	}
        });
        
        v.jbtampil.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		v.paneltitle.setVisible(false);
        		v.paneltambah.setVisible(false);
        		v.paneltampil.setVisible(true);
        		v.panelaboutus.setVisible(false);
        	}
        });
        
        v.jbaboutus.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		v.paneltitle.setVisible(false);
        		v.paneltambah.setVisible(false);
        		v.paneltampil.setVisible(false);
        		v.panelaboutus.setVisible(true);
        	}
        });
        
         v.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = v.tabel.getSelectedRow();
                String dataterpilih = v.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                v.jbhapus.setEnabled(true);
                v.jbedit.setEnabled(true);
                
                v.jbhapus.addActionListener(new ActionListener() {
                @Override   
                public void actionPerformed(ActionEvent ae){
                    int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus data pinjam buku oleh ID Anggota " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                    m.delete(dataterpilih);
                    String dataPeminjaman[][] = m.read();
                    v.tabel.setModel(new JTable(dataPeminjaman, v.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
                        v.jbhapus.setEnabled(false);
                        v.jbedit.setEnabled(false);
                	}
                });

                v.jbedit.addActionListener(new ActionListener() {
                	int baris = v.tabel.getSelectedRow();
                        String dataterpilih = v.tabel.getValueAt(baris, 0).toString();
                	public void actionPerformed(ActionEvent e) {
                		v.jtidanggota2.setText(dataterpilih);
                		v.paneledit.setVisible(true);
                	}
                }); 
            }
        }
        );
         v.jbedit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		boolean valid=true;
        		if(v.geteditIdanggota().equals("")) valid=false;
            	if(v.geteditNama().equals("")) valid=false;
            	if(v.geteditIdbuku().equals("")) valid=false;
            	if(v.geteditJudulbuku().equals("")) valid=false;
        		
                String idanggota = v.geteditIdanggota();
                String nama = v.geteditNama();
                String idbuku = v.geteditIdbuku();
                String judulbuku = v.geteditJudulbuku();
                
                
                if(valid==true)m.update(idanggota, nama, idbuku, judulbuku);
                else JOptionPane.showMessageDialog(null, "Field Empty");
                String dataAnggota[][] = m.read();
                v.tabel.setModel(new JTable(dataAnggota, v.namaKolom).getModel());
                v.paneledit.setVisible(false);
            }
        });
    }     
}
