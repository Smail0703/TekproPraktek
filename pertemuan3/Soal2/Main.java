package Soal2;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n--- Test Shape ---");
        Shape s1 = new Shape("blue", false);
        System.out.println(s1); 

        System.out.println("\n--- Test Circle ---");
        Circle c1 = new Circle(7.0, "green", true);
        System.out.println(c1);
        System.out.println("Luas Lingkaran     : " + c1.getArea());
        System.out.println("Keliling Lingkaran : " + c1.getPerimeter());

        System.out.println("\n--- Test Rectangle ---");
        Rectangle r1 = new Rectangle(5.0, 10.0, "yellow", false);
        System.out.println(r1);
        System.out.println("Luas Persegi Panjang     : " + r1.getArea());
        System.out.println("Keliling Persegi Panjang : " + r1.getPerimeter());

        System.out.println("\n--- Test Square ---");
        Square sq1 = new Square(4.0, "purple", true);
        System.out.println("Kondisi Awal: " + sq1);
        System.out.println("Luas Persegi: " + sq1.getArea());
        System.out.println("\nMengubah lebar (width) menjadi 8.0...");
        sq1.setWidth(8.0); 
        
        System.out.println("Kondisi Akhir: " + sq1); 
        System.out.println("Luas Baru    : " + sq1.getArea());
        
    }
}