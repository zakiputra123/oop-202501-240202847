package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Validatable;
import com.upb.agripos.model.kontrak.Receiptable;

public class TransferBank extends Pembayaran implements Validatable, Receiptable {
    private String bankName;
    private boolean isConfirmed;

    public TransferBank(String invoiceNo, double total, String bankName, boolean isConfirmed) {
        super(invoiceNo, total);
        this.bankName = bankName;
        this.isConfirmed = isConfirmed;
    }

    @Override
    public double biaya() { return 3500.0; }

    @Override
    public boolean validasi() { return isConfirmed; }

    @Override
    public boolean prosesPembayaran() { return validasi(); }

    @Override
    public String cetakStruk() {
        return String.format("[STRUK BANK] INV: %s | Bank: %s | Total: %.2f",
                invoiceNo, bankName, totalBayar());
    }
}