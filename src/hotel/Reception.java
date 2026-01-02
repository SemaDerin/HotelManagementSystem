package hotel;

import javax.print.attribute.standard.JobName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.EmptyStackException;

public class Reception extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args){
        new Reception();
    }

    public Reception(){
        setBounds(530,200,850,570);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(250,30,500,470);
        add(l1);



        JButton btnNewCustomerForm = new JButton("New Customer Form");
        btnNewCustomerForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    NewCustomer custom = new NewCustomer();
                    custom.setVisible(true);
                    setVisible(false);
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });


        btnNewCustomerForm.setBounds(10,30,200,30);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.WHITE);
        contentPane.add(btnNewCustomerForm);

        JButton btnNewButton = new JButton("Room");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Room room = new Room();
                    room.setVisible(true);
                    setVisible(false);

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        btnNewButton.setBounds(10,70,200,30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);


        JButton btnNewButton2 = new JButton("All Employee Info");
        btnNewButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Employee em = new Employee();
                    em.setVisible(true);
                    setVisible(false);
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });


        btnNewButton2.setBounds(10,150,200,30);
        btnNewButton2.setBackground(Color.BLACK);
        btnNewButton2.setForeground(Color.WHITE);
        contentPane.add(btnNewButton2);


        JButton btnManagerInfo = new JButton("Manager Info");
        btnManagerInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ManagerInfo mana =  new ManagerInfo();
                    mana.setVisible(true);
                    setVisible(false);
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        btnManagerInfo.setBounds(10,230,200,30);
        btnManagerInfo.setBackground(Color.BLACK);
        btnManagerInfo.setForeground(Color.WHITE);
        contentPane.add(btnManagerInfo);

        JButton btnNewButton4 = new JButton("Check Out");
        btnNewButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckOut check ;   // bu constructor SQLException atıyorsa
                try{
                    check = new CheckOut();
                    check.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });


        btnNewButton4.setBounds(10,270,200,30);
        btnNewButton4.setBackground(Color.BLACK);
        btnNewButton4.setForeground(Color.WHITE);
        contentPane.add(btnNewButton4);



        JButton btnNewButton5 = new JButton("Update Check Status");
        btnNewButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    UpdateCheck update = new UpdateCheck();
                    update.setVisible(true);
                    setVisible(false);
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        btnNewButton5.setBounds(10,310,200,30);
        btnNewButton5.setBackground(Color.BLACK);
        btnNewButton5.setForeground(Color.WHITE);
        contentPane.add(btnNewButton5);


        JButton btnNewButton6 = new JButton("Update Room Status");
        btnNewButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    UpdateRoom room = new UpdateRoom();
                    room.setVisible(true);
                    setVisible(false);
                }catch (Exception s){
                    s.printStackTrace();
                }
            }
        });

        btnNewButton6.setBounds(10,350,200,30);
        btnNewButton6.setBackground(Color.BLACK);
        btnNewButton6.setForeground(Color.WHITE);
        contentPane.add(btnNewButton6);

        JButton btnPickUpService = new JButton("Pick Up Service");
        btnPickUpService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    PickUp pick = new PickUp();
                    pick.setVisible(true);
                    setVisible(false);
                }catch (Exception ss){
                    ss.printStackTrace();
                }
            }
        });

        btnPickUpService.setBounds(10,390,200,30);
        btnPickUpService.setBackground(Color.BLACK);
        btnPickUpService.setForeground(Color.WHITE);
        contentPane.add(btnPickUpService);


        JButton btnSearchButton = new JButton("Search Room");
        btnSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    SearchRoom search = new SearchRoom();
                    search.setVisible(true);
                    setVisible(false);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        btnSearchButton.setBounds(10,430,200,30);
        btnSearchButton.setBackground(Color.BLACK);
        btnSearchButton.setForeground(Color.WHITE);

        contentPane.add(btnSearchButton);


        JButton btnNewButton7 = new JButton("Log Out");
        btnNewButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Login().setVisible(true);
                    setVisible(false);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        btnNewButton7.setBounds(10,470,200,30);
        btnNewButton7.setBackground(Color.BLACK);
        btnNewButton7.setForeground(Color.WHITE);
        contentPane.add(btnNewButton7);

        getContentPane().setBackground(Color.WHITE);






        setVisible(true);











    }


}
