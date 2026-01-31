package ss4_mylinkedlist;

import java.util.NoSuchElementException;

public class MyLinkedList {
    // Class Node: Đại diện cho 1 phần tử trong danh sách
    private class Node {
        int data;       // Dữ liệu
        Node next;      // Con trỏ trỏ tới nút tiếp theo

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;      // Nút đầu tiên (quản lý cả dây xích)
    private int numNodes;   // Số lượng phần tử

    public MyLinkedList() {
        this.head = null;
        this.numNodes = 0;
    }

    // a. addFirst (int element): Thêm vào đầu
    public void addFirst(int element) {
        Node newNode = new Node(element);
        newNode.next = head; // Trỏ nút mới vào head cũ
        head = newNode;      // Cập nhật head là nút mới
        numNodes++;
    }

    // b. toString (): Hiển thị danh sách
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data);
            if (temp.next != null) {
                sb.append(" -> ");
            }
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // c. addLast (int element): Thêm vào cuối
    public void addLast(int element) {
        if (head == null) {
            addFirst(element);
            return;
        }

        // Duyệt đến nút cuối cùng
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Gắn nút mới vào đuôi
        temp.next = new Node(element);
        numNodes++;
    }

    // d. add (int index, int element): Thêm vào vị trí bất kỳ
    public void add(int index, int element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Lỗi: Index nằm ngoài danh sách");
        }
        if (index == 0) {
            addFirst(element);
            return;
        }

        // Tìm nút đứng TRƯỚC vị trí cần chèn (index - 1)
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(element);
        newNode.next = temp.next; // Nút mới trỏ vào nút sau
        temp.next = newNode;      // Nút trước trỏ vào nút mới
        numNodes++;
    }

    // e. removeFirst (): Xóa đầu
    public int removeFirst() {
        if (numNodes == 0) throw new NoSuchElementException("Danh sách rỗng!");

        int data = head.data;
        head = head.next; // Bỏ qua nút đầu, trỏ sang nút thứ 2
        numNodes--;
        return data;
    }

    // f. removeLast (): Xóa cuối
    public int removeLast() {
        if (numNodes == 0) throw new NoSuchElementException("Danh sách rỗng!");
        if (numNodes == 1) return removeFirst(); // Chỉ có 1 nút

        // Duyệt đến nút KẾ CUỐI (temp.next là nút cuối)
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        int data = temp.next.data;
        temp.next = null; // Cắt đứt liên kết với nút cuối
        numNodes--;
        return data;
    }

    // g. remove (int index): Xóa tại vị trí index
    public int remove(int index) {
        if (index < 0 || index >= numNodes) throw new IndexOutOfBoundsException("Index sai!");
        if (index == 0) return removeFirst();
        if (index == numNodes - 1) return removeLast();

        // Tìm nút đứng TRƯỚC nút cần xóa
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        int data = temp.next.data; // Lấy dữ liệu nút cần xóa
        temp.next = temp.next.next; // Bỏ qua nút cần xóa, nối với nút sau nó
        numNodes--;
        return data;
    }

    // h. getFirst ()
    public int getFirst() {
        if (head == null) throw new NoSuchElementException("Danh sách rỗng!");
        return head.data;
    }

    // i. getLast ()
    public int getLast() {
        if (head == null) throw new NoSuchElementException("Danh sách rỗng!");
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    // j. get (int index)
    public int get(int index) {
        if (index < 0 || index >= numNodes) throw new IndexOutOfBoundsException("Index sai!");
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // k. set (int index, int element): Cập nhật dữ liệu
    public void set(int index, int element) {
        if (index < 0 || index >= numNodes) throw new IndexOutOfBoundsException("Index sai!");
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = element;
    }

    // l. indexOf (int element): Tìm vị trí đầu tiên
    public int indexOf(int element) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == element) return index;
            temp = temp.next;
            index++;
        }
        return -1; // Không tìm thấy
    }

    // m. lastIndexOf (int element): Tìm vị trí cuối cùng
    public int lastIndexOf(int element) {
        Node temp = head;
        int index = 0;
        int lastIndex = -1; // Giả sử chưa tìm thấy
        while (temp != null) {
            if (temp.data == element) {
                lastIndex = index; // Cập nhật mỗi khi tìm thấy
            }
            temp = temp.next;
            index++;
        }
        return lastIndex;
    }
}