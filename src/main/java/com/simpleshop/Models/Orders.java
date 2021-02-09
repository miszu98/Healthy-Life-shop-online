package com.simpleshop.Models;

import javax.persistence.*;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;

    private String type;

    private Long authorID;

    private int quantity;

    public String getKgFormatPrice() {
        return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(product.getPricePerKg() * quantity);
    }

    public String getOneFormatPrice() {
        return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(product.getPricePerOne() * quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", product=" + product +
                ", type='" + type + '\'' +
                ", authorID=" + authorID +
                ", quantity=" + quantity +
                '}';
    }
}
