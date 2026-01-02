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

public class UpdateRoom extends JFrame {

    Connection conn = null;
    PreparedStatement pst;
    private JPanel contentPane;
    private JTextField txtId, txtAva, txtStatus, txtRoom;
    Choice c1 ;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    UpdateRoom frame = new UpdateRoom();
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

    public UpdateRoom() throws SQLException{

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530,200,1000,450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i3 = i1.getImage().getScaledInstance(550,250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(400,80,600,250);
        add(l1);

        JLabel lblUpdateRoomStatus = new JLabel("Update Room Status");
        lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN,20));
        lblUpdateRoomStatus.setBounds(85,11,206,34);
        contentPane.add(lblUpdateRoomStatus);


        JLabel lblNewLabel = new JLabel("Guest Id");
        lblNewLabel.setBounds(27,87,90,14);
        contentPane.add(lblNewLabel);

        c1 = new Choice();
        try{
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("Select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch (Exception e){ }
        c1.setBounds(160,84,140,20);
        contentPane.add(c1);

        JLabel lblAvailability = new JLabel("Availability: ");
        lblAvailability.setBounds(27,187,90,14);
        contentPane.add(lblAvailability);

        JLabel lblCleanStatus = new JLabel("Clean Status: ");
        lblCleanStatus.setBounds(27,240,90,14);
        contentPane.add(lblCleanStatus);

        txtAva = new JTextField();
        txtAva.setBounds(160,184,140,20);
        contentPane.add(txtAva);
        txtAva.setColumns(10);

        txtStatus = new JTextField();
        txtStatus.setBounds(160,237,140,20);
        contentPane.add(txtStatus);
        txtStatus.setColumns(10);

        txtRoom = new JTextField();
        txtRoom.setBounds(160,130,140,20);
        contentPane.add(txtRoom);
        txtRoom.setColumns(10);

        JButton b1 = new JButton("Check");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String s1 = c1.getSelectedItem();
                    Conn c = new Conn();
                    ResultSet rs1 = c.s.executeQuery("Select * from customer where number" +s1);
                    while(rs1.next()){
                        txtRoom.setText(rs1.getString("room_number"));
                    }
                }catch (Exception ee){}
            }
        });


        b1.setBounds(120,315,89,23);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);


        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws NumberFormatException{

                try{
                    Conn c = new Conn();
                    String str = "Update room set clean_status= '"+txtStatus.getText()+"' where room_number= "+txtRoom.getText();
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Update Successfull");
                    new Reception().setVisible(true);
                    setVisible(false);
                }catch (Exception ee){
                    ee.printStackTrace();
                }

            }
        });


        btnUpdate.setBounds(60,355,89,23);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        contentPane.add(btnUpdate);


        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });


        btnExit.setBounds(180,355,89,23);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);


        JLabel lblRoomId = new JLabel("Room Number: ");
        lblRoomId.setBounds(27,133,100,14);
        contentPane.add(lblRoomId);


        getContentPane().setBackground(Color.WHITE);









































    }
}
