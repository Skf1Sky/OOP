package ss3_abstract_interface;

// Kế thừa Phone VÀ Triển khai IDiscount
public class NewPhone extends Phone implements IDiscount {
    private int quantity;

    public NewPhone(String id, String name, double price, int warranty, String manufact, int quantity) {
        super(id, name, price, warranty, manufact);
        this.quantity = quantity;
    }

    // 1. Ghi đè phương thức abstract của lớp cha
    @Override
    public void hienThiThongTin() {
        System.out.printf("| %-10s | %-15s | Giá: %-10.0f | SL: %-5d | (NEW)\n",
                id, name, price, quantity);
    }

    // 2. Triển khai phương thức của Interface
    @Override
    public double tinhGiamGia() {
        // Nếu số lượng > 5 thì giảm 5%
        if (this.quantity > 5) {
            return this.price * 0.05;
        }
        return 0;
    }

    // Getter
    public int getQuantity() { return quantity; }
}