package Sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Database
{
     String database(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery("select * from bookdata");
            ResultSet resultSet2 = statement.executeQuery("select * from employeecredentials");
            ResultSet resultSet3 = statement.executeQuery("select * from usercredentials");
            System.out.println("Connected Successfully");
            return("Connected Successfully");
        }
        catch (Exception e){
            return("Not Connected");
        }
    }
}

public class LoadingScreen
{
    public static void main(String[] args)
    {
        JFrame loadingscreenframe = new JFrame();
        JPanel loadingscreenpanel = new JPanel();
        loadingscreenpanel.setBackground(new Color(40, 48, 118, 255));
        loadingscreenpanel.setLayout(null);

        JLabel loadingscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        loadingscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        loadingscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        loadingscreentitlelabel.setBounds(0, 100, 800, 35);
        loadingscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel loadingscreenwaitlabel = new JLabel("Please wait while the app is ready to use :-)");
        loadingscreenwaitlabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        loadingscreenwaitlabel.setForeground(new Color(255, 255, 255, 255));
        loadingscreenwaitlabel.setBounds(0, 175, 800, 35);
        loadingscreenwaitlabel.setHorizontalAlignment(SwingConstants.CENTER);
        JProgressBar loadingscreenprogressbar = new JProgressBar();
        loadingscreenprogressbar.setBackground(new Color(17, 17, 16, 110));
        loadingscreenprogressbar.setForeground(new Color(255, 0, 0, 255));
        loadingscreenprogressbar.setOrientation(SwingConstants.HORIZONTAL);
        loadingscreenprogressbar.setMinimum(0);
        loadingscreenprogressbar.setMaximum(100);
        loadingscreenprogressbar.setValue(0);
        loadingscreenprogressbar.setBounds(50, 250, 700, 35);
        JButton loadingscreenproceedbutton = new JButton("Proceed");
        loadingscreenproceedbutton.setFont(new Font("Montserrat", Font.PLAIN, 28));
        loadingscreenproceedbutton.setBounds(320, 300, 160, 50);
        loadingscreenproceedbutton.setBackground(new Color(40, 48, 118, 255));
        loadingscreenproceedbutton.setForeground(new Color(255, 255, 255, 255));
        loadingscreenproceedbutton.setBorderPainted(false);
        loadingscreenproceedbutton.addActionListener(e -> {
        loadingscreenframe.dispose();
        UserLogin.main(null);
    });

        Database conn = new Database();
        String cursor = conn.database();

        loadingscreenpanel.add(loadingscreentitlelabel);
        loadingscreenpanel.add(loadingscreenwaitlabel);
        loadingscreenpanel.add(loadingscreenprogressbar);
        loadingscreenframe.add(loadingscreenpanel);
        loadingscreenframe.setBounds(0,0,800,500);
        loadingscreenpanel.setBounds(0, 0, 800, 500);
        loadingscreenframe.setVisible(true);

        int i = 0;
        if(cursor.equals("Connected Successfully")){
            while(i<=102){
                loadingscreenprogressbar.setValue(i);
                i += 3;
                if(i==33){
                    loadingscreenprogressbar.setForeground(new Color(255, 202, 0,255));
                }
                if(i==66){
                    loadingscreenprogressbar.setForeground(new Color(0, 255, 0,255));
                }
                if(i==102){
                    loadingscreenpanel.add(loadingscreenproceedbutton);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        loadingscreenframe.addWindowListener(new WindowAdapter() {
                                    public void windowClosing(WindowEvent we) {
                                        loadingscreenframe.dispose();
                                    }
                                }
        );
    }
}