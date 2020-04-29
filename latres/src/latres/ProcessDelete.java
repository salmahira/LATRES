package latres;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ProcessDelete extends JFrame {
    Statement statement;
    ResultSet resultSet;
    JButton bDelete, bBack;
    JLabel lTitle, lNama;
    JTextField fNama;

    public void ProcessDelete() {
        this.lTitle = new JLabel("Hapus Data Kontak");
        this.lNama = new JLabel("Nama ");
        this.bDelete = new JButton("Hapus");
        this.bBack = new JButton("Kembali");
        this.fNama = new JTextField();

        this.setTitle("Hapus Data Kontak");
        this.setSize(300, 200);
        this.lTitle.setHorizontalAlignment(0);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.setLayout((LayoutManager)null);

        this.add(this.lTitle);
        this.add(this.lNama);
        this.add(this.fNama);
        this.add(this.bDelete);
        this.add(this.bBack);


        this.lTitle.setBounds(50, 10, 150, 25);
        this.lNama.setBounds(50, 50, 100, 25);
        this.fNama.setBounds(100, 50, 100, 25);
        this.bBack.setBounds(30, 90, 100, 25);
        this.bDelete.setBounds(140, 90, 100, 25);
        this.bBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                ProcessDelete.this.setVisible(false);
                new Menu();
            }
        });
        this.bDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                ProcessDelete.this.btnDelactionListener();
                new ReadData();
            }
        });
    }

    private void btnDelactionListener() {
        DBConnection koneksi = new DBConnection();
        try {
            this.statement = koneksi.getConnection().createStatement();
            this.statement.executeUpdate("DELETE FROM kontak WHERE nama='" + this.fNama.getText() + "'");
            JOptionPane.showMessageDialog((Component)null, "Data berhasil di Hapus!", "Hasil", 1);
            this.statement.close();
        } catch (SQLException var3) {
            JOptionPane.showMessageDialog((Component)null, "Data Gagal di Hapus!", "Hasil", 0);
        } catch (ClassNotFoundException var4) {
            JOptionPane.showMessageDialog((Component)null, "Driver Tidak Ditemukan!", "Hasil", 0);
        }

    }
}
