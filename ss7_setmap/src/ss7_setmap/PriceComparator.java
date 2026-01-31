package ss7_setmap;

import ss3_abstract_interface.Phone;
import java.util.Comparator;

public class PriceComparator implements Comparator<Phone> {
    @Override
    public int compare(Phone p1, Phone p2) {
        // So sánh giá tiền tăng dần
        if (p1.getPrice() > p2.getPrice()) {
            return 1; // p1 lớn hơn -> xếp sau
        } else if (p1.getPrice() < p2.getPrice()) {
            return -1; // p1 nhỏ hơn -> xếp trước
        } else {
            return 0; // bằng nhau
        }

        // Cách viết ngắn gọn hơn:
        // return Double.compare(p1.getPrice(), p2.getPrice());

        // Nếu muốn giảm dần thì đổi chỗ p2 và p1:
        // return Double.compare(p2.getPrice(), p1.getPrice());
    }
}