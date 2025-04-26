//package repository;
//
//import models.Product;
//import models.dto.CreateProductDto;
//import models.dto.UpdateProductDto;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductRepository extends BaseRepository<Product, CreateProductDto, UpdateProductDto> {
//    public ProductRepository() {
//        super("product");
//    }
//
//    public Product fromResultSet(ResultSet rs) throws SQLException {
//        return Product.getInstance(rs);
//    }
//
//    @Override
//    Product fromResutlSet(ResultSet res) {
//        return null;
//    }
//
//    public Product create(CreateProductDto productDto) {
//        String query = """
//                INSERT INTO PRODUCT (NAME, PRICE, STOCK)
//                VALUES (? ? ?)
//                """;
//        try {
//            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            pstm.setString(1, productDto.getName());
//            pstm.setDouble(2, productDto.getPrice());
//            pstm.setInt(3, productDto.getStock());
//            pstm.execute();
//            ResultSet result = pstm.getGeneratedKeys();
//            if (result.next()) {
//                int id = result.getInt(1);
//                return this.getById(id);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    Product udpate(UpdateProductDto updateProductDto) {
//        return null;
//    }
//
//    public Product update(UpdateProductDto updateProductDto) {
//        StringBuilder query = new StringBuilder("UPDATE PRODUCT SET ");
//        List<Object> parametrat = new ArrayList<>();
//        boolean hasUpdates=false;
//
//        if (updateProductDto.getName() != null) {
//            query.append("name = ?, ");
//            parametrat.add(updateProductDto.getName());
//            hasUpdates=true;
//        }
//        if(updateProductDto.getPrice()>=0) {
//            query.append("price=?, ");
//            parametrat.add(updateProductDto.getPrice());
//            hasUpdates=true;
//        }
//        if(updateProductDto.getStock()>=0) {
//            query.append("stock=?, ");
//            parametrat.add(updateProductDto.getStock());
//            hasUpdates=true;
//        }
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
//            for(int i=0; i<parametrat.size(); i++) {
//                preparedStatement.setObject(i+1, parametrat.get(i));
//            }
//            preparedStatement.executeUpdate();
//            return getById(updateProductDto.getId());
//        } catch (SQLException e) {
//            throw new RuntimeException("Gabim gjate perditesimit!", e);
//        }
//    }
//}
//
//}
