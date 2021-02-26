package Store.DAO.impl;

import Store.DAO.IBrandDAO;
import Store.model.Brand;
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
public class BrandDAOImpl implements IBrandDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addBrand(Brand brand) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(brand);
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
    public List<Brand> getAllBrands() {

        Session session = this.sessionFactory.openSession();
        Query<Brand> query = session
                .createQuery("FROM Store.model.Brand");
        List<Brand> result = query.getResultList();
        session.close();

        return result;
    }

    @Override
    public Brand getBrandByName(String name) {
        try {
        Session session = this.sessionFactory.openSession();
        Query<Brand> query = session
                .createQuery("FROM Store.model.Brand WHERE name = :name ");
        query.setParameter("name", name);
        Brand brand = query.getSingleResult();
        session.close();
        return brand;
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public Brand getBrandByShortcut(String Shortcut) {
        try {
        Session session = this.sessionFactory.openSession();
        Query<Brand> query = session
                .createQuery("FROM Store.model.Brand WHERE Shortcut = :Shortcut ");
        query.setParameter("Shortcut", Shortcut);
            Brand brand = query.getSingleResult();
            session.close();
            return brand;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Brand> findBrandName(String pattern) {
        Session session = this.sessionFactory.openSession();

        Query<Brand> query = session
                .createQuery("FROM Store.model.Brand WHERE name like :name OR Shortcut like :Shortcut");
        query.setParameter("name", "%" + pattern + "%");
        query.setParameter("Shortcut", "%" + pattern + "%");
        List<Brand> result = query.getResultList();
        session.close();

        return result;
    }

    @Override
    public List<Brand> findBrand(String patternBrand) {
        Session session = this.sessionFactory.openSession();

        Query<Brand> query = session
                .createQuery("FROM Store.model.Brand WHERE name like :name OR Shortcut like :Shortcut");
        query.setParameter("name", "%" + patternBrand + "%");
        query.setParameter("Shortcut", "%" + patternBrand + "%");
        List<Brand> result = query.getResultList();
        session.close();

        return result;
    }
}
