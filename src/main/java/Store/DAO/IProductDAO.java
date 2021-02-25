package Store.DAO;

import Store.model.Product;

import java.util.List;

public interface IProductDAO {

    void addProduct(Product product);

    void updateProduct(Product product);

    Product getProductByBarcode(String barcode);
    List<Product> allProductList();
    List<Product> getProductByCategory(Product.Category category);
    List<Product> getProductByName(String name);
    List<Product> findProduct(String pattern);
    List<Product> getProductByBrandId(int id);



}
