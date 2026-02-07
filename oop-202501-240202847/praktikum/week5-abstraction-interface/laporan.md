# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Zaki Saputra]
- NIM   : [240202847]
- Kelas : [3IKRA]

---

## Tujuan
(
1. Mahasiswa memahami perbedaan antara Abstract Class dan Interface dalam Java.

2. Mahasiswa mampu mendesain Abstract Class yang memiliki perpaduan antara method abstrak dan konkrit.

3. Mahasiswa mampu mengimplementasikan Multiple Inheritance melalui penggunaan interface.

4. Mahasiswa mampu menerapkan konsep abstraksi untuk menyederhanakan sistem pembayaran pada aplikasi Agri-POS.)

---

## Dasar Teori
(
1. Abstraction: Proses menyembunyikan detail implementasi dan hanya menampilkan fungsionalitas utama kepada pengguna.

2. Abstract Class: Class yang tidak dapat dibuat objeknya secara langsung. Digunakan sebagai induk yang menyediakan state (atribut) dan perilaku dasar bagi subclass-nya.

3. nterface: Kontrak perilaku yang harus diikuti oleh class yang mengimplementasikannya. Interface memungkinkan sebuah class memiliki kemampuan dari berbagai sumber (multiple inheritance).

4. Shared State: Keunggulan Abstract Class dibanding Interface adalah kemampuannya menyimpan variabel (field) yang bisa diwariskan ke subclass.)

---

## Langkah Praktikum
(
1. Membuat Struktur Package: Memisahkan model pembayaran di package com.upb.agripos.model.pembayaran dan interface di package com.upb.agripos.model.kontrak.

2. Membangun Abstract Class: Membuat class Pembayaran sebagai induk dengan method abstrak biaya() dan prosesPembayaran().

3. Mendefinisikan Interface: Membuat interface Validatable (untuk validasi keamanan) dan Receiptable (untuk kemampuan cetak struk).

4. Implementasi Subclass:

- Class Cash mewarisi Pembayaran dan mengimplementasikan Receiptable.

- Class EWallet mewarisi Pembayaran serta mengimplementasikan dua interface sekaligus (Validatable dan Receiptable).

5. Eksekusi Polimorfik: Menggunakan MainAbstraction.java untuk menjalankan berbagai metode pembayaran dan mencetak hasilnya.

6. Version Control: Melakukan commit dengan pesan week5-abstraction-interface.)

---

## Kode Program
(// Contoh Abstract Class
public abstract class Pembayaran {
    protected double total;
    public abstract double biaya(); // Harus diimplementasikan anak
    public double totalBayar() { return total + biaya(); } // Method konkrit
}

// Contoh Multiple Inheritance via Interface di EWallet
public class EWallet extends Pembayaran implements Validatable, Receiptable {
    @Override
    public boolean validasi() { return otp.length() == 6; }
    
    @Override
    public String cetakStruk() { return "Struk E-Wallet..."; }
}
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/Screenshot2025-12-25.png)
)
---

## Analisis
(
- Analisis Struktur: Dengan menggunakan Abstract Class Pembayaran, kita tidak perlu menulis ulang logika totalBayar() di setiap jenis pembayaran. Cukup tentukan biaya() spesifiknya saja.

- Analisis Interface: Penggunaan interface Receiptable sangat efektif karena baik pembayaran Cash maupun EWallet sama-sama butuh cetak struk, meskipun cara pembayarannya sangat berbeda.

- Multiple Inheritance: Java tidak mengizinkan sebuah class memiliki dua induk class, namun melalui interface (seperti pada class EWallet), kita bisa memberikan banyak kemampuan sekaligus (validasi dan cetak struk) kepada satu class.

- Kendala: Kesulitan dalam melakukan casting objek saat memanggil method interface dari variabel tipe Abstract Class. Kendala ini diselesaikan dengan menggunakan sintaks ((Receiptable) variabel).cetakStruk().  
)
---

## Kesimpulan
(Abstraksi membantu dalam membangun sistem yang fleksibel. Abstract class digunakan ketika ada hubungan "is-a" (EWallet adalah Pembayaran), sedangkan interface digunakan untuk kemampuan tambahan "can-do" (EWallet bisa divalidasi). Hal ini membuat sistem Agri-POS mudah ditambah metode pembayaran baru di masa depan.)

---

## Quiz
(1. [Jelaskan perbedaan konsep dan penggunaan abstract class dan interface?]  
   **Abstract class digunakan untuk class yang memiliki hubungan kekerabatan erat dan ingin berbagi atribut/state. Interface digunakan sebagai kontrak kemampuan yang bisa diterapkan pada class mana saja tanpa mempedulikan hierarki class-nya.** …  

2. [Mengapa multiple inheritance lebih aman dilakukan dengan interface pada Java?]  
   **Karena interface hanya menyediakan tanda tangan method tanpa isi (sebelum Java 8), sehingga tidak ada risiko konflik implementasi (Diamond Problem) jika sebuah class mengambil method dari banyak sumber.** …  

3. [Pada contoh Agri-POS, bagian mana yang paling tepat menjadi abstract class dan mana yang menjadi interface?]  
   **Pembayaran paling tepat menjadi Abstract Class karena semua jenis pembayaran pasti punya invoiceNo dan total. Validatable paling tepat menjadi Interface karena tidak semua pembayaran butuh validasi (seperti Cash yang tidak butuh OTP).** …  )