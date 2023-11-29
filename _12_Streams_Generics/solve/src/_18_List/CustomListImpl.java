package _18_List;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {
    Object[] elementData;
    private int size;
    private int curr;
    private int elementsCnt;

    public CustomListImpl() {
        this.elementData = new Object[1];
        this.size = 0;
        this.curr = 0;
        this.elementsCnt = 1;
    }

    @Override
    public void add(T element) {

        if (this.curr + 1 >= elementsCnt) {
            int newElementsCnt = elementsCnt * 2;
            elementsCnt = newElementsCnt;
            Object[] newArr = new Object[newElementsCnt];

            for (int i = 0; i < curr + 1; i++) {
                newArr[i] = elementData[i];
            }
            elementData = newArr;
        }
        this.elementData[curr++] = element;
        this.size++;
    }

    @Override
    public T get(int index) {
        if (checkBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elementData[index];
    }

    @Override
    public T remove(int index) {
        if (checkBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        T toRemove = (T) elementData[index];
        for (int i = index; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        curr--;
        return toRemove;
    }

    @Override
    public boolean contains(T element) {

        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void swap(int i1, int i2) {
        if (checkBounds(i1) || checkBounds(i2)) {
            throw new IndexOutOfBoundsException();
        }

        T temp = (T) elementData[i1];
        elementData[i1] = elementData[i2];
        elementData[i2] = temp;
    }

    @Override
    public int countGreaterThan(T element) {
        int cnt = 0;
        for (int i = 0; i < this.size; i++) {
            if (element.compareTo((T) elementData[i]) < 0) {
                cnt++;
            }
        }
        return cnt;
    }

    @Override
    public T getMax() {
        T max = (T) elementData[0];
        for (int i = 1; i < size; i++) {
            if (max.compareTo((T)elementData[i]) < 0) {
                max = (T) elementData[i];
            }
        }
        return max;
    }

    @Override
    public T getMin() {
        T min = (T) elementData[0];
        for (int i = 1; i < size; i++) {
            if (min.compareTo((T)elementData[i]) > 0) {
                min = (T) elementData[i];
            }
        }
        return min;
    }

    @Override
    public int size() {
        return this.size;
    }
    private boolean checkBounds(int index) {
        return index < 0 || index > size - 1;
    }
}
