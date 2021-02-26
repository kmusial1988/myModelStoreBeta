package Store.DAO;

import Store.model.Brand;

import java.util.List;

public interface IBrandDAO {
    void addBrand(Brand brand);
    List<Brand> getAllBrands();

    Brand getBrandByName(String name);
    Brand getBrandByShortcut(String Shortcut);
    List<Brand> findBrandName(String pattern);
    List<Brand> findBrand(String patternBrand);
}
