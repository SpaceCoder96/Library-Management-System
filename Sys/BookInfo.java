package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

class BookInfoSearch{
    String booknamesearch(String code) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT bookname,bookcode,author FROM bookdata");
            while (rs.next()) {
                if (code.equals(rs.getString("bookcode"))) {
                    return (rs.getString("bookname"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return("");
    }
    String bookauthorsearch(String code) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT bookname,bookcode,author FROM bookdata");
            while (rs.next()) {
                if (code.equals(rs.getString("bookcode"))) {
                    return (rs.getString("author"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return("");
    }
    String bookpublishedsearch(String code) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT bookname,bookcode,author,published FROM bookdata");
            while (rs.next()) {
                if (code.equals(rs.getString("bookcode"))) {
                    return (rs.getString("published"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return("");
    }
}

public class BookInfo
{
    public static void main(String code) {
        BookInfoSearch result = new BookInfoSearch();
        String name = result.booknamesearch(code);
        String author = result.bookauthorsearch(code);
        String publish = result.bookpublishedsearch(code);
        JFrame bookinfomainscreenframe = new JFrame();
        JPanel bookinfomainscreenpanel = new JPanel();
        bookinfomainscreenpanel.setBackground(new Color(40, 48, 118, 255));
        bookinfomainscreenpanel.setLayout(null);

        JLabel bookinfomainscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        bookinfomainscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        bookinfomainscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        bookinfomainscreentitlelabel.setBounds(0, 30, 1200, 35);
        bookinfomainscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel bookinfomainscreenbooknamelabel = new JLabel(name, SwingConstants.LEFT);
        bookinfomainscreenbooknamelabel.setFont(new Font("Montserrat", Font.PLAIN, 42));
        bookinfomainscreenbooknamelabel.setForeground(new Color(255, 255, 255, 255));
        bookinfomainscreenbooknamelabel.setBounds(50, 100, 850, 42);

        JLabel bookinfomainscreenauthornamelabel = new JLabel("-"+author);
        bookinfomainscreenauthornamelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        bookinfomainscreenauthornamelabel.setForeground(new Color(255, 255, 255, 255));
        bookinfomainscreenauthornamelabel.setBounds(0, 150, 350, 30);
        bookinfomainscreenauthornamelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel bookinfomainscreenwrittenlabel = new JLabel("Publishedin "+publish);
        bookinfomainscreenwrittenlabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        bookinfomainscreenwrittenlabel.setForeground(new Color(255, 255, 255, 255));
        bookinfomainscreenwrittenlabel.setBounds(0, 200, 325, 30);
        bookinfomainscreenwrittenlabel.setHorizontalAlignment(SwingConstants.CENTER);

        String data = new String();
        File file = new File("src/Sys/Assets/bookinfo/"+code+".txt");
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

        JLabel bookinfomainscreendescriptionarea = new JLabel(data);
        bookinfomainscreendescriptionarea.setFont(new Font("Montserrat", Font.PLAIN, 25));
        bookinfomainscreendescriptionarea.setBackground(new Color(72, 77, 129, 255));
        bookinfomainscreendescriptionarea.setForeground(new Color(255,255,255,255));
        bookinfomainscreendescriptionarea.setBounds(40, 175, 850, 400);

        ImageIcon covericon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/bookcover/"+code+".png"));
        Image covericonimg = covericon.getImage().getScaledInstance(250, 350,Image.SCALE_DEFAULT);
        ImageIcon covericon1 = new ImageIcon(covericonimg);
        JLabel bookinfomainscreencoverlabel = new JLabel("");
        bookinfomainscreencoverlabel.setIcon(covericon);
        bookinfomainscreencoverlabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        bookinfomainscreencoverlabel.setForeground(new Color(255, 255, 255, 255));
        bookinfomainscreencoverlabel.setBounds(890, 90, 300, 400);
        bookinfomainscreencoverlabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon backicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Back.png"));
        Image backiconimg = backicon.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon backicon1 = new ImageIcon(backiconimg);
        JButton bookinfomainscreenbackbutton = new JButton("", backicon1);
        bookinfomainscreenbackbutton.setBounds(0, 0, 50, 50);
        bookinfomainscreenbackbutton.setBorderPainted(false);
        bookinfomainscreenbackbutton.addActionListener(e -> {
            bookinfomainscreenframe.dispose();
            UserMain.main(null);
        });

        bookinfomainscreenpanel.add(bookinfomainscreentitlelabel);
        bookinfomainscreenpanel.add(bookinfomainscreenbackbutton);
        bookinfomainscreenpanel.add(bookinfomainscreencoverlabel);
        bookinfomainscreenpanel.add(bookinfomainscreenauthornamelabel);
        bookinfomainscreenpanel.add(bookinfomainscreenbooknamelabel);
        bookinfomainscreenpanel.add(bookinfomainscreenwrittenlabel);
        bookinfomainscreenpanel.add(bookinfomainscreendescriptionarea);
        bookinfomainscreenframe.add(bookinfomainscreenpanel);
        bookinfomainscreenframe.setBounds(0,0,1200,700);
        bookinfomainscreenpanel.setBounds(0, 0, 1200, 700);
        bookinfomainscreenframe.setVisible(true);

        bookinfomainscreenframe.addWindowListener(new WindowAdapter() {
                                                    public void windowClosing(WindowEvent we) {
                                                        bookinfomainscreenframe.dispose();
                                                    }
                                                }
        );
    }
}