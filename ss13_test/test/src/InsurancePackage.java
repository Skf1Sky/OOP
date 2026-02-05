import java.util.Date;

public abstract class InsurancePackage {
    public String hoTen;
    public Date ngaySinh;
    public String noiThuongTru;
    public String cmnd;
    public String tenGoi;
    public String thoiHan;
    public long mucPhi;
    public String mucDich;
    public String cachThuc;
    public Date ngayBatDau;

    public InsurancePackage(String hoTen, Date ngaySinh, String noiThuongTru, String cmnd,
                            String tenGoi, String thoiHan, long mucPhi, String mucDich,
                            String cachThuc, Date ngayBatDau) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.noiThuongTru = noiThuongTru;
        this.cmnd = cmnd;
        this.tenGoi = tenGoi;
        this.thoiHan = thoiHan;
        this.mucPhi = mucPhi;
        this.mucDich = mucDich;
        this.cachThuc = cachThuc;
        this.ngayBatDau = ngayBatDau;
    }

    public abstract String toString();
}