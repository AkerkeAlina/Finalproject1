package Shop.client.pages;

import Shop.client.application.ApplicationButton;
import Shop.client.application.ApplicationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientPage extends ApplicationPanel {
    public ClientFrame boss;
    public JLabel welcome;
    public ApplicationButton clothesButton, historyButton,logoutButton;

    public ClientPage(ClientFrame boss){

        this.boss=boss;

        welcome=new JLabel("");
        welcome.setBounds(300, 190, 500, 50);
        welcome.setForeground(new Color(0xFDF8FF));
        welcome.setFont(new Font("Arial",Font.ITALIC,40));
        add(welcome);

        clothesButton=new ApplicationButton("CATALOG");
        clothesButton.setLocation(380, 260);
        add(clothesButton);
        clothesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boss.clientPage.setVisible(false);
                boss.catalogPage.setVisible(true);
            }
        });

        historyButton=new ApplicationButton("HISTORY");
        historyButton.setLocation(380, 320);
        add(historyButton);
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boss.clientPage.setVisible(false);
                boss.historyPage.setVisible(true);
            }
        });

        logoutButton=new ApplicationButton("LOGOUT");
        logoutButton.setLocation(380, 380);
        add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMainFrame.currentUser=null;
                boss.clientPage.setVisible(false);
                boss.loginPage.setVisible(true);
            }
        });
    }
    public void updateData(){
        welcome.setText("Welcome "+ClientMainFrame.currentUser.getFullname());
    }
    }

