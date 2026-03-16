package soal2;

abstract public class Shape {
    private String shapeName;

    public Shape(String shapeName){
        this.shapeName = shapeName;
    }

    public abstract double area();

    public String toString(){
        return shapeName;
    }
}