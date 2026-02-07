
package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Product, Integer> items = new HashMap<>();
    private final ProductService logger = ProductService.getInstance();

    public void addProduct(Product p, int qty) throws InvalidQuantityException {
        if (qty <= 0) {
            throw new InvalidQuantityException("Gagal tambah: Quantity (" + qty + ") harus lebih dari 0.");
        }
        items.put(p, items.getOrDefault(p, 0) + qty);
        logger.logActivity("Berhasil menambah " + qty + " unit " + p.getName());
    }

    public void removeProduct(Product p) throws ProductNotFoundException {
        if (!items.containsKey(p)) {
            throw new ProductNotFoundException("Gagal hapus: Produk '" + p.getName() + "' tidak ada di keranjang.");
        }
        items.remove(p);
        logger.logActivity("Berhasil menghapus " + p.getName() + " dari keranjang.");
    }

    public void checkout() throws InsufficientStockException {
        System.out.println("\n--- Memulai Proses Checkout ---");
        
        // Tahap 1: Validasi stok semua item
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int requestedQty = entry.getValue();
            
            if (product.getStock() < requestedQty) {
                throw new InsufficientStockException(
                    "Stok tidak cukup! Produk: " + product.getName() + 
                    " | Tersedia: " + product.getStock() + " | Diminta: " + requestedQty
                );
            }
        }

        // Tahap 2: Jika lolos validasi, kurangi stok
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            entry.getKey().reduceStock(entry.getValue());
        }
        
        items.clear(); // Kosongkan keranjang setelah berhasil
        System.out.println("Checkout Berhasil! Stok gudang telah diperbarui.");
    }
}
