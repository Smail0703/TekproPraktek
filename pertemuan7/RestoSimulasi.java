import java.util.concurrent.locks.ReentrantLock;

class Resto {
    private int chickenStock = 100;
    private final ReentrantLock lock = new ReentrantLock();

    public void serverCustomer(String cashierName) {
        lock.lock(); 
        try {
            if (chickenStock > 0) {
                try { Thread.sleep(10); } catch (InterruptedException e) { }

                chickenStock--;
                System.out.println(cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);
            } else {
                System.out.println(cashierName + " gagal: Stock Habis");
            }
        } finally {
            lock.unlock();
        }
    }

    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {
        Resto ayamJuicyLuicygallagher = new Resto();

        Runnable task = () -> {
            for (int i = 0; i < 40; i++) {
                ayamJuicyLuicygallagher.serverCustomer(Thread.currentThread().getName());
                if (ayamJuicyLuicygallagher.getRemainingStock() <= 0) {
                    break;
                }
            }
        };

        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        kasir1.start();
        kasir2.start();
        kasir3.start();

        kasir1.join();
        kasir2.join();
        kasir3.join();

        System.out.println("--- Hasil Akhir Stock ---\n" + ayamJuicyLuicygallagher.getRemainingStock());
    }
}