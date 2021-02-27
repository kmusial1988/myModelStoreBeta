package Store.DAO;

import Store.model.Basket;

public interface IBasketDAO {
    void addOrUpdateToBasket(Basket basket);

    Basket getProductByBarcode(String barcode);
}
