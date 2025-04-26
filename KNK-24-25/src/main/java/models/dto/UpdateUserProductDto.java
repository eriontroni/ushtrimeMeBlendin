package models.dto;

public class UpdateUserProductDto {
    private int id;
    private int userId;
    private int productId;

    public UpdateUserProductDto(int id, int userId, int productId) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getProductId() {
        return productId;
    }
}
