//package services;
//
//import models.Product;
//import models.UserProduct;
//import models.dto.CreateUserProductDto;
//import models.dto.UpdateProductDto;
//import models.dto.UserBuyProductDto;
//import repository.ProductRepository;
//import repository.UserProductRepository;
//
//public class UserProductService {
//    private ProductRepository productRepository;
//    private UserProductRepository userProductRepository;
//
//    public boolean buyProduct(UserBuyProductDto userProduct) throws Exception {
//        if(userProduct.getQuantity() <= 0){
//            throw new Exception("Quantity cannot be zero!");
//        }
//        Product product = this.productRepository.getById(userProduct.getProductId());
//        if(product.getStock() < userProduct.getQuantity()){
//            throw new Exception("Quantity is greater than stock!");
//        }
//
//    CreateUserProductDto createUserProductDto = new CreateUserProductDto(userProduct.getUserId(), userProduct.getProductId(), userProduct.getQuantity());
//    UserProduct createdUserProduct = this.userProductRepository.create(createUserProductDto);
//    if(createdUserProduct == null){
//        throw new Exception("User buy product failed");
//    }
//
//    UpdateProductDto updateProductDto = new UpdateProductDto();
//    updateProductDto.setStock(product.getStock() - userProduct.getQuantity());
//    this.productRespository.update(updateProductDto);
//    return true;
//
//}
//
//
//}
