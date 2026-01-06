package phonemanagement;

import java.util.Scanner;

public abstract class DienThoai {
    protected String id;
    protected String ten;
    protected double gia;
    protected int baoHanh;
    protected String hang;

    public abstract void input();
    public abstract void output();
}
