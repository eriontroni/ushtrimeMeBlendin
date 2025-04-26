package java6;

import database.DBConnector;
import models.User;
import models.dto.CreateUserDto;
import models.dto.UpdateUserDto;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Detyra1 {
    public static void main(String[] args) {
//        try{
//            Connection connection = DBConnector.getConnection();
//            Statement statement = connection.createStatement();
//            String query = "SELECT * FROM USERS ORDER BY ID DESC LIMIT 1";  // kjo e kthen veq nje rekord
//            ResultSet result = statement.executeQuery(query);
//            if(result.next()){
//                User user = User.getInstance(result);
//                System.out.println("Id: " + user.getId());
//                System.out.println("Email: " + user.getEmail());
//            }
            UserRepository userRepository = new UserRepository();
            User user = userRepository.getById(3);
            System.out.println("Id: " + user.getId());
            System.out.println("Email: " + user.getEmail());
//        } catch (SQLException e){
//
//        }

        CreateUserDto userDto = new CreateUserDto(
                "student 1", "student@gmail.com", 22
        );
        User newUser = userRepository.create(userDto);
        if(newUser != null) {
            System.out.println("New user id: " + newUser.getId());
            System.out.println("New user email: " + newUser.getEmail());
        }


        UpdateUserDto updateUserDto = new UpdateUserDto(
                newUser.getId(), "updated@gmail.com"
        );
        newUser = userRepository.update(updateUserDto);
        System.out.println("Updated email: " + newUser.getEmail());


        if(userRepository.delete(newUser.getId())) {
            System.out.println("Deleted user id: " + newUser.getId());
        }


    }
}
