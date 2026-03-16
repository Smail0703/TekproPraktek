public class GenericsMethods {

    // Java Generic Method
    public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) {//<T> sebelum tipe pengembalian memberitahu bahwa ini adalah metode generik T hanyalah simbol tipe data yang nanti akan diganti. parameternya juga memastikan g1 dan g2 tipe parameternya sama
        return g1.get().equals(g2.get()); //mebandingkan nilai dalam objek tersebut
    }

    public static void main(String args[]) {
        GenericsType<String> g1 = new GenericsType<>();
        g1.set("Java");

        GenericsType<String> g2 = new GenericsType<>();
        g2.set("Java"); //membuat dua buah objek yang dikhususkan untuk menyimpan String dengan nilai yang sama yaitu Java

        boolean isEqual;
        isEqual = GenericsMethods.<String>isEqual(g1, g2); //secara eksplisit menyisipkan tipe data string sebelum nama method 
        // above statement can be written simply as 
        isEqual = GenericsMethods.isEqual(g1, g2); //compiler otomatis mengetahui g1 dan g2 sebagai argumen dan akan tahu bahwa g1 dan g2 bertipe GenericsType<String> terus akan menyimpulkan datanya secara otomatis

        System.out.println("\n" + isEqual);
        /*
         * This feature, known as type inference, allows you to invoke
         * a generic method as an ordinary method, without specifying 
         * a type between angle brackets 
         */
        
        // Compiler will infer the type that is needed
    }
}

