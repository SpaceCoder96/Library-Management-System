package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class BookState{
    String name(String code){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT bookname,bookcode FROM bookdata");
            while(rs.next()){
                if(code.equals(rs.getString("bookcode"))){
                    return(rs.getString("bookname"));
                }
            }
        }
        catch (Exception e){
            return("Not Connected");
        }
        return("");
    }
    String authorname(String code){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT author,bookcode FROM bookdata");
            while(rs.next()){
                if(code.equals(rs.getString("bookcode"))){
                    return(rs.getString("author"));
                }
            }
        }
        catch (Exception e){
            return("Not Connected");
        }
        return("");
    }
    String state(String code){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT bookstatus,bookcode,returndate FROM bookdata");
            while(rs.next()){
                if(code.equals(rs.getString("bookcode"))){
                    String store = rs.getString("bookstatus");
                    if(store.equals("1")){
                        return("Book Available");
                    }
                    if(store.equals("0")){
                        return ("Book will be available by "+rs.getString("returndate"));
                    }
                    else{
                        return("Not Connected");
                    }
                }
            }
        }
        catch (Exception e){
            return("Not Connected");
        }
        return("");
    }
}

public class BookStatus
{
    public static void main(String code) {
        BookState state = new BookState();
        String bookname = state.name(code);
        String authorname = state.authorname(code);
        String status = state.state(code);
        JFrame bookstatusscreenframe = new JFrame();
        JPanel bookstatusscreenpanel = new JPanel();
        bookstatusscreenpanel.setBackground(new Color(40, 48, 118, 255));
        bookstatusscreenpanel.setLayout(null);

        JLabel bookstatusscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        bookstatusscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        bookstatusscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        bookstatusscreentitlelabel.setBounds(0, 50, 800, 35);
        bookstatusscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel bookstatusscreennamelabel = new JLabel(bookname);
        bookstatusscreennamelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        bookstatusscreennamelabel.setForeground(new Color(255, 255, 255, 255));
        bookstatusscreennamelabel.setBounds(0, 175, 500, 35);
        bookstatusscreennamelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel bookstatusscreenauthornamelabel = new JLabel(authorname);
        bookstatusscreenauthornamelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        bookstatusscreenauthornamelabel.setForeground(new Color(255, 255, 255, 255));
        bookstatusscreenauthornamelabel.setBounds(0, 225, 500, 35);
        bookstatusscreenauthornamelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel bookstatusscreenissuelabel = new JLabel(status);
        bookstatusscreenissuelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        bookstatusscreenissuelabel.setForeground(new Color(255, 255, 255, 255));
        bookstatusscreenissuelabel.setBounds(0, 275, 500, 35);
        bookstatusscreenissuelabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon covericon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/bookcover/"+code+".png"));
        Image covericonimg = covericon.getImage().getScaledInstance(250, 350,Image.SCALE_DEFAULT);
        ImageIcon covericon1 = new ImageIcon(covericonimg);
        JLabel bookstatusscreencoverlabel = new JLabel("");
        bookstatusscreencoverlabel.setIcon(covericon);
        bookstatusscreencoverlabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        bookstatusscreencoverlabel.setForeground(new Color(255, 255, 255, 255));
        bookstatusscreencoverlabel.setBounds(500, 100, 250, 350);
        bookstatusscreencoverlabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon backicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Back.png"));
        Image backiconimg = backicon.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon backicon1 = new ImageIcon(backiconimg);
        JButton bookstatusscreenbackbutton = new JButton("", backicon1);
        bookstatusscreenbackbutton.setBounds(0, 0, 50, 50);
        bookstatusscreenbackbutton.setBorderPainted(false);
        bookstatusscreenbackbutton.addActionListener(e -> {
            bookstatusscreenframe.dispose();
            UserMain.main(null);
        });

        bookstatusscreenpanel.add(bookstatusscreentitlelabel);
        bookstatusscreenpanel.add(bookstatusscreenbackbutton);
        bookstatusscreenpanel.add(bookstatusscreenauthornamelabel);
        bookstatusscreenpanel.add(bookstatusscreennamelabel);
        bookstatusscreenpanel.add(bookstatusscreenissuelabel);
        bookstatusscreenpanel.add(bookstatusscreencoverlabel);
        bookstatusscreenframe.add(bookstatusscreenpanel);
        bookstatusscreenframe.setBounds(0,0,800,500);
        bookstatusscreenpanel.setBounds(0, 0, 800, 500);
        bookstatusscreenframe.setVisible(true);

        bookstatusscreenframe.addWindowListener(new WindowAdapter() {
                                                    public void windowClosing(WindowEvent we) {
                                                        bookstatusscreenframe.dispose();
                                                    }
                                                }
        );
    }
}