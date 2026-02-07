package com.upb.agripos;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> items = new ArrayList<>();

    public void addProduct(Product p) {
        items.add(p);
        System.out.println("[+] Berhasil menambah: " + p.getName());
    }

    public void removeProduct(Product p) {
        if (items.remove(p)) {
            System.out.println("[-] Berhasil menghapus: " + p.getName());
        } else {
            System.out.println("[!] Produk tidak ditemukan di keranjang.");
        }
    }

    public double getTotal() {
        double sum = 0;
        for (Product p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("\n--- ISI KERANJANG (ArrayList) ---");
        if (items.isEmpty()) {
            System.out.println("(Keranjang Kosong)");
        } else {
            for (Product p : items) {
                System.out.println("- " + p.getCode() + " | " + p.getName() + " \t: Rp" + p.getPrice());
            }
        }
        System.out.println("TOTAL BELANJA: Rp" + getTotal());
        System.out.println("---------------------------------");
    }
}