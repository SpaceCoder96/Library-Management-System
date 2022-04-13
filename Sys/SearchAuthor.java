package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

class AuthorCodeSearch {
    String authorcodesearch(String author) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT bookname,authorcode,author FROM bookdata");
            while (rs.next()) {
                if (author.equals(rs.getString("author"))) {
                    return (rs.getString("authorcode"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return("");
    }
}

public class SearchAuthor
{
    public static void main(String[] args) {
        JFrame searchauthorscreenframe = new JFrame();
        JPanel searchauthorscreenpanel = new JPanel();
        searchauthorscreenpanel.setBackground(new Color(40, 48, 118, 255));
        searchauthorscreenpanel.setLayout(null);

        JLabel searchauthorscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        searchauthorscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        searchauthorscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        searchauthorscreentitlelabel.setBounds(0, 100, 800, 35);
        searchauthorscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel searchauthorscreenwaitlabel = new JLabel("Enter the Author's name to know more about them");
        searchauthorscreenwaitlabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        searchauthorscreenwaitlabel.setForeground(new Color(255, 255, 255, 255));
        searchauthorscreenwaitlabel.setBounds(0, 175, 800, 35);
        searchauthorscreenwaitlabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField searchauthorscreenbooknametextfield = new JTextField();
        searchauthorscreenbooknametextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        searchauthorscreenbooknametextfield.setBackground(new Color(40, 48, 118, 255));
        searchauthorscreenbooknametextfield.setForeground(new Color(255, 255, 255, 255));
        searchauthorscreenbooknametextfield.setBounds(100, 225, 600,35);

        ImageIcon backicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Back.png"));
        Image backiconimg = backicon.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon backicon1 = new ImageIcon(backiconimg);
        JButton searchauthorscreenbackbutton = new JButton("", backicon1);
        searchauthorscreenbackbutton.setBounds(0, 0, 50, 50);
        searchauthorscreenbackbutton.setBorderPainted(false);
        searchauthorscreenbackbutton.addActionListener(e -> {
            searchauthorscreenframe.dispose();
            UserMain.main(null);
        });
        JButton searchauthorscreenproceedbutton = new JButton("Search");
        searchauthorscreenproceedbutton.setFont(new Font("Montserrat", Font.PLAIN, 28));
        searchauthorscreenproceedbutton.setBounds(320, 300, 160, 50);
        searchauthorscreenproceedbutton.setBackground(new Color(40, 48, 118, 255));
        searchauthorscreenproceedbutton.setForeground(new Color(255, 255, 255, 255));
        searchauthorscreenproceedbutton.setBorderPainted(false);
        searchauthorscreenproceedbutton.addActionListener(e -> {
            searchauthorscreenframe.dispose();
            AuthorCodeSearch result = new AuthorCodeSearch();
            String code = result.authorcodesearch(searchauthorscreenbooknametextfield.getText());
            AuthorInfo.main(code);
        });

        searchauthorscreenpanel.add(searchauthorscreentitlelabel);
        searchauthorscreenpanel.add(searchauthorscreenwaitlabel);
        searchauthorscreenpanel.add(searchauthorscreenbackbutton);
        searchauthorscreenpanel.add(searchauthorscreenproceedbutton);
        searchauthorscreenpanel.add(searchauthorscreenbooknametextfield);
        searchauthorscreenframe.add(searchauthorscreenpanel);
        searchauthorscreenframe.setBounds(0,0,800,500);
        searchauthorscreenpanel.setBounds(0, 0, 800, 500);
        searchauthorscreenframe.setVisible(true);

        searchauthorscreenframe.addWindowListener(new WindowAdapter() {
                                                    public void windowClosing(WindowEvent we) {
                                                        searchauthorscreenframe.dispose();
                                                    }
                                                }
        );
    }
}