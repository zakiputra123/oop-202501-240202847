# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Zaki Saputra]
- NIM   : [240202847]
- Kelas : [3IKRA]

---

## Tujuan
(
1. Mahasiswa memahami konsep Polymorphism (banyak bentuk) dalam pemrograman berorientasi objek.

2. Mahasiswa mampu membedakan dan mengimplementasikan Method Overloading dan Method Overriding.

3. Mahasiswa mampu menerapkan Dynamic Binding menggunakan array dari superclass untuk memanggil method subclass pada saat runtime.

4. Mahasiswa mampu menganalisis penerapan polimorfisme pada sistem manajemen stok Agri-POS.)

---

## Dasar Teori
(
1. Polymorphism: Kemampuan suatu objek untuk memiliki berbagai bentuk. Dalam Java, ini memungkinkan variabel tipe induk merujuk pada objek tipe anak.

2. Overloading: Mendefinisikan beberapa method dengan nama yang sama di dalam satu class, tetapi memiliki parameter yang berbeda (jumlah atau tipe data).

3. Overriding: Subclass menulis ulang method yang sudah ada di superclass untuk memberikan implementasi yang lebih spesifik.

4. Dynamic Binding: Proses di mana Java menentukan method mana yang akan dijalankan berdasarkan tipe objek aktual saat program berjalan, bukan berdasarkan tipe variabelnya.)

---

## Langkah Praktikum
(
1. Modifikasi Superclass: Menambahkan fitur overloading pada method tambahStok() di class Produk agar bisa menerima input int maupun double.

2. Implementasi Overriding: Menambahkan method getInfo() pada class Produk, kemudian meng-override method tersebut di class Benih, Pupuk, dan AlatPertanian.

3. Penerapan Dynamic Binding: Membuat array Produk[] di MainPolymorphism.java dan mengisinya dengan berbagai objek subclass.

4. Iterasi Objek: Menggunakan loop untuk memanggil getInfo() dari setiap elemen array.

5. Version Control: Melakukan commit dengan pesan week4-polymorphism dan mengunggahnya ke GitHub.)

---

## Kode Program
(// Contoh Overloading di Produk.java
public void tambahStok(int jumlah) { this.stok += jumlah; }
public void tambahStok(double jumlah) { this.stok += (int) jumlah; }

// Contoh Overriding di Benih.java
@Override
public String getInfo() {
    return "Benih: " + super.getInfo() + ", Varietas: " + varietas;
}

// Contoh Dynamic Binding di MainPolymorphism.java
Produk[] daftarProduk = {
    new Benih("BNH-01", "Padi", 25000, 10, "Unggul"),
    new Pupuk("PPK-01", "Urea", 50000, 5, "Kimia")
};

for (Produk p : daftarProduk) {
    System.out.println(p.getInfo()); // Memanggil method sesuai objek asli
}
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/Screenshot-2025-12-25.png)
)
---

## Analisis
(
- Analisis Program: Program menggunakan array tipe Produk untuk menyimpan berbagai macam objek (Benih, Pupuk, dll). Meskipun variabelnya bertipe Produk, Java cukup cerdas untuk menjalankan getInfo() milik subclass masing-masing. Inilah yang disebut Dynamic Binding.

- Efisiensi Overloading: Dengan overloading pada tambahStok, sistem menjadi lebih fleksibel karena bisa menerima input angka bulat maupun desimal tanpa perlu membuat nama method yang berbeda.

- Kendala: Kesalahan umum biasanya lupa menambahkan anotasi @Override atau salah menuliskan tanda tangan method (signature). Kendala ini diatasi dengan memastikan nama dan parameter method di subclass sama persis dengan yang ada di superclass.  
)
---

## Kesimpulan
(Polimorfisme membuat kode program menjadi sangat fleksibel dan mudah dikembangkan. Kita bisa mengelola berbagai macam produk pertanian yang berbeda dalam satu wadah (array) dan memprosesnya dengan perintah yang sama, namun tetap mendapatkan hasil yang spesifik sesuai jenis produknya.)

---

## Quiz
(1. [Apa perbedaan overloading dan overriding?]  
   **Overloading terjadi dalam satu class yang sama dengan nama method sama tapi parameter berbeda (compile-time). Overriding terjadi pada hubungan pewarisan di mana subclass mengganti isi method superclass dengan parameter yang identik (runtime).** …  

2. [Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?]  
   **Java melihat tipe objek aktual yang dibuat di memori (menggunakan kata kunci new), bukan melihat tipe variabel referensinya.** …  

3. [Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian.]  
   **Sistem pembayaran. Superclass Pembayaran memiliki method prosesBayar(). Subclass-nya seperti Cash, KartuKredit, dan EWallet akan meng-override method tersebut dengan cara verifikasi yang berbeda-beda.** …  )