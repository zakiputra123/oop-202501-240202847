# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Zaki Saputra]
- NIM   : [240202847]
- Kelas : [3IKRA]

---

## Tujuan
(
1. Aplikasi Agri-POS (Point of Sale Pertanian) adalah sistem kasir sederhana yang memungkinkan pengguna untuk mengelola data produk pertanian (Master Data) dan melakukan simulasi transaksi melalui fitur keranjang belanja. Data produk tersimpan secara persisten di database PostgreSQL, sementara perhitungan transaksi dikelola menggunakan Java Collections di memori aplikasi.

- Fitur Utama:

 Manajemen Produk (Lihat, Tambah, Hapus) via TableView.

 Fitur Keranjang Belanja (Tambah Item, Hitung Total).

 Validasi Input (Exception Handling) untuk harga, stok, dan kode produk.

 oneksi Database Terpusat (Singleton Pattern).

 Pengujian Logika Bisnis (Unit Testing).)

---

## Dasar Teori
(
1. Aplikasi ini merupakan gabungan dari modul-modul sebelumnya:

2. Bab 1-5 (OOP Dasar & Abstraksi): Penggunaan class Product, Cart, dan pewarisan pada metode pembayaran.

3. Bab 6 (UML & SOLID): Implementasi mengikuti Class Diagram MVC dan prinsip Dependency Inversion (DIP).

3. Bab 7 (Collections): Menggunakan Map<Product, Integer> dan List untuk mengelola item di dalam keranjang belanja.

4. Bab 9 (Exception): Custom exception InvalidQuantityException dan InsufficientStockException untuk validasi transaksi.

5. Bab 10 (Pattern & Testing): Implementasi Singleton pada DatabaseConnection dan JUnit untuk mengetes perhitungan total belanja.

6. Bab 11-13 (JDBC & GUI): Operasi CRUD ke PostgreSQL melalui ProductDAO yang divisualisasikan dengan JavaFX TableView dan Event Handling (Lambda).)

---

## Langkah Praktikum
(Masukkan gambar diagram yang sudah Anda buat/update di sini)

Class Diagram: Terdiri dari Layer View, Controller, Service, DAO, dan Model.

Sequence Diagram: Menunjukkan alur dari Klik Tombol → Service → DAO → JDBC.)

---

## Kode Program
(public class DatabaseConnection {
    private static Connection instance;
    public static Connection getInstance() throws SQLException {
        if (instance == null || instance.isClosed()) {
            instance = DriverManager.getConnection(URL, USER, PASS);
        }
        return instance;
    }
}
@Test
public void testCalculateTotal() {
    Cart cart = new Cart();
    cart.addItem(new Product("P01", "Beras", 10000, 10), 2); // 20.000
    assertEquals(20000.0, cart.getTotalPrice());
}
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/Screenshot 2026-01-16.png)
)
---

## Analisis
(
- Kendala: Terjadi Memory Leak karena koneksi database tidak tertutup otomatis. Solusi: Menerapkan try-with-resources pada setiap operasi di JdbcProductDAO.

- Kendala: Kesulitan sinkronisasi antara data di ObservableList (UI) dan Database setelah operasi hapus. Solusi: Memanggil kembali method loadData() yang melakukan fetch ulang dari ProductService setiap kali transaksi database berhasil.  
)
---

## Kesimpulan
(Beberapa poin utama yang dapat disimpulkan adalah:

1. Pemisahan Tanggung Jawab (Separation of Concerns): Dengan menerapkan pola MVC, Service, dan DAO, aplikasi menjadi lebih modular. Perubahan pada tampilan (GUI) tidak akan merusak logika database (DAO).

2. Keamanan dan Stabilitas: Penggunaan Exception Handling dan PreparedStatement memastikan aplikasi tidak mudah crash saat menerima input salah dan terlindungi dari serangan SQL Injection.

3. Pentingnya Dokumentasi Desain: Desain UML pada Bab 6 menjadi kompas utama dalam integrasi ini. Tanpa desain yang konsisten, proses penyatuan (integrasi) berbagai modul dari minggu ke minggu akan mengalami banyak konflik.

4. Kualitas Terjamin: Penerapan Unit Testing memberikan kepercayaan diri bagi pengembang bahwa logika perhitungan (seperti total harga keranjang) sudah akurat sebelum dilempar ke pengguna.)

---

## Quiz
(1. [Mengapa alur akses data harus melewati Controller -> Service -> DAO dan tidak boleh dari View langsung ke DAO?]  
   **Untuk menjaga prinsip Low Coupling. Jika View (GUI) langsung mengakses DAO, maka UI akan sangat bergantung pada struktur database. Dengan adanya Service Layer, kita bisa menambahkan logika bisnis tambahan (seperti validasi stok atau diskon) tanpa mengotori kode antarmuka.** …  
Dalam implementasi Keranjang Belanja, kapan sebaiknya kita menggunakan List dan kapan menggunakan Map?
2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **List sangat baik digunakan jika kita ingin mempertahankan urutan barang yang dimasukkan pelanggan. Namun, Map<Product, Integer> lebih efisien jika kita ingin mengelompokkan barang yang sama; sehingga jika barang yang sama ditambahkan lagi, kita cukup memperbarui nilai Quantity (Value) berdasarkan Key produk tersebut.** …  

3. [Apa peran krusial Singleton Pattern dalam koneksi database pada aplikasi Agri-POS?]  
   **Singleton memastikan bahwa aplikasi hanya membuka satu koneksi aktif ke PostgreSQL. Tanpa Singleton, setiap kali kita melakukan CRUD, aplikasi bisa membuka koneksi baru yang jika tidak tertutup akan menyebabkan kebocoran sumber daya (resource leak) dan membuat database melambat atau bahkan menolak koneksi baru** …  )