package latres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

public class CreateData extends JFrame {
    JLabel lTitle, lNama, lNoTelp, lKeterangan;
    JTextField fNama, fNoTelp, fKeterangan;
    JButton bSave, bBack;
    Statement statement;
    String nama, no_telp, keterangan;

    public CreateData(){
        setTitle("INPUT DATA KONTAK");
        lTitle = new JLabel("Input Data Kontak");
        lTitle.setFont(new Font("Regular", Font.BOLD, 18));
        lNama = new JLabel("Nama ");
        lNama.setFont(new Font("Regular", Font.PLAIN, 18));
        fNama = new JTextField();
        fNama.setFont(new Font("Regular", Font.PLAIN, 16));
        lNoTelp = new JLabel("No Telp ");
        lNoTelp.setFont(new Font("Regular", Font.PLAIN, 18));
        fNoTelp = new JTextField();
        fNoTelp.setFont(new Font("Regular", Font.PLAIN, 16));
        lKeterangan = new JLabel("Ket. ");
        lKeterangan.setFont(new Font("Regular", Font.PLAIN, 18));
        fKeterangan = new JTextField();
        fKeterangan.setFont(new Font("Regular", Font.PLAIN, 16));

        bSave = new JButton("Simpan");
        bSave.setFont(new Font("Regular",Font.PLAIN, 14));
        bBack = new JButton("Kembali");
        bBack.setFont(new Font("Regular",Font.PLAIN, 14));


        setLayout(null);
        add(lTitle);
        add(lNama);
        add(fNama);
        add(lNoTelp);
        add(fNoTelp);
        add(lKeterangan);
        add(fKeterangan);
        add(bSave);
        add(bBack);

        lTitle.setBounds(110, 20, 250, 30);
        lNama.setBounds(30, 70, 120, 30);
        fNama.setBounds(110, 73,270,25);
        lNoTelp.setBounds(30, 110, 120, 30);
        fNoTelp.setBounds(110, 113, 270, 25);
        lKeterangan.setBounds(30, 150, 120, 30);
        fKeterangan.setBounds(110, 153, 270, 25);
        bSave.setBounds(120, 245, 90, 30);
        bBack.setBounds(220, 245, 90,30);

        setSize(440, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nama = fNama.getText();
                    no_telp = fNoTelp.getText();
                    keterangan = fKeterangan.getText();

                    Data data = new Data(nama, no_telp, keterangan);

                    DBConnection connec = new DBConnection();
                    try {
                        statement = connec.getConnection().createStatement();
                        statement.executeUpdate("INSERT INTO kontak VALUES('" + data.getNama() + "','" + data.getNo_telp() + "','" + data.getKeterangan() + "')");
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan");
                    } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(CreateData.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(CreateData.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
                }catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
                }

                setVisible(false);
            }
        });

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main();
            }
        });
    }
}

