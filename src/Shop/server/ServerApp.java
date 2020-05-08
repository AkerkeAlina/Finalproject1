package Shop.server;

import Shop.data.Clothe;
import Shop.data.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.sql.*;
import java.util.ArrayList;

public class ServerApp {
    public static Connection connection;
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_project?useUnicode=true&serverTimezone=UTC", "root", "");
            ServerSocket serverSocket=new ServerSocket(2002);
            System.out.println("Waiting client...");
            while(true){
                Socket socket=serverSocket.accept();
                System.out.println("Client connected");
                ServerThread serverThread=new ServerThread(socket);
                serverThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addUser(User user){
        try {
            PreparedStatement statement=connection.prepareStatement("" + "INSERT INTO users(id, login, password, fullname, role)" + "VALUES(null, ?, ?, ?, ?) ");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullname());
            statement.setInt(4,user.getRole());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static User checkLogin(String login, String password) {
        User user=null;
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM users where login=? and password=?");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Long id= resultSet.getLong("id");
                String login1= resultSet.getString("login");
                String password1= resultSet.getString("password");
                String fullname= resultSet.getString("fullname");
                int role=resultSet.getInt("role");
                user=new User(id, login1, password1, fullname, role);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public static void addClothe(Clothe clothe){
        try {
            PreparedStatement statement=connection.prepareStatement("" + "INSERT INTO clothes(id, model, price, count, size, type) " + " VALUES(null, ?, ?, ?, ?, ?) ");
            statement.setString(1, clothe.getModel());
            statement.setInt(2, clothe.getPrice());
            statement.setInt(3, clothe.getCount());
            statement.setString(4, clothe.getSize());
            statement.setString(5, clothe.getType());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Clothe> getAllClothes(){
        ArrayList<Clothe> clothes=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("" + "SELECT * FROM clothes");
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                Long id=resultSet.getLong("id");
                String model=resultSet.getString("model");
                int price=resultSet.getInt("price");
                int count=resultSet.getInt("count");
                String size=resultSet.getString("size");
                String type=resultSet.getString("type");
                clothes.add(new Clothe(id,model,price,count,size,type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clothes;
    }
}
