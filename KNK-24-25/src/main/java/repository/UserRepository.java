package repository;

import database.DBConnector;
import models.User;
import models.dto.CreateUserDto;
import models.dto.UpdateUserDto;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository extends BaseRepository<User, CreateUserDto, UpdateUserDto>{    // kjo eshte e mire qe me pas kodin per SQL te centralizum, pra me ni vend, tani veq i thirrim metodat
//    lexim, shkrim, fshirje, perditesim (update)

    public UserRepository(){
        super("users");
    }

    public User fromReusultSet(ResultSet result) throws SQLException{  // kjo ldihet me qato
        return User.getInstance(result);
    }

//    private Connection connection;
//    public UserRepository(){
//        this.connection = DBConnector.getConnection();   // arsya osht qe kur jena te getAll, skena nevoje me menu per getConnection, qato e deklarojm ktu
//    }

//    public ArrayList<User> getAll(){  // nese dikush don mi lexu kejt rekordet, e thirr qit metoden getAll
//        ArrayList<User> users = new ArrayList<>();
//        String query = "SELECT * FROM USERS";
//        try{
//            Statement statement = this.connection.createStatement();
//            ResultSet restulSet = statement.executeQuery(query);  // e ekzekutojm queryn tone, qe ka rekorde
//            while(restulSet.next()){  // perderisa kena rezultat te rradhes, merre qato edhe vendose te lista jone
//                users.add(
//                        User.getInstance(restulSet)
//                );
//            }
//
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
//
//        return users;
//    }

//    getById("12345; Drop table users;")
//    getById("1234 or 1 = 1;") // nese na perdorim ket statement, na shfaqet rrezik qe me ndodh SQL injection (sulm i databazes), qishtu mun edhe me password, rrjedhimisht ta hakojn leht

//    public User getById(int id){
//        String query = "SELECT * FROM USERS WHERE ID = ?";   // gjith kur kena me vendos vlera prej perdoruesit, e shkrujm pikpytjen, qe me tregu qe qaty ka me pas input
//        try{
//            PreparedStatement statement = this.connection.prepareStatement(query);   // kto e shkrujm qe mu siguru qe sulmi SQL injection smun me ndodh
//            statement.setInt(1, id);   //kjo shkruhet gjith mas PreparedStatement se ajo pret na mi kallxu qa qysh tek
//            ResultSet resultSet = statement.executeQuery(query);
//            if(resultSet.next()){
//                return User.getInstance(resultSet);
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//        return null;  // nese ska objekt
//    }


    @Override
    User fromResutlSet(ResultSet res) {
        return null;
    }

    public User create(CreateUserDto userDto){
        String query = """
                INSERT INTO USERS (NAME, EMAIL, AGE)
                VALUES (?, ?, ?)
                """;
        try{
            PreparedStatement pstm = this.connection.prepareStatement(
                    query, Statement.RETURN_GENERATED_KEYS
            );
            pstm.setString(1, userDto.getName());
            pstm.setString(2, userDto.getEmail());
            pstm.setInt(3, userDto.getAge());
            pstm.execute();
            ResultSet result = pstm.getGeneratedKeys();
            if(result.next()){
                int id = result.getInt(1);
                return this.getById(id);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    User udpate(UpdateUserDto updateUserDto) {
        return null;
    }


    public User update(UpdateUserDto userDto){
        String query = """
                UPDATE USERS
                SET EMAIL = ?
                WHERE ID = ?
                """;
        try{
            PreparedStatement pstm = this.connection.prepareStatement(query);
            pstm.setString(1, userDto.getEmail());
            pstm.setInt(2, userDto.getId());
            pstm.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return this.getById(userDto.getId());
    }


//    public boolean delete(int id){
//        String query = "DELETE FROM USERS WHERE ID = ?";
//        try{
//            PreparedStatement pstm = this.connection.prepareStatement(query);
//            pstm.setInt(1, id);
//            return pstm.executeUpdate() == 1;
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//        return false;
//    }



}
