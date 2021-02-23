package Store.DAO;

import Store.model.Product;

import java.util.List;

public interface IProductDAO {
    void addProduct(Product product);

    Product getProductByBarcode(String barcode);
    List<Product> allProductList();
}
