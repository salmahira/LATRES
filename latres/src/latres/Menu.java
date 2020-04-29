package latres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame {
    JLabel lTittle;
    JButton bCreate, bRead, bUpdate, bDelete, bExit;

    public void displayMenu(){
        setTitle("DATA KONTAK");
        lTittle = new JLabel("DATA KONTAK");
        lTittle.setFont(new Font("Regular", Font.BOLD, 18));
        bCreate = new JButton("Input Data");
        bCreate.setFont(new Font("Regular",Font.PLAIN, 16));
        bRead = new JButton("Tampilkan Data");
        bRead.setFont(new Font("Regular",Font.PLAIN, 16));
        bUpdate = new JButton("Edit Data");
        bUpdate.setFont(new Font("Regular",Font.PLAIN, 16));
        bDelete = new JButton("Hapus Data");
        bDelete.setFont(new Font("Regular",Font.PLAIN, 16));
        bExit = new JButton("Exit ");
        bExit.setFont(new Font("Regular",Font.PLAIN, 16));


        setLayout(null);
        add(lTittle);
        add(bCreate);
        add(bRead);
        add(bUpdate);
        add(bDelete);
        add(bExit);

        lTittle.setBounds(145,30,180,30);
        bCreate.setBounds(100, 80, 220, 30);
        bRead.setBounds(100, 120, 220, 30);
        bUpdate.setBounds(100, 160, 220, 30);
        bDelete.setBounds(100, 200, 220, 30);
        bExit.setBounds(100, 240, 220, 30);

        setSize(430, 370);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateData();
            }
        });
        bRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReadData();
            }
        });
        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new DeleteData();
                }catch (ClassNotFoundException classError){
                    classError.printStackTrace();
                }catch (SQLException sqlError){
                    sqlError.printStackTrace();
                }
            }
        });
        bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateData();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
