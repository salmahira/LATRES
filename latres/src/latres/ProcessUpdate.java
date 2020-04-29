package latres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessUpdate extends JFrame {
    JLabel lTitle, lNama, lNoTelp, lKeterangan;
    JTextField fNama, fNoTelp, fKeterangan;
    JButton bSave, bBack;
    Statement statement;

    public ProcessUpdate() {

        setTitle("FORM EDIT DATA");
        lTitle = new JLabel("Edit Berdasarkan Nama");
        lTitle.setFont(new Font("Regular", Font.PLAIN, 20));
        lNama = new JLabel("Nama ");
        lNama.setFont(new Font("Regular", Font.PLAIN, 18));
        fNama = new JTextField();
        fNama.setFont(new Font("Regular", Font.PLAIN, 16));
        lKeterangan = new JLabel("Ket. ");
        lKeterangan.setFont(new Font("Regular", Font.PLAIN, 18));
        fKeterangan = new JTextField();
        fKeterangan.setFont(new Font("Regular", Font.PLAIN, 16));
        lNoTelp = new JLabel("No Telp ");
        lNoTelp.setFont(new Font("Regular", Font.PLAIN, 18));
        fNoTelp= new JTextField();
        fNoTelp.setFont(new Font("Regular", Font.PLAIN, 16));
        bSave = new JButton("Simpan");
        bSave.setFont(new Font("Regular",Font.PLAIN, 14));
        bBack = new JButton("Kembali");
        bBack.setFont(new Font("Regular",Font.PLAIN, 14));

        setLayout(null);
        add(lTitle);
        add(lNama);
        add(fNama);
        add(lKeterangan);
        add(fKeterangan);
        add(lNoTelp);
        add(fNoTelp);
        add(bSave);
        add(bBack);

        lTitle.setBounds(120, 20, 250, 30);
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
            public void actionPerformed(ActionEvent ae) {
                btnUpdateactionListener();
            }

            private void btnUpdateactionListener() {
                DBConnection connec = new DBConnection();
                try {
                    statement = connec.getConnection().createStatement();
                    statement.executeUpdate("UPDATE kontak SET  nama='" +
                            fNama.getText() + "'," + "no_telp='" + fNoTelp.getText() + "'," + "keterangan='" + fKeterangan.getText() + "'WHERE nama='" + fNama.getText() + "'");

                    JOptionPane.showMessageDialog(null, "Data berhasil di Update!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
                    statement.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Data gagal diupdate!", "Hasil", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        bBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                try {
                    new UpdateData();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ProcessUpdate.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ProcessUpdate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
