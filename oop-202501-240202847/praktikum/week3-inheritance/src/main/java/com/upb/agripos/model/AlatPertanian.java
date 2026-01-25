package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    // Variabel yang hanya diinisialisasi di konstruktor sebaiknya diberi 'final'
    private final String model; // Atribut tambahan (model/tipe alat)
    private final String bahan; // Atribut tambahan (bahan dasar)

    // Konstruktor Subkelas
    // Urutan: (kode, nama, harga, stok, model, bahan)
    public AlatPertanian(String kode, String nama, double harga, int stok, String model, String bahan) {
        // Memanggil Konstruktor Superclass (Produk)
        super(kode, nama, harga, stok);
        this.model = model;
        this.bahan = bahan;
    }

    // Getter untuk atribut tambahan
    public String getModel() {
        return model;
    }

    public String getBahan() {
        return bahan;
    }
}