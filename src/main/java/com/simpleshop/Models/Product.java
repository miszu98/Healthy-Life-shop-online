package com.simpleshop.Models;


import javax.persistence.*;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double pricePerKg;
    private double pricePerOne;
    private String img;
    private int quantity;
    private String category;
    private Long buyerId;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public String getFormatPricePerKg() {
        return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(getPricePerKg()) + "/kg";
    }

    public String getFormatPricePerOne() {
        return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(getPricePerOne()) + "/item";
    }

    public double getPricePerOne() {
        return pricePerOne;
    }

    public void setPricePerOne(double pricePerOne) {
        this.pricePerOne = pricePerOne;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pricePerKg=" + pricePerKg +
                ", pricePerOne=" + pricePerOne +
                ", img='" + img + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
