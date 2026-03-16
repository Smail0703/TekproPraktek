import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// --- 2. RECORD ---
// Dideklarasikan di luar class utama (sebagai package-private) agar rapi
record Mahasiswa(String nim, String nama, double ipk) {
    public Mahasiswa {
        if (ipk < 0.0 || ipk > 4.0) {
            throw new IllegalArgumentException("IPK tidak valid!");
        }
    }
}

public class EksplorasiStrukturData {

    public static void main(String[] args) {
        System.out.println("Memulai eksekusi seluruh kasus...\n");
        ListSetMap();
        Record();
        Optional();
        Concurrent();
        QueueDeque();
        Immutable();
        Vector();
        
        System.out.println("\nEksekusi selesai!");
    }

    // --- 1. LIST, SET, MAP ---
    private static void ListSetMap() {
        System.out.println("=== 1.  List, Set, dan Map ===");
        
        List<String> listPengunjung = new ArrayList<>();
        listPengunjung.add("Budi");
        listPengunjung.add("Siti");
        listPengunjung.add("Budi"); // List mengizinkan duplikat

        Set<String> setKategori = new HashSet<>();
        setKategori.add("Elektronik");
        setKategori.add("Pakaian");
        setKategori.add("Elektronik"); // Set akan menolak duplikat ini

        Map<String, Integer> mapStok = new HashMap<>();
        mapStok.put("Laptop", 10);
        mapStok.put("Kemeja", 50);

        System.out.println("List (Bisa duplikat, urut): " + listPengunjung);
        System.out.println("Set (Unik, tidak berurutan): " + setKategori);
        System.out.println("Map (Key-Value): Stok Laptop ada " + mapStok.get("Laptop"));
        System.out.println("--------------------------------------------------");
    }

    // --- 2. RECORD ---
    private static void Record() {
        System.out.println("=== 2.  Record ===");
        Mahasiswa mhs = new Mahasiswa("10101", "Andi", 3.8);
        System.out.println("Data Record: " + mhs.toString());
        System.out.println("Akses Nama: " + mhs.nama()); // Tanpa getNama()
        System.out.println("--------------------------------------------------");
    }

    // --- 3. OPTIONAL ---
    private static void Optional() {
        System.out.println("=== 3.  Optional ===");
        
        Optional<String> dataDitemukan = cariData("admin");
        dataDitemukan.ifPresent(data -> System.out.println("Hasil: " + data));

        Optional<String> dataKosong = cariData("guest");
        String hasilFallback = dataKosong.orElse("Data Default (Karena tidak ditemukan)");
        System.out.println("Hasil: " + hasilFallback);
        System.out.println("--------------------------------------------------");
    }
    private static Optional<String> cariData(String keyword) {
        if ("admin".equals(keyword)) return Optional.of("Rahasia_Admin_123");
        return Optional.empty();
    }

    // --- 4. CONCURRENT COLLECTIONS ---
    private static void Concurrent() {
        System.out.println("=== 4.  Concurrent Collections ===");
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("Counter", 0);

        Runnable tugas = () -> {
            for (int i = 0; i < 100; i++) {
                // Thread-safe update
                concurrentMap.compute("Counter", (k, v) -> v + 1);
            }
        };

        Thread t1 = new Thread(tugas);
        Thread t2 = new Thread(tugas);

        t1.start(); t2.start();

        try {
            t1.join(); t2.join();
            System.out.println("Hasil perhitungan 2 Thread bersamaan: " + concurrentMap.get("Counter") + " (Pasti 200)");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------");
    }

    // --- 5. QUEUE & DEQUEUE ---
    private static void QueueDeque() {
        System.out.println("=== 5.  Queue dan Dequeue ===");
        
        Queue<String> antrean = new LinkedList<>();
        antrean.offer("Orang Pertama");
        antrean.offer("Orang Kedua");
        System.out.println("Queue (FIFO) dipanggil: " + antrean.poll());

        Deque<String> riwayat = new ArrayDeque<>();
        riwayat.push("Halaman_A");
        riwayat.push("Halaman_B"); // Paling atas/baru
        System.out.println("Deque (Bisa LIFO) di-pop: " + riwayat.pop()); // Keluar Halaman_B
        System.out.println("--------------------------------------------------");
    }

    // --- 6. IMMUTABLE COLLECTION ---
    private static void Immutable() {
        System.out.println("=== 6.  Immutable Collection ===");
        List<String> listPaten = List.of("Merah", "Kuning", "Hijau");
        System.out.println("List Immutable: " + listPaten);
        
        System.out.print("Mencoba mengubah List Immutable... ");
        try {
            listPaten.add("Biru"); // Ini akan error!
        } catch (UnsupportedOperationException e) {
            System.out.println("Gagal! (Terjadi UnsupportedOperationException karena list tidak bisa diubah)");
        }
        System.out.println("--------------------------------------------------");
    }

    // --- 7. VECTOR ---
    private static void Vector() {
        System.out.println("=== 7.  Vector ===");
        Vector<String> vectorLama = new Vector<>();
        vectorLama.add("Data 1");
        vectorLama.add("Data 2");
        
        System.out.println("Isi Vector: " + vectorLama);
        System.out.println("Kapasitas Vector (Otomatis menyesuaikan): " + vectorLama.capacity());
        System.out.println("Catatan: Vector jarang digunakan di kode modern, diganti oleh ArrayList.");
        System.out.println("--------------------------------------------------");
    }
}