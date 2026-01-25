# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Zaki Saputra]
- NIM   : [240202847]
- Kelas : [3IKRA]


---

## Tujuan
(
1. Mahasiswa mampu membedakan antara Error (fatal) dan Exception (dapat ditangani).

2. Mahasiswa mampu mengimplementasikan struktur kontrol try-catch-finally untuk menjaga stabilitas program.

3. Mahasiswa mampu membuat Custom Exception untuk menangani logika bisnis yang spesifik pada sistem Agri-POS.

4. Mahasiswa memahami dasar penerapan Design Pattern (Singleton) dan arsitektur MVC sederhana.)

---

## Dasar Teori
(
1. Exception Handling: Mekanisme untuk menangani kejadian tidak normal saat runtime agar program tidak berhenti secara mendadak (crash).

2. Try-Catch-Finally:

- try: Blok kode yang diawasi.

- catch: Blok penanganan jika terjadi kesalahan.

3. finally: Blok yang akan selalu dijalankan (misal untuk menutup koneksi atau membersihkan memori).

4. Custom Exception: Class pengecualian buatan sendiri yang mewarisi class Exception, digunakan untuk memvalidasi aturan bisnis (seperti stok habis atau kuantitas negatif).

5. Singleton Pattern: Pola desain yang memastikan sebuah class hanya memiliki satu instansi di seluruh aplikasi.)

---

## Langkah Praktikum
(
1. Membuat Custom Exceptions: Membuat tiga class exception baru: InvalidQuantityException, ProductNotFoundException, dan InsufficientStockException.

2. Modifikasi Model Product: Menambahkan atribut stock dan method reduceStock() untuk mensimulasikan inventaris nyata.

3. Penerapan Logika Validasi: Pada class ShoppingCart, setiap method kini dilengkapi dengan kata kunci throws. Jika validasi gagal (misal qty < 0), program akan melakukan throw new CustomException.

4. Penanganan pada Main Program: Menggunakan blok try-catch di MainExceptionDemo.java untuk menangkap pesan kesalahan dan menampilkannya dengan rapi kepada pengguna tanpa mematikan program.

5. Implementasi Singleton (Opsional): Membuat ProductService untuk mensimulasikan pengelolaan produk terpusat.)

---

## Kode Program
(// Contoh Custom Exception
public class InsufficientStockException extends Exception {
    public InsufficientStockException(String msg) { super(msg); }
}

// Implementasi pada ShoppingCart
public void checkout() throws InsufficientStockException {
    for (Map.Entry<Product, Integer> entry : items.entrySet()) {
        if (entry.getKey().getStock() < entry.getValue()) {
            throw new InsufficientStockException("Stok tidak cukup!");
        }
    }
}

// Penanganan di Main
try {
    cart.checkout();
} catch (InsufficientStockException e) {
    System.out.println("Gagal Checkout: " + e.getMessage());
}
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/praktikum/week9-exception-handling/Screenshot 2025 12  26 .png)
)
---

## Analisis
(
- Analisis Validasi: Dengan Exception Handling, program menjadi lebih "cerdas". Program tidak akan memproses transaksi jika jumlah barang yang dibeli lebih besar dari stok yang tersedia.

- Analisis Finally: Penggunaan finally (jika diterapkan) menjamin bahwa log transaksi atau pembersihan data tetap terjadi meskipun terjadi eror di tengah proses.

- Design Pattern: Penerapan Singleton pada ProductService sangat membantu dalam memastikan data produk konsisten di berbagai bagian aplikasi (tidak ada duplikasi database di memori).

- Kendala: Sering kali lupa menambahkan deklarasi throws pada tanda tangan method. Hal ini menyebabkan eror kompilasi karena Java mewajibkan Checked Exception untuk dideklarasikan.  
)
---

## Kesimpulan
(Exception Handling bukan hanya tentang menangkap eror, tapi tentang membuat aplikasi yang tangguh (robust). Dengan Custom Exception, pengembang dapat memberikan pesan eror yang manusiawi dan relevan dengan bisnis Agri-POS, sehingga pengguna tahu persis mengapa sebuah aksi (seperti checkout) gagal dilakukan.)

---

## Quiz
(1. [Jelaskan perbedaan error dan exception?]  
   **Error adalah masalah serius yang biasanya berkaitan dengan lingkungan sistem (seperti kehabisan memori) dan tidak disarankan untuk ditangkap. Exception adalah kondisi abnormal yang disebabkan oleh logika program (seperti pembagian nol atau input salah) dan dapat ditangani agar program tetap berjalan.** …  

2. [Apa fungsi finally dalam blok try–catch–finally?]  
   **Untuk menjalankan kode penting yang harus tetap dieksekusi terlepas dari apakah pengecualian terjadi atau tidak.** …  

3. [Mengapa custom exception diperlukan?]  
   **Agar pesan kesalahan lebih spesifik dan sesuai dengan konteks aplikasi. Daripada menggunakan Exception umum, InsufficientStockException jauh lebih jelas memberikan informasi kepada pengembang dan pengguna.** …  )
