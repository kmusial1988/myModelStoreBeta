package Store.DAO;

import Store.model.Product;

import java.util.List;

public interface IProductDAO {
    void addProduct(Product product);

    Product getProductByBarcode(String barcode);
    List<Product> allProductList();
/*
    List<Product> allProductListCat1();
    List<Product> allProductListCat2();
    List<Product> allProductListCat3();
    List<Product> allProductListCat4();*/
    List<Product> getProductByCategory(Product.Category category);
    List<Product> getProductByFilter(String filter);
}
