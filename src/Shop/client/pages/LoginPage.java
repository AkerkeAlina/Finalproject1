package Shop.client.pages;

import Shop.client.application.ApplicationButton;
import Shop.client.application.ApplicationField;
import Shop.client.application.ApplicationLabel;
import Shop.client.application.ApplicationPanel;
import Shop.data.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends ApplicationPanel {
    private ClientFrame boss;
    private JLabel welcome, log, pas;
    private ApplicationField login;
    private JPasswordField paasword;
    private ApplicationButton logbutton, back;

    public LoginPage(ClientFrame boss){
        this.boss=boss;

        welcome=new JLabel("WELCOME USER");
        welcome.setBounds(350, 80, 500, 30);
        welcome.setForeground(new Color(0xFDF8FF));
        welcome.setFont(new Font("Arial",Font.ROMAN_BASELINE,36));
        add(welcome);

        log=new JLabel("Login: ");
        log.setBounds(300, 150, 300, 30);
        log.setForeground(new Color(0xFDF8FF));
        add(log);

        pas=new JLabel("Password: ");
        pas.setBounds(300, 210, 300, 30);
        pas.setForeground(new Color(0xFDF8FF));
        add(pas);

        login=new ApplicationField();
        login.setLocation(420, 150);
        add(login);

        paasword=new JPasswordField();
        paasword.setBounds(420, 210, 200, 30);
        add(paasword);

        logbutton=new ApplicationButton("LOG IN");
        logbutton.setLocation(250, 300);
        add(logbutton);
        logbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login1=login.getText();
                String password1=paasword.getText();
                User user=boss.clientSocket.checkUser(new User(null, login1, password1,null, 2 ));
                if(user!=null){
                    ClientMainFrame.currentUser=user;
                    if(user.getRole()==1){
                        boss.loginPage.setVisible(false);
                        boss.adminPage.setVisible(true);
                    }
                    else if(user.getRole()==2){
                        boss.loginPage.setVisible(false);
                        boss.clientPage.updateData();
                        boss.clientPage.setVisible(true);
                    }
                }
                else{
                    login.setText("");
                    paasword.setText("");
                    JOptionPane.showMessageDialog(boss, "Your password or login incorrect");
                }
            }
        });

        back=new ApplicationButton("BACK");
        back.setLocation(600, 300);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boss.mainMenu.setVisible(true);
                boss.loginPage.setVisible(false);
            }
        });
    }
}
