package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by ibrar on 2/22/17.
 */
public class dbUtility {

    Connection conn;

    public dbUtility(){

        String dbURL = "jdbc:mysql://localhost:3306/ChatApp";
        String username = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(dbURL, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean signInUser(String id,String password){

        String query = "SELECT * FROM `user_account` WHERE  `user_ID_name` = '"+id+"' and `user_password` = '"+password+"' ";

        boolean result=false;
        try{

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Main.userID = resultSet.getString("user_ID_name");
                System.out.println("Found");
                result = true;
            }else {
                System.out.println("NOT Found");
                result = false;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }


        return result;

    }


    public ObservableList<UserDataModel> getUserData(){

        ObservableList<UserDataModel> userList = FXCollections.observableArrayList();
        String query= "SELECT * FROM `User_status` WHERE `user_name` <> '"+Main.userID+"'";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                userList.add(new UserDataModel(resultSet.getString("user_name"),resultSet.getString("user_status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;

    }


    public void signUpUser(String id,String password){


        String query = "INSERT INTO `user_account`(`user_ID_name`, `user_password`) VALUES ('"+id+"','"+password+"')";
        int rowsInserted = 0;
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new person was inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }



}
