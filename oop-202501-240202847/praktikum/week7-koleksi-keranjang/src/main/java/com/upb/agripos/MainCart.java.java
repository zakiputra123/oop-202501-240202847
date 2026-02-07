package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        // Ganti dengan Nama dan NIM Anda
        System.out.println("===== Agri-POS System - Week 7 =====");
        System.out.println("Nama : [Rizal Ramadani]");
        System.out.println("NIM  : [240202883]\n");

        // Data Produk
        Product p1 = new Product("P01", "Beras 5kg", 65000);
        Product p2 = new Product("P02", "Pupuk Urea", 45000);
        Product p3 = new Product("P03", "Bibit Padi", 25000);

        // 1. Uji Coba ArrayList
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p2); // Duplikat diperbolehkan di List
        cart.printCart();

        cart.removeProduct(p1);
        cart.printCart();

        // 2. Uji Coba Map (Dengan Quantity)
        ShoppingCartMap cartMap = new ShoppingCartMap();
        cartMap.addProduct(p1);
        cartMap.addProduct(p3);
        cartMap.addProduct(p3); // Akan menambah quantity, bukan baris baru
        cartMap.printCart();
    }
}