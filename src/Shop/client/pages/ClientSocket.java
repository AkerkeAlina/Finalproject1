package Shop.client.pages;

import Shop.data.Bought;
import Shop.data.Clothe;
import Shop.data.Packet;
import Shop.data.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientSocket {
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public ClientSocket() {
        try {
            socket= new Socket("localhost", 2002);
            output=new ObjectOutputStream(socket.getOutputStream());
            input=new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void disconnect(){
        try {
            output.close();
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addUser(User user){
        Packet packet= new Packet("ADD", user);
        try {
            output.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public User checkUser(User user){
        User result=null;
        try {
            Packet packet=new Packet("AUTH", user);
            output.writeObject(packet);

            Packet packet1=(Packet) input.readObject();
            result=(User) packet1.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public void addClothe(Clothe clothe){
        Packet packet= new Packet("ADD_CLOTHES", clothe);
        try {
            output.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Clothe> getAllClothes(){
        ArrayList<Clothe> clothes=new ArrayList<>();
        Packet packet=new Packet("ALL_CLOTHES", null);
        try {
            output.writeObject(packet);
            Packet packet1=(Packet) input.readObject();
            clothes=(ArrayList<Clothe>) packet1.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clothes;
    }
    public void addBought(Bought bought){
        Packet packet=new Packet("ADD_BOUGHT", bought);
        try {
            output.writeObject(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
