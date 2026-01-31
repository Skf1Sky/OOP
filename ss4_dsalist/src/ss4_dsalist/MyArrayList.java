package ss4_dsalist;

import java.util.Arrays;

public class MyArrayList {
    private int[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor: Khởi tạo mảng với dung lượng mặc định
    public MyArrayList() {
        this.elements = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Constructor: Khởi tạo với dung lượng tùy chọn
    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.elements = new int[capacity];
        } else {
            this.elements = new int[DEFAULT_CAPACITY];
        }
        this.size = 0;
    }

    // --- HÀM HỖ TRỢ: Tăng dung lượng mảng khi đầy ---
    private void ensureCapacity() {
        if (size >= elements.length) {
            // Tạo mảng mới gấp đôi mảng cũ
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    // a. add (int element): Thêm phần tử vào cuối
    public void add(int element) {
        ensureCapacity(); // Kiểm tra xem mảng có đầy không
        elements[size] = element;
        size++;
    }

    // b. toString (): Hiển thị danh sách
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

    // c. add (int index, int element): Chèn vào vị trí index
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();

        // Dịch chuyển các phần tử từ index về sau sang phải 1 bước
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    // d. set (int index, int element): Thay thế (Ghi đè)
    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[index] = element;
    }

    // e. get (int index): Lấy giá trị
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    // f. indexOf (int element): Tìm vị trí đầu tiên
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1; // Không tìm thấy
    }

    // g. lastIndexOf (int element): Tìm vị trí cuối cùng
    public int lastIndexOf(int element) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1; // Không tìm thấy
    }

    // h. remove (int index): Xóa tại vị trí index
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int removedElement = elements[index];

        // Dịch chuyển các phần tử phía sau index sang trái 1 bước
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--; // Giảm kích thước thực tế
        return removedElement;
    }

    // i. removeElement (int element): Xóa TẤT CẢ phần tử có giá trị element
    public void removeElement(int element) {
        // Cách an toàn nhất: Duyệt ngược từ cuối về đầu
        // Tại sao? Vì nếu duyệt xuôi, khi xóa index sẽ bị thay đổi làm lỡ phần tử kế tiếp
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i] == element) {
                remove(i);
            }
        }
    }

    // Hàm phụ lấy kích thước hiện tại (Optional)
    public int size() {
        return size;
    }
}