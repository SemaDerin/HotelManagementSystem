package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class NewCustomer extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;

    private JPanel contentPane;
    private JTextField t1,t2,t3,t5,t6;
    JComboBox comboBox;
    JRadioButton r1,r2;
    Choice c1;

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            try{
                NewCustomer frame = new NewCustomer();
                frame.setVisible(true);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public NewCustomer() throws SQLException{

        setBounds(530,200,850,550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        JLabel l1 = new JLabel(new ImageIcon(i3));
        l1.setBounds(480,10,300,500);
        add(l1);

        JLabel lblName = new JLabel("NEW CUSTOMER FORM");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN,20));
        lblName.setBounds(118,11,260,53);
        contentPane.add(lblName);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(35,76,200,14);
        contentPane.add(lblId);

        comboBox = new JComboBox(new String[]{"Passport","Aadhar Card","Voter Id","Driving Licence"});
        comboBox.setBounds(271,73,150,20);
        contentPane.add(comboBox);

        JLabel l2 = new JLabel("Number:");
        l2.setBounds(35,111,200,14);
        contentPane.add(l2);

        t1 = new JTextField();
        t1.setBounds(271,111,150,20);
        contentPane.add(t1);

        JLabel lblName1 = new JLabel("Name:");
        lblName1.setBounds(35,151,200,14);
        contentPane.add(lblName1);

        t2 = new JTextField();
        t2.setBounds(271,151,150,20);
        contentPane.add(t2);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(35,191,200,14);
        contentPane.add(lblGender);

        r1 = new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setBounds(271,191,80,20);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,191,100,20);
        add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel lblCountry = new JLabel("Country:");
        lblCountry.setBounds(35,231,200,14);
        contentPane.add(lblCountry);

        t3 = new JTextField();
        t3.setBounds(271,231,150,20);
        contentPane.add(t3);

        JLabel lblReserveRoomNumber = new JLabel("Allocated Room Number:");
        lblReserveRoomNumber.setBounds(35,274,200,14);
        contentPane.add(lblReserveRoomNumber);

        c1 = new Choice();
        c1.setBounds(271,274,150,20);
        contentPane.add(c1);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM room");
            while(rs.next()){
                c1.add(rs.getString("room_number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblCheckInStatus = new JLabel("Checked-In:");
        lblCheckInStatus.setBounds(35,316,200,14);
        contentPane.add(lblCheckInStatus);

        t5 = new JTextField();
        t5.setBounds(271,316,150,20);
        contentPane.add(t5);

        JLabel lblDeposite = new JLabel("Deposit:");
        lblDeposite.setBounds(35,359,200,14);
        contentPane.add(lblDeposite);

        t6 = new JTextField();
        t6.setBounds(271,359,150,20);
        contentPane.add(t6);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(100,430,120,30);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        contentPane.add(btnAdd);

        btnAdd.addActionListener(e -> {
            Conn c = new Conn();
            String gender = r1.isSelected() ? "Male" : "Female";

            try{
                String s1 = (String) comboBox.getSelectedItem();
                String s2 = t1.getText();
                String s3 = t2.getText();
                String s4 = gender;
                String s5 = t3.getText();
                String s6 = c1.getSelectedItem();
                String s7 = t5.getText();
                String s8 = t6.getText();

                String q1 = "INSERT INTO customer VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q2 = "UPDATE room SET availability='Occupied' WHERE room_number='"+s6+"'";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null,"Data Inserted Successfully");
                new Reception().setVisible(true);
                setVisible(false);

            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });

        JButton btnExit = new JButton("Back");
        btnExit.setBounds(260,430,120,30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        btnExit.addActionListener(e -> {
            new Reception().setVisible(true);
            setVisible(false);
        });

        getContentPane().setBackground(Color.WHITE);
    }
}
