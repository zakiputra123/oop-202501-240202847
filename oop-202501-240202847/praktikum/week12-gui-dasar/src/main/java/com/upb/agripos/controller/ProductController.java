package com.upb.agripos.controller;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductFormView;

public class ProductController {
    private final ProductFormView view;
    private final ProductService service;

    public ProductController(ProductFormView view, ProductService service) {
        this.view = view;
        this.service = service;
        initEventHandlers();
        loadData();
    }

    private void initEventHandlers() {
        // Event-Driven: Aksi saat tombol diklik
        view.btnAdd.addActionListener(event -> {
            try {
                Product p = new Product(
                    view.txtCode.getText(),
                    view.txtName.getText(),
                    Double.parseDouble(view.txtPrice.getText()),
                    Integer.parseInt(view.txtStock.getText())
                );
                
                service.addProduct(p); // Alur AD-01 & SD-01: View -> Controller -> Service
                refreshList();
                clearForm();
                
            } catch (Exception e) {
                showError("Gagal Tambah: " + e.getMessage());
            }
        });
    }

    private void loadData() {
        try {
            DefaultListModel<String> model = (DefaultListModel<String>) view.listView.getModel();
            service.getAllProducts().forEach(p -> 
                model.addElement(p.getCode() + " - " + p.getName() + " [Rp" + p.getPrice() + "]"));
        } catch (Exception e) {
            showError("Gagal Load Data: " + e.getMessage());
        }
    }

    private void refreshList() throws Exception {
        DefaultListModel<String> model = (DefaultListModel<String>) view.listView.getModel();
        model.clear();
        loadData();
    }

    private void clearForm() {
        view.txtCode.setText("");
        view.txtName.setText("");
        view.txtPrice.setText("");
        view.txtStock.setText("");
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(view, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}