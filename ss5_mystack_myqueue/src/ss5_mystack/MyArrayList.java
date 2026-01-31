package ss5_mystack;

import ss4_dsalist.MyArrayList; // Import file cũ của bạn

public class MyStackArr {
    private MyArrayList list;

    public MyStackArr() {
        // Tái sử dụng MyArrayList
        this.list = new MyArrayList();
    }

    // a. push(): Thêm vào cuối mảng
    public void push(int element) {
        list.add(element);
    }

    // b. peek(): Lấy phần tử cuối mảng ra xem
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack rỗng!");
        }
        return list.get(list.size() - 1);
    }

    // c. pop(): Lấy phần tử cuối mảng ra và xóa đi
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack rỗng!");
        }
        // remove(index) trong MyArrayList đã trả về phần tử bị xóa
        return list.remove(list.size() - 1);
    }

    // d. isEmpty(): Kiểm tra rỗng
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // e. size(): Trả về số lượng
    public int size() {
        return list.size();
    }
}