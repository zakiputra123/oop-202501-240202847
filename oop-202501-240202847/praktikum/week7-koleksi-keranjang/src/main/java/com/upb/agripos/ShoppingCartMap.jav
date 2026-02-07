
package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p) {
        items.put(p, items.getOrDefault(p, 0) + 1);
        System.out.println("[+] Tambah ke Map: " + p.getName());
    }

    public void removeProduct(Product p) {
        if (!items.containsKey(p)) return;
        int qty = items.get(p);
        if (qty > 1) {
            items.put(p, qty - 1);
        } else {
            items.remove(p);
        }
        System.out.println("[-] Kurangi dari Map: " + p.getName());
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void printCart() {
        System.out.println("\n--- ISI KERANJANG (Map/Quantity) ---");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getName() + " \t(x" + e.getValue() + ") \t: Rp" + (e.getKey().getPrice() * e.getValue()));
        }
        System.out.println("TOTAL AKHIR: Rp" + getTotal());
        System.out.println("------------------------------------");
    }
}
