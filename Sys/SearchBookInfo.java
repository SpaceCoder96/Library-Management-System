package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

class BookCodeSearch {
    String bookcodesearch(String book) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT bookname,bookcode FROM bookdata");
            while (rs.next()) {
                if (book.equals(rs.getString("bookname"))) {
                    return (rs.getString("bookcode"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return("");
    }
}

public class SearchBookInfo
{
    public static void main(String[] args) {
        JFrame searchbookinfoscreenframe = new JFrame();
        JPanel searchbookinfoscreenpanel = new JPanel();
        searchbookinfoscreenpanel.setBackground(new Color(40, 48, 118, 255));
        searchbookinfoscreenpanel.setLayout(null);

        JLabel searchbookinfoscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        searchbookinfoscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        searchbookinfoscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        searchbookinfoscreentitlelabel.setBounds(0, 100, 800, 35);
        searchbookinfoscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel searchbookinfoscreenwaitlabel = new JLabel("Enter the book's name to know more about it");
        searchbookinfoscreenwaitlabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        searchbookinfoscreenwaitlabel.setForeground(new Color(255, 255, 255, 255));
        searchbookinfoscreenwaitlabel.setBounds(0, 175, 800, 35);
        searchbookinfoscreenwaitlabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField searchbookinfoscreenbooknametextfield = new JTextField();
        searchbookinfoscreenbooknametextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        searchbookinfoscreenbooknametextfield.setBackground(new Color(40, 48, 118, 255));
        searchbookinfoscreenbooknametextfield.setForeground(new Color(255, 255, 255, 255));
        searchbookinfoscreenbooknametextfield.setBounds(100, 225, 600,35);

        ImageIcon backicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Back.png"));
        Image backiconimg = backicon.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon backicon1 = new ImageIcon(backiconimg);
        JButton searchbookinfoscreenbackbutton = new JButton("", backicon1);
        searchbookinfoscreenbackbutton.setBounds(0, 0, 50, 50);
        searchbookinfoscreenbackbutton.setBorderPainted(false);
        searchbookinfoscreenbackbutton.addActionListener(e -> {
            searchbookinfoscreenframe.dispose();
            UserMain.main(null);
        });
        JButton searchbookinfoscreenproceedbutton = new JButton("Search");
        searchbookinfoscreenproceedbutton.setFont(new Font("Montserrat", Font.PLAIN, 28));
        searchbookinfoscreenproceedbutton.setBounds(320, 300, 160, 50);
        searchbookinfoscreenproceedbutton.setBackground(new Color(40, 48, 118, 255));
        searchbookinfoscreenproceedbutton.setForeground(new Color(255, 255, 255, 255));
        searchbookinfoscreenproceedbutton.setBorderPainted(false);
        searchbookinfoscreenproceedbutton.addActionListener(e -> {
            searchbookinfoscreenframe.dispose();
            String book = searchbookinfoscreenbooknametextfield.getText();
            BookCodeSearch getcode = new BookCodeSearch();
            String code = getcode.bookcodesearch(book);
            if (code != "N.A."){
                BookInfo.main(code);
            }
        });

        searchbookinfoscreenpanel.add(searchbookinfoscreentitlelabel);
        searchbookinfoscreenpanel.add(searchbookinfoscreenwaitlabel);
        searchbookinfoscreenpanel.add(searchbookinfoscreenbackbutton);
        searchbookinfoscreenpanel.add(searchbookinfoscreenproceedbutton);
        searchbookinfoscreenpanel.add(searchbookinfoscreenbooknametextfield);
        searchbookinfoscreenframe.add(searchbookinfoscreenpanel);
        searchbookinfoscreenframe.setBounds(0,0,800,500);
        searchbookinfoscreenpanel.setBounds(0, 0, 800, 500);
        searchbookinfoscreenframe.setVisible(true);

        searchbookinfoscreenframe.addWindowListener(new WindowAdapter() {
                                                    public void windowClosing(WindowEvent we) {
                                                        searchbookinfoscreenframe.dispose();
                                                    }
                                                }
        );
    }
}