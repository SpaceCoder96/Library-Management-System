package Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyEditorSupport;
import java.io.*;
import java.util.Scanner;

class FineFileExist{
    static void finefileexist() throws IOException {
        File f = new File("src/Sys/Assets/admin/finerate.dat");
        if(f.exists() && !f.isDirectory()) {
            System.out.println("File Present");
        }
        else{
            System.out.println("File Not Present");
            File file = new File("src/Sys/Assets/admin/finerate.dat");
            file.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(file));
            FileWriter myWriter = new FileWriter(file);
            myWriter.write("2.00");
            myWriter.close();
        }
    }
}

class GetFine{
    Double getfine() throws FileNotFoundException {
        File file = new File("src/Sys/Assets/admin/finerate.dat");
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            Double price =  Double.parseDouble(data);
            return price;
        }
        myReader.close();
        return(1.00);
    }
}

class UpdateFine{
    static void updatefine(String fine) throws IOException {
        File file = new File("src/Sys/Assets/admin/finerate.dat");
        file.delete();
        file.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(file));
        FileWriter myWriter = new FileWriter(file);
        myWriter.write(fine);
        myWriter.close();
    }
}

public class AdminMain
{
    public static void main(String[] args) throws IOException {
        FineFileExist.finefileexist();
        GetFine price = new GetFine();
        Double rate = price.getfine();
        String rates = Double.toString(rate);
        JFrame adminmainscreenframe = new JFrame();
        JPanel adminmainscreenpanel = new JPanel();
        adminmainscreenpanel.setLayout(null);
        adminmainscreenpanel.setBackground(new Color(40, 48, 118, 255));

        JLabel adminmainscreentitlelabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        adminmainscreentitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        adminmainscreentitlelabel.setForeground(new Color(255, 255, 255, 255));
        adminmainscreentitlelabel.setBounds(0, 20, 800, 35);
        adminmainscreentitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel adminmainscreensecondtitlelabel = new JLabel("Welcome Admin!!");
        adminmainscreensecondtitlelabel.setFont(new Font("Montserrat", Font.PLAIN, 30));
        adminmainscreensecondtitlelabel.setForeground(new Color(255, 255, 255, 255));
        adminmainscreensecondtitlelabel.setBounds(0, 75, 800, 32);
        adminmainscreensecondtitlelabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel adminmainscreenadminnamelabel = new JLabel("Late Fee Rate: ");
        adminmainscreenadminnamelabel.setFont(new Font("Montserrat", Font.PLAIN, 28));
        adminmainscreenadminnamelabel.setForeground(new Color(255, 255, 255, 255));
        adminmainscreenadminnamelabel.setBounds(40, 200, 300, 30);

        JTextField adminmainscreenadminnametextfield = new JTextField();
        adminmainscreenadminnametextfield.setText(rates);
        adminmainscreenadminnametextfield.setFont(new Font("Montserrat", Font.PLAIN, 28));
        adminmainscreenadminnametextfield.setBackground(new Color(40, 48, 118, 255));
        adminmainscreenadminnametextfield.setForeground(new Color(255, 255, 255, 255));
        adminmainscreenadminnametextfield.setBounds(250, 200, 400,35);

        JButton adminmainscreenloginbutton = new JButton("SAVE");
        adminmainscreenloginbutton.setFont(new Font("Montserrat", Font.PLAIN, 28));
        adminmainscreenloginbutton.setBounds(320, 300, 160, 45);
        adminmainscreenloginbutton.setBackground(new Color(40, 48, 118, 255));
        adminmainscreenloginbutton.setForeground(new Color(255, 255, 255, 255));
        adminmainscreenloginbutton.setBorderPainted(false);
        adminmainscreenloginbutton.addActionListener(e -> {
            String fine = adminmainscreenadminnametextfield.getText();
            try {
                UpdateFine.updatefine(fine);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        ImageIcon backicon = new ImageIcon(ClassLoader.getSystemResource("Sys/Assets/Icons/Back.png"));
        Image backiconimg = backicon.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon backicon1 = new ImageIcon(backiconimg);
        JButton adminmainscreenbackbutton = new JButton("", backicon1);
        adminmainscreenbackbutton.setBounds(0, 0, 50, 50);
        adminmainscreenbackbutton.setBorderPainted(false);
        adminmainscreenbackbutton.addActionListener(e -> {
            adminmainscreenframe.dispose();
            UserLogin.main(null);
        });

        adminmainscreenframe.add(adminmainscreenpanel);
        adminmainscreenpanel.add(adminmainscreentitlelabel);
        adminmainscreenpanel.add(adminmainscreensecondtitlelabel);
        adminmainscreenpanel.add(adminmainscreenadminnamelabel);
        adminmainscreenpanel.add(adminmainscreenadminnametextfield);
        adminmainscreenpanel.add(adminmainscreenloginbutton);
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