package hotel;

import javax.imageio.ImageWriter;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckOut extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t1;
    Choice c1;


    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    CheckOut frame = new CheckOut();
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


    public CheckOut() throws SQLException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530,200,800,294);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400,225,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(300,0,500,225);
        add(l1);



        JLabel lblCheckOut = new JLabel("Check Out");
        lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCheckOut.setBounds(70,11,140,35);
        contentPane.add(lblCheckOut);


        JLabel lblName = new JLabel("Number");
        lblName.setBounds(20,85,80,14);
        contentPane.add(lblName);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch (Exception et){ }

        c1.setBounds(130,82,150,20);
        contentPane.add(c1);



        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JButton l2 = new JButton(i6);
        l2.setBounds(290,82,20,20);
        add(l2);

        l2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hi");
                try{
                    Conn c = new Conn();
                    String number = c1.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("Select * from customer where number = "+number);
                    if(rs.next()){
                        System.out.println("Clicked");
                        t1.setText(rs.getString("room_number"));
                    }
                }catch (Exception er){

                }
            }
        });

        JLabel lblRoomNumber = new JLabel("Room Number: ");
        lblRoomNumber.setBounds(25,132,150,14);
        contentPane.add(lblRoomNumber);

        t1 = new JTextField();
        t1.setBounds(130,132,150,20);
        contentPane.add(t1);

        JButton btnCheckOut = new JButton("Check Out");
        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c1.getSelectedItem();
                String s1 = t1.getText();
                String deleteSql = "Delete from customer where number ="+id;
                String q2= "Update room set availability = 'Available' where room_number= "+s1;

                Conn c = new Conn();

                try{
                    c.s.executeUpdate(deleteSql);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Check Out Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);

                }catch (SQLException eq){
                    System.out.println(eq.getMessage());
                }


            }
        });


        btnCheckOut.setBounds(50,200,100,25);
        btnCheckOut.setBackground(Color.BLACK);
        btnCheckOut.setForeground(Color.WHITE);
        contentPane.add(btnCheckOut);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });

        btnExit.setBounds(160,200,100,25);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);













    }
}
