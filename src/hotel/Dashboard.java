package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    public static void main(String[] args){
        new Dashboard().setVisible(true);
    }

    public Dashboard(){
        super("HOTEL MANAGEMENT SYSTEM");
        setForeground(Color.CYAN);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel newLabel = new JLabel(i3);
        newLabel.setBounds(0,0,1950,1000);
        add(newLabel);

        JLabel AirlineManagementSystem = new JLabel("THE TAJ GROUP WELCOMES YOU");
        AirlineManagementSystem.setForeground(Color.WHITE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN,46));
        AirlineManagementSystem.setBounds(600,60,1000,85);
        newLabel.add(AirlineManagementSystem);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu AirlineSystem = new JMenu("HOTEL MANAGEMENT");
        AirlineSystem.setForeground(Color.BLUE);
        menuBar.add(AirlineSystem);

        JMenuItem FlightDetails = new JMenuItem("RECEPTION");
        AirlineSystem.add(FlightDetails);

        JMenu AirlineSystemHello = new JMenu("ADMIN");
        AirlineSystemHello.setForeground(Color.RED);
        menuBar.add(AirlineSystemHello);

        JMenuItem FlightDetailsHello1 = new JMenuItem("ADD EMPLOYEE");
        AirlineSystemHello.add(FlightDetailsHello1);

        FlightDetailsHello1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //new AddEmployee().setVisible(true);
                }catch (Exception e1){

                }
            }
        });


        JMenuItem FlighDetailsHello2 = new JMenuItem("ADD ROOMS");
        AirlineSystemHello.add(FlighDetailsHello2);

        FlighDetailsHello2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    //new AddRoom().setVisible(true);
                }catch (Exception e){}

            }
        });

        FlightDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //new Reception();
            }
        });

        JMenuItem FlightDetailsHello3 = new JMenuItem("ADD DRIVERS");
        AirlineSystemHello.add(FlightDetailsHello3);
        FlightDetailsHello3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea) {
                try{
                    //new AddDrivers().setVisible(true);
                }catch (Exception e){}
            }
        });


        setSize(1950,1090);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);







    }


}
