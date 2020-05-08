package Shop.client.pages;

import Shop.client.application.ApplicationButton;
import Shop.client.application.ApplicationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends ApplicationPanel {
    private ClientFrame boss;
    private ApplicationButton clothebutton, incomebutton, logoutbutton;
    private JLabel welcome;

    public AdminPage(ClientFrame boss) {
        this.boss=boss;

        welcome=new JLabel("WELCOME BOSS)");
        welcome.setBounds(300, 190, 300, 50);
        welcome.setForeground(new Color(0xFDF8FF));
        welcome.setFont(new Font("Arial",Font.ITALIC,36));
        add(welcome);

        clothebutton=new ApplicationButton("CLOTHES");
        clothebutton.setLocation(380, 260);
        add(clothebutton);
        clothebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boss.adminPage.setVisible(false);
                boss.clothesPage.updateDevice();
                boss.clothesPage.setVisible(true);
            }
        });

        incomebutton=new ApplicationButton("INCOME");
        incomebutton.setLocation(380, 320);
        add(incomebutton);
        incomebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boss.adminPage.setVisible(false);
                boss.incomePage.setVisible(true);
            }
        });

        logoutbutton=new ApplicationButton("LOGOUT");
        logoutbutton.setLocation(380, 380);
        add(logoutbutton);
        logoutbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainFrame.currentUser=null;
                boss.adminPage.setVisible(false);
                boss.loginPage.setVisible(true);
            }
        });
    }
}
