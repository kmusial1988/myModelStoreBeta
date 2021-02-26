package Store.services.impl;

import Store.DAO.IBrandDAO;
import Store.model.Brand;
import Store.model.Product;
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
    public List<Brand> getAllBrands() {

        return this.brandDAO.getAllBrands();
    }

    @Override
    public List<Brand> findBrand(String pattern) {
        return this.findBrand(pattern);
    }

    @Override
    public List<Brand> findBrandBrand(String patternBrand) {
        return this.brandDAO.findBrand(patternBrand);
    }

    @Override
    public Brand getBrandByShortcut(String Shortcut) {
        return this.brandDAO.getBrandByShortcut(Shortcut);
    }

    @Override
    public Brand getBrandByName(String name) {
        return this.brandDAO.getBrandByName(name);
    }


}
