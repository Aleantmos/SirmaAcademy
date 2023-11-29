package _12_GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable<T>> {
    private List<T> container;

    public Box() {
        this.container = new ArrayList<>();
    }

    public void add(T element) {
        container.add(element);
    }

    public void swap(int first, int second) {
        T temp = container.get(first);
        container.set(first, container.get(second));
        container.set(second, temp);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (T t : container) {
            result.append(String.format("%s: %s%n", t.getClass(), t));
        }
        return result.toString();
    }

    public int countGreaterThan(T value) {
        int count = 0;
        for (T element : container) {
            if (element.compareTo(value) > 0) {
                count++;
            }
        }
        return count;
    }

}
