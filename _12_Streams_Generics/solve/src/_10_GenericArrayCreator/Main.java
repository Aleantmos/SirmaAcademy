package _10_GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] intArray1 = ArrayCreator.create(5, 0);
        String[] strArray1 = ArrayCreator.create(3, "Hello");

        Integer[] intArray2 = ArrayCreator.create(Integer.class, 4, 42);
        Double[] doubleArray = ArrayCreator.create(Double.class, 2, 3.14);
    }
}
