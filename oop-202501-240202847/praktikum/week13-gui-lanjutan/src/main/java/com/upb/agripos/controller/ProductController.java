package com.upb.agripos.controller;

import java.util.List;

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
                
                service.addProduct(p);
                refreshList();
                clearForm();
                
            } catch (Exception e) {
                showError("Gagal Tambah: " + e.getMessage());
            }
        });

        view.btnUpdate.addActionListener(event -> {
            try {
                Product p = new Product(
                    view.txtCode.getText(),
                    view.txtName.getText(),
                    Double.parseDouble(view.txtPrice.getText()),
                    Integer.parseInt(view.txtStock.getText())
                );
                
                service.updateProduct(p);
                refreshList();
                clearForm();
                
            } catch (Exception e) {
                showError("Gagal Update: " + e.getMessage());
            }
        });

        view.btnDelete.addActionListener(event -> {
            try {
                String code = view.txtCode.getText();
                if (code.isEmpty()) {
                    showError("Pilih produk dari daftar untuk dihapus!");
                    return;
                }
                service.deleteProduct(code);
                refreshList();
                clearForm();
                
            } catch (Exception e) {
                showError("Gagal Hapus: " + e.getMessage());
            }
        });

        view.btnSearch.addActionListener(event -> {
            try {
                String query = view.txtSearch.getText();
                List<Product> results = service.searchProducts(query);
                updateList(results);
                
            } catch (Exception e) {
                showError("Gagal Cari: " + e.getMessage());
            }
        });

        // List selection listener
        view.listView.addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                String selected = view.listView.getSelectedValue();
                if (selected != null) {
                    try {
                        String code = selected.split(" - ")[0];
                        Product p = service.findProduct(code);
                        if (p != null) {
                            view.txtCode.setText(p.getCode());
                            view.txtName.setText(p.getName());
                            view.txtPrice.setText(String.valueOf(p.getPrice()));
                            view.txtStock.setText(String.valueOf(p.getStock()));
                        }
                    } catch (Exception e) {
                        showError("Gagal Load Produk: " + e.getMessage());
                    }
                }
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

    private void updateList(List<Product> products) {
        DefaultListModel<String> model = (DefaultListModel<String>) view.listView.getModel();
        model.clear();
        products.forEach(p -> 
            model.addElement(p.getCode() + " - " + p.getName() + " [Rp" + p.getPrice() + "]"));
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