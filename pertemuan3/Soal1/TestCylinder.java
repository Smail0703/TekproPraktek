import java.util.Scanner;

public class TestCylinder { // Save as "TestCylinder.java"
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double InputRadius;
        double InputHeight;
        char konfirmasi;
        do{
            System.out.print("\nInput Radius: ");
            InputRadius = sc.nextDouble();
            System.out.print("Input Height: ");
            InputHeight = sc.nextDouble();

            // Declare and allocate a new instance of cylinder
            // with default color, radius, and height
            Cylinder c1 = new Cylinder(InputRadius,InputHeight); 
            System.out.println("\nCylinder:" + " radius=" + c1.getRadius() + " height=" + c1.getHeight() + " base area=" + c1.getArea() + " volume=" + c1.getVolume());
            System.out.println("Mau nyoba lagi?");
            konfirmasi = sc.next().charAt(0);
        }while(konfirmasi == 'Y' || konfirmasi == 'y');
        
        System.out.println("program selesai");
        sc.close();
    }
}