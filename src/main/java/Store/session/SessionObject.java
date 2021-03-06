package Store.session;

import Store.model.Basket;
import Store.model.Product;
import Store.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@SessionScope
public class SessionObject {


    private User user =null;
    private String info = null;
    private String filter = null;
    private Map<Product, Integer > basket = new HashMap<>();
    private String lastAddress;
    private String lastFindPattern;
    private List<Product> basketProduct = new ArrayList<>();
    private Product productUpdate;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public boolean isLogged() {
        return  !(this.user == null);
    }

    public String getInfo() {
        String result = this.info;
        this.info = null;
        return result;
    }

    public Product getProductUpdate() {
        return productUpdate;
    }

    public void setProductUpdate(Product productUpdate) {
        this.productUpdate = productUpdate;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Product, Integer> getBasket() {
        return basket;
    }

    public void setBasket(Map<Product, Integer> basket) {
        this.basket = basket;
    }

    public String getLastAddress() {
        return lastAddress;
    }

    public void setLastAddress(String lastAddress) {
        this.lastAddress = lastAddress;
    }

    public String getLastFindPattern() {
        return lastFindPattern;
    }

    public void setLastFindPattern(String lastFindPattern) {
        this.lastFindPattern = lastFindPattern;
    }

    public List<Product> getBasketProduct() {
        return basketProduct;
    }

    public void setBasketProduct(List<Product> basketProduct) {
        this.basketProduct = basketProduct;
    }
}


