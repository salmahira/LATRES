package latres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData extends JFrame {
    String[][] datas = new String[500][4];
    String[] kolom = {"Nama", "No Telp", "Keterangan"};
    JLabel lTitle;
    JTable tTable;
    JButton bBack;
    JScrollPane scrollPane;
    ResultSet resultSet;
    Statement statement;

    public ReadData(){
        setTitle("DATA KONTAK");

        lTitle = new JLabel("Seluruh Data Kontak");
        lTitle.setFont(new Font("tahoma", Font.BOLD, 18));
        bBack = new JButton("Kembali");
        bBack.setFont(new Font("Regular",Font.PLAIN, 14));
        tTable = new JTable(datas, kolom);
        scrollPane = new JScrollPane(tTable);

        setLayout(null);
        add(lTitle);
        add(bBack);
        add(scrollPane);

        lTitle.setBounds(160, 30, 300, 30);
        scrollPane.setBounds(70, 70, 400, 400);
        bBack.setBounds(230, 490, 90, 30);

        setSize(570, 620);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main();
            }
        });

        DBConnection connec = new DBConnection();
        try {
            statement = connec.getConnection().createStatement();
            String sql = "SELECT * FROM kontak";
            resultSet = statement.executeQuery(sql);

            int row = 0;
            while (resultSet.next()){
                datas[row][0] = resultSet.getString("nama");
                datas[row][1] = resultSet.getString("no_telp");
                datas[row][2] = resultSet.getString("keterangan");
                row++;
            }
            statement.close();

        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(rootPane, "Data Gagal Ditampilkan" + sqlError);
        } catch (ClassNotFoundException classError) {
            JOptionPane.showMessageDialog(rootPane, "Driver tidak ditemukan !!");
        }
    }
}
