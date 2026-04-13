class Account {
    int balance = 150;
}

public class TransferFulus  {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        //Menjumlahkan Tranfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized(acc1){ //mengunci objek acc1 sehingga t1 memegang acc1
                System.out.println("Thread 1/t1 berhasil mengunci acc1");
                try{Thread.sleep(100);}catch(Exception e){}

                synchronized(acc2){//mengunci objek acc2 sehingga t1 memegang acc2
                    System.out.println("Thread 1/t1 berhasil mengunci acc2");
                    acc2.balance += acc1.balance;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized(acc1){//mengunci objek acc2 sehinnga t1 memegang acc2
                System.out.println("Thread 2/t2 berhasil mengunci acc2");
                acc1.balance += acc2.balance;
                try{Thread.sleep(100);
                }catch(Exception e){}

                synchronized(acc2){
                    System.out.println("Thread 2/t2 berhasil mengunci acc1");
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("---Hasil Akhir---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}