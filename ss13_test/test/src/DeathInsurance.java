import java.text.SimpleDateFormat;
import java.util.Date;

public class DeathInsurance extends InsurancePackage {
    public String truongHop;
    public String thoiGianToiThieu;

    public DeathInsurance(String hoTen, Date ngaySinh, String noiThuongTru, String cmnd, String tenGoi, String thoiHan, long mucPhi, String mucDich, String cachThuc, Date ngayBatDau, String truongHop, String thoiGianToiThieu) {
        super(hoTen, ngaySinh, noiThuongTru, cmnd, tenGoi, thoiHan, mucPhi, mucDich, cachThuc, ngayBatDau);
        this.truongHop = truongHop;
        this.thoiGianToiThieu = thoiGianToiThieu;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return "Ho ten: " + hoTen + "\nNgay sinh: " + sdf.format(ngaySinh) + "\nNoi thuong tru: " + noiThuongTru + "\nSo chung minh thu: " + cmnd + "\nTen goi BH: " + tenGoi + "\nThoi han: " + thoiHan + "\nMuc phi: " + mucPhi + "\nMuc dich: " + mucDich + "\nCach thuc dong phi: " + cachThuc + "\nThoi gian bat dau: " + sdf.format(ngayBatDau) + "\nLoai BH: " + truongHop + "\nThoi gian toi thieu tham gia: " + thoiGianToiThieu;
    }
}