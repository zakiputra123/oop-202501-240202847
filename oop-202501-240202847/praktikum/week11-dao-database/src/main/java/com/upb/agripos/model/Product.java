package com.upb.agripos.model;

public class Product {
    private String code;
    private String name;
    private int price;
    private int stock;

    // Pastikan Constructor ini ada!
    public Product(String code, String name, int price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getter & Setter
    public String getCode() { return code; }
    public String getName() { return name; }
    
    // Pastikan method ini ada!
    public void setPrice(int price) { this.price = price; }
    public int getPrice() { return price; }
    
    public int getStock() { return stock; }
    
    @Override
    public String toString() {
        return "Product{code='" + code + "', name='" + name + "', price=" + price + ", stock=" + stock + "}";
    }
}