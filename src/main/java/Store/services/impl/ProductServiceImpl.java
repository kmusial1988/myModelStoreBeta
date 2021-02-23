package Store.services.impl;

import Store.DAO.IProductDAO;
import Store.model.Product;
import Store.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    IProductDAO productDAO;


    @Override
    public void addProduct(Product product) {
        this.productDAO.addProduct(product);

    }

    @Override
    public List<Product> allProductList() {
        return this.productDAO.allProductList();
    }

    @Override
    public List<Product> getProductByCategory(Product.Category category) {
        return this.productDAO.getProductByCategory(category);
    }


}
