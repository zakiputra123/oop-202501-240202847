# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Zaki Saputra]
- NIM   : [240202847]
- Kelas : [3IKRA]


---

## Tujuan
(
1. Mahasiswa memahami dan mampu mengimplementasikan Singleton Pattern untuk menjamin instansi tunggal pada objek global.

2. Mahasiswa mampu menerapkan arsitektur Model-View-Controller (MVC) untuk memisahkan logika bisnis, data, dan tampilan.

3. Mahasiswa mampu membuat dan menjalankan pengujian mandiri menggunakan framework JUnit.

4. Mahasiswa mampu menganalisis pengaruh penerapan pola desain terhadap kemudahan pemeliharaan kode (maintainability).)

---

## Dasar Teori
(
1. Singleton Pattern: Pola yang membatasi pembuatan objek dari suatu class menjadi satu instansi saja. Biasanya digunakan untuk manajemen koneksi database atau konfigurasi aplikasi.

2. MVC (Model-View-Controller): Pola arsitektur yang membagi aplikasi menjadi tiga bagian:

- Model: Mengelola data dan aturan bisnis.

- View: Mengelola representasi visual/tampilan (output).

3. Controller: Menerima input dan menjembatani interaksi antara Model dan View.)

---

## Langkah Praktikum
(
1. Implementasi Singleton: Membuat class DatabaseConnection di package config dengan constructor privat agar tidak bisa di-instansiasi dari luar.

2. Penerapan MVC:

- Membuat Product.java (Model) untuk menyimpan data.

- Membuat ConsoleView.java (View) untuk mencetak pesan ke terminal.

- Membuat ProductController.java (Controller) untuk mengontrol aliran data dari model ke view.

3. Integrasi Sistem: Menjalankan AppMVC.java sebagai titik masuk aplikasi yang menggabungkan ketiga komponen MVC.

4. Pembuatan Unit Test: Membuat class ProductTest.java di folder src/test menggunakan library JUnit 5 untuk memvalidasi apakah getter pada Model berjalan dengan benar.

5. Running Test: Menjalankan test runner di IDE (seperti IntelliJ atau VS Code) dan memastikan muncul indikator "Green Bar" (Lulus).)

---

## Kode Program
(// Contoh Implementasi Singleton
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private DatabaseConnection() {} // Constructor Privat
    public static DatabaseConnection getInstance() {
        if (instance == null) instance = new DatabaseConnection();
        return instance;
    }
}

// Contoh Unit Test
@Test
public void testProductName() {
    Product p = new Product("P01", "Benih Jagung");
    assertEquals("Benih Jagung", p.getName()); // Validasi
}
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
Screenshot 2026-01-14 at 07.00.03.png
Screnshots-2026-01-14-at-07.00.03.png
)
---

## Analisis
(
- Analisis Singleton: Dengan Singleton, kita menjamin efisiensi memori karena tidak ada pembuatan objek koneksi database yang berulang-ulang.

- Analisis MVC: Pemisahan ini sangat membantu. Jika di masa depan kita ingin mengubah tampilan dari Console ke GUI (Swing/JavaFX), kita hanya perlu mengganti bagian View saja tanpa menyentuh logika di Model.

- Analisis Testing: JUnit memberikan jaminan bahwa perubahan kecil pada kode tidak akan merusak fungsi utama. Jika getName() tiba-tiba mengembalikan nilai salah, test akan langsung gagal (Red Bar).

- Kendala: Kesulitan dalam mengatur classpath untuk library JUnit. Kendala diatasi dengan menambahkan dependensi JUnit di file konfigurasi proyek (seperti pom.xml atau menambahkan JAR secara manual).  
)
---

## Kesimpulan
(Penerapan Design Pattern dan Unit Testing secara signifikan meningkatkan kualitas perangkat lunak. MVC membuat kode lebih rapi dan modular, Singleton menjaga konsistensi objek global, dan JUnit memastikan kode tetap andal selama proses pengembangan.)

---

## Quiz
(1. [Mengapa constructor pada Singleton harus bersifat private?]  
   **Agar class tersebut tidak bisa diinstansiasi (dibuat objeknya) menggunakan kata kunci new dari class lain. Akses hanya diizinkan melalui method getInstance().** …  

2. [Jelaskan manfaat pemisahan Model, View, dan Controller]  
   **Manfaatnya adalah memudahkan pemeliharaan kode (maintenance), memungkinkan kolaborasi tim yang lebih baik (misal: satu orang fokus di UI, satu di logika), serta meningkatkan kemampuan reusability kode.** …  

3. [Apa peran unit testing dalam menjaga kualitas perangkat lunak?]  
   **Sebagai jaring pengaman untuk mendeteksi bug sedini mungkin sebelum aplikasi masuk ke tahap produksi atau tahap pengujian yang lebih luas.** …  )
