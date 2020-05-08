package Shop.client.pages;
import Shop.client.application.ApplicationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends ApplicationPanel{
    private ClientFrame boss;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private  JLabel label1;
    private  JLabel label2;
    private  JLabel label3;
    private  JLabel labelImage1;
    private  JLabel labelImage2;
    public MainMenu(ClientFrame boss)  {
        this.boss=boss;
        button1= new JButton("LOG IN");
        button1.setBounds(310,300,230,40);
        button1.setBackground(new Color(0xC7D0D8));
        button1.setForeground(Color.white);
        add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boss.mainMenu.setVisible(false);
                boss.loginPage.setVisible(true);

            }
        });
        button2= new JButton("SIGN UP");
        button2.setBounds(310,350,230,40);
        button2.setBackground(new Color(0xC7D0D8));
        button2.setForeground(Color.white);
        add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boss.mainMenu.setVisible(false);
                boss.registerPage.setVisible(true);
            }
        });

        button3= new JButton("EXIT");
        button3.setBounds(310,400,230,40);
        button3.setBackground(new Color(0xC7D0D8));
        button3.setForeground(Color.white);
        add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        label1= new JLabel("MILLENIUM");
        label1.setBounds(280,75,800,120);
        label1.setFont(new Font("Agency Fb",Font.BOLD,90));
        label1.setForeground(Color.white);
        add(label1);
        label2= new JLabel("S H O W R O O M");
        label2.setBounds(330,165,500,120);
        label2.setFont(new Font("Arial Narrow",Font.PLAIN,30));
        label2.setForeground(Color.white);
        add(label2);
        button3= new JButton("WOMEN");
        button3.setBounds(80,150,120,40);
        button3.setBackground(new Color(0x0F6E72));
        button3.setForeground(Color.white);
        add(button3);
        button4= new JButton("MEN");
        button4.setBounds(650,150,120,40);
        button4.setBackground(Color.white);
        button4.setForeground(new Color(0x0F6E72));
        add(button4);
        label3= new JLabel("STUDENT:10% OFF 24/7");
        label3.setBounds(70,440,300,120);
        label3.setFont(new Font("Arial Narrow",Font.BOLD,18));
        label3.setForeground(Color.white);
        add(label3);
        labelImage1 =new JLabel();
        labelImage1.setBounds(650,505,30,30);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Erke\\Desktop\\insta logo.jpg");
        labelImage1.setIcon(imageIcon);
        add(labelImage1);
        labelImage2 =new JLabel();
        labelImage2.setBounds(690,505,30,30);
        ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\Erke\\Desktop\\face logo.png");
        labelImage2.setIcon(imageIcon1);
        add(labelImage2);

    }
}
