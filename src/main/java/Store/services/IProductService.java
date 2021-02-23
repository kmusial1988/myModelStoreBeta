package Store.services;

import Store.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    List<Product> allProductList();

    boolean productExist(Product product);
}
