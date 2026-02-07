package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Validatable;
import com.upb.agripos.model.kontrak.Receiptable;

public class EWallet extends Pembayaran implements Validatable, Receiptable {
    private String akun;
    private String otp;

    public EWallet(String invoiceNo, double total, String akun, String otp) {
        super(invoiceNo, total);
        this.akun = akun;
        this.otp = otp;
    }

    @Override
    public double biaya() { return total * 0.015; }

    @Override
    public boolean validasi() {
        return otp != null && otp.length() == 6; // Simulasi: OTP harus 6 digit
    }

    @Override
    public boolean prosesPembayaran() {
        return validasi();
    }

    @Override
    public String cetakStruk() {
        String status = prosesPembayaran() ? "BERHASIL" : "GAGAL (OTP SALAH)";
        return String.format("[STRUK E-WALLET] INV: %s | Akun: %s | Total Akhir: %.2f | Status: %s",
                invoiceNo, akun, totalBayar(), status);
    }
}