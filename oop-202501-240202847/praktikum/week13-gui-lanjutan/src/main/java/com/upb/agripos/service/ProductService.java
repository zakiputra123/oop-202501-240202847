package com.upb.agripos.service;

import java.util.List;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(Product p) throws Exception {
        // Validasi bisnis sederhana sebelum ke DAO
        if (p.getPrice() < 0) throw new Exception("Harga tidak boleh negatif!");
        productDAO.insert(p);
    }

    public void updateProduct(Product p) throws Exception {
        if (p.getPrice() < 0) throw new Exception("Harga tidak boleh negatif!");
        productDAO.update(p);
    }

    public void deleteProduct(String code) throws Exception {
        productDAO.delete(code);
    }

    public Product findProduct(String code) throws Exception {
        return productDAO.findByCode(code);
    }

    public List<Product> getAllProducts() throws Exception {
        return productDAO.findAll();
    }

    public List<Product> searchProducts(String query) throws Exception {
        List<Product> all = productDAO.findAll();
        return all.stream()
            .filter(p -> p.getCode().toLowerCase().contains(query.toLowerCase()) ||
                        p.getName().toLowerCase().contains(query.toLowerCase()))
            .toList();
    }
}