package BUS;

import DAO.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class HOADON
{
    private int IDHD;
    private int IDNV;
    private int tongtien;
    private Date date = new Date();
    
    //Phần thêm
    ArrayList<String> list = new ArrayList<String>();
    private String tenNV;
    
    
    public HOADON(int idHD, int idNV, int tongtien, Date date) throws SQLException
    {
        this.IDHD = idHD;
        this.IDNV = idNV;
        this.tongtien = tongtien;
        this.date = date;
        
        ResultSet res = DAO.select("NHANVIEN.tenNV", "HOADON, NHANVIEN",
               "NHANVIEN.idNV = HOADON.idNV AND HOADON.idHD = " + idHD);
        try
        {
            while (res.next())
            {
                this.list.add(res.getString(1));
            }
        }
        catch (SQLException ex) {}
        this.tenNV = this.list.get(0);
    }

    public int getID() {return this.IDHD;}
    public int getIDNV() {return this.IDNV;}
    public int getTongtien() {return this.tongtien;}
    public Date getDate() {return this.date;}
    public String getTenNV() {return tenNV;}

    public void setID(int IDHD) {this.IDHD = IDHD;}
    public void setIDNV(int IDNV) {this.IDHD = IDNV;}
    public void setTongtien(int tongtien) {this.tongtien = tongtien;}
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