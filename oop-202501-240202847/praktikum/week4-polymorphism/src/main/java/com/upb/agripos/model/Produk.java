
package com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // --- OVERLOADING ---
    // Menambah stok dengan bilangan bulat
    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    // Menambah stok dengan bilangan desimal (di-cast ke int)
    public void tambahStok(double jumlah) {
        this.stok += (int) jumlah;
    }

    public String getInfo() {
        return "Produk: " + nama + " [" + kode + "]";
    }

    // Getter untuk stok agar bisa dipanggil di Main
    public int getStok() { return stok; }
}
