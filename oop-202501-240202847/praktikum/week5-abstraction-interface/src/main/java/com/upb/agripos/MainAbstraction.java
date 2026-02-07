package com.upb.agripos;

import com.upb.agripos.model.pembayaran.*;
import com.upb.agripos.model.kontrak.*;
import com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        // Inisialisasi berbagai metode pembayaran
        Pembayaran bayar1 = new Cash("INV-001", 50000, 100000);
        Pembayaran bayar2 = new EWallet("INV-002", 75000, "08123456789", "123456");
        Pembayaran bayar3 = new TransferBank("INV-003", 250000, "Bank Mandiri", true);

        // Array untuk memproses secara polimorfik
        Pembayaran[] daftarBayar = {bayar1, bayar2, bayar3};

        System.out.println("=== PROSES TRANSAKSI AGRI-POS ===\n");

        for (Pembayaran p : daftarBayar) {
            if (p.prosesPembayaran()) {
                // Downcasting ke interface untuk akses cetakStruk
                if (p instanceof Receiptable) {
                    System.out.println(((Receiptable) p).cetakStruk());
                }
            } else {
                System.out.println("Transaksi " + p.getInvoiceNo() + " GAGAL DIPROSES.");
            }
        }

        // Tampilkan identitas
        CreditBy.print("240202847", "Zaki Saputra"); // Ganti dengan data Anda
    }
}