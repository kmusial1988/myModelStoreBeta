package Store.services;

import Store.model.Basket;

public interface IBasketService {
    void addProductToBasket(int id);
    Basket getProductByBarcode(String barcode);
}
