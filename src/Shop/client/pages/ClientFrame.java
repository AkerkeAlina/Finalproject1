package Shop.client.pages;
import javax.swing.*;
import java.awt.*;

public class ClientFrame extends JFrame {
    public ClientSocket clientSocket;
    public MainMenu mainMenu;
    public RegisterPage registerPage;
    public LoginPage loginPage;
    public AdminPage adminPage;
    public ClothesPage clothesPage;
    public ClientPage clientPage;
    public CatalogPage catalogPage;
    public HistoryPage historyPage;
    public IncomePage incomePage;

    public ClientFrame(){
//                JLabel l0 = new JLabel();
//        l0.setBounds(0, 0, 900, 600);
//        ImageIcon image = new ImageIcon("C:\\Users\\saila\\Desktop\\Java\\background.jpeg");
//        l0.setIcon(image);
//        add(l0);
        setContentPane(new JLabel(new ImageIcon("C://Users//saila//Desktop//Java//background.jpeg")));
        setLayout(new FlowLayout());
        setSize(900,600);
        setTitle("Shop Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        clientSocket=new ClientSocket();

        mainMenu=new MainMenu(this);
        mainMenu.setVisible(true);
        add(mainMenu);

        registerPage=new RegisterPage(this);
        registerPage.setVisible(false);
        add(registerPage);

        loginPage=new LoginPage(this);
        loginPage.setVisible(false);
        add(loginPage);

        adminPage=new AdminPage(this);
        adminPage.setVisible(false);
        add(adminPage);

        clothesPage=new ClothesPage(this);
        clothesPage.setVisible(false);
        add(clothesPage);

        clientPage=new ClientPage(this);
        clientPage.setVisible(false);
        add(clientPage);

        catalogPage=new CatalogPage(this);
        catalogPage.setVisible(false);
        add(catalogPage);

        historyPage=new HistoryPage(this);
        historyPage.setVisible(false);
        add(historyPage);

        incomePage=new IncomePage(this);
        incomePage.setVisible(false);
        add(incomePage);
    }
}
