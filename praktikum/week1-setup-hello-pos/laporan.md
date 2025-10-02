# Laporan Praktikum Minggu 1 
Topik: [Class dan Object]

## Identitas
- Nama  : [Zaki Saputra]
- NIM   : [240202847]
- Kelas : [3 IKRA]

---

## Tujuan
 *Mahasiswa memahami perbedaan paradigma pemrograman* 

---

## Dasar Teori
1. Class adalah blueprint dari objek.  
2. Object adalah instansiasi dari class.  
3. Enkapsulasi digunakan untuk menyembunyikan data.

---

## Langkah Praktikum
1. Persiapan
   a.Install JDK (cek dengan java -version).
   b.Buka folder project di VS Code.
2. Buat Program
   a. HelloWorldProcedural.java → versi prosedural.
   b. HelloWorldOOP.java → versi OOP.
   c. HelloWorldFunctional.java → versi fungsional (lambda).
3. Kompilasi & Jalankan
   a. Buat file baru di VS Code → simpan sebagai HelloWorldFunctional.java.
   b. Isi dengan kode:
   
    ```java
    public class HelloWorldFunctional {
    public static void main(String[] args) {
        Runnable pesan = () -> System.out.println("Hello World, I am Zaki Saputra-240202847");
        pesan.run();
    }
}
  c. Klik kanan → Run Java atau tekan tombol hijau ▶ Run di atas.
  d. Lihat output di terminal VS Code:
  
     Hello World, I am Zaki Saputra-240202847

 4. Analisis
    a. Catat kelebihan & kekurangan tiap paradigma.
    b. Simpan output sebagai bukti.
---

## Kode Program


```java

public class HelloWorldProcedural {
    public static void main(String[] args) {
        tampilkanPesan();
    }

    static void tampilkanPesan() {
        System.out.println("Hello World, I am Zaki Saputra-240202847");
    }
}



```java

  class HelloWorldOOP {
    private String nama;
    private String nim;

    public HelloWorldOOP(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public void tampilkanPesan() {
        System.out.println("Hello World, I am " + nama + "-" + nim);
    }

    public static void main(String[] args) {
        HelloWorldOOP hello = new HelloWorldOOP("Zaki Saputra", "240202847");
        hello.tampilkanPesan();
    }
}




```java

    import java.util.function.Supplier;

public class HelloWorldFunctional {
    public static void main(String[] args) {
        Supplier<String> pesan = () -> "Hello World, I am Zaki Saputra-240202847";
        System.out.println(pesan.get());
    }
}


---

## Hasil Eksekusi
Screenshot 2025-10-01 120147.png
Screenshot 2025-10-01 120344.png
Screenshot 2025-10-01 123337.png
---

## Analisis

Dari perbandingan ketiga paradigma pemrograman (Prosedural, OOP, dan Fungsional) dapat disimpulkan bahwa masing-masing memiliki kelebihan dan kekurangan sesuai kebutuhan aplikasi.

  a. Prosedural cocok untuk program sederhana, tetapi jika skala program membesar, maintainability dan scalability menjadi sulit.
  b. OOP lebih unggul untuk sistem besar dan kompleks karena konsep objek, enkapsulasi, dan modularitas membuat aplikasi lebih mudah         dipelihara dan dikembangkan. Oleh karena itu, OOP lebih sesuai untuk aplikasi seperti POS (Point of Sale).
  c. Fungsional menawarkan kode yang ringkas, minim efek samping, serta mendukung paralelisme, sehingga cocok untuk pemrosesan data          besar dan dapat mengurangi boilerplate code dengan memanfaatkan fungsi murni, lambda, dan higher-order function.
Dengan demikian, pemilihan paradigma harus menyesuaikan kebutuhan: untuk aplikasi kecil bisa menggunakan prosedural, untuk aplikasi kompleks lebih tepat OOP, dan untuk pemrosesan data intensif lebih cocok fungsional.

---

## Kesimpulan
Kelebihan & Kekurangan
1. Paradigma Prosedural
   Kelebihan : Sederhana, mudah dipahami, cocok untuk program kecil.
   Kekurangan : Sulit dikelola jika program besar, karena semua fungsi bercampur.
2. Paradigma OOP
   Kelebihan : Struktur lebih rapi, reusable, mudah dikembangkan untuk aplikasi besar.
   Kekurangan : Lebih kompleks, butuh lebih banyak kode awal.
3.  Paradigma Fungsional
    Kelebihan : Mengurangi kode berulang (boilerplate), lebih ringkas, mudah untuk operasi data paralel.
     Kekurangan : Kurang intuitif bagi pemula, tidak semua masalah cocok diselesaikan dengan pendekatan fungsional.

---

## Quiz
1. Apakah OOP selalu lebih baik dari prosedural?
   Jawaban: Tidak selalu, OOP lebih baik untuk aplikasi kompleks, sedangkan prosedural cocok untuk program sederhana.
2. Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural?
   Jawaban: Saat membutuhkan pemrosesan data yang paralel, ringkas, dan minim efek samping (misalnya data processing, AI, big data).
3. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi?
➝ Jawaban: Prosedural: sulit dimaintain bila besar.
➝ OOP: lebih mudah di-maintain & scalable.
➝ Fungsional: kode ringkas, lebih mudah diuji & di-scale untuk data besar.
4. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?
   Jawaban: Karena OOP bisa memodelkan objek nyata (produk, transaksi, user) sehingga lebih terstruktur, modular, dan mudah dikembangkan.
5. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)?
   Jawaban: Dengan fungsi murni, lambda, dan higher-order function sehingga kode lebih singkat, reusable, dan tidak perlu banyak template berulang.

