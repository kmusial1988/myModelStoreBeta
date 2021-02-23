package Store.DAO.impl;

import Store.DAO.IProductDAO;
import Store.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(product);
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
    public Product getProductByBarcode(String barcode) {
        try {
            Session session = sessionFactory.openSession();
            Query<Product> query = session
                    .createQuery("FROM Store.model.Product WHERE barcode = :barcode");
            query.setParameter("barcode", barcode);
            Product product = query.getSingleResult();
            session.close();
            return product;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Product> allProductList() {


        Session session = this.sessionFactory.openSession();
        Query<Product> query = session
                .createQuery("FROM Store.model.Product");
        List<Product> result = query.getResultList();
        session.close();

        return result;
    }

    @Override
    public List<Product> getProductByCategory(Product.Category category) {
        Session session = this.sessionFactory.openSession();

        Query<Product> query = session
                .createQuery("FROM Store.model.Product WHERE category = :category");
        query.setParameter("category", category);
        List<Product> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Product> getProductByFilter(String filter) {

        Session session = this.sessionFactory.openSession();

        Query<Product> query = session
                .createQuery("FROM Store.model.Product WHERE category = :category");
        query.setParameter("category", category);
        List<Product> result = query.getResultList();
        session.close();
        return result;
    }
/*
    @Override
    public List<Product> allProductListCat1() {
        Session session = this.sessionFactory.openSession();
        Query<Product> query = session
                .createQuery("FROM Store.model.Product");
        List<Product> result = query.getResultList();
        session.close();

        return result;
    }

    @Override
    public List<Product> allProductListCat2() {
        Session session = this.sessionFactory.openSession();
        Query<Product> query = session
                .createQuery("FROM Store.model.Product");
        List<Product> result = query.getResultList();
        session.close();

        return result;
    }

    @Override
    public List<Product> allProductListCat3() {
        Session session = this.sessionFactory.openSession();
        Query<Product> query = session
                .createQuery("FROM Store.model.Product");
        List<Product> result = query.getResultList();
        session.close();

        return result;
    }

    @Override
    public List<Product> allProductListCat4() {
        Session session = this.sessionFactory.openSession();
        Query<Product> query = session
                .createQuery("FROM Store.model.Product");
        List<Product> result = query.getResultList();
        session.close();

        return result;
    }*/
}
