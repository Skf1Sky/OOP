package ss3_abstract_interface;

public class OldPhone extends Phone implements IDiscount {
    private int battery;
    private String description;

    public OldPhone(String id, String name, double price, int warranty, String manufact, int battery, String description) {
        super(id, name, price, warranty, manufact);
        this.battery = battery;
        this.description = description;
    }

    @Override
    public void hienThiThongTin() {
        System.out.printf("| %-10s | %-15s | Giá: %-10.0f | Pin: %-3d%% | (OLD)\n",
                id, name, price, battery);
    }

    @Override
    public double tinhGiamGia() {
        // Nếu Pin yếu (<80%) thì giảm 10%
        if (this.battery < 80) {
            return this.price * 0.10;
        }
        return 0;
    }
}