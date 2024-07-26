/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.util.Date;

/**
 *
 * @author nguye
 */
public class DonHang {
    private int MaDonHang;
    private Date NgayGiao;
    private Date NgayDat;
    private String DaThanhToan;
    private int TinhTrangGiaoHang;
    private int MaKH;

    public DonHang() {
    }

    public DonHang(int MaDonHang, Date NgayGiao, Date NgayDat, String DaThanhToan, int TinhTrangGiaoHang, int MaKH) {
        this.MaDonHang = MaDonHang;
        this.NgayGiao = NgayGiao;
        this.NgayDat = NgayDat;
        this.DaThanhToan = DaThanhToan;
        this.TinhTrangGiaoHang = TinhTrangGiaoHang;
        this.MaKH = MaKH;
    }

    public int getMaDonHang() {
        return MaDonHang;
    }

    public void setMaDonHang(int MaDonHang) {
        this.MaDonHang = MaDonHang;
    }

    public Date getNgayGiao() {
        return NgayGiao;
    }

    public void setNgayGiao(Date NgayGiao) {
        this.NgayGiao = NgayGiao;
    }

    public Date getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    public String getDaThanhToan() {
        return DaThanhToan;
    }

    public void setDaThanhToan(String DaThanhToan) {
        this.DaThanhToan = DaThanhToan;
    }

    public int getTinhTrangGiaoHang() {
        return TinhTrangGiaoHang;
    }

    public void setTinhTrangGiaoHang(int TinhTrangGiaoHang) {
        this.TinhTrangGiaoHang = TinhTrangGiaoHang;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }
    
}
