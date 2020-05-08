package Shop.server;

import Shop.data.Bought;
import Shop.data.Clothe;
import Shop.data.Packet;


import Shop.data.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    public void run(){
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
            while(true){
                Packet packet=(Packet)objectInputStream.readObject();
                if(packet.getCode().equals("ADD")){
                    User user=(User) packet.getData();
                    ServerApp.addUser(user);
                }
                else if(packet.getCode().equals("AUTH")){
                    User user=(User) packet.getData();
                    User response=ServerApp.checkLogin(user.getLogin(), user.getPassword());
                    Packet packet1=new Packet("AUTH", response);
                    objectOutputStream.writeObject(packet1);
                }
                else if(packet.getCode().equals("ADD_CLOTHES")){
                    Clothe clothe=(Clothe) packet.getData();
                    ServerApp.addClothe(clothe);
                }
                else if(packet.getCode().equals("ALL_CLOTHES")){
                    ArrayList<Clothe> clothes=ServerApp.getAllClothes();
                    Packet packet1=new Packet("ALL_CLOTHES", clothes);
                    objectOutputStream.writeObject(packet1);
                }
                else if(packet.getCode().equals("ADD_BOUGHT")){
                    Bought bought=(Bought) packet.getData();
       //             ServerApp.addBought(bought);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
