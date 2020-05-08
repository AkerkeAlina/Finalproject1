package Shop.client.pages;

import Shop.data.User;

public class ClientMainFrame {
    public static User currentUser;
    public static void main(String[] args) {
        ClientFrame clientFrame=new ClientFrame();
        clientFrame.setVisible(true);
    }
}
