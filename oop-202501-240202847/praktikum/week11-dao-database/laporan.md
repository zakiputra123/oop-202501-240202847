# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Zaki Saputra]
- NIM   : [240202847]
- Kelas : [3IKRA]


---

## Tujuan
(
1. Mahasiswa memahami dan mampu menerapkan pola desain Data Access Object (DAO) untuk memisahkan logika bisnis dengan logika akses data.

2. Mahasiswa mampu mengonfigurasi koneksi basis data relasional (PostgreSQL) menggunakan JDBC (Java Database Connectivity).

3. Mahasiswa mampu mengimplementasikan operasi CRUD (Create, Read, Update, Delete) menggunakan PreparedStatement untuk keamanan data.

4. Mahasiswa mampu mengintegrasikan DAO ke dalam aplikasi utama sesuai prinsip desain OOP yang baik.)

---

## Dasar Teori
(
1. DAO Pattern: Pola desain yang menyediakan antarmuka abstrak ke beberapa jenis database. Ini memungkinkan aplikasi tetap konsisten meskipun teknologi penyimpanan di belakangnya berubah.

2. JDBC (Java Database Connectivity): API standar Java untuk menghubungkan aplikasi dengan database. Komponen utamanya meliputi:

- DriverManager: Mengelola daftar driver database.

- Connection: Menangani sesi komunikasi dengan database.

3. PreparedStatement: Digunakan untuk mengeksekusi query SQL yang terparameter (mencegah SQL Injection).

4. ResultSet: Menampung data hasil query SELECT.)

---

## Langkah Praktikum
(
1. Persiapan Database: Membuat database agripos di PostgreSQL dan menjalankan script SQL untuk membuat tabel products.

2. Pembuatan Model: Mendefinisikan class Product.java sebagai entitas data (POJO - Plain Old Java Object).

3. Definisi Interface: Membuat ProductDAO.java yang berisi kontrak method CRUD tanpa implementasi teknis.

4. Implementasi DAO: Membuat ProductDAOImpl.java yang berisi logika JDBC (membuka koneksi, eksekusi query, dan menutup resource).

5. Uji Coba Sistem: Menjalankan MainDAOTest.java untuk mensimulasikan alur: Tambah data -> Update data -> Cari data -> Hapus data.

6. Version Control: Melakukan commit dengan pesan week11-dao-database: implement crud operations.)

---

## Kode Program
(// Contoh Implementasi Insert pada ProductDAOImpl
@Override
public void insert(Product p) throws Exception {
    String sql = "INSERT INTO products(code, name, price, stock) VALUES (?, ?, ?, ?)";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setString(1, p.getCode());
        ps.setString(2, p.getName());
        ps.setDouble(3, p.getPrice());
        ps.setInt(4, p.getStock());
        ps.executeUpdate();
    }
}

// Penggunaan DAO di Main Program
ProductDAO dao = new ProductDAOImpl(conn);
dao.insert(new Product("P01", "Pupuk Organik", 25000, 10));
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Database table showing product inventory with columns for code, name, price, and stock. Two products listed: P02 Bibit Padi priced at 15000 with 50 units in stock, and P01 Pupuk Organik priced at 27500 with 10 units in stock. Table demonstrates successful CRUD operation and data persistence in PostgreSQL database.](screenshots/Screenshot 2026-01-15 174318.png)
)
---

## Analisis
(
- Analisis DAO: Dengan menggunakan interface ProductDAO, logika utama di MainDAOTest tidak tercampur dengan kode SQL. Ini membuat kode jauh lebih bersih dan mudah dibaca.

- Keamanan Data: Penggunaan PreparedStatement dengan tanda tanya (?) memastikan bahwa data input dari pengguna tidak akan dieksekusi sebagai perintah SQL berbahaya (SQL Injection).

- Resource Management: Penggunaan try-with-resources pada JDBC memastikan bahwa objek PreparedStatement dan ResultSet ditutup secara otomatis setelah digunakan, sehingga mencegah kebocoran memori (memory leak).

- endala: Kendala yang sering dihadapi adalah lupa menambahkan driver JDBC PostgreSQL ke dalam build path proyek. Kendala ini diatasi dengan menambahkan file .jar driver ke dalam dependensi proyek.  
)
---

## Kesimpulan
(Penerapan pola DAO dalam akses database JDBC membuat aplikasi Agri-POS lebih profesional dan terstruktur. Pemisahan tanggung jawab antara Model, Interface, dan Implementasi memudahkan pengujian dan pengembangan aplikasi di masa depan, terutama jika database ingin diganti dari PostgreSQL ke MySQL atau teknologi lainnya.)

---

## Quiz
(1. [Apa perbedaan antara Statement dan PreparedStatement dalam JDBC? Mengapa PreparedStatement lebih disarankan?]  
   **Statement: Digunakan untuk eksekusi query SQL statis tanpa parameter. Query dikirim langsung ke database setiap kali dijalankan.** …  

2. [Mengapa kita perlu membuat Interface untuk DAO (misal: ProductDAO) sebelum membuat class implementasinya (ProductDAOImpl)?]  
   **Penggunaan Interface bertujuan untuk Abstraksi dan Loose Coupling. Dengan Interface, logika bisnis aplikasi hanya tahu "apa saja" operasi yang tersedia (seperti insert atau delete) tanpa perlu tahu "bagaimana" teknis penyimpanannya. Jika suatu saat kita ingin mengganti database dari PostgreSQL ke MySQL atau bahkan ke teknologi Cloud, kita cukup membuat implementasi baru tanpa mengubah kode di level aplikasi utama.** …  

3. [Apa fungsi dari ResultSet dalam operasi SELECT?]  
   **ResultSet adalah objek yang menampung baris-baris data hasil eksekusi query dari database. Kita dapat membayangkan ResultSet sebagai tabel virtual di memori Java yang memiliki kursor. Kita menggunakan method .next() untuk menggerakkan kursor ke baris berikutnya dan method seperti .getString() atau .getInt() untuk mengambil nilai dari kolom tertentu pada baris tersebut.** …  )