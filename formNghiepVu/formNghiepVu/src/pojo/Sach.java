/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.util.Date;

/**
 *
 * @author Ther
 */
public class Sach {
    private int masach;
    private String tensach;
    private int giaban;
    private String mota;
    private Date ngaycapnhat;
    private String maanhbia;
    private int soluongton;
    private int machude;
    private int manxb;
    private int moi;

    public Sach() {
    }


    public Sach(int masach, String tensach, int giaban, String mota, Date ngaycapnhat, String maanhbia, int soluongton, int machude, int manxb, int moi) {
        this.masach = masach;
        this.tensach = tensach;
        this.giaban = giaban;
        this.mota = mota;
        this.ngaycapnhat = ngaycapnhat;
        this.maanhbia = maanhbia;
        this.soluongton = soluongton;
        this.machude = machude;
        this.manxb = manxb;
        this.moi = moi;
    }

    public int getMachude() {
        return machude;
    }

    public int getManxb() {
        return manxb;
    }

    public void setMachude(int machude) {
        this.machude = machude;
    }

    public void setManxb(int manxb) {
        this.manxb = manxb;
    }

    
    public int getMasach() {
        return masach;
    }

    public String getTensach() {
        return tensach;
    }

    public int getGiaban() {
        return giaban;
    }

    public String getMota() {
        return mota;
    }

    public Date getNgaycapnhat() {
        return ngaycapnhat;
    }

    public String getMaanhbia() {
        return maanhbia;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public int getMoi() {
        return moi;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setNgaycapnhat(Date ngaycapnhat) {
        this.ngaycapnhat = ngaycapnhat;
    }

    public void setMaanhbia(String maanhbia) {
        this.maanhbia = maanhbia;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public void setMoi(int moi) {
        this.moi = moi;
    }
   
}
