package _10_GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator<T> {


    public static <T> T[] create(int length, T item) {
        T[] newArray = (T[]) Array.newInstance(item.getClass(), length);

        for (int i = 0; i < length; i++) {
            newArray[i] = item;
        }

        return newArray;
    }

    public static <T> T[] create(Class<T> clazz, int length, T item) {
        T[] newArray = (T[]) Array.newInstance(clazz, length);

        for (int i = 0; i < length; i++) {
            newArray[i] = item;
        }
        return newArray;
    }

}
