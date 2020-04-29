package latres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData extends JFrame {

    Statement statement;
    ResultSet resultSet;
    JButton bUpdate, bBack;
    JLabel lTitle;
    String[][] datas = new String[500][4];
    String[] column = {"Nama","No Telp","Keterangan"};
    JTable tTable;
    JScrollPane scrollPane;

    public UpdateData() throws ClassNotFoundException, SQLException {
        lTitle = new JLabel ("Seluruh Data Kontak");
        lTitle.setFont(new Font("Regular", Font.BOLD, 18));
        bUpdate = new JButton ("Edit");
        bUpdate.setFont(new Font("Regular", Font.PLAIN, 14));
        bBack = new JButton ("Kembali");
        bBack.setFont(new Font("Regular", Font.PLAIN, 14));
        tTable = new JTable(datas, column);
        scrollPane = new JScrollPane(tTable);

        setTitle("EDIT DATA");
        setSize (570,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(null);
        add(lTitle);
        add(bUpdate);
        add(bBack);
        add(scrollPane);

        lTitle.setBounds(160, 30, 300, 30);
        scrollPane.setBounds(70, 70, 400, 400);
        bUpdate.setBounds(170, 490, 90, 25);
        bBack.setBounds(280, 490, 90, 25);

        DBConnection connec = new DBConnection();
        statement = connec.getConnection().createStatement();
        String sql = "SELECT *FROM kontak";
        resultSet = statement.executeQuery(sql);
        int row = 0;
        while (resultSet.next()){
            datas[row][0] = resultSet.getString("nama");
            datas[row][1] = resultSet.getString("no_telp");
            datas[row][2] = resultSet.getString("keterangan");
            row++;
        }
        statement.close();
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main();
            }
        });
        bUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new ProcessUpdate();
            }
        });


    }

}
