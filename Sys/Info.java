package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Info
{
    public static void main(String[] args) {
        JFrame infoscreenframe = new JFrame();
        JPanel infoscreenpanel = new JPanel();
        infoscreenpanel.setBackground(new Color(40, 48, 118, 255));
        infoscreenpanel.setLayout(null);

        JLabel infoscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        infoscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        infoscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        infoscreentitlelabel.setBounds(0, 100, 800, 35);
        infoscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel infoscreenwaitlabel = new JLabel("Made by Viraj-20BCE10440");
        infoscreenwaitlabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        infoscreenwaitlabel.setForeground(new Color(255, 255, 255, 255));
        infoscreenwaitlabel.setBounds(0, 175, 800, 35);
        infoscreenwaitlabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon backicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Back.png"));
        Image backiconimg = backicon.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon backicon1 = new ImageIcon(backiconimg);
        JButton infoscreenbackbutton = new JButton("", backicon1);
        infoscreenbackbutton.setBounds(0, 0, 50, 50);
        infoscreenbackbutton.setBorderPainted(false);
        infoscreenbackbutton.addActionListener(e -> {
            infoscreenframe.dispose();
            UserMain.main(null);
        });
        
        infoscreenpanel.add(infoscreentitlelabel);
        infoscreenpanel.add(infoscreenwaitlabel);
        infoscreenpanel.add(infoscreenbackbutton);
        infoscreenframe.add(infoscreenpanel);
        infoscreenframe.setBounds(0,0,800,500);
        infoscreenpanel.setBounds(0, 0, 800, 500);
        infoscreenframe.setVisible(true);
        infoscreenframe.addWindowListener(new WindowAdapter() {
                                                 public void windowClosing(WindowEvent we) {
                                                     infoscreenframe.dispose();
                                                 }
                                             }
        );
    }
}