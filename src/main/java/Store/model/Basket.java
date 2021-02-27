package Store.model;

import javax.persistence.*;

@Entity(name = "tbasket")
public class Basket {
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
    private Product.Box box;
    @Column(nullable = false, length = 5)
    private int pieces;
    @Enumerated(EnumType.STRING)
    private Product.Category category;
    @Column(nullable = false, length = 5)
    private double price;
    @Enumerated(EnumType.STRING)
    private Status status;

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

    public Product.Box getBox() {
        return box;
    }

    public void setBox(Product.Box box) {
        this.box = box;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public Product.Category getCategory() {
        return category;
    }

    public void setCategory(Product.Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Basket{" +
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

    public enum Status {
        RESERVED,
        BOUGHT,

    }
}
