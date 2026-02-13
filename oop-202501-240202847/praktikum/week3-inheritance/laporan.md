# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Zaki Saputra]
- NIM   : [240202847]
- Kelas : [3IKRA]

---

## Tujuan
(
1. Mahasiswa memahami dan mampu mengimplementasikan konsep pewarisan (Inheritance) dalam pemrograman berorientasi objek.)

2. Mahasiswa mampu membedakan peran Superclass dan Subclass.

3. Mahasiswa mampu menggunakan kata kunci super untuk mengakses konstruktor maupun method pada induk class.

4. Mahasiswa mampu membangun hierarki class yang terstruktur pada studi kasus Agri-POS
---

## Dasar Teori
(
1. Inheritance: Mekanisme yang memungkinkan sebuah class (subclass) mewarisi atribut dan method dari class lain (superclass).

2. Reusability: Keuntungan utama inheritance adalah menghindari duplikasi kode dengan meletakkan atribut umum di superclass.

3. Keyword extends: Digunakan untuk mendeklarasikan bahwa sebuah class merupakan turunan dari class lain.

4. Keyword super: Digunakan untuk memanggil konstruktor atau method yang berada di dalam superclass.)

---

## Langkah Praktikum
(
1. Reuse Superclass: Menggunakan kembali class Produk.java sebagai induk dari semua kategori produk.

2. Pembuatan Subclass: Membuat tiga file baru yaitu Benih.java, Pupuk.java, dan AlatPertanian.java yang semuanya melakukan extends ke class Produk.

3. Penambahan Atribut Spesifik: Menambahkan atribut unik di setiap subclass, seperti varietas pada Benih, jenis pada Pupuk, dan material pada AlatPertanian.

4. Eksekusi Program: Membuat MainInheritance.java untuk melakukan instansiasi objek dari setiap subclass dan menampilkan datanya.

5. Version Control: Melakukan commit dengan pesan week3-inheritance dan melakukan push ke repositori GitHub.)

---

## Kode Program
(// Contoh penggunaan Inheritance di Benih.java
public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok); // Memanggil konstruktor Produk
        this.varietas = varietas;
    }
}

// Contoh Instansiasi di MainInheritance.java
Benih b = new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64");
System.out.println("Produk: " + b.getNama() + " | Varietas: " + b.getVarietas());
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil] (screenshots/Screenshots-2025-12-25.png)
)
---

## Analisis
(
- Cara Kerja Kode: Saat objek Benih dibuat, konstruktor Benih memanggil konstruktor Produk melalui super(). Hal ini memungkinkan atribut umum (kode, nama, harga) terisi sekaligus atribut spesifik (varietas) diatur di dalam subclass tersebut.

- Perbedaan Pendekatan: Minggu lalu kita membuat objek langsung dari class tunggal. Minggu ini, kita menggunakan hierarki. Jika ada atribut baru yang berlaku untuk semua produk (misal: diskon), kita cukup menambahkannya di class Produk saja, tidak perlu di setiap file.

- Kendala: Memahami urutan pemanggilan super() yang harus diletakkan di baris pertama dalam konstruktor. Kendala ini diatasi dengan mengikuti aturan sintaks Java yang mewajibkan konstruktor induk dipanggil sebelum inisialisasi atribut anak.  
)
---

## Kesimpulan
(Dengan menerapkan Inheritance, struktur kode program Agri-POS menjadi jauh lebih efisien dan reusable. Kita tidak perlu menulis ulang atribut yang sama pada setiap jenis produk, cukup mewarisinya dari class induk Produk.)

---

## Quiz
(1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?   
   **Jawaban: Dengan inheritance, kode menjadi lebih efisien karena atribut dan method umum cukup ditulis sekali di superclass. Hal ini mengurangi duplikasi kode, memudahkan pemeliharaan, serta membuat hubungan antar class lebih jelas secara hierarkis.** …  

2. Bagaimana cara subclass memanggil konstruktor superclass?    
   **Jawaban:Subclass dapat memanggil konstruktor superclass menggunakan keyword super(...) di baris pertama konstruktor subclass, dengan menyertakan argumen yang sesuai dengan konstruktor superclass.** …  

3.Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass. 
   **Jawaban: Contoh lainnya adalah Pestisida yang memiliki atribut tambahan seperti bahanAktif, atau BibitTernak dengan atribut spesies dan umur. Keduanya bisa menjadi subclass dari Produk dengan menyesuaikan method getKeterangan().** …  )
