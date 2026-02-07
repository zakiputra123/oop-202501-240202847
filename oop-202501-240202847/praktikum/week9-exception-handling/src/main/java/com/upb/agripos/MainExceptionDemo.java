package com.upb.agripos;

public class MainExceptionDemo {
    public static void main(String[] args) {
        System.out.println("=== Agri-POS Exception Handling & Singleton Demo ===");
        System.out.println("Nama: [Rizal Ramadani] - NIM: [240202883]\n");

        ShoppingCart cart = new ShoppingCart();
        Product p1 = new Product("P01", "Pupuk Organik", 25000, 5);
        Product p2 = new Product("P02", "Bibit Jagung", 15000, 10);

        // Kasus 1: Quantity Invalid
        try {
            cart.addProduct(p1, 0);
        } catch (InvalidQuantityException e) {
            System.err.println("ALERT: " + e.getMessage());
        }

        // Kasus 2: Produk Tidak Ada saat dihapus
        try {
            cart.removeProduct(p2);
        } catch (ProductNotFoundException e) {
            System.err.println("ALERT: " + e.getMessage());
        }

        // Kasus 3: Skenario Checkout (Berhasil lalu Stok Kurang)
        try {
            System.out.println("\nSkenario Checkout Normal:");
            cart.addProduct(p1, 2); // Ambil 2 dari 5
            cart.checkout();

            System.out.println("\nSkenario Stok Melebihi Batas:");
            cart.addProduct(p1, 4); // Sisa stok tadi 3, tapi minta 4
            cart.checkout();
        } catch (Exception e) {
            System.err.println("ERROR KRITIS: " + e.getMessage());
        } finally {
            System.out.println("\n[Sistem]: Membersihkan memori dan menutup sesi transaksi.");
        }
    }
}