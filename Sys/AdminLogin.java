package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

class AdminValidation{
    String adminvalidation(String user, String pass){
        if(user.equals("admin")&&pass.equals("admin123")){
            return("Login");
        }
        return ("Invalid");
    }
}

public class AdminLogin
{
    public static void main(String[] args) {
        JFrame adminloginscreenframe = new JFrame();
        JPanel adminloginscreenpanel = new JPanel();
        adminloginscreenpanel.setLayout(null);
        adminloginscreenpanel.setBackground(new Color(40, 48, 118, 255));

        JLabel adminloginscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        adminloginscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        adminloginscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        adminloginscreentitlelabel.setBounds(0, 20, 800, 35);
        adminloginscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel adminloginscreensecondtitlelabel = new JLabel("Enter Login Credentials");
        adminloginscreensecondtitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        adminloginscreensecondtitlelabel.setForeground(new Color(255, 255, 255, 255));
        adminloginscreensecondtitlelabel.setBounds(0, 75, 800, 32);
        adminloginscreensecondtitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel adminloginscreenadminnamelabel = new JLabel("Admin ID: ");
        adminloginscreenadminnamelabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        adminloginscreenadminnamelabel.setForeground(new Color(255, 255, 255, 255));
        adminloginscreenadminnamelabel.setBounds(50, 150, 300, 30);

        JTextField adminloginscreenadminnametextfield = new JTextField();
        adminloginscreenadminnametextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        adminloginscreenadminnametextfield.setBackground(new Color(40, 48, 118, 255));
        adminloginscreenadminnametextfield.setForeground(new Color(255, 255, 255, 255));
        adminloginscreenadminnametextfield.setBounds(250, 150, 400,35);

        JLabel adminloginscreenpasswordlabel = new JLabel("Password: ");
        adminloginscreenpasswordlabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        adminloginscreenpasswordlabel.setForeground(new Color(255, 255, 255, 255));
        adminloginscreenpasswordlabel.setBounds(50, 250, 300, 30);

        JPasswordField adminloginscreenpasswordtextfield = new JPasswordField();
        adminloginscreenpasswordtextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        adminloginscreenpasswordtextfield.setBackground(new Color(40, 48, 118, 255));
        adminloginscreenpasswordtextfield.setForeground(new Color(255, 255, 255, 255));
        adminloginscreenpasswordtextfield.setBounds(250, 250, 400,35);

        JButton adminloginscreenloginbutton = new JButton("LOGIN");
        adminloginscreenloginbutton.setFont(new Font("Montserrat", Font.PLAIN, 28));
        adminloginscreenloginbutton.setBounds(320, 300, 160, 45);
        adminloginscreenloginbutton.setBackground(new Color(40, 48, 118, 255));
        adminloginscreenloginbutton.setForeground(new Color(255, 255, 255, 255));
        adminloginscreenloginbutton.setBorderPainted(false);
        adminloginscreenloginbutton.addActionListener(e -> {
            String user = adminloginscreenadminnametextfield.getText();
            String pass = String.valueOf(adminloginscreenpasswordtextfield.getPassword());
            AdminValidation login = new AdminValidation();
            String result = login.adminvalidation(user, pass);
                switch (result){
                    case "Login":{
                        adminloginscreenframe.dispose();
                        try {
                            AdminMain.main(null);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    break;
                    case "Invalid":{
                        adminloginscreenadminnametextfield.setText("");
                        adminloginscreenpasswordtextfield.setText("");
                        JOptionPane.showMessageDialog(null, "Invalid Credentials");
                    }
                    break;
                    default: JOptionPane.showMessageDialog(null, "Invalid Credentials");

            }
        });

        ImageIcon backicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Back.png"));
        Image backiconimg = backicon.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon backicon1 = new ImageIcon(backiconimg);
        JButton adminloginscreenbackbutton = new JButton("", backicon1);
        adminloginscreenbackbutton.setBounds(0, 0, 50, 50);
        adminloginscreenbackbutton.setBorderPainted(false);
        adminloginscreenbackbutton.addActionListener(e -> {
            adminloginscreenframe.dispose();
            UserLogin.main(null);
        });

        adminloginscreenframe.add(adminloginscreenpanel);
        adminloginscreenpanel.add(adminloginscreentitlelabel);
        adminloginscreenpanel.add(adminloginscreensecondtitlelabel);
        adminloginscreenpanel.add(adminloginscreenadminnamelabel);
        adminloginscreenpanel.add(adminloginscreenpasswordlabel);
        adminloginscreenpanel.add(adminloginscreenadminnametextfield);
        adminloginscreenpanel.add(adminloginscreenpasswordtextfield);
        adminloginscreenpanel.add(adminloginscreenloginbutton);
        adminloginscreenpanel.add(adminloginscreenbackbutton);

        adminloginscreenframe.setBounds(0,0,800,500);
        adminloginscreenpanel.setBounds(0, 0, 800, 500);
        adminloginscreenframe.setVisible(true);
        adminloginscreenframe.addWindowListener(new WindowAdapter() {
                                                   public void windowClosing(WindowEvent we) {
                                                       adminloginscreenframe.dispose();
                                                   }
                                               }
        );
    }
}