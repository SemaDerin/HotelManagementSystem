package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JLabel titleLabel;
    JButton nextButton;

    public HotelManagementSystem() {

        setSize(1366, 430);
        setLayout(null);
        setLocation(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Arka plan resmi
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1366, 390, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);

        JLabel bgLabel = new JLabel(i2);
        bgLabel.setBounds(0, 0, 1366, 390);
        add(bgLabel);

        // Başlık
        titleLabel = new JLabel("HOTEL MANAGEMENT SYSTEM");
        titleLabel.setBounds(30, 300, 1500, 100);
        titleLabel.setFont(new Font("serif", Font.PLAIN, 70));
        titleLabel.setForeground(Color.RED);
        bgLabel.add(titleLabel);

        // Buton
        nextButton = new JButton("Next");
        nextButton.setBounds(1170, 325, 150, 50);
        nextButton.setBackground(Color.WHITE);
        nextButton.setForeground(Color.BLACK);
        nextButton.addActionListener(this);
        bgLabel.add(nextButton);

        // Yazıyı yanıp söndürmek için Swing Timer
        Timer timer = new Timer(500, e -> titleLabel.setVisible(!titleLabel.isVisible()));
        timer.start();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
