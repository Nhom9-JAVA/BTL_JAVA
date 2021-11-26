/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltdModel;

/**
 *
 * @author Gia Thinh
 */
public class ThongKe {
    private KhachHang kh;
    private ThongTinCaNhan ttcn;
    private DienKe dk;
    private HoaDon hd;
    
    
    public ThongKe(){
        
    }

    public ThongKe(KhachHang kh, ThongTinCaNhan ttcn, DienKe dk, HoaDon hd) {
        this.kh = kh;
        this.ttcn = ttcn;
        this.dk = dk;
        this.hd = hd;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public ThongTinCaNhan getTtcn() {
        return ttcn;
    }

    public void setTtcn(ThongTinCaNhan ttcn) {
        this.ttcn = ttcn;
    }

    public DienKe getDk() {
        return dk;
    }

    public void setDk(DienKe dk) {
        this.dk = dk;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    
    
    

}
