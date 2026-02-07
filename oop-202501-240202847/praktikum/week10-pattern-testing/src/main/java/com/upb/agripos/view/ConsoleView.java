package com.upb.agripos.view;

public class ConsoleView {
    public void printProductDetails(String code, String name) {
        System.out.println("\n=== DETAIL PRODUK AGRI-POS ===");
        System.out.println("Kode Produk : " + code);
        System.out.println("Nama Produk : " + name);
        System.out.println("==============================");
    }

    public void showMessage(String message) {
        System.out.println("[INFO]: " + message);
    }
}