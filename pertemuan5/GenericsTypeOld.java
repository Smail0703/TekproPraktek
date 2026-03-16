public class GenericsTypeOld {

    private Object t;

    public Object get(){ //getter
        return t;
    }

    public void set(Object t){ //setter 
        this.t = t;
    }

    public static void main(String args[]) {
        GenericsTypeOld type = new GenericsTypeOld();
        type.set("Java");
        String str = (String) type.get(); // type casting, error prone and can cause ClassCastException
        System.out.println("\n" + str);
    }
}
