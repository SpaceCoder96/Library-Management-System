package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class EmployeeLoginDatabase
{
    String employeelogindatabase(String user, String pass){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from employeecredentials");
            ResultSet rs = statement.executeQuery("SELECT empid,passkey FROM employeecredentials");
            while(rs.next()){
                if(user.equals(rs.getString("empid")) && pass.equals(rs.getString("passkey"))){
                    return("Login");
                }
            }
        }
        catch (Exception e){
            return("Not Connected");
        }
        return("");
    }
}

public class EmployeeLogin
{
    public static void main(String[] args) {
        JFrame employeeloginscreenframe = new JFrame();
        JPanel employeeloginscreenpanel = new JPanel();
        employeeloginscreenpanel.setLayout(null);
        employeeloginscreenpanel.setBackground(new Color(40, 48, 118, 255));

        JLabel employeeloginscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        employeeloginscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        employeeloginscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        employeeloginscreentitlelabel.setBounds(0, 20, 800, 35);
        employeeloginscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel employeeloginscreensecondtitlelabel = new JLabel("Enter Login Credentials");
        employeeloginscreensecondtitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        employeeloginscreensecondtitlelabel.setForeground(new Color(255, 255, 255, 255));
        employeeloginscreensecondtitlelabel.setBounds(0, 75, 800, 32);
        employeeloginscreensecondtitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel employeeloginscreenemployeenamelabel = new JLabel("Employee ID: ");
        employeeloginscreenemployeenamelabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        employeeloginscreenemployeenamelabel.setForeground(new Color(255, 255, 255, 255));
        employeeloginscreenemployeenamelabel.setBounds(50, 150, 300, 30);

        JTextField employeeloginscreenemployeenametextfield = new JTextField();
        employeeloginscreenemployeenametextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        employeeloginscreenemployeenametextfield.setBackground(new Color(40, 48, 118, 255));
        employeeloginscreenemployeenametextfield.setForeground(new Color(255, 255, 255, 255));
        employeeloginscreenemployeenametextfield.setBounds(250, 150, 400, 35);

        JLabel employeeloginscreenpasswordlabel = new JLabel("Password: ");
        employeeloginscreenpasswordlabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        employeeloginscreenpasswordlabel.setForeground(new Color(255, 255, 255, 255));
        employeeloginscreenpasswordlabel.setBounds(50, 250, 300, 30);

        JPasswordField employeeloginscreenpasswordtextfield = new JPasswordField();
        employeeloginscreenpasswordtextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        employeeloginscreenpasswordtextfield.setBackground(new Color(40, 48, 118, 255));
        employeeloginscreenpasswordtextfield.setForeground(new Color(255, 255, 255, 255));
        employeeloginscreenpasswordtextfield.setBounds(250, 250, 400, 35);

        JButton employeeloginscreenloginbutton = new JButton("LOGIN");
        employeeloginscreenloginbutton.setFont(new Font("Montserrat", Font.PLAIN, 28));
        employeeloginscreenloginbutton.setBounds(320, 300, 160, 45);
        employeeloginscreenloginbutton.setBackground(new Color(40, 48, 118, 255));
        employeeloginscreenloginbutton.setForeground(new Color(255, 255, 255, 255));
        employeeloginscreenloginbutton.setBorderPainted(false);
        employeeloginscreenloginbutton.addActionListener(e -> {
            String user = employeeloginscreenemployeenametextfield.getText();
            String pass = String.valueOf(employeeloginscreenpasswordtextfield.getPassword());
            EmployeeLoginDatabase login = new EmployeeLoginDatabase();
            String result = login.employeelogindatabase(user, pass);
            switch (result){
                case "Login": {
                    employeeloginscreenframe.dispose();
                    EmployeeMain.main(null);
                }
                break;
                case "Not Connected": {
                    JOptionPane.showMessageDialog(null, "Database Offline. Try again later.");
                }
                break;
                default:{
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                    employeeloginscreenemployeenametextfield.setText("");
                    employeeloginscreenpasswordtextfield.setText("");
                }
            }
        });

        ImageIcon backicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Back.png"));
        Image backiconimg = backicon.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon backicon1 = new ImageIcon(backiconimg);
        JButton employeeloginscreenbackbutton = new JButton("", backicon1);
        employeeloginscreenbackbutton.setBounds(0, 0, 50, 50);
        employeeloginscreenbackbutton.setBorderPainted(false);
        employeeloginscreenbackbutton.addActionListener(e -> {
            employeeloginscreenframe.dispose();
            UserLogin.main(null);
        });

        employeeloginscreenframe.add(employeeloginscreenpanel);
        employeeloginscreenpanel.add(employeeloginscreentitlelabel);
        employeeloginscreenpanel.add(employeeloginscreensecondtitlelabel);
        employeeloginscreenpanel.add(employeeloginscreenemployeenamelabel);
        employeeloginscreenpanel.add(employeeloginscreenpasswordlabel);
        employeeloginscreenpanel.add(employeeloginscreenemployeenametextfield);
        employeeloginscreenpanel.add(employeeloginscreenpasswordtextfield);
        employeeloginscreenpanel.add(employeeloginscreenloginbutton);
        employeeloginscreenpanel.add(employeeloginscreenbackbutton);

        employeeloginscreenframe.setBounds(0,0,800,500);
        employeeloginscreenpanel.setBounds(0, 0, 800, 500);
        employeeloginscreenframe.setVisible(true);
        employeeloginscreenframe.addWindowListener(new WindowAdapter() {
                                                   public void windowClosing(WindowEvent we) {
                                                       employeeloginscreenframe.dispose();
                                                   }
                                               }
        );
    }
}