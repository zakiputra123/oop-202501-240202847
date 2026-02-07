
package com.upb.agripos;

import com.upb.agripos.config.DatabaseConnection;
import com.upb.agripos.controller.ProductController;
import com.upb.agripos.model.Product;
import com.upb.agripos.view.ConsoleView;

public class AppMVC {
    public static void main(String[] args) {
        System.out.println("Agri-POS System Week 10");
        System.out.println("Developed by: [Rizal Ramadani] - [240202883]\n");

        // 1. Uji Singleton
        try {
            DatabaseConnection db = DatabaseConnection.getInstance();
            db.executeQuery("SELECT * FROM products");
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }

        // 2. Uji MVC
        // Model
        Product myProduct = new Product("P001", "Bibit Padi Unggul");
        // View
        ConsoleView myView = new ConsoleView();
        // Controller
        ProductController controller = new ProductController(myProduct, myView);

        controller.updateView();
    }
}
