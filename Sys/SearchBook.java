package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class BookSearch{
    String booksearch(String book){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT bookname,bookcode FROM bookdata");
            while(rs.next()){
                if(book.equals(rs.getString("bookname"))){
                    return(rs.getString("bookcode"));
                }
            }
        }
        catch (Exception e){
            return("Not Connected");
        }
        return("Invalid");
    }
}

public class SearchBook
{
    public static void main(String[] args) {
        JFrame searchbookscreenframe = new JFrame();
        JPanel searchbookscreenpanel = new JPanel();
        searchbookscreenpanel.setBackground(new Color(40, 48, 118, 255));
        searchbookscreenpanel.setLayout(null);

        JLabel searchbookscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        searchbookscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        searchbookscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        searchbookscreentitlelabel.setBounds(0, 100, 800, 35);
        searchbookscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel searchbookscreenwaitlabel = new JLabel("Enter the book's name to know its status");
        searchbookscreenwaitlabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        searchbookscreenwaitlabel.setForeground(new Color(255, 255, 255, 255));
        searchbookscreenwaitlabel.setBounds(0, 175, 800, 35);
        searchbookscreenwaitlabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField searchbookscreenbooknametextfield = new JTextField();
        searchbookscreenbooknametextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        searchbookscreenbooknametextfield.setBackground(new Color(40, 48, 118, 255));
        searchbookscreenbooknametextfield.setForeground(new Color(255, 255, 255, 255));
        searchbookscreenbooknametextfield.setBounds(100, 225, 600,35);

        ImageIcon backicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Back.png"));
        Image backiconimg = backicon.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon backicon1 = new ImageIcon(backiconimg);
        JButton searchbookscreenbackbutton = new JButton("", backicon1);
        searchbookscreenbackbutton.setBounds(0, 0, 50, 50);
        searchbookscreenbackbutton.setBorderPainted(false);
        searchbookscreenbackbutton.addActionListener(e -> {
            searchbookscreenframe.dispose();
            UserMain.main(null);
        });
        JButton searchbookscreenproceedbutton = new JButton("Search");
        searchbookscreenproceedbutton.setFont(new Font("Montserrat", Font.PLAIN, 28));
        searchbookscreenproceedbutton.setBounds(320, 300, 160, 50);
        searchbookscreenproceedbutton.setBackground(new Color(40, 48, 118, 255));
        searchbookscreenproceedbutton.setForeground(new Color(255, 255, 255, 255));
        searchbookscreenproceedbutton.setBorderPainted(false);
        searchbookscreenproceedbutton.addActionListener(e -> {
            String book = searchbookscreenbooknametextfield.getText();
            BookSearch search = new BookSearch();
            String code = search.booksearch(book);
            String codevalid = code.substring(0,2);
            switch (codevalid) {
                case "00": {
                    searchbookscreenframe.dispose();
                    BookStatus.main(code);
                }
                break;
                case "No": {
                    JOptionPane.showMessageDialog(null, "Database Offline. Try again later.");
                }
                break;
                case "In": {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials.");
                }
                break;
                default: {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                    searchbookscreenbooknametextfield.setText("");
                }
            }
        });

        searchbookscreenpanel.add(searchbookscreentitlelabel);
        searchbookscreenpanel.add(searchbookscreenwaitlabel);
        searchbookscreenpanel.add(searchbookscreenbackbutton);
        searchbookscreenpanel.add(searchbookscreenproceedbutton);
        searchbookscreenpanel.add(searchbookscreenbooknametextfield);
        searchbookscreenframe.add(searchbookscreenpanel);
        searchbookscreenframe.setBounds(0,0,800,500);
        searchbookscreenpanel.setBounds(0, 0, 800, 500);
        searchbookscreenframe.setVisible(true);

        searchbookscreenframe.addWindowListener(new WindowAdapter() {
                                                 public void windowClosing(WindowEvent we) {
                                                     searchbookscreenframe.dispose();
                                                 }
                                             }
        );
    }
}