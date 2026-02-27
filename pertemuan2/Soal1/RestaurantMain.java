package pertemuan2;

import java.util.Scanner;

public class RestaurantMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurant menu = new Restaurant();
        int pilihan,stok;

        System.out.println("=== Selamat Datang di Sistem Restoran ===");

        do {
            System.out.println("\nSilakan Pilih Aksi:");
            System.out.println("1. Tambah Menu Makanan");
            System.out.println("2. Tampilkan Menu Makanan");
            System.out.println("3. Pesan Makanan");
            System.out.println("4. Keluar");
            System.out.print("Pilihan (1-4): ");
            
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n-- Tambah Menu Baru --");
                    System.out.print("Masukkan nama makanan: ");
                    String nama = sc.nextLine();
                    
                    System.out.print("Masukkan harga (Rp): ");
                    double harga = sc.nextDouble();
                    
                    do{
                        System.out.print("Masukkan stok awal: ");
                        stok = sc.nextInt();
                        if (stok <= 0) {
                            System.out.println("stok tidak boleh kurang dari sama dengan 0");
                        }
                    }while(stok <= 0);
                    
                    menu.tambahMenuMakanan(nama, harga, stok);
                    System.out.println("Info: Proses penambahan menu selesai.");
                    break;
                    
                case 2:
                    System.out.println("\n=== Daftar Menu Saat Ini ===");
                    menu.tampilMenuMakanan();
                    break;
                    
                case 3:
                    System.out.println("\n-- Form Pemesanan --");
                    System.out.print("Masukkan nama makanan yang ingin dipesan: ");
                    String pesanan = sc.nextLine();
                    
                    System.out.print("Masukkan jumlah porsi: ");
                    int jumlah = sc.nextInt();
                    
                    menu.pesanMenu(pesanan, jumlah);
                    break;
                    
                case 4:
                    System.out.println("\nGoodbye");
                    break;
                    
                default:
                    System.out.println("\nPilihan tidak valid! Silakan masukkan angka 1-4.");
            }
        } while (pilihan != 4);

        // Menutup sc untuk membebaskan memori
        sc.close();
    }
}