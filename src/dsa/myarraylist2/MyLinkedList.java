package dsa.myarraylist2;

import java.util.Arrays;

public class MyLinkedList {
    private int[] elements;
    private int[] nextIndices;
    private int head;
    private int free;
    private int size;
    private static final int MAX_SIZE = 1000;

    public MyLinkedList() {
        elements = new int[MAX_SIZE];
        nextIndices = new int[MAX_SIZE];
        head = -1;
        free = 0;
        size = 0;

        for (int i = 0; i < MAX_SIZE - 1; i++) {
            nextIndices[i] = i + 1;
        }
        nextIndices[MAX_SIZE - 1] = -1;
    }

    private int getNewIndex() {
        if (free == -1) {
            throw new RuntimeException("List is full");
        }
        int index = free;
        free = nextIndices[free];
        return index;
    }

    private void releaseIndex(int index) {
        nextIndices[index] = free;
        free = index;
    }

    public void addFirst(int element) {
        int newIdx = getNewIndex();
        elements[newIdx] = element;
        nextIndices[newIdx] = head;
        head = newIdx;
        size++;
    }

    public void addLast(int element) {
        if (head == -1) {
            addFirst(element);
            return;
        }
        int current = head;
        while (nextIndices[current] != -1) {
            current = nextIndices[current];
        }
        int newIdx = getNewIndex();
        elements[newIdx] = element;
        nextIndices[newIdx] = -1;
        nextIndices[current] = newIdx;
        size++;
    }

    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        int prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = nextIndices[prev];
        }
        int newIdx = getNewIndex();
        elements[newIdx] = element;
        nextIndices[newIdx] = nextIndices[prev];
        nextIndices[prev] = newIdx;
        size++;
    }

    public void removeFirst() {
        if (head == -1) return;
        int oldHead = head;
        head = nextIndices[head];
        releaseIndex(oldHead);
        size--;
    }

    public void removeLast() {
        if (head == -1) return;
        if (nextIndices[head] == -1) {
            removeFirst();
            return;
        }
        int current = head;
        while (nextIndices[nextIndices[current]] != -1) {
            current = nextIndices[current];
        }
        releaseIndex(nextIndices[current]);
        nextIndices[current] = -1;
        size--;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        int prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = nextIndices[prev];
        }
        int toRemove = nextIndices[prev];
        nextIndices[prev] = nextIndices[toRemove];
        releaseIndex(toRemove);
        size--;
    }

    public int getFirst() {
        if (head == -1) throw new RuntimeException("List is empty");
        return elements[head];
    }

    public int getLast() {
        if (head == -1) throw new RuntimeException("List is empty");
        int current = head;
        while (nextIndices[current] != -1) {
            current = nextIndices[current];
        }
        return elements[current];
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        int current = head;
        for (int i = 0; i < index; i++) {
            current = nextIndices[current];
        }
        return elements[current];
    }

    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        int current = head;
        for (int i = 0; i < index; i++) {
            current = nextIndices[current];
        }
        elements[current] = element;
    }

    public int indexOf(int element) {
        int current = head;
        for (int i = 0; i < size; i++) {
            if (elements[current] == element) {
                return i;
            }
            current = nextIndices[current];
        }
        return -1;
    }

    public int lastIndexOf(int element) {
        int lastIndex = -1;
        int current = head;
        for (int i = 0; i < size; i++) {
            if (elements[current] == element) {
                lastIndex = i;
            }
            current = nextIndices[current];
        }
        return lastIndex;
    }

    @Override
    public String toString() {
        if (head == -1) return "[]";
        StringBuilder sb = new StringBuilder("[");
        int current = head;
        while (current != -1) {
            sb.append(elements[current]);
            if (nextIndices[current] != -1) {
                sb.append(", ");
            }
            current = nextIndices[current];
        }
        sb.append("]");
        return sb.toString();
    }
}
