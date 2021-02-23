package Store.DAO;

import Store.model.Brand;

import java.util.List;

public interface IBrandDAO {
    void addBrand(Brand brand);
    List<Brand> getAllBrands();

}
