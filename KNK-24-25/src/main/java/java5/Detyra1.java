package java5;

import database.DBConnector;

import java.sql.*;

public class Detyra1 {
    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:postgresql://localhost:KNK";
//        String user = "postgres";
//        String password = "123456";
//        Connection connection = DriverManager.getConnection(
//                url, user, password
//        );
//        if(connection.isValid(100)){
//            System.out.println("DB Connected");
//        }
        Connection connection = DBConnector.getConnection();  // n'vend t'qitij kodit nalt i komentum
        String query = """
    INSERT INTO USERS (name, email, age)
    VALUES('filan', 'filan@gmail.com', 25)
""";
        Statement statement = connection.createStatement();
//    statement.executeQuery();  // kur dojm me selektu dicka?
        statement.execute(query);
//        statement.execute("DELETE FROM USERS WHERE id = 2");  // ktu si tekst osht komanda qe e kishim shkru n'pgadmin

        query = """
    SELECT * FROM USERS
""";
        ResultSet results = statement.executeQuery(query);   // rekordet i lexojm ne klasen ResultSet, e tani rresht per rresht i lexojm permes next
        while(results.next()){
            int id = results.getInt("id");
            String name = results.getString("name");
            String email = results.getString("email");
            int age = results.getInt("age");
            System.out.println("Id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Age: " + age);
            System.out.println("--------------");
        }

    }




}
