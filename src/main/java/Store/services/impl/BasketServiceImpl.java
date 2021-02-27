package Store.services.impl;

import Store.DAO.IBasketDAO;
import Store.DAO.IProductDAO;
import Store.model.Basket;
import Store.model.Product;
import Store.model.User;
import Store.services.IBasketService;
import Store.session.SessionObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BasketServiceImpl implements IBasketService {

    @Autowired
    IBasketDAO basketDAO;

    @Autowired
    IProductDAO productDAO;

    @Resource
    SessionObject sessionObject;


    @Override
    public void addProductToBasket(int id) {
        Product product = this.productDAO.getProductById(id);

    }

    @Override
    public Basket getProductByBarcode(String barcode) {
        return this.basketDAO.getProductByBarcode(barcode);
    }

}
