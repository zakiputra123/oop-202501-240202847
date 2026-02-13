# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Zaki Saputra]
- NIM   : [240202847]
- Kelas : [3IKRA]

---

## Tujuan
(
1. Mahasiswa memahami konsep Java Collections Framework (List, Map, dan Set).

2. Mahasiswa mampu mengimplementasikan ArrayList untuk mengelola data objek secara dinamis.

3. Mahasiswa mampu menggunakan HashMap untuk menangani data dengan pasangan Key-Value (seperti produk dan kuantitas).

4. Mahasiswa mampu melakukan operasi CRUD sederhana (Create, Read, Delete) serta kalkulasi pada koleksi data.)

---

## Dasar Teori
(
1. Java Collections Framework: Sekumpulan antarmuka dan kelas yang digunakan untuk menyimpan dan memanipulasi grup objek.

2. List (ArrayList): Koleksi terurut yang mengizinkan duplikasi elemen. Sangat efektif untuk pencarian data berdasarkan indeks.

3. Map (HashMap): Koleksi yang memetakan kunci (key) ke nilai (value). Tidak boleh ada kunci duplikat, dan sangat cepat dalam pencarian berdasarkan kunci.

4. Set (HashSet): Koleksi yang menjamin tidak ada elemen duplikat di dalamnya.)

---

## Langkah Praktikum
(
1. Membuat Model Data: Membuat class Product dengan atribut kode, nama, dan harga sebagai entitas dasar.

2. Implementasi List: Membuat class ShoppingCart menggunakan ArrayList<Product> untuk menyimpan item belanja secara linear.

3. Implementasi Map: Membuat class ShoppingCartMap menggunakan HashMap<Product, Integer> untuk mendukung fitur kuantitas (quantity).

4. Logika Bisnis: Membuat method untuk menambah produk, menghapus produk, menghitung total harga, dan mencetak isi keranjang ke konsol.

5. Main Program: Menjalankan MainCart.java untuk menguji fungsionalitas keranjang belanja.

6. Version Control: Melakukan commit dengan pesan format week7-collections: [fitur] [deskripsi].)

---

## Kode Program
(// Contoh Logika Tambah Produk pada Map (Dengan Quantity)
public void addProduct(Product p) { 
    items.put(p, items.getOrDefault(p, 0) + 1); 
}

// Contoh Kalkulasi Total pada ArrayList
public double getTotal() {
    double sum = 0;
    for (Product p : items) {
        sum += p.getPrice();
    }
    return sum;
}
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
Screenshot 2025 12 26.png
Screenshots 2025 12 26 .png
)
---

## Analisis
(
- Analisis Struktur: Penggunaan ArrayList mempermudah penambahan item tanpa perlu menentukan ukuran array di awal. Namun, jika ada produk yang sama dibeli berkali-kali, ArrayList akan menyimpannya sebagai baris baru.

- Efisiensi Map: Dengan HashMap, produk yang sama tidak akan muncul berulang kali di baris yang berbeda, melainkan hanya memperbarui nilai quantity-nya saja. Hal ini jauh lebih efisien untuk sistem kasir (POS) yang menangani banyak barang.

- Kendala: Saat menggunakan Product sebagai kunci di HashMap, penting untuk memperhatikan apakah objek tersebut dianggap sama atau berbeda oleh Java. Kendala ini diatasi dengan memastikan referensi objek yang digunakan tetap konsisten.  
)
---

## Kesimpulan
(Koleksi data (Collections) sangat krusial dalam pengembangan aplikasi seperti Agri-POS. ArrayList cocok untuk daftar item yang sederhana, sedangkan HashMap sangat ideal untuk menangani keranjang belanja yang memerlukan perhitungan jumlah barang per jenis produk secara otomatis.)

---

## Quiz
(1. [Jelaskan perbedaan mendasar antara List, Map, dan Set?]  
    **Jawaban:List bersifat terurut dan dapat menyimpan data duplikat, Map menyimpan data dalam bentuk pasangan key–value, sedangkan Set tidak mengizinkan data duplikat.** …  

2. [Mengapa ArrayList cocok digunakan untuk keranjang belanja sederhana?]  
   **Jawaban:Karena ArrayList bersifat dinamis, mudah digunakan, dan mendukung penyimpanan data duplikat.**

3. [Bagaimana struktur Set mencegah duplikasi data?]  
     **Jawaban:Set menggunakan mekanisme hashing atau perbandingan objek untuk menolak elemen yang sama.** …  )