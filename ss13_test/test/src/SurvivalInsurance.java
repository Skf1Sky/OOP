import java.text.SimpleDateFormat;
import java.util.Date;

public class SurvivalInsurance extends InsurancePackage {
    public Date ngayKetThuc;
    public String thoiGianTroCap;

    public SurvivalInsurance(String hoTen, Date ngaySinh, String noiThuongTru, String cmnd, String tenGoi, String thoiHan, long mucPhi, String mucDich, String cachThuc, Date ngayBatDau, Date ngayKetThuc, String thoiGianTroCap) {
        super(hoTen, ngaySinh, noiThuongTru, cmnd, tenGoi, thoiHan, mucPhi, mucDich, cachThuc, ngayBatDau);
        this.ngayKetThuc = ngayKetThuc;
        this.thoiGianTroCap = thoiGianTroCap;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return "Ho ten: " + hoTen + "\nNgay sinh: " + sdf.format(ngaySinh) + "\nNoi thuong tru: " + noiThuongTru + "\nSo chung minh thu: " + cmnd + "\nTen goi BH: " + tenGoi + "\nThoi han: " + thoiHan + "\nMuc phi: " + mucPhi + "\nMuc dich: " + mucDich + "\nCach thuc dong phi: " + cachThuc + "\nThoi gian bat dau: " + sdf.format(ngayBatDau) + "\nThoi gian ket thuc: " + (ngayKetThuc != null ? sdf.format(ngayKetThuc) : "null") + "\nThoi gian tro cap: " + thoiGianTroCap;
    }
}