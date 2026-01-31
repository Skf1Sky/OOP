package ss3_abstract_interface;

public abstract class Phone implements Comparable<Phone> {
    protected String id;
    protected String name;
    protected double price;
    protected int warranty;
    protected String manufact;

    // Constructor
    public Phone(String id, String name, double price, int warranty, String manufact) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warranty = warranty;
        this.manufact = manufact;
    }

    // Phương thức Abstract bắt buộc lớp con phải triển khai
    public abstract void hienThiThongTin();

    // --- TRIỂN KHAI COMPARABLE ---
    // Sắp xếp mặc định theo Tên (A -> Z)
    @Override
    public int compareTo(Phone o) {
        return this.name.compareTo(o.getName());
    }

    // --- GETTER / SETTER ---
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getWarranty() {
        return warranty;
    }

    public String getManufact() {
        return manufact;
    }
}