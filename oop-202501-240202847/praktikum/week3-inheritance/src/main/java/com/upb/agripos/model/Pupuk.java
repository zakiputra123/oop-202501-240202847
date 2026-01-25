package com.upb.agripos.model;

public class Pupuk extends Produk {
    private final double beratKg;

    public Pupuk(String kode, String nama, double harga, int stok, double beratKg) {
        super(kode, nama, harga, stok);
        this.beratKg = beratKg;
    }

    // Gunakan nama ini agar sinkron dengan MainInheritance.java
    public double getBerat() {
        return beratKg;
    }
}