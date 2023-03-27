package com.example.appdemo.model;

import java.io.Serializable;

public class SanPhamMoi implements Serializable {
    String MASP, TENSP, PHANLOAI, NOINHAP, NOIDUNG;
    Integer SOLUONG, HINHANH;
    Long DONGIA;
    public SanPhamMoi(){ }
    public SanPhamMoi(String MASP, String TENSP, String PHANLOAI, String NOINHAP, String NOIDUNG,Integer SOLUONG, Long DONGIA, int HINHANH) {
        this.MASP = MASP;
        this.TENSP = TENSP;
        this.PHANLOAI = PHANLOAI;
        this.NOINHAP = NOINHAP;
        this.NOIDUNG = NOIDUNG;
        this.SOLUONG = SOLUONG;
        this.HINHANH = HINHANH;
        this.DONGIA = DONGIA;
    }


    public String getMASP() {
        return MASP;
    }

    public void setMASP(String MASP) {
        this.MASP = MASP;
    }

    public String getTENSP() {
        return TENSP;
    }

    public void setTENSP(String TENSP) {
        this.TENSP = TENSP;
    }

    public String getPHANLOAI() {
        return PHANLOAI;
    }

    public void setPHANLOAI(String PHANLOAI) {
        this.PHANLOAI = PHANLOAI;
    }

    public String getNOINHAP() {
        return NOINHAP;
    }

    public void setNOINHAP(String NOINHAP) {
        this.NOINHAP = NOINHAP;
    }

    public String getNOIDUNG() {
        return NOIDUNG;
    }

    public void setNOIDUNG(String NOIDUNG) {
        this.NOIDUNG = NOIDUNG;
    }

    public Integer getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(Integer SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public Integer getHINHANH() {
        return HINHANH;
    }

    public void setHINHANH(Integer HINHANH) {
        this.HINHANH = HINHANH;
    }

    public Long getDONGIA() {
        return DONGIA;
    }

    public void setDONGIA(Long DONGIA) {
        this.DONGIA = DONGIA;
    }

}
