// HelloOOP.java {// HelloOOP.java {
class Mahasiswa {
    String nama;
    int nim;

        public Mahasiswa(String nama, int nim) {
            this.nama = nama;
            this.nim = nim;
        }
    void sapa (){System.out.println("Hallo World, I am " + nama+ "," + nim);}
    
    }

    public class HelloOOP {

         public static void main(String[] args) {
            Mahasiswa m = new Mahasiswa ("Zaki Saputra", 240202847);
            m.sapa();
         }}