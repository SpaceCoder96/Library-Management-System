package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EmployeeMain
{
    public static void main(String[] args) {
        ImageIcon bookinfoicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/BookInfo.png"));
        Image bookinfoiconimg = bookinfoicon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon bookinfoicon1 = new ImageIcon(bookinfoiconimg);

        ImageIcon issueicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/IssueBook.png"));
        Image issueiconimg = issueicon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon issueicon1 = new ImageIcon(issueiconimg);

        ImageIcon returnicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/ReturnBook.png"));
        Image returniconimg = returnicon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon returnicon1 = new ImageIcon(returniconimg);

        ImageIcon infoicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Info.png"));
        Image infoiconimg = infoicon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon infoicon1 = new ImageIcon(infoiconimg);

        JFrame adminmainscreenframe = new JFrame();
        JPanel adminmainscreenpanel = new JPanel();
        adminmainscreenpanel.setLayout(null);
        adminmainscreenpanel.setBackground(new Color(40, 48, 118, 255));

        JLabel adminmainscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        adminmainscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        adminmainscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        adminmainscreentitlelabel.setBounds(0, 20, 800, 35);
        adminmainscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel adminmainscreensecondtitlelabel = new JLabel("Welcome!!!!");
        adminmainscreensecondtitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        adminmainscreensecondtitlelabel.setForeground(new Color(255, 255, 255, 255));
        adminmainscreensecondtitlelabel.setBounds(0, 75, 800, 32);
        adminmainscreensecondtitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton adminmainscreensearchbook = new JButton("", issueicon1);
        adminmainscreensearchbook.setBorderPainted(false);
        adminmainscreensearchbook.setBounds(200, 125, 100, 100);
        adminmainscreensearchbook.addActionListener(e -> {
            adminmainscreenframe.dispose();
            SearchBook.main(null);
        });
        JLabel adminmainscreensearchbooklabel = new JLabel("Issue Book");
        adminmainscreensearchbooklabel.setFont(new Font("Montserrat", Font.PLAIN, 15));
        adminmainscreensearchbooklabel.setForeground(new Color(255, 255, 255, 255));
        adminmainscreensearchbooklabel.setBounds(200, 225, 100, 30);

        JButton adminmainscreenauthorinfo = new JButton("", returnicon1);
        adminmainscreenauthorinfo.setBorderPainted(false);
        adminmainscreenauthorinfo.setBounds(500, 125, 100, 100);
        adminmainscreenauthorinfo.addActionListener(e -> {
            adminmainscreenframe.dispose();
            SearchAuthor.main(null);
        });
        JLabel adminmainscreenauthorinfolabel = new JLabel("Return Book");
        adminmainscreenauthorinfolabel.setFont(new Font("Montserrat", Font.PLAIN, 15));
        adminmainscreenauthorinfolabel.setForeground(new Color(255, 255, 255, 255));
        adminmainscreenauthorinfolabel.setBounds(500, 225, 100, 30);

        JButton adminmainscreenbookinfo = new JButton("", bookinfoicon1);
        adminmainscreenbookinfo.setBorderPainted(false);
        adminmainscreenbookinfo.setBounds(200, 275, 100, 100);
        adminmainscreenbookinfo.addActionListener(e -> {
            adminmainscreenframe.dispose();
            EmployeeSearchBookInfo.main(null);
        });
        JLabel adminmainscreenbookinfolabel = new JLabel("Book Info");
        adminmainscreenbookinfolabel.setFont(new Font("Montserrat", Font.PLAIN, 15));
        adminmainscreenbookinfolabel.setForeground(new Color(255, 255, 255, 255));
        adminmainscreenbookinfolabel.setBounds(200, 375, 100, 30);

        JButton adminmainscreeninfo = new JButton("", infoicon1);
        adminmainscreeninfo.setBorderPainted(false);
        adminmainscreeninfo.setBounds(500, 275, 100, 100);
        adminmainscreeninfo.addActionListener(e -> {
            adminmainscreenframe.dispose();
            EmployeeInfo.main(null);
        });
        JLabel adminmainscreeninfolabel = new JLabel("About Us");
        adminmainscreeninfolabel.setFont(new Font("Montserrat", Font.PLAIN, 15));
        adminmainscreeninfolabel.setForeground(new Color(255, 255, 255, 255));
        adminmainscreeninfolabel.setBounds(500, 375, 100, 30);

        JButton adminmainscreenbackbutton = new JButton("Logout");
        adminmainscreenbackbutton.setFont(new Font("Montserrat", Font.PLAIN, 15));
        adminmainscreenbackbutton.setBounds(0, 0, 100, 50);
        adminmainscreenbackbutton.setBorderPainted(false);
        adminmainscreenbackbutton.setBackground(new Color(40, 48, 118, 255));
        adminmainscreenbackbutton.setForeground(new Color(255,255,255,255));
        adminmainscreenbackbutton.addActionListener(e -> {
            adminmainscreenframe.dispose();
            UserLogin.main(null);
        });

        adminmainscreenframe.add(adminmainscreenpanel);
        adminmainscreenpanel.add(adminmainscreentitlelabel);
        adminmainscreenpanel.add(adminmainscreensecondtitlelabel);
        adminmainscreenpanel.add(adminmainscreensearchbook);
        adminmainscreenpanel.add(adminmainscreenbookinfo);
        adminmainscreenpanel.add(adminmainscreenauthorinfo);
        adminmainscreenpanel.add(adminmainscreeninfo);
        adminmainscreenpanel.add(adminmainscreensearchbooklabel);
        adminmainscreenpanel.add(adminmainscreenbookinfolabel);
        adminmainscreenpanel.add(adminmainscreenauthorinfolabel);
        adminmainscreenpanel.add(adminmainscreeninfolabel);
        adminmainscreenpanel.add(adminmainscreenbackbutton);

        adminmainscreenframe.setBounds(0,0,800,500);
        adminmainscreenpanel.setBounds(0, 0, 800, 500);
        adminmainscreenframe.setVisible(true);
        adminmainscreenframe.addWindowListener(new WindowAdapter() {
                                                  public void windowClosing(WindowEvent we) {
                                                      adminmainscreenframe.dispose();
                                                  }
                                              }
        );
    }
}