package ss4_dsalist;

public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        // 1. Test Add
        System.out.println("--- Test Add ---");
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20); // Thêm số 20 lần nữa để test lastIndexOf và removeElement
        list.add(40);
        System.out.println("Danh sách ban đầu: " + list.toString());

        // 2. Test Add tại Index
        System.out.println("\n--- Test Add tại Index 1 giá trị 99 ---");
        list.add(1, 99);
        System.out.println(list);

        // 3. Test Set (Cập nhật)
        System.out.println("\n--- Test Set tại index 0 thành 55 ---");
        list.set(0, 55);
        System.out.println(list);

        // 4. Test Get
        System.out.println("\n--- Test Get tại index 2 ---");
        System.out.println("Giá trị tại index 2 là: " + list.get(2));

        // 5. Test IndexOf / LastIndexOf
        System.out.println("\n--- Test Tìm kiếm số 20 ---");
        System.out.println("Vị trí đầu tiên của 20: " + list.indexOf(20));
        System.out.println("Vị trí cuối cùng của 20: " + list.lastIndexOf(20));

        // 6. Test Remove index
        System.out.println("\n--- Test Xóa tại index 3 ---");
        int deleted = list.remove(3);
        System.out.println("Đã xóa số: " + deleted);
        System.out.println("Danh sách sau xóa: " + list);

        // 7. Test RemoveElement (Xóa tất cả số 20)
        System.out.println("\n--- Test Xóa tất cả số 20 ---");
        // Add thêm 1 số 20 nữa để chắc chắn có nhiều số 20
        list.add(20);
        System.out.println("Trước khi xóa hết 20: " + list);

        list.removeElement(20);
        System.out.println("Sau khi xóa hết 20:   " + list);
    }
}