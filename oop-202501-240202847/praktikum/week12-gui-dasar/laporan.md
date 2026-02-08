# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Zaki Saputra]
- NIM   : [240202847]
- Kelas : [3IKRA]

---

## Tujuan
(
1. Mahasiswa mampu membangun antarmuka grafis (GUI) menggunakan JavaFX.

2. Mahasiswa memahami konsep Event-Driven Programming melalui penanganan aksi tombol (Event Handling).

3. Mahasiswa mampu mengintegrasikan GUI dengan backend (Service & DAO) yang telah dibuat sebelumnya.

4. Mahasiswa mampu merealisasikan desain UML (Bab 6) ke dalam implementasi kode nyata secara konsisten.)

---

## Dasar Teori
(
1. Event-Driven Programming: Paradigma pemrograman di mana alur eksekusi program ditentukan oleh peristiwa (event) seperti klik mouse, penekanan tombol, atau input sensor.

2. JavaFX: Framework modern Java untuk membangun aplikasi desktop yang kaya fitur. Komponen utamanya meliputi Stage (jendela), Scene (kontainer konten), dan Nodes (elemen UI seperti Button, TextField).

3. Traceability: Kemampuan untuk menelusuri implementasi kode kembali ke dokumen desain (Bab 6) guna memastikan fungsionalitas aplikasi sesuai dengan Use Case dan Sequence Diagram yang telah dirancang.)

---

## Langkah Praktikum
(
1. Persiapan Project: Memastikan library JavaFX sudah terkonfigurasi dan terkoneksi dengan database PostgreSQL melalui ProductDAO.

2. Implementasi Service: Membuat ProductService sebagai jembatan antara Controller GUI dan DAO agar sesuai dengan prinsip SOLID (Dependency Inversion).

3. Mendesain UI: Menggunakan Layout Pane (seperti VBox atau GridPane) untuk menata TextField (Kode, Nama, Harga, Stok) dan Button.

4. Coding Event Handler: Menambahkan listener setOnAction pada tombol Tambah Produk untuk mengambil data dari inputan dan mengirimkannya ke ProductService.

5. Verifikasi Traceability: Mencocokkan nama method dan urutan panggilan objek dengan Sequence Diagram Bab 6.)

---

## Kode Program
(// Implementasi Event Handling pada AppJavaFX / ProductFormView
btnAdd.setOnAction(event -> {
    try {
        // 1. Ambil Data dari TextField
        Product p = new Product(
            txtCode.getText(),
            txtName.getText(),
            Double.parseDouble(txtPrice.getText()),
            Integer.parseInt(txtStock.getText())
        );

        // 2. Panggil Service (Sesuai Sequence Diagram Bab 6)
        productService.addProduct(p); 

        // 3. Update Tampilan (Event-Driven)
        listView.getItems().add(p.getCode() + " - " + p.getName() + " (Tersimpan)");
        
        // 4. Reset Form
        txtCode.clear(); txtName.clear();
    } catch (Exception e) {
        showError("Gagal menambah produk: " + e.getMessage());
    }
});
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/Screenshot 2026-01-15 175106.png)
)
---

## Analisis
(
- Analisis Event-Driven: Aplikasi tidak berjalan secara linear, melainkan menunggu interaksi pengguna pada tombol Tambah. Begitu diklik, sebuah event object dibuat dan ditangani oleh handler yang kita definisikan.

- Analisis Arsitektur: Dengan memisahkan View dari DAO melalui Service, kode menjadi lebih modular. Jika kita mengganti JavaFX dengan aplikasi Web, logika ProductService dan ProductDAO tetap bisa digunakan tanpa perubahan.

- Kesesuaian Bab 6: Implementasi method addProduct() di Controller telah mengikuti alur Sequence Diagram. Nama atribut di class Product juga konsisten dengan Class Diagram Bab 6.

- Kendala: Masalah konversi tipe data (String ke Double/Integer) yang bisa menyebabkan NumberFormatException. Solusi: Menambahkan validasi try-catch agar aplikasi tidak force close.  
)
---

## Kesimpulan
(GUI JavaFX berhasil dibangun dan diintegrasikan dengan database PostgreSQL. Dengan mengikuti tabel traceability, integritas antara desain sistem (Bab 6) dan implementasi (Bab 12) tetap terjaga, memastikan aplikasi Agri-POS berkembang sesuai kebutuhan fungsional yang telah direncanakan.)

---

## Quiz
(1. [Apa yang dimaksud dengan Event-Driven Programming dan bagaimana perbedaannya dengan pemrograman prosedural yang biasa dipelajari di awal?]  
   **Dalam pemrograman prosedural, alur program ditentukan oleh urutan baris kode yang ditulis oleh pemrogram (linear). Sedangkan dalam Event-Driven Programming, alur program ditentukan oleh tindakan pengguna (user actions) seperti klik tombol, gerakan mouse, atau input keyboard. Program berada dalam kondisi "menunggu" (listening) dan baru akan mengeksekusi blok kode tertentu (handler) ketika peristiwa (event) terjadi.** …  

2. [Apa peran dari Layout Pane (seperti VBox, HBox, atau GridPane) dalam JavaFX?]  
   **Layout Pane berfungsi sebagai kontainer yang mengatur posisi dan tata letak elemen-elemen UI (Nodes) secara otomatis. Tanpa Layout Pane, kita harus mengatur koordinat X dan Y setiap elemen secara manual, yang akan menyulitkan ketika jendela aplikasi diubah ukurannya (resize).** …  

3. [Mengapa di dalam Event Handler tombol "Tambah", kita sangat disarankan memanggil ProductService dan bukan langsung memanggil ProductDAO?]  
   **Hal ini dilakukan untuk mematuhi prinsip DIP (Dependency Inversion Principle) dan Separation of Concerns. ProductService berfungsi sebagai lapisan logika bisnis. Jika suatu saat ada aturan tambahan (misal: "produk tidak boleh ditambah jika stok di gudang penuh"), kita cukup mengubahnya di Service tanpa menyentuh kode UI atau DAO. Ini membuat kode lebih modular dan mudah diuji** …  )