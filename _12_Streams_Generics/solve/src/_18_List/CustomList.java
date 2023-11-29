package _18_List;

public interface CustomList<T> {

    void add(T element);
    T get(int index);
    T remove(int index);
    boolean contains(T element);
    void swap(int i1, int i2);
    int countGreaterThan(T element);
    T getMax();
    T getMin();
    int size();
}
