package com.upb.agripos.util;

public class CreditBy {
    /**
     * Menampilkan identitas mahasiswa di console.
     * 
     * @param nim  Nomor Induk Mahasiswa
     * @param nama Nama Lengkap Mahasiswa
     */
    public static void print(String nim, String nama) {
        System.out.println("\n-------------------------------------------");
        System.out.println("credit by: " + nim + " - " + nama);
        System.out.println("-------------------------------------------");
    }
}