package BUS;

import java.util.*;

public class PHIEUTHU
{
    private int id;
    Date date = new Date();
    private int tongTien;
    
    public PHIEUTHU(int id, int tongtien, Date date)
    {
        this.id = id;
        this.tongTien = tongtien;
        this.date = date;
    }

    public int getID() {return id;}
    public int getTongtien() {return tongTien;}
    public Date getDate() {return date;}

    public void setID(int id) {this.id = id;}
    public void setTongtien(int tienChi) {this.tongTien = tienChi;}
    public void setDate(Date date) {this.date = date;}
    
    @Override
    public String toString()
    {
        String d = null;
        if (date.getDate() < 10) d = "0" + String.valueOf(date.getDate());
        else d = String.valueOf(date.getDate());
        String m = null;
        if (date.getMonth() < 10) m = "0" + String.valueOf(date.getMonth() + 1);
        else m = String.valueOf(date.getMonth() + 1);
        String result = d + "/" + m + "/" + String.valueOf(date.getYear() + 1900);
        return result;
    }
}
