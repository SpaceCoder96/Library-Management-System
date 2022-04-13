package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

class Issue{
    static void issuebook(String book, String name){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String today = dateFormat.format(date);
        LocalDate currentDate = LocalDate.now();
        LocalDate weekdate = currentDate.plus(1, ChronoUnit.WEEKS);
        String week = weekdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT bookname,bookstatus,issuedate,returndate,issuedto FROM bookdata");

            String sql = "UPDATE bookdata SET bookstatus=?, issuedate=?, returndate=?, issuedto=? WHERE bookname=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "0");
            stmt.setString(2, today);
            stmt.setString(3, week);
            stmt.setString(4, name);
            stmt.setString(5, book);
            int rowsUpdated = stmt.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

class CheckIssue{
    String checkuser(String user){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from usercredentials");
            ResultSet rs = statement.executeQuery("SELECT username FROM usercredentials");
            while(rs.next()){
                if(user.equals(rs.getString("username"))){
                    return("Yes");
                }
            }
        }
        catch (Exception e){
            return("Not Connected");
        }
        return("");
    }
    String checkavail(String book, String user){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT bookname,bookstatus,issuedto FROM bookdata");
            /*while(rs.next()){
                if (user.equals(rs.getString("issuedto"))) {
                    return("multiple");
                }
            }*/
            while(rs.next()){
                if(book.equals(rs.getString("bookname"))){
                    if(rs.getString("bookstatus").equals("1")){
                        return("Yes");
                    }
                    else{
                        return("book unavail");
                    }
                }
            }
        }
        catch (Exception e){
            return("Not Connected");
        }
        return("user not found");
    }
}

public class IssueBook
{
    public static void main(String[] args) {
        JFrame issuescreenframe = new JFrame();
        JPanel issuescreenpanel = new JPanel();
        issuescreenpanel.setLayout(null);
        issuescreenpanel.setBackground(new Color(40, 48, 118, 255));

        JLabel issuescreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        issuescreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        issuescreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        issuescreentitlelabel.setBounds(0, 20, 800, 35);
        issuescreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel issuescreensecondtitlelabel = new JLabel("Enter Login Credentials");
        issuescreensecondtitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        issuescreensecondtitlelabel.setForeground(new Color(255, 255, 255, 255));
        issuescreensecondtitlelabel.setBounds(0, 75, 800, 32);
        issuescreensecondtitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel issuescreenemployeenamelabel = new JLabel("User's Name: ");
        issuescreenemployeenamelabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        issuescreenemployeenamelabel.setForeground(new Color(255, 255, 255, 255));
        issuescreenemployeenamelabel.setBounds(50, 150, 300, 30);

        JTextField issuescreenemployeenametextfield = new JTextField();
        issuescreenemployeenametextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        issuescreenemployeenametextfield.setBackground(new Color(40, 48, 118, 255));
        issuescreenemployeenametextfield.setForeground(new Color(255, 255, 255, 255));
        issuescreenemployeenametextfield.setBounds(250, 150, 400, 35);

        JLabel issuescreenbooknamelabel = new JLabel("Book's Name: ");
        issuescreenbooknamelabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        issuescreenbooknamelabel.setForeground(new Color(255, 255, 255, 255));
        issuescreenbooknamelabel.setBounds(50, 225, 300, 30);

        JTextField issuescreenbooknametextfield = new JTextField();
        issuescreenbooknametextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        issuescreenbooknametextfield.setBackground(new Color(40, 48, 118, 255));
        issuescreenbooknametextfield.setForeground(new Color(255, 255, 255, 255));
        issuescreenbooknametextfield.setBounds(250, 225, 400, 35);

        JButton issuescreenloginbutton = new JButton("Issue");
        issuescreenloginbutton.setFont(new Font("Montserrat", Font.PLAIN, 28));
        issuescreenloginbutton.setBounds(320, 300, 160, 45);
        issuescreenloginbutton.setBackground(new Color(40, 48, 118, 255));
        issuescreenloginbutton.setForeground(new Color(255, 255, 255, 255));
        issuescreenloginbutton.setBorderPainted(false);
        issuescreenloginbutton.addActionListener(e -> {
            String user = issuescreenemployeenametextfield.getText();
            String book = issuescreenbooknametextfield.getText();
            CheckIssue result = new CheckIssue();
            String name = result.checkuser(user);
            String avail = result.checkavail(book, user);
            if(name.equals("Yes")){
                switch (avail){
                    case "Yes": {
                        JOptionPane.showMessageDialog(null, "Book Issued.");
                        Issue.issuebook(book, user);
                        issuescreenframe.dispose();
                        EmployeeMain.main(null);
                    }
                    break;
                    case "book unavail":{
                        JOptionPane.showMessageDialog(null, "Book Unavailable.");
                    }
                    break;
                    case "Not Connected":{
                        JOptionPane.showMessageDialog(null, "Database Offline. Try again later.");
                    }
                    break;
                    case "multiple":{
                        JOptionPane.showMessageDialog(null, "Cannot issue more that one book.");
                    }
                    break;
                    default:JOptionPane.showMessageDialog(null, "Error!");
                }
            }
            if(name.equals("user not found")){
                JOptionPane.showMessageDialog(null, "User Not Found.");
            }
        }
        );

        ImageIcon backicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Back.png"));
        Image backiconimg = backicon.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon backicon1 = new ImageIcon(backiconimg);
        JButton issuescreenbackbutton = new JButton("", backicon1);
        issuescreenbackbutton.setBounds(0, 0, 50, 50);
        issuescreenbackbutton.setBorderPainted(false);
        issuescreenbackbutton.addActionListener(e -> {
            issuescreenframe.dispose();
            EmployeeMain.main(null);
        });

        issuescreenframe.add(issuescreenpanel);
        issuescreenpanel.add(issuescreentitlelabel);
        issuescreenpanel.add(issuescreensecondtitlelabel);
        issuescreenpanel.add(issuescreenemployeenamelabel);
        issuescreenpanel.add(issuescreenemployeenametextfield);
        issuescreenpanel.add(issuescreenloginbutton);
        issuescreenpanel.add(issuescreenbackbutton);
        issuescreenpanel.add(issuescreenbooknamelabel);
        issuescreenpanel.add(issuescreenbooknametextfield);

        issuescreenframe.setBounds(0,0,800,500);
        issuescreenpanel.setBounds(0, 0, 800, 500);
        issuescreenframe.setVisible(true);
        issuescreenframe.addWindowListener(new WindowAdapter() {
                                                public void windowClosing(WindowEvent we) {
                                                    issuescreenframe.dispose();
                                                }
                                            }
        );
    }
}