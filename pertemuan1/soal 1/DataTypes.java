import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan Jumlah angka yang ingin di Test: ");
        int TestCase = scan.nextInt();

        for(int i = 1; i <= TestCase;i++){
            try{
                long nilai = scan.nextLong();
                System.out.println(nilai + " can be fit in:");
                if(nilai >= Byte.MIN_VALUE && nilai <= Byte.MAX_VALUE){
                    System.out.println("* byte");
                }
                if(nilai <= Short.MAX_VALUE && nilai >= Short.MIN_VALUE){
                    System.out.println("* short");
                }
                if(nilai <= Integer.MAX_VALUE && nilai >= Integer.MIN_VALUE){
                    System.out.println("* int");
                }
                if(nilai <= Long.MAX_VALUE && nilai >= Long.MIN_VALUE){
                    System.out.println("* long");
                }
                }catch(Exception e){
                System.out.println(scan.next() + " can't be fitted anywhere.");
            }
        }
        scan.close();
    }
}