package Store.services.impl;

import Store.DAO.IBrandDAO;
import Store.model.Brand;
import Store.services.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    IBrandDAO brandDAO;

    @Override
    public void addBrand(Brand brand) {
        this.brandDAO.addBrand(brand);

    }

    @Override
    public List<Brand> getAllBrandsByName() {

        return this.brandDAO.getAllBrandsByName();
    }
}
