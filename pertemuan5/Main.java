interface MinMax<T extends Comparable<T>> { // interface generic
    T max();
}

class MyClass<T extends Comparable<T>> implements MinMax<T> { //myclass mengimplementasikan interface MinMax maka dari itu tipe data T harus comparable
    T[] vals; //penyimpanan menggunakan array

    MyClass(T[] o) { //menyimpan kumpulan data yang dimasukkan melalui Constructor
        vals = o;
    }

    public T max() {
        T v = vals[0];
        
        for (int i = 1; i < vals.length; i++) {
            // Menggunakan method compareTo dari interface Comparable
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] inums = {3, 6, 2, 8, 6};
        Character[] chs = {'b', 'r', 'p', 'w'}; //kedua array ini sudah mengimplementasikan interface

        MyClass<Integer> a = new MyClass<>(inums);
        MyClass<Character> b = new MyClass<>(chs);

        System.out.println("\nNilai Integer Terbesar: " + a.max());
        System.out.println("Karakter Terbesar: " + b.max());
    }
}
