package com.upb.agripos.util;

import com.upb.agripos.model.Produk;
public class MainProduk {
    public static void main(String[] args) {
        // 1. Instansiasi Objek (Membuat Produk)
        Produk p1 = new Produk("BNH-001", "Benih Padi IR64", 25000, 100);
        Produk p2 = new Produk("PPK-101", "Pupuk Urea 50kg", 350000, 40);
        Produk p3 = new Produk("ALT-501", "Cangkul Baja", 90000, 15);

        // 2. Menampilkan Informasi Produk ke Console
        System.out.println("=== DAFTAR PRODUK PERTANIAN ===");
        tampilkanInfo(p1);
        tampilkanInfo(p2);
        tampilkanInfo(p3);

        // Contoh simulasi perubahan stok
        System.out.println("\n--- Simulasi Update Stok ---");
        p1.kurangiStok(10); // Mengurangi stok benih
        System.out.println("Stok terbaru " + p1.getNama() + ": " + p1.getStok());

        // 3. Menampilkan Identitas (Isi dengan NIM dan Nama Anda)
        CreditBy.print("240202847", "Zaki Saputra");
    }

    /**
     * Helper method untuk mencetak data produk agar kode di main lebih rapi
     */
    private static void tampilkanInfo(Produk p) {
        System.out.println("Kode: " + p.getKode() +
                " | Nama: " + p.getNama() +
                " | Harga: Rp" + p.getHarga() +
                " | Stok: " + p.getStok());
    }
}