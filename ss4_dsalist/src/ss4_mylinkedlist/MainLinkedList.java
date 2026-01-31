package ss4_mylinkedlist;

public class MainLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        System.out.println("--- TEST ADD ---");
        list.addFirst(10);      // [10]
        list.addFirst(5);       // [5 -> 10]
        list.addLast(20);       // [5 -> 10 -> 20]
        list.add(1, 99);   // [5 -> 99 -> 10 -> 20]
        list.addLast(10);       // [5 -> 99 -> 10 -> 20 -> 10] (Để test lastIndexOf)

        System.out.println("Danh sách: " + list.toString());

        System.out.println("\n--- TEST GET / SET ---");
        System.out.println("Phần tử đầu: " + list.getFirst());
        System.out.println("Phần tử cuối: " + list.getLast());
        System.out.println("Tại index 2: " + list.get(2));

        list.set(2, 888); // Đổi 10 thành 888
        System.out.println("Sau khi set index 2: " + list);

        System.out.println("\n--- TEST SEARCH ---");
        System.out.println("Tìm số 10 (indexOf): " + list.indexOf(10)); // Vị trí cuối
        System.out.println("Tìm số 10 (lastIndexOf): " + list.lastIndexOf(10));
        System.out.println("Tìm số 100 (không có): " + list.indexOf(100));

        System.out.println("\n--- TEST REMOVE ---");
        System.out.println("Xóa đầu (removeFirst): " + list.removeFirst());
        System.out.println("Danh sách: " + list);

        System.out.println("Xóa cuối (removeLast): " + list.removeLast());
        System.out.println("Danh sách: " + list);

        System.out.println("Xóa tại index 1 (remove): " + list.remove(1));
        System.out.println("Cuối cùng: " + list);
    }
}