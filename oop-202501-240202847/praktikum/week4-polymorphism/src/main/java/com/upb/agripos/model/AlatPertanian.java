package com.upb.agripos.model;

/**
 * Subclass AlatPertanian yang mewarisi class Produk.
 * Mengimplementasikan Overriding pada method getInfo().
 */
public class AlatPertanian extends Produk {
    private String material;

    // Konstruktor untuk inisialisasi atribut superclass dan subclass
    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    // Getter dan Setter untuk atribut material
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    /**
     * Overriding method getInfo() dari superclass Produk.
     * Menggunakan super.getInfo() untuk mengambil informasi dasar, 
     * lalu menambahkan detail material khusus alat pertanian.
     */
    @Override
    public String getInfo() {
        return "Alat Pertanian: " + super.getInfo() + ", Material: " + material;
    }
}