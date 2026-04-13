import java.util.Scanner;

public class PenjumlahanParalel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. MENGAMBIL INPUT DARI USER
        System.out.println("Masukkan Jumlah Thread:");
        int InputThread = input.nextInt();
        System.out.println("Masukkan Angka Akhir yang ingin dijumlahkan:");
        int InputAngkaAkhir = input.nextInt();

        // 2. persiapan tempat
        // Array untuk menyimpan objek thread (pekerja)
        Thread[] pekerja = new Thread[InputThread];
        // Array untuk menyimpan hasil hitungan dari masing-masing thread
        // Dibuat di luar loop agar bisa dipakai bersama oleh semua thread
        long[] hasilParsial = new long[InputThread];
        
        // Menghitung berapa banyak angka yang harus diurus oleh satu thread
        int RangeThread = InputAngkaAkhir / InputThread;

        // 3. FASE DIVIDE & CONQUER (Membagi Tugas & Membuat Thread)
        for (int i = 0; i < InputThread; i++) {
            // Variabel 'final' digunakan agar nilainya dikunci dan aman 
            // saat dikirim ke dalam Lambda Expression (Thread)
            final int index = i; 
            final int start = (i * RangeThread) + 1;
            final int end;
            
            // Penanganan sisa pembagian: 
            // Jika ini adalah thread terakhir, dia harus mengambil sisa angka sampai InputAngkaAkhir
            if (i == InputThread - 1) {
                end = InputAngkaAkhir;
            } else {
                end = start + RangeThread - 1;
            }

            // Mendefinisikan tugas untuk thread menggunakan Lambda Expression
            pekerja[i] = new Thread(() -> {
                long jumlah = 0;
                // Thread melakukan proses penjumlahan pada rentang tugasnya
                for (int j = start; j <= end; j++) {
                    jumlah += j;
                }
                
                // Menyimpan hasil hitungan thread ini ke dalam indeks miliknya sendiri
                hasilParsial[index] = jumlah;
                
                // Mencetak laporan tugas dari thread ini
                System.out.println("Thread " + (index + 1) + ": Menjumlahkan " + start + " - " + end + " | Hasil Parsial: " + hasilParsial[index]);
            });
            
            // Menyalakan/memulai thread agar langsung bekerja
            pekerja[i].start();
        }

        // 4. Sinkronisasi
        for (int i = 0; i < InputThread; i++) {
            try {
                // Method join() memaksa program utama (Main Thread) 
                // untuk berhenti di sini dan menunggu thread pekerja[i] selesai
                pekerja[i].join(); 
            } catch (InterruptedException e) {
                System.out.println("Thread terganggu: " + e.getMessage());
            }
        }

        // 5. Menjumlahkan Hasil Parsial
        long totalakhir = 0;
        
        // Loop ini baru akan berjalan SETELAH semua thread selesai (berkat join() di atas)
        for (int i = 0; i < InputThread; i++) {
            totalakhir += hasilParsial[i];
        }
        
        System.out.println("==============================================");
        System.out.println("Total Akhir = " + totalakhir);

        input.close();
    }
}