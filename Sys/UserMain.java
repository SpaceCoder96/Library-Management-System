package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserMain
{
    public static void main(String[] args) {
        ImageIcon bookinfoicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/BookInfo.png"));
        Image bookinfoiconimg = bookinfoicon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon bookinfoicon1 = new ImageIcon(bookinfoiconimg);

        ImageIcon authorinfoicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/AuthorInfo.png"));
        Image authorinfoiconimg = authorinfoicon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon authorinfoicon1 = new ImageIcon(authorinfoiconimg);

        ImageIcon searchbookicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/SearchBook.png"));
        Image searchbookiconimg = searchbookicon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon searchbookicon1 = new ImageIcon(searchbookiconimg);

        ImageIcon infoicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Info.png"));
        Image infoiconimg = infoicon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon infoicon1 = new ImageIcon(infoiconimg);

        JFrame usermainscreenframe = new JFrame();
        JPanel usermainscreenpanel = new JPanel();
        usermainscreenpanel.setLayout(null);
        usermainscreenpanel.setBackground(new Color(40, 48, 118, 255));

        JLabel usermainscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        usermainscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        usermainscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        usermainscreentitlelabel.setBounds(0, 20, 800, 35);
        usermainscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel usermainscreensecondtitlelabel = new JLabel("Welcome!!!!");
        usermainscreensecondtitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        usermainscreensecondtitlelabel.setForeground(new Color(255, 255, 255, 255));
        usermainscreensecondtitlelabel.setBounds(0, 75, 800, 32);
        usermainscreensecondtitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton usermainscreensearchbook = new JButton("", searchbookicon1);
        usermainscreensearchbook.setBorderPainted(false);
        usermainscreensearchbook.setBounds(200, 125, 100, 100);
        usermainscreensearchbook.addActionListener(e -> {
            usermainscreenframe.dispose();
            SearchBook.main(null);
        });
        JLabel usermainscreensearchbooklabel = new JLabel("Search Book");
        usermainscreensearchbooklabel.setFont(new Font("Montserrat", Font.PLAIN, 15));
        usermainscreensearchbooklabel.setForeground(new Color(255, 255, 255, 255));
        usermainscreensearchbooklabel.setBounds(200, 225, 100, 30);

        JButton usermainscreenbookinfo = new JButton("", bookinfoicon1);
        usermainscreenbookinfo.setBorderPainted(false);
        usermainscreenbookinfo.setBounds(500, 125, 100, 100);
        usermainscreenbookinfo.addActionListener(e -> {
            usermainscreenframe.dispose();
            SearchBookInfo.main(null);
        });
        JLabel usermainscreenbookinfolabel = new JLabel("Book Info");
        usermainscreenbookinfolabel.setFont(new Font("Montserrat", Font.PLAIN, 15));
        usermainscreenbookinfolabel.setForeground(new Color(255, 255, 255, 255));
        usermainscreenbookinfolabel.setBounds(500, 225, 100, 30);

        JButton usermainscreenauthorinfo = new JButton("", authorinfoicon1);
        usermainscreenauthorinfo.setBorderPainted(false);
        usermainscreenauthorinfo.setBounds(200, 275, 100, 100);
        usermainscreenauthorinfo.addActionListener(e -> {
            usermainscreenframe.dispose();
            SearchAuthor.main(null);
        });
        JLabel usermainscreenauthorinfolabel = new JLabel("Author Info");
        usermainscreenauthorinfolabel.setFont(new Font("Montserrat", Font.PLAIN, 15));
        usermainscreenauthorinfolabel.setForeground(new Color(255, 255, 255, 255));
        usermainscreenauthorinfolabel.setBounds(200, 375, 100, 30);

        JButton usermainscreeninfo = new JButton("", infoicon1);
        usermainscreeninfo.setBorderPainted(false);
        usermainscreeninfo.setBounds(500, 275, 100, 100);
        usermainscreeninfo.addActionListener(e -> {
            usermainscreenframe.dispose();
            Info.main(null);
        });
        JLabel usermainscreeninfolabel = new JLabel("About Us");
        usermainscreeninfolabel.setFont(new Font("Montserrat", Font.PLAIN, 15));
        usermainscreeninfolabel.setForeground(new Color(255, 255, 255, 255));
        usermainscreeninfolabel.setBounds(500, 375, 100, 30);

        JButton usermainscreenbackbutton = new JButton("Logout");
        usermainscreenbackbutton.setFont(new Font("Montserrat", Font.PLAIN, 15));
        usermainscreenbackbutton.setBounds(0, 0, 100, 50);
        usermainscreenbackbutton.setBorderPainted(false);
        usermainscreenbackbutton.setBackground(new Color(40, 48, 118, 255));
        usermainscreenbackbutton.setForeground(new Color(255,255,255,255));
        usermainscreenbackbutton.addActionListener(e -> {
            usermainscreenframe.dispose();
            UserLogin.main(null);
        });

        usermainscreenframe.add(usermainscreenpanel);
        usermainscreenpanel.add(usermainscreentitlelabel);
        usermainscreenpanel.add(usermainscreensecondtitlelabel);
        usermainscreenpanel.add(usermainscreensearchbook);
        usermainscreenpanel.add(usermainscreenbookinfo);
        usermainscreenpanel.add(usermainscreenauthorinfo);
        usermainscreenpanel.add(usermainscreeninfo);
        usermainscreenpanel.add(usermainscreensearchbooklabel);
        usermainscreenpanel.add(usermainscreenbookinfolabel);
        usermainscreenpanel.add(usermainscreenauthorinfolabel);
        usermainscreenpanel.add(usermainscreeninfolabel);
        usermainscreenpanel.add(usermainscreenbackbutton);

        usermainscreenframe.setBounds(0,0,800,500);
        usermainscreenpanel.setBounds(0, 0, 800, 500);
        usermainscreenframe.setVisible(true);
        usermainscreenframe.addWindowListener(new WindowAdapter() {
                                                    public void windowClosing(WindowEvent we) {
                                                        usermainscreenframe.dispose();
                                                    }
                                                }
        );
    }
}