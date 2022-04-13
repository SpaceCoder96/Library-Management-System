package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

class AuthorInfoSearch{
    String authornamesearch(String code) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT author,authorcode,author FROM bookdata");
            while (rs.next()) {
                if (code.equals(rs.getString("authorcode"))) {
                    return (rs.getString("author"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return("");
    }
    String authorbornsearch(String code) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT authorborn, authorcode,author FROM bookdata");
            while (rs.next()) {
                if (code.equals(rs.getString("authorcode"))) {
                    return (rs.getString("authorborn"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return("");
    }
    String authordiedsearch(String code) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT authordied,authorcode,author,published FROM bookdata");
            while (rs.next()) {
                if (code.equals(rs.getString("authorcode"))) {
                    return (rs.getString("authordied"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return("");
    }
}

public class AuthorInfo
{
    public static void main(String code) {
        AuthorInfoSearch result = new AuthorInfoSearch();
        String name = result.authornamesearch(code);
        String born = result.authorbornsearch(code);
        String died = result.authordiedsearch(code);
        JFrame authormainmainscreenframe = new JFrame();
        JPanel authormainmainscreenpanel = new JPanel();
        authormainmainscreenpanel.setBackground(new Color(40, 48, 118, 255));
        authormainmainscreenpanel.setLayout(null);

        JLabel authormainmainscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        authormainmainscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        authormainmainscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        authormainmainscreentitlelabel.setBounds(0, 50, 1200, 35);
        authormainmainscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel authormainmainscreenbooknamelabel = new JLabel(name);
        authormainmainscreenbooknamelabel.setFont(new Font("Montserrat", Font.PLAIN, 38));
        authormainmainscreenbooknamelabel.setForeground(new Color(255, 255, 255, 255));
        authormainmainscreenbooknamelabel.setBounds(25, 100, 525, 38);
        authormainmainscreenbooknamelabel.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel authormainmainscreenauthornamelabel = new JLabel("Born: "+born, SwingConstants.LEFT);
        authormainmainscreenauthornamelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        authormainmainscreenauthornamelabel.setForeground(new Color(255, 255, 255, 255));
        authormainmainscreenauthornamelabel.setBounds(25, 150, 525, 30);

        JLabel authormainmainscreenwrittenlabel = new JLabel("Died: "+died, SwingConstants.LEFT);
        authormainmainscreenwrittenlabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        authormainmainscreenwrittenlabel.setForeground(new Color(255, 255, 255, 255));
        authormainmainscreenwrittenlabel.setBounds(25, 200, 525, 30);

        String data = new String();
        File file = new File("src/Sys/Assets/authorinfo/"+code+".txt");
        Scanner myReader = null;
        try {
            myReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();

        }
        myReader.close();

        JLabel authormainmainscreendescriptionarea = new JLabel(data);
        authormainmainscreendescriptionarea.setFont(new Font("Montserrat", Font.PLAIN, 25));
        authormainmainscreendescriptionarea.setBackground(new Color(72, 77, 129, 255));
        authormainmainscreendescriptionarea.setForeground(new Color(255,255,255,255));
        authormainmainscreendescriptionarea.setBounds(40, 175, 850, 400);

        ImageIcon covericon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/authorphoto/"+code+".png"));
        Image covericonimg = covericon.getImage().getScaledInstance(250, 350,Image.SCALE_DEFAULT);
        ImageIcon covericon1 = new ImageIcon(covericonimg);
        JLabel authormainmainscreencoverlabel = new JLabel("");
        authormainmainscreencoverlabel.setIcon(covericon);
        authormainmainscreencoverlabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        authormainmainscreencoverlabel.setForeground(new Color(255, 255, 255, 255));
        authormainmainscreencoverlabel.setBounds(890, 90, 300, 400);
        authormainmainscreencoverlabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon backicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Back.png"));
        Image backiconimg = backicon.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon backicon1 = new ImageIcon(backiconimg);
        JButton authormainmainscreenbackbutton = new JButton("", backicon1);
        authormainmainscreenbackbutton.setBounds(0, 0, 50, 50);
        authormainmainscreenbackbutton.setBorderPainted(false);
        authormainmainscreenbackbutton.addActionListener(e -> {
            authormainmainscreenframe.dispose();
            UserMain.main(null);
        });

        authormainmainscreenpanel.add(authormainmainscreentitlelabel);
        authormainmainscreenpanel.add(authormainmainscreenbackbutton);
        authormainmainscreenpanel.add(authormainmainscreencoverlabel);
        authormainmainscreenpanel.add(authormainmainscreenauthornamelabel);
        authormainmainscreenpanel.add(authormainmainscreenbooknamelabel);
        authormainmainscreenpanel.add(authormainmainscreenwrittenlabel);
        authormainmainscreenpanel.add(authormainmainscreendescriptionarea);
        authormainmainscreenframe.add(authormainmainscreenpanel);
        authormainmainscreenframe.setBounds(0,0,1200,700);
        authormainmainscreenpanel.setBounds(0, 0, 1200, 700);
        authormainmainscreenframe.setVisible(true);

        authormainmainscreenframe.addWindowListener(new WindowAdapter() {
                                                      public void windowClosing(WindowEvent we) {
                                                          authormainmainscreenframe.dispose();
                                                      }
                                                  }
        );
    }
}