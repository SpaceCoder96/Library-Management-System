package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class EmployeeBookState{
    String name(String code){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
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
            ResultSet rs = statement.executeQuery("SELECT bookstatus,bookcode,returndate,issuedto FROM bookdata");
            while(rs.next()){
                if(code.equals(rs.getString("bookcode"))){
                    String store = rs.getString("bookstatus");
                    if(store.equals("1")){
                        return("Book Available");
                    }
                    if(store.equals("0")){
                        return ("Available by "+rs.getString("returndate"));
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
    String issuestate(String code){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT bookstatus,bookcode,returndate,issuedto FROM bookdata");
            while(rs.next()){
                if(code.equals(rs.getString("bookcode"))){
                    String store = rs.getString("bookstatus");
                    if(store.equals("1")){
                        return("Book Available");
                    }
                    if(store.equals("0")){
                        return (rs.getString("issuedto"));
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
    String genrestate(String code){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT bookstatus,bookcode,genre,issuedto FROM bookdata");
            while(rs.next()){
                if(code.equals(rs.getString("bookcode"))){
                    return (rs.getString("genre"));
                }
            }
        }
        catch (Exception e){
            return("Not Connected");
        }
        return("");
    }
    String foundstate(String code){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT bookstatus,bookcode,store,issuedto FROM bookdata");
            while(rs.next()){
                if(code.equals(rs.getString("bookcode"))){
                    return (rs.getString("store"));
                }
            }
        }
        catch (Exception e){
            return("Not Connected");
        }
        return("");
    }
}

public class EmployeeBookInfo
{
    public static void main(String code) {
        EmployeeBookState state = new EmployeeBookState();
        String bookname = state.name(code);
        String authorname = state.authorname(code);
        String status = state.state(code);
        String issued = state.issuestate(code);
        String genre = state.genrestate(code);
        String store = state.foundstate(code);
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
        bookstatusscreennamelabel.setBounds(0, 125, 500, 35);
        bookstatusscreennamelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel bookstatusscreenauthornamelabel = new JLabel(authorname);
        bookstatusscreenauthornamelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        bookstatusscreenauthornamelabel.setForeground(new Color(255, 255, 255, 255));
        bookstatusscreenauthornamelabel.setBounds(0, 175, 500, 35);
        bookstatusscreenauthornamelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel bookstatusscreenissuelabel = new JLabel(status);
        bookstatusscreenissuelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        bookstatusscreenissuelabel.setForeground(new Color(255, 255, 255, 255));
        bookstatusscreenissuelabel.setBounds(0, 225, 500, 35);
        bookstatusscreenissuelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel bookstatusscreencurrentlabel = new JLabel("Issued to: "+issued);
        bookstatusscreencurrentlabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        bookstatusscreencurrentlabel.setForeground(new Color(255, 255, 255, 255));
        bookstatusscreencurrentlabel.setBounds(0, 275, 500, 35);
        bookstatusscreencurrentlabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel bookstatusscreengenrelabel = new JLabel("Genre: "+genre);
        bookstatusscreengenrelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        bookstatusscreengenrelabel.setForeground(new Color(255, 255, 255, 255));
        bookstatusscreengenrelabel.setBounds(0, 325, 500, 35);
        bookstatusscreengenrelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel bookstatusscreenstoredlabel = new JLabel("Found in: "+store);
        bookstatusscreenstoredlabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        bookstatusscreenstoredlabel.setForeground(new Color(255, 255, 255, 255));
        bookstatusscreenstoredlabel.setBounds(0, 375, 500, 35);
        bookstatusscreenstoredlabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon covericon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/bookcover/"+code+".png"));
        Image covericonimg = covericon.getImage().getScaledInstance(250, 350,Image.SCALE_DEFAULT);
        ImageIcon covericon1 = new ImageIcon(covericonimg);
        JLabel bookstatusscreencoverlabel = new JLabel("");
        bookstatusscreencoverlabel.setIcon(covericon1);
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
            EmployeeMain.main(null);
        });

        bookstatusscreenpanel.add(bookstatusscreentitlelabel);
        bookstatusscreenpanel.add(bookstatusscreenbackbutton);
        bookstatusscreenpanel.add(bookstatusscreenauthornamelabel);
        bookstatusscreenpanel.add(bookstatusscreennamelabel);
        bookstatusscreenpanel.add(bookstatusscreenissuelabel);
        bookstatusscreenpanel.add(bookstatusscreencoverlabel);
        bookstatusscreenpanel.add(bookstatusscreencurrentlabel);
        bookstatusscreenpanel.add(bookstatusscreengenrelabel);
        bookstatusscreenpanel.add(bookstatusscreenstoredlabel);
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