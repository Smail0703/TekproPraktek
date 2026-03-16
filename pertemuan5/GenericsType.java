public class GenericsType<T> {

    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t1) {
        this.t = t1;
    }

    public static void main(String args[]) {
        String str;
        int Angka;
        GenericsType<String> type = new GenericsType<>();
        type.set("Java"); // valid
        str = type.get();
        System.out.println("\n" + str);

        GenericsType type1 = new GenericsType(); // raw type
        type1.set("Java"); // valid
        str = (String) type1.get();
        System.out.println(str);
        type1.set(10); // valid and autoboxing support
        Angka = (int) type1.get();
        System.out.println(Angka);
    }
}
