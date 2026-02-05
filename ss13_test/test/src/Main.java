import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static ArrayList<InsurancePackage> list = new ArrayList<>();
    static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    public static void main(String[] args) {
        try {

            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter("error.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(", ");

                String loi = "";
                boolean checkOK = true;


                try {
                    sdf.setLenient(false);
                    sdf.parse(arr[1]);
                    sdf.parse(arr[9]);
                    if (!arr[10].equals("null")) {
                        sdf.parse(arr[10]);
                    }
                } catch (Exception e) {
                    loi += "Ngay thang sai dinh dang; ";
                    checkOK = false;
                }
                long phi = 0;
                try {
                    phi = Long.parseLong(arr[6]);
                    if (phi <= 1000000 || phi >= 10000000000L) {
                        loi += "Muc phi khong hop le; ";
                        checkOK = false;
                    }
                } catch (Exception e) {
                    loi += "Muc phi sai kieu so; ";
                    checkOK = false;
                }
                String tenGoi = arr[4];

                if (tenGoi.contains("sinh ky")) {
                    if (!arr[11].equals("null") || !arr[12].equals("null") || !arr[13].equals("null")) {
                        loi += "Du lieu thua cua goi sinh ky; ";
                        checkOK = false;
                    }
                }
                else if (tenGoi.contains("tu vong")) {
                    if (!arr[10].equals("null") || !arr[11].equals("null") || !arr[14].equals("null")) {
                        loi += "Du lieu thua cua goi tu vong; ";
                        checkOK = false;
                    }
                }
                else {
                    if (!arr[12].equals("null") || !arr[13].equals("null") || !arr[14].equals("null")) {
                        loi += "Du lieu thua cua goi thoi han; ";
                        checkOK = false;
                    }
                }
                if (checkOK) {
                    Date ns = sdf.parse(arr[1]);
                    Date nbd = sdf.parse(arr[9]);
                    Date nkt = null;
                    if (!arr[10].equals("null")) nkt = sdf.parse(arr[10]);

                    if (tenGoi.contains("tu vong")) {
                        list.add(new DeathInsurance(arr[0], ns, arr[2], arr[3], arr[4], arr[5], phi, arr[7], arr[8], nbd, arr[12], arr[13]));
                    } else if (tenGoi.contains("sinh ky")) {
                        list.add(new SurvivalInsurance(arr[0], ns, arr[2], arr[3], arr[4], arr[5], phi, arr[7], arr[8], nbd, nkt, arr[14]));
                    } else {
                        list.add(new TermInsurance(arr[0], ns, arr[2], arr[3], arr[4], arr[5], phi, arr[7], arr[8], nbd, nkt, arr[11]));
                    }
                } else {
                    bw.write(line);
                    bw.newLine();
                    bw.write("Loi: " + loi);
                    bw.newLine();
                }
            }
            br.close();
            bw.close();

            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap CMND can tim: ");
            String cmnd = sc.nextLine();
            boolean timThay = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).cmnd.equals(cmnd)) {
                    System.out.println(list.get(i).toString());
                    timThay = true;
                }
            }
            if (!timThay) System.out.println("Khong tim thay");

            long max = 0;
            for (InsurancePackage p : list) {
                if (p.mucPhi > max) max = p.mucPhi;
            }
            System.out.println("Cac goi co phi cao nhat (" + max + "):");
            for (InsurancePackage p : list) {
                if (p.mucPhi == max) {
                    System.out.println(p.toString());
                    System.out.println("***********************");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}