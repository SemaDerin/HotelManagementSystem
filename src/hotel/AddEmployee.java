package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame {

    JTextField textFieldName, textFieldAge, textFieldSalary,
            textFieldPhone, textFieldAadhar, textFieldEmail;

    JComboBox<String> jobCombo;
    JRadioButton male, female;

    public AddEmployee() {

        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE DETAIL");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(900, 600);
        getContentPane().setLayout(null);

        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setBounds(60, 30, 150, 27);
        add(name);

        textFieldName = new JTextField();
        textFieldName.setBounds(200, 30, 150, 27);
        add(textFieldName);

        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        age.setBounds(60, 80, 150, 27);
        add(age);

        textFieldAge = new JTextField();
        textFieldAge.setBounds(200, 80, 150, 27);
        add(textFieldAge);

        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        gender.setBounds(60, 120, 150, 27);
        add(gender);

        male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(200, 120, 70, 27);
        add(male);

        female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(280, 120, 80, 27);
        add(female);

        // Radio button group EKLENDİ
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel job = new JLabel("JOB");
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        job.setBounds(60, 170, 150, 27);
        add(job);

        String jobList[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Stuff",
                "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};

        jobCombo = new JComboBox<>(jobList);
        jobCombo.setBackground(Color.WHITE);
        jobCombo.setBounds(200, 170, 200, 30);
        add(jobCombo);

        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        salary.setBounds(60, 220, 150, 27);
        add(salary);

        textFieldSalary = new JTextField();
        textFieldSalary.setBounds(200, 220, 150, 27);
        add(textFieldSalary);

        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        phone.setBounds(60, 270, 150, 27);
        add(phone);

        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(200, 270, 150, 27);
        add(textFieldPhone);

        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        aadhar.setBounds(60, 320, 150, 27);
        add(aadhar);

        textFieldAadhar = new JTextField();
        textFieldAadhar.setBounds(200, 320, 150, 27);
        add(textFieldAadhar);

        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 370, 150, 27);
        add(email);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(200, 370, 150, 27);
        add(textFieldEmail);

        JButton save = new JButton("SAVE");
        save.setBounds(200, 420, 150, 30);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        add(save);

        JLabel addEmployee = new JLabel("ADD EMPLOYEE DETAILS");
        addEmployee.setForeground(Color.BLUE);
        addEmployee.setFont(new Font("Tahoma", Font.PLAIN, 31));
        addEmployee.setBounds(450, 24, 442, 35);
        add(addEmployee);

        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image im3 = im1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon im2 = new ImageIcon(im3);
        JLabel image = new JLabel(im2);
        image.setBounds(410, 80, 480, 410);
        add(image);

        // SAVE BUTTON ACTION
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sname = textFieldName.getText();
                String sage = textFieldAge.getText();
                String ssalary = textFieldSalary.getText();
                String sphone = textFieldPhone.getText();
                String saadhr = textFieldAadhar.getText();
                String semail = textFieldEmail.getText();
                String sgender = null;

                if (male.isSelected())
                    sgender = "Male";
                else if (female.isSelected())
                    sgender = "Female";

                String sjob = (String) jobCombo.getSelectedItem();

                try {
                    Conn c = new Conn();

                    String query = "INSERT INTO employee VALUES ('" + sname + "','" + sage + "','" + sgender + "','" +
                            sjob + "','" + ssalary + "','" + sphone + "','" + saadhr + "','" + semail + "')";

                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                    setVisible(false);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setLocation(530, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
