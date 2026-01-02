package hotel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCheck extends JFrame {

    Connection conn = null;
    PreparedStatement pst= null;
    private JPanel contentPane;
    private JTextField txtId, txtRoom, txtStatus, txtDate, txtTime, txtPayment;
    Choice c1,c2;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    UpdateCheck frame = new UpdateCheck();
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


    public UpdateCheck() throws SQLException{
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,200,950,500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUpdateCheckStatus = new JLabel("Check in Details");
        lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUpdateCheckStatus.setBounds(124,11,222,25);
        contentPane.add(lblUpdateCheckStatus);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(450,70,476,270);
        add(l1);

        JLabel lblNewLabel = new JLabel("ID: ");
        lblNewLabel.setBounds(25,88,46,14);
        contentPane.add(lblNewLabel);


        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch (Exception e){}
        c1.setBounds(248,85,140,20);
        contentPane.add(c1);


        JLabel lblNewLabel2 = new JLabel("Room Number: ");
        lblNewLabel2.setBounds(25,129,107,14);
        contentPane.add(lblNewLabel2);

        txtId = new JTextField();
        txtId.setBounds(248,126,140,20);
        contentPane.add(txtId);

        JLabel lblNewLabel3 = new JLabel("Name: ");
        lblNewLabel3.setBounds(25,174,97,14);
        contentPane.add(lblNewLabel3);
        JLabel lblNewLabel4 = new JLabel("Checked In: ");
        lblNewLabel4.setBounds(25,216,107,14);
        contentPane.add(lblNewLabel4);

        JLabel lblNewLabel5 = new JLabel("Account Paid (Rs): ");
        lblNewLabel5.setBounds(25,261,107,14);
        contentPane.add(lblNewLabel5);

        JLabel lblNewLabel6 = new JLabel("Pending Amount (Rs): ");
        lblNewLabel6.setBounds(25,302,150,14);
        contentPane.add(lblNewLabel6);

        txtStatus = new JTextField();
        txtStatus.setBounds(248,171,140,20);
        contentPane.add(txtStatus);
        txtStatus.setColumns(10);

        txtDate = new JTextField();
        txtDate.setBounds(248,216,140,20);
        contentPane.add(txtDate);
        txtDate.setColumns(10);

        txtTime = new JTextField();
        txtTime.setBounds(248,258,140,20);
        contentPane.add(txtTime);
        txtTime.setColumns(10);


        txtPayment = new JTextField();
        txtPayment.setBounds(248,299,140,20);
        contentPane.add(txtPayment);
        txtPayment.setColumns(10);


        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Conn c = new Conn();

                    String s1 = c1.getSelectedItem();
                    String s2 = txtId.getText();
                    String s3 = txtStatus.getText();
                    String s4 = txtDate.getText();
                    String s5 = txtTime.getText();

                    c.s.executeUpdate("Update customer set room_number = '"+s2+"', name = '"+s3+"', status= '"+s4+"', deposit ='"+s5+"' where number = '"+s1+"'");
                    JOptionPane.showMessageDialog(null, "Data updated successfully");
                    new Reception().setVisible(true);
                    setVisible(false);



                }catch (Exception ee){
                    System.out.println(ee);
                }
            }
        });


        btnUpdate.setBounds(168,378,89,23);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        contentPane.add(btnUpdate);


        JButton btnAdd = new JButton("Check");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String s1 = c1.getSelectedItem();
                    Conn c = new Conn();
                    ResultSet rs1 = c.s.executeQuery("Select * from customer where number= "+s1);
                    while (rs1.next()){
                        txtId.setText(rs1.getString("room_number"));
                        txtStatus.setText(rs1.getString("name"));
                        txtDate.setText(rs1.getString("status"));
                        txtTime.setText(rs1.getString("deposit"));
                    }
                }catch (Exception ee){

                }

                try{
                    String total = "";
                    Conn c = new Conn();
                    ResultSet rs2 = c.s.executeQuery("Select * from where room_number= "+txtId.getText());
                    while(rs2.next()){
                        total = rs2.getString("price");
                    }

                    String paid= txtTime.getText();
                    int pending = Integer.parseInt(total)- Integer.parseInt(paid);
                    txtPayment.setText(Integer.toString(pending));
                }catch (Exception ew){}
            }
        });


        btnAdd.setBounds(56,378,89,23);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        contentPane.add(btnAdd);

        getContentPane().setBackground(Color.WHITE);























    }
}
