package com.upb.agripos;

import java.sql.Connection;
import java.util.List;

import com.upb.agripos.config.DatabaseConfig;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;

public class MainDAOTest {

    public static void main(String[] args) {
        System.out.println("=== Agri-POS Database CRUD Test ===");

        try (Connection conn = DatabaseConfig.getConnection()) {
            ProductDAO dao = new ProductDAOImpl(conn);

            // 1. CREATE
            System.out.println("\n[Action] Menambah Produk...");
            dao.insert(new Product("P01", "Pupuk Organik", 25000, 10));
            dao.insert(new Product("P02", "Bibit Padi", 15000, 50));

            // 2. READ (Find One)
            Product p = dao.findByCode("P01");
            System.out.println("[Result] Cari P01: " + p);

            // 3. UPDATE
            System.out.println("\n[Action] Update Harga P01...");
            if (p != null) {
                p.setPrice(27500);
                dao.update(p);
            }

            // 4. READ (Find All)
            System.out.println("[Result] Daftar Semua Produk:");
            List<Product> allProducts = dao.findAll();
            for (Product item : allProducts) {
                System.out.println(" - " + item);
            }

            // 5. DELETE
            // System.out.println("\n[Action] Menghapus P02...");
            // dao.delete("P02");
            System.out.println("[Status] Selesai.");

        } catch (Exception e) {
            System.err.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}