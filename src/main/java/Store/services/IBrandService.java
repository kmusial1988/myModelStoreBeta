package Store.services;

import Store.model.Brand;

import java.util.List;

public interface IBrandService {
    void addBrand(Brand brand);
    List<Brand> getAllBrands();
}
