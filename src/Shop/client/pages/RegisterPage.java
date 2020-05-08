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

public class RegisterPage extends ApplicationPanel {
    public ClientFrame boss;
    private ApplicationField newlogin,fiopassword;
    private JLabel login,passwordF, fio;
    private JPasswordField password;
    private ApplicationButton signup, back;


    public RegisterPage(ClientFrame boss) {
        this.boss = boss;

        login=new JLabel("Login:");
        login.setBounds(300,150,100,40);
        login.setForeground(Color.white);
        add(login);
        newlogin=new ApplicationField();
        newlogin.setLocation(420,150);
        add(newlogin);

        password=new JPasswordField();
        password.setBounds(420, 210, 200, 30);
        add(password);
        passwordF=new JLabel("Password:");
        passwordF.setBounds(300,210,100,40);
        passwordF.setForeground(Color.white);
        add(passwordF);

        fio=new JLabel("Full name:");
        fio.setBounds(300,270,100,40);
        fio.setForeground(Color.white);
        add(fio);
        fiopassword=new ApplicationField();
        fiopassword.setLocation(420,270);
        add(fiopassword);

        signup=new ApplicationButton("SIGN UP");
        signup.setLocation(250, 350);
        add(signup);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login=newlogin.getText();
                String pass=password.getText();
                String fioname=fio.getText();
                if(login.isEmpty() || pass.isEmpty() || fioname.isEmpty()){
                    JOptionPane.showMessageDialog(boss, "Please fill all fields!");
                }
                else{
                    User user= new User(null, login, pass, fioname, 2);
                    boss.clientSocket.addUser(user);
                    newlogin.setText("");
                    password.setText("");
                    fio.setText("");
                    JOptionPane.showMessageDialog(boss, "U have successfully registered!");
                }
            }
        });

        back=new ApplicationButton("BACK");
        back.setLocation(600, 350);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boss.mainMenu.setVisible(true);
                boss.registerPage.setVisible(false);
            }
        });

    }
}
