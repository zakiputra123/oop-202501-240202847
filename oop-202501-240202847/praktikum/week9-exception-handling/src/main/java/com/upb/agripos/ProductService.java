package com.upb.agripos;

// Menjamin hanya ada satu layanan pengelola produk
public class ProductService {
    private static ProductService instance;

    private ProductService() {}

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    public void logActivity(String message) {
        System.out.println("[LOG SERVICE]: " + message);
    }
}