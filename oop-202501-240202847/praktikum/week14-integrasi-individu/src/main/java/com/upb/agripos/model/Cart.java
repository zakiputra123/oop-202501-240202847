package com.upb.agripos.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getCode().equals(product.getCode())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(String productCode) {
        items.removeIf(item -> item.getProduct().getCode().equals(productCode));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotal() {
        return items.stream().mapToDouble(CartItem::getSubtotal).sum();
    }

    public void clear() {
        items.clear();
    }
}