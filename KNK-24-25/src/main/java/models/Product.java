package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    private Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public static Product getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        double price = resultSet.getDouble("price");
        int stock = resultSet.getInt("stock");

        return new Product(id, name, price, stock);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
