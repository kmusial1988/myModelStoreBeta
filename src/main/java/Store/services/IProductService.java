package Store.services;

import Store.model.Basket;
import Store.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    List<Product> allProductList();
    List<Product> getProductByCategory(Product.Category category);
    List<Product> getProductByName(String name);
    List<Product> findProduct(String pattern);
    Product getProductByBarcode(String barcode);

    Product getProductById(int id);

    void updateProduct(Product product);

    void addOrUpdateToBasket(Basket basket);
}
