package _9_JarOfT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Jar <T> {

    private ArrayDeque<T> list;

    public Jar() {
        this.list = new ArrayDeque<>();
    }

    public void add(T element) {
        this.list.push(element);
    }

    public void remove() {
        this.list.pop();
    }

    public int size() {
        return list.size();
    }
}
