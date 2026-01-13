package dsa.myarraylist1;

import java.util.Arrays;

public class MyArrayList {
    private int[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public MyArrayList() {
        this.elements = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public void add(int element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public void set(int index, int element) {
        checkIndex(index);
        elements[index] = element;
    }

    public int get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int element) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public void removeElement(int element) {
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i] != element) {
                elements[newSize] = elements[i];
                newSize++;
            }
        }
        size = newSize;
    }

    public int size() {
        return size;
    }
}
