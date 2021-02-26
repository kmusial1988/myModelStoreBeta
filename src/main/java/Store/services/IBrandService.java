package Store.services;

import Store.model.Brand;
import Store.model.Product;

import java.util.List;

public interface IBrandService {
    void addBrand(Brand brand);
    List<Brand> getAllBrands();
    List<Brand> findBrand(String pattern);
    List<Brand> findBrandBrand(String patternBrand);
    Brand getBrandByShortcut(String Shortcut);

    Brand getBrandByName(String name);
}
