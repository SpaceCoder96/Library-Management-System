package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class UserLoginDatabase
{
    String userlogindatabase(String user, String pass){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from usercredentials");
            ResultSet rs = statement.executeQuery("SELECT username,passkey FROM usercredentials");
            while(rs.next()){
                if(user.equals(rs.getString("username")) && pass.equals(rs.getString("passkey"))){
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

public class UserLogin
{
    public static void main(String[] args) {
        JFrame userloginscreenframe = new JFrame();
        JPanel userloginscreenpanel = new JPanel();
        userloginscreenpanel.setLayout(null);
        userloginscreenpanel.setBackground(new Color(40, 48, 118, 255));

        JLabel userloginscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        userloginscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        userloginscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        userloginscreentitlelabel.setBounds(0, 20, 800, 35);
        userloginscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel userloginscreensecondtitlelabel = new JLabel("Enter Login Credentials");
        userloginscreensecondtitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        userloginscreensecondtitlelabel.setForeground(new Color(255, 255, 255, 255));
        userloginscreensecondtitlelabel.setBounds(0, 75, 800, 32);
        userloginscreensecondtitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel userloginscreenusernamelabel = new JLabel("Username: ");
        userloginscreenusernamelabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        userloginscreenusernamelabel.setForeground(new Color(255, 255, 255, 255));
        userloginscreenusernamelabel.setBounds(50, 150, 300, 28);

        JTextField userloginscreenusernametextfield = new JTextField();
        userloginscreenusernametextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        userloginscreenusernametextfield.setBackground(new Color(40, 48, 118, 255));
        userloginscreenusernametextfield.setForeground(new Color(255, 255, 255, 255));
        userloginscreenusernametextfield.setBounds(250, 150, 400, 35);

        JLabel userloginscreenpasswordlabel = new JLabel("Password: ");
        userloginscreenpasswordlabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        userloginscreenpasswordlabel.setForeground(new Color(255, 255, 255, 255));
        userloginscreenpasswordlabel.setBounds(50, 250, 300, 28);

        JPasswordField userloginscreenpasswordtextfield = new JPasswordField();
        userloginscreenpasswordtextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        userloginscreenpasswordtextfield.setBackground(new Color(40, 48, 118, 255));
        userloginscreenpasswordtextfield.setForeground(new Color(255, 255, 255, 255));
        userloginscreenpasswordtextfield.setBounds(250, 250, 400, 35);

        JButton userloginscreenloginbutton = new JButton("LOGIN");
        userloginscreenloginbutton.setFont(new Font("Montserrat", Font.PLAIN, 28));
        userloginscreenloginbutton.setBounds(320, 300, 160, 45);
        userloginscreenloginbutton.setBackground(new Color(40, 48, 118, 255));
        userloginscreenloginbutton.setForeground(new Color(255, 255, 255, 255));
        userloginscreenloginbutton.setBorderPainted(false);
        userloginscreenloginbutton.addActionListener(e -> {
            String user = userloginscreenusernametextfield.getText();
            String pass = String.valueOf(userloginscreenpasswordtextfield.getPassword());
            UserLoginDatabase login = new UserLoginDatabase();
            String result = login.userlogindatabase(user, pass);
            switch (result){
                case "Login": {
                    userloginscreenframe.dispose();
                    UserMain.main(null);
                }
                break;
                case "Not Connected": {
                    JOptionPane.showMessageDialog(null, "Database Offline. Try again later.");
                }
                break;
                default:{
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                    userloginscreenpasswordtextfield.setText("");
                    userloginscreenusernametextfield.setText("");
                }
            }
        });

        JButton userloginscreenemployeeloginbutton = new JButton("Login as an Employee");
        userloginscreenemployeeloginbutton.setFont(new Font("Montserrat", Font.PLAIN, 18));
        userloginscreenemployeeloginbutton.setBounds(240, 375, 320, 25);
        userloginscreenemployeeloginbutton.setBackground(new Color(40, 48, 118, 255));
        userloginscreenemployeeloginbutton.setForeground(new Color(255, 255, 255, 255));
        userloginscreenemployeeloginbutton.setBorderPainted(false);
        userloginscreenemployeeloginbutton.addActionListener(e -> {
            userloginscreenframe.dispose();
            EmployeeLogin.main(null);
        });

        JButton userloginscreenadminloginbutton = new JButton("Login as an Admin");
        userloginscreenadminloginbutton.setFont(new Font("Montserrat", Font.PLAIN, 18));
        userloginscreenadminloginbutton.setBounds(240, 415, 320, 25);
        userloginscreenadminloginbutton.setBackground(new Color(40, 48, 118, 255));
        userloginscreenadminloginbutton.setForeground(new Color(255, 255, 255, 255));
        userloginscreenadminloginbutton.setBorderPainted(false);
        userloginscreenadminloginbutton.addActionListener(e -> {
            userloginscreenframe.dispose();
            AdminLogin.main(null);
        });

        userloginscreenframe.add(userloginscreenpanel);
        userloginscreenpanel.add(userloginscreentitlelabel);
        userloginscreenpanel.add(userloginscreensecondtitlelabel);
        userloginscreenpanel.add(userloginscreenusernamelabel);
        userloginscreenpanel.add(userloginscreenpasswordlabel);
        userloginscreenpanel.add(userloginscreenusernametextfield);
        userloginscreenpanel.add(userloginscreenpasswordtextfield);
        userloginscreenpanel.add(userloginscreenloginbutton);
        userloginscreenpanel.add(userloginscreenemployeeloginbutton);
        userloginscreenpanel.add(userloginscreenadminloginbutton);

        userloginscreenframe.setBounds(0,0,800,500);
        userloginscreenpanel.setBounds(0, 0, 800, 500);
        userloginscreenframe.setVisible(true);
        userloginscreenframe.addWindowListener(new WindowAdapter() {
                                                 public void windowClosing(WindowEvent we) {
                                                     userloginscreenframe.dispose();
                                                 }
                                             }
        );
    }
}