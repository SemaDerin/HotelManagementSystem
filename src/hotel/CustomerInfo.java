package hotel;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerInfo extends JFrame {

    private JPanel contentPane;
    private JLabel lbdId, lblNewLabel, lblGender, lblCountry, lblRoom, lblStatus, lblNewLabel2;
    private JTable table;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    CustomerInfo frame = new CustomerInfo();
                    frame.setVisible(true);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public void close(){
        this.dispose();
    }

    public CustomerInfo() throws SQLException{
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530,200,900,600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(450,510,120,30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Conn c = new Conn();
                    String displayCustomersql = "Select * from customer";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }
                catch (Exception ez){
                    ez.printStackTrace();
                }

            }
        });


        btnLoadData.setBounds(300,510,120,30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        lbdId = new JLabel("ID");
        lbdId.setBounds(31,11,46,14);
        contentPane.add(lbdId);


        JLabel  l1 = new JLabel("Number");
        l1.setBounds(150,11,46,14);
        contentPane.add(l1);

        lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(270,11,65,14);
        contentPane.add(lblNewLabel);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(360,11,46,14);
        contentPane.add(lblGender);

        table = new JTable();
        table.setBounds(0,40,900,450);
        contentPane.add(table);

        lblCountry = new JLabel("Country");
        lblCountry.setBounds(480,11,46,14);
        contentPane.add(lblCountry);

        lblRoom = new JLabel("Room");
        lblRoom.setBounds(600,11,46,14);
        contentPane.add(lblRoom);


        lblStatus = new JLabel("Check in Status");
        lblStatus.setBounds(680,11,100,14);
        contentPane.add(lblStatus);

        lblNewLabel2 = new JLabel("Deposit");
        lblNewLabel2.setBounds(800,11,100,14);
        contentPane.add(lblNewLabel2);

        getContentPane().setBackground(Color.WHITE);














    }
}
