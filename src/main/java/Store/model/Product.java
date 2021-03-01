package Store.model;

import javax.persistence.*;

@Entity(name = "tproduct")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Brand brand;
    @Column(nullable = false, unique = true, length = 13)
    private String barcode;
    @Enumerated(EnumType.STRING)
    private Box box;
    @Column(nullable = false, length = 5)
    private int pieces;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(nullable = false, length = 5)
    private double price;
    @Enumerated(EnumType.STRING)
    private Basket.Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Basket.Status getStatus() {
        return status;
    }

    public void setStatus(Basket.Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand=" + brand +
                ", barcode='" + barcode + '\'' +
                ", box=" + box +
                ", pieces=" + pieces +
                ", category=" + category +
                ", price=" + price +
                ", status=" + status +
                '}';
    }

    public enum Box {
        WEIGHT,
        PIECES,
        LITERS,
        OTHER

    }

    public enum Category {
        CAT1,
        CAT2,
        CAT3,
        CAT4,
    }
    public enum Status {
        STOCK,
        RESERVED,
        BOUGHT,

    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            Product p = (Product) o;
            return p.id == this.id;
        }
            return false;

    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
