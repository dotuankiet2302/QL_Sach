/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.KhachHang;
/**
 *
 * @author ACER
 */
public class KhachHangDAO {
    public static ArrayList<KhachHang> layDanhSachKhachHang(){
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            String sql = "Select * from khachhang";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("HoTen"));
                kh.setNgaySinh(rs.getString("NgaySinh"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setDienThoai(rs.getString("DienThoai"));
                kh.setTaiKhoan(rs.getString("TaiKhoan"));
                kh.setMatKhau(rs.getString("MatKhau"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                dsKH.add(kh);
            }
            provider.Close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKH;
    }
    
    public static ArrayList<KhachHang> timKiemKhachHangTheoTen(String tenKH){
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            String sql = "Select * from khachhang where HoTen like N'%"+tenKH+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("HoTen"));
                kh.setNgaySinh(rs.getString("NgaySinh"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setDienThoai(rs.getString("DienThoai"));
                kh.setTaiKhoan(rs.getString("TaiKhoan"));
                kh.setMatKhau(rs.getString("MatKhau"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                dsKH.add(kh);
            }
            provider.Close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKH;
    }
    
    public static ArrayList<KhachHang> timKiemKhachHangTheoMa(String MaKH){
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            String sql = "Select * from khachhang where makh like '%"+MaKH+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("HoTen"));
                kh.setNgaySinh(rs.getString("NgaySinh"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setDienThoai(rs.getString("DienThoai"));
                kh.setTaiKhoan(rs.getString("TaiKhoan"));
                kh.setMatKhau(rs.getString("MatKhau"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                dsKH.add(kh);
            }
            provider.Close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKH;
    }
    
    public static ArrayList<KhachHang> timKiemKhachHangDiaChi(String diaChi){
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            String sql = "Select * from khachhang where diachi like N'%"+diaChi+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("HoTen"));
                kh.setNgaySinh(rs.getString("NgaySinh"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setDienThoai(rs.getString("DienThoai"));
                kh.setTaiKhoan(rs.getString("TaiKhoan"));
                kh.setMatKhau(rs.getString("MatKhau"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                dsKH.add(kh);
            }
            provider.Close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKH;
    }
    
    public static ArrayList<KhachHang> timKiemKhachHangTheoTaiKhoan(String taiKhoan){
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            String sql = "Select * from khachhang where taikhoan like N'%"+taiKhoan+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("HoTen"));
                kh.setNgaySinh(rs.getString("NgaySinh"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setDienThoai(rs.getString("DienThoai"));
                kh.setTaiKhoan(rs.getString("TaiKhoan"));
                kh.setMatKhau(rs.getString("MatKhau"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                dsKH.add(kh);
            }
            provider.Close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKH;
    }
    
    public static boolean themKhachHang(KhachHang kh){
        boolean kq  = false;
        String sql = String.format("insert into khachhang(hoten, ngaysinh, gioitinh, dienthoai, taikhoan, matkhau, email, diachi) values (N'%s', N'%s', N'%s', '%s', '%s', '%s', '%s', N'%s');",
        kh.getTenKH(),
        kh.getNgaySinh(),
        kh.getGioiTinh(),
        kh.getDienThoai(),
        kh.getTaiKhoan(),
        kh.getMatKhau(),
        kh.getEmail(),
        kh.getDiaChi());
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.Open();
        int n = provider.executeUpdate(sql);
        if(n == 1){
            return true;
        }
        provider.Close();
        return kq;
    }
    
    public static boolean xoaKhachHang(KhachHang kh){
        boolean kq  = false;
        String sql = String.format("delete from khachhang where makh = %d", kh.getMaKH());
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.Open();
        int n = provider.executeUpdate(sql);
        if(n == 1){
            return true;
        }
        provider.Close();
        return kq;
    }
    
    public static boolean capNhatKhachHang(KhachHang kh){
        boolean kq  = false;
        String sql = String.format("update khachhang set hoten = N'%s', ngaysinh = '%s', gioitinh = N'%s', dienthoai = '%s', taikhoan = '%s', matkhau = '%s', email = '%s', diachi = N'%s' where makh = %d", kh.getTenKH(),kh.getNgaySinh(),kh.getGioiTinh(),kh.getDienThoai(),kh.getTaiKhoan(),kh.getMatKhau(),kh.getEmail(),kh.getDiaChi(), kh.getMaKH());
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.Open();
        int n = provider.executeUpdate(sql);
        if(n == 1){
            return true;
        }
        provider.Close();
        return kq;
    }
}
