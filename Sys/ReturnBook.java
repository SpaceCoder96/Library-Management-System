package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class ReturnConfirm{
    static void returnconfirm(String user){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT * FROM bookdata");
            String booktoret = new String();
            while (rs.next()){
                if(user.equals(rs.getString("issuedto"))) {
                    booktoret = rs.getString("bookname");
                }
            }
            String sql = "UPDATE bookdata SET bookstatus=?, issuedate=?, returndate=?, issuedto=? WHERE bookname=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "1");
            stmt.setString(2, null);
            stmt.setString(3, null);
            stmt.setString(4, null);
            stmt.setString(5, booktoret);
            int rowsUpdated = stmt.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

class CheckReturn{
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
    String checkavail(String user){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "FSLtqMnRt18@19400A");
            Statement statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from bookdata");
            ResultSet rs = statement.executeQuery("SELECT returndate,issuedto FROM bookdata");
            while(rs.next()){
                if (user.equals(rs.getString("issuedto"))) {
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar cal = Calendar.getInstance();
                    Date date = cal.getTime();
                    String today = dateFormat.format(date);
                    Date todaydate = dateFormat.parse(today);
                    String retdate = rs.getString("returndate");
                    Date returndate = dateFormat.parse(retdate);
                    if(todaydate.after(returndate)) {
                        long diffInMillies = Math.abs(returndate.getTime() - todaydate.getTime());
                        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.DAYS);
                        Double finedays = Double.parseDouble(String.valueOf(diff));
                        File file = new File("src/Sys/Assets/admin/finerate.dat");
                        Scanner myReader = new Scanner(file);
                        Double rate = null;
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            rate = Double.parseDouble(data);
                        }
                        myReader.close();
                        Double finalfine = rate * finedays;
                        String finalfinestr = finalfine.toString();
                        return (finalfinestr);
                    }
                    if(returndate.after(todaydate)){
                        return("0");
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


public class ReturnBook
{
    public static void main(String[] args) {
        JFrame returnscreenframe = new JFrame();
        JPanel returnscreenpanel = new JPanel();
        returnscreenpanel.setLayout(null);
        returnscreenpanel.setBackground(new Color(40, 48, 118, 255));

        JLabel returnscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        returnscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        returnscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        returnscreentitlelabel.setBounds(0, 20, 800, 35);
        returnscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel returnscreensecondtitlelabel = new JLabel("Enter Login Credentials");
        returnscreensecondtitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        returnscreensecondtitlelabel.setForeground(new Color(255, 255, 255, 255));
        returnscreensecondtitlelabel.setBounds(0, 75, 800, 32);
        returnscreensecondtitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel returnscreenemployeenamelabel = new JLabel("User's Name: ");
        returnscreenemployeenamelabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        returnscreenemployeenamelabel.setForeground(new Color(255, 255, 255, 255));
        returnscreenemployeenamelabel.setBounds(50, 150, 300, 30);

        JTextField returnscreenemployeenametextfield = new JTextField();
        returnscreenemployeenametextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        returnscreenemployeenametextfield.setBackground(new Color(40, 48, 118, 255));
        returnscreenemployeenametextfield.setForeground(new Color(255, 255, 255, 255));
        returnscreenemployeenametextfield.setBounds(250, 150, 400, 35);

        JLabel returnscreenFinelabel = new JLabel("");
        returnscreenFinelabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        returnscreenFinelabel.setForeground(new Color(255, 255, 255, 255));
        returnscreenFinelabel.setBounds(50, 225, 300, 30);

        JButton returnscreenconfirmbutton = new JButton("Confirm Return");
        returnscreenconfirmbutton.setFont(new Font("Montserrat", Font.PLAIN, 28));
        returnscreenconfirmbutton.setBounds(240, 300, 320, 45);
        returnscreenconfirmbutton.setBackground(new Color(40, 48, 118, 255));
        returnscreenconfirmbutton.setForeground(new Color(255, 255, 255, 255));
        returnscreenconfirmbutton.setBorderPainted(false);
        returnscreenconfirmbutton.addActionListener(e -> {
            String user = returnscreenemployeenametextfield.getText();
            ReturnConfirm.returnconfirm(user);
            returnscreenframe.dispose();
            EmployeeMain.main(null);
        });

        JButton returnscreenloginbutton = new JButton("Search");
        returnscreenloginbutton.setFont(new Font("Montserrat", Font.PLAIN, 28));
        returnscreenloginbutton.setBounds(320, 300, 160, 45);
        returnscreenloginbutton.setBackground(new Color(40, 48, 118, 255));
        returnscreenloginbutton.setForeground(new Color(255, 255, 255, 255));
        returnscreenloginbutton.setBorderPainted(false);
        returnscreenloginbutton.addActionListener(e -> {
            String username = returnscreenemployeenametextfield.getText();
            CheckReturn user = new CheckReturn();
            String uservalid = user.checkuser(username);
            switch (uservalid){
                case "Yes":{
                    String finecost = user.checkavail(username);
                    returnscreenFinelabel.setText("Fine is "+finecost+"/-");
                    returnscreenpanel.remove(returnscreenloginbutton);
                    returnscreenpanel.add(returnscreenconfirmbutton);
                }
                break;
                case "Not Connected":{
                    JOptionPane.showMessageDialog(null, "Database Offline. Try again later.");
                }
                break;
                case "":{
                    JOptionPane.showMessageDialog(null, "User Not Found.");
                }
                break;
                default:JOptionPane.showMessageDialog(null, "Error!");
            }
        });

        ImageIcon backicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Back.png"));
        Image backiconimg = backicon.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon backicon1 = new ImageIcon(backiconimg);
        JButton returnscreenbackbutton = new JButton("", backicon1);
        returnscreenbackbutton.setBounds(0, 0, 50, 50);
        returnscreenbackbutton.setBorderPainted(false);
        returnscreenbackbutton.addActionListener(e -> {
            returnscreenframe.dispose();
            EmployeeMain.main(null);
        });

        returnscreenframe.add(returnscreenpanel);
        returnscreenpanel.add(returnscreentitlelabel);
        returnscreenpanel.add(returnscreensecondtitlelabel);
        returnscreenpanel.add(returnscreenemployeenamelabel);
        returnscreenpanel.add(returnscreenemployeenametextfield);
        returnscreenpanel.add(returnscreenloginbutton);
        returnscreenpanel.add(returnscreenbackbutton);
        returnscreenpanel.add(returnscreenFinelabel);

        returnscreenframe.setBounds(0,0,800,500);
        returnscreenpanel.setBounds(0, 0, 800, 500);
        returnscreenframe.setVisible(true);
        returnscreenframe.addWindowListener(new WindowAdapter() {
                                                       public void windowClosing(WindowEvent we) {
                                                           returnscreenframe.dispose();
                                                       }
                                                   }
        );
    }
}