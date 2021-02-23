package Store.DAO.impl;

import Store.DAO.IBrandDAO;
import Store.model.Brand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
