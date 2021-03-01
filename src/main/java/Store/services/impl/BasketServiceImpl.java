package Store.services.impl;

import Store.DAO.IProductDAO;
import Store.model.Product;
import Store.services.IBasketService;
import Store.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class BasketServiceImpl implements IBasketService {


    @Autowired
    IProductDAO productDAO;

    @Resource
    SessionObject sessionObject;


    @Override
    public void addProductToBasket(int id) {

        Product product = this.productDAO.getProductById(id);
        Map<Product, Integer> basket = sessionObject.getBasket();
        boolean isBookInBasket = sessionObject.getBasket().containsKey(product);
        if(isBookInBasket){
            basket.put(product, basket.get(product) +1);

        }else {
            basket.put(product, 1);
        }
        System.out.println(basket);
    }
}
