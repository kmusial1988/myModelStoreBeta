package Store.services.impl;

import Store.DAO.IBrandDAO;
import Store.DAO.IProductDAO;
import Store.model.Basket;
import Store.model.Brand;
import Store.model.Product;
import Store.services.IProductService;
import Store.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    IProductDAO productDAO;

    @Autowired
    IBrandDAO brandDAO;


    @Resource
    SessionObject sessionObject;


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

    @Override
    public List<Product> getProductByName(String name) {
        return this.productDAO.getProductByName(name);
    }

    @Override
    public List<Product> findProduct(String pattern) {
        Set<Product> result = new HashSet<Product>();
        List<Product> products = this.productDAO.findProduct(pattern);

        result.addAll(products);
        List<Brand> brands = this.brandDAO.findBrandName(pattern);

        for(Brand brand : brands) {
            List<Product> productsForBrand = this.productDAO
                    .getProductByBrandId(brand.getId());

            result.addAll(productsForBrand);
        }


        return new ArrayList<>(result);
    }

    @Override
    public Product getProductByBarcode(String barcode) {

        return this.productDAO.getProductByBarcode(barcode);
    }

    @Override
    public Product getProductById(int id) {
        return this.productDAO.getProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        this.productDAO.updateProduct(product);

    }


    /*@Override
    public void addOrUpdateToBasket(String barcode) {
        Product product = this.productDAO.getProductByBarcode(barcode);
        List<Product> basket = sessionObject.getBasket();
        boolean isProductInBasket = basket.contains(product);

        if(isProductInBasket) {
            basket.add(product);
        }

    }*/



}
