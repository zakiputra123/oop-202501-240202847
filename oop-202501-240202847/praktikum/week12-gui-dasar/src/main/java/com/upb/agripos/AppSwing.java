package com.upb.agripos;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.SwingUtilities;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductFormView;

public class AppSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Load driver
                Class.forName("org.postgresql.Driver");
                
                // 1. Setup Database & Backend
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agripos", "postgres", "rizalramadani01");
                ProductDAOImpl dao = new ProductDAOImpl(conn);
                ProductService service = new ProductService(dao);

                // 2. Setup GUI (MVC)
                ProductFormView view = new ProductFormView();
                new ProductController(view, service);

                // 3. Show Window
                view.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}