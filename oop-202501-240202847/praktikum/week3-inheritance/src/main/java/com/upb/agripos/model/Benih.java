package com.upb.agripos.model;

public class Benih extends Produk {
    private final String varietas; 
    private final String jenis;    

    // Konstruktor Benih
    public Benih(String kode, String nama, double harga, int stok, String varietas, String jenis) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
        this.jenis = jenis;
    }

    // Getter
    public String getVarietas() {
        return varietas;
    }

    public String getJenis() {
        return jenis;
    }
}