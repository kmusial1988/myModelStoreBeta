package Store.DAO.impl;

import Store.DAO.IBasketDAO;
import Store.model.Basket;
import Store.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class BasketDAOImpl implements IBasketDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addOrUpdateToBasket(Basket basket) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(basket);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }


    @Override
    public Basket getProductByBarcode(String barcode) {
        try {
            Session session = sessionFactory.openSession();
            Query<Basket> query = session
                    .createQuery("FROM Store.model.Basket WHERE barcode = :barcode");
            query.setParameter("barcode", barcode);
            Basket basket = query.getSingleResult();
            session.close();
            return basket;
        } catch (NoResultException e) {
            return null;
        }
    }
}
