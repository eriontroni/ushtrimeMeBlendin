package repository;

import database.DBConnector;
import models.User;

import java.sql.*;
import java.util.ArrayList;
// cdo komunikim me baze te te dhenave, behet permes repositories

abstract class BaseRepository<Model, CreateModelDto, UpdateModelDto> {
    protected Connection connection;
    private String tableName;

    public BaseRepository(String tableName) {
        this.connection = DBConnector.getConnection();
        this.tableName = tableName;
    }

//    abstract String tableName();  mujm permes qisaj, amo mujm edhe permes Konstruktorit (me thirr te UserRepository)

    abstract Model fromResutlSet(ResultSet res);  // cdo repo, duhet me implementu ket metode qe tani te getById me mujt me bo gjith getInstance?

    public Model getById(int id){
        String query = "SELECT * FROM " + this.tableName + " WHERE id = ?";
            try{
                PreparedStatement statement = this.connection.prepareStatement(query);
                statement.setInt(1, id);
                ResultSet res = statement.executeQuery(query);
                if(res.next()){
                    return this.fromResutlSet(res);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
            return null;
    }

    public ArrayList<Model> getAll(){  // nese dikush don mi lexu kejt rekordet, e thirr qit metoden getAll
        ArrayList<Model> models = new ArrayList<>();
        String query = "SELECT * FROM " + this.tableName;
        try{
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery(query);  // e ekzekutojm queryn tone, qe ka rekorde
            while(res.next()){  // perderisa kena rezultat te rradhes, merre qato edhe vendose te lista jone
                models.add(this.fromResutlSet(res));
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

        return models;
    }

    abstract Model create(CreateModelDto createModelDto);

    abstract Model udpate(UpdateModelDto updateModelDto);

//    abstract boolean delete(int id);


    public boolean delete(int id){
        String query = "DELETE FROM ??? WHERE ID = ?";
        try{
            PreparedStatement pstm = this.connection.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
