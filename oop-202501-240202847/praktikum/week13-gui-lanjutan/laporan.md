# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Zaki Saputra]
- NIM   : [240202847]
- Kelas : [3IKRA]

---

## Tujuan
(
1. Mahasiswa mampu mengimplementasikan komponen TableView JavaFX untuk menampilkan data dalam format tabel yang terstruktur.

2. Mahasiswa mampu mengintegrasikan koleksi objek (ObservableList) dengan antarmuka grafis.

3. Mahasiswa mampu menerapkan Lambda Expression untuk menyederhanakan penulisan Event Handling.

4. Mahasiswa mampu membangun aplikasi CRUD (Create, Read, Delete) yang terhubung penuh dari GUI hingga database PostgreSQL.

5. Mahasiswa mampu memastikan kepatuhan kode terhadap desain UML dan prinsip SOLID yang telah dirancang pada Bab 6.)

---

## Dasar Teori
(
1. TableView: Komponen JavaFX yang sangat kuat untuk menampilkan data dalam baris dan kolom. Menggunakan PropertyValueFactory untuk menghubungkan atribut Model dengan kolom tabel.

2. ObservableList: Koleksi khusus dari JavaFX yang memungkinkan UI untuk secara otomatis memperbarui tampilan ketika ada perubahan data (tambah/hapus) di dalam daftar tersebut.

3. Lambda Expression: Fitur Java yang memungkinkan kita menulis fungsionalitas sebagai argumen metode. Dalam JavaFX, digunakan untuk menyingkat penulisan EventHandler.

4. Traceability & DIP: Menjamin bahwa setiap baris kode di UI memiliki landasan pada dokumen desain (Bab 6) dan tetap mematuhi Dependency Inversion Principle (UI bergantung pada Service, bukan langsung pada Database).)

---

## Langkah Praktikum
(
1. Refactoring week12: Mengubah tampilan dari ListView atau TextArea menjadi TableView<Product>.

2. Konfigurasi Kolom: Menentukan kolom untuk Kode, Nama, Harga, dan Stok menggunakan TableColumn dan cellValueFactory.

3. Penerapan Lambda: Mengganti semua Anonymous Inner Class pada tombol Tambah dan Hapus dengan Lambda Expression.

4. Implementasi Fitur Hapus: Menambahkan logika pengambilan item terpilih (getSelectedItem()) dan meneruskan kodenya ke ProductService.delete().

5. Sinkronisasi Data: Membuat metode loadData() yang dipanggil saat aplikasi pertama kali berjalan dan setiap kali terjadi perubahan data (setelah tambah/hapus).

6. Final Testing: Memastikan data yang dihapus di tabel juga hilang dari database PostgreSQL secara permanen.)

---

## Kode Program
(// Inisialisasi Kolom TableView
TableColumn<Product, String> colCode = new TableColumn<>("Kode");
colCode.setCellValueFactory(new PropertyValueFactory<>("code"));

// Event Handler Hapus dengan Lambda Expression
btnDelete.setOnAction(e -> {
    Product selected = table.getSelectionModel().getSelectedItem();
    if (selected != null) {
        // Panggil Service sesuai prinsip DIP
        productService.deleteProduct(selected.getCode());
        
        // Reload data untuk menyegarkan tampilan
        loadData(); 
        System.out.println("Produk berhasil dihapus!");
    } else {
        showAlert("Peringatan", "Pilih produk yang ingin dihapus terlebih dahulu!");
    }
});

// Method Load Data dari Database
private void loadData() {
    ObservableList<Product> data = FXCollections.observableArrayList(productService.getAllProducts());
    table.setItems(data);
}
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/Screenshot 2026-01-16 175944.png)
)
---

## Analisis
(
- Analisis TableView: Komponen ini jauh lebih efisien dibanding ListView karena memberikan visualisasi data yang sesuai dengan struktur tabel di database. Penggunaan ObservableList sangat krusial agar UI selalu up-to-date.

- Analisis Lambda: Kode menjadi jauh lebih ringkas. Penulisan btn.setOnAction(e -> { ... }) menghilangkan boilerplate code yang biasanya ada pada Java versi lama.

- Integritas Sistem: Aplikasi sekarang sudah bersifat Full-Stack sederhana. Setiap aksi di GUI (View) diproses oleh Controller, divalidasi oleh Service, dan dieksekusi oleh DAO ke database.

- Kepatuhan Bab 6: Semua penamaan metode (findAll, delete, insert) tetap konsisten dengan diagram yang dibuat di Bab 6, sehingga mempermudah proses audit dan pemeliharaan kode.  
)
---

## Kesimpulan
(Praktikum Minggu 13 berhasil menyatukan seluruh komponen yang telah dipelajari selama satu semester. Dengan penggunaan TableView, aplikasi Agri-POS kini memiliki antarmuka yang profesional. Penerapan Design Pattern dan prinsip traceability memastikan aplikasi ini kokoh dan siap dikembangkan lebih lanjut menjadi sistem manajemen toko yang lengkap.)

---

## Quiz
(1. [Apa keuntungan menggunakan ObservableList dibandingkan ArrayList biasa pada JavaFX?]  
   **ObservableList memiliki kemampuan untuk memberitahu UI secara otomatis jika ada perubahan data (seperti penambahan atau penghapusan elemen). Hal ini memungkinkan TableView untuk melakukan auto-refresh tampilan tanpa harus memanggil ulang fungsi render secara manual.** …  

2. [Jelaskan peran PropertyValueFactory dalam konfigurasi TableColumn!]  
   **PropertyValueFactory berfungsi untuk memetakan kolom tabel ke atribut yang ada pada class Model (Product). Ia secara otomatis akan memanggil metode getter (misal: getCode()) dari objek Model untuk ditampilkan isinya di kolom tersebut.** …  

3. [Mengapa penghapusan data di TableView juga harus diikuti dengan penghapusan di Database melalui DAO?]  
   **Karena TableView hanyalah representasi sementara di memori aplikasi (View). Jika kita hanya menghapus di tabel saja, maka saat aplikasi dijalankan ulang, data tersebut akan muncul kembali karena masih ada di database (Persistence).** …  )