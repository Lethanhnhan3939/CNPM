package BUS;

import DAO.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DSHOADON
{
    private ArrayList<HOADON> list = new ArrayList<>();
    
    public DSHOADON()
    {
        this.importDS();
    }

    public ArrayList<HOADON> getList() {return this.list;}
    
    private void importDS()
    {
        ResultSet res;
        res = DAO.select("*", "HOADON", null);
        try
        {
            while (res.next())
            {
                this.list.add(new HOADON(res.getInt(1), res.getInt(2), res.getInt(3), res.getDate(4)));
            }
        }
        catch (SQLException ex) {}
    }
    
    public ArrayList<HOADON> importDS_theothang(int month, int year)
    {
        ResultSet res;
        res = DAO.select("*", "HOADON", "month(ngay) = " + month + " and year(ngay) = " + year);
        ArrayList<HOADON> dsthang = new ArrayList<>();
        try
        {
            while (res.next())
            {
                dsthang.add(new HOADON(res.getInt(1), res.getInt(2), res.getInt(3), res.getDate(4)));
            }
        }
        catch (SQLException ex) {}
        return dsthang;
    }
    
    public void add(int idNV, int tongtien, Date date)
    {
        int day = date.getDate();
        int month = date.getMonth() + 1;
        int year = date.getYear() + 1900;
        String date_format = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
        String time_format = String.valueOf(date.getHours()) + ":" + String.valueOf(date.getMinutes()) + ":" + String.valueOf(date.getSeconds());
        String str = String.format("'" + idNV + "','" + tongtien + "','" 
                + date_format + "T" + time_format + "'");
        DAO.insert("HOADON", "idNV, tongtien, ngay", str);
        this.list.clear();
        this.importDS();
    }
    
    public void delete(int id)
    {
        for (int i = 0; i < this.list.size(); i++)
        {
            if (this.list.get(i).getID() == id)
            {
                this.list.remove(i);
                break;
            }
        }
        String str1 = String.format("idHD = " + id);
        DAO.delete("HOADON", str1);
        
        DSCTHOADON ds = new DSCTHOADON();
        for (int i = 0; i < ds.getList().size(); i++)
        {
            if (ds.getList().get(i).getIDHD() == id)
            {
                ds.getList().remove(i);
            }
        }
        String str2 = String.format("idHD = " + id);
        DAO.delete("CTHOADON", str2);
    }
    
    public ArrayList<HOADON> searchID(int id)
    {
        ArrayList<HOADON> result = new ArrayList<HOADON>();
        for (int i = 0; i < this.list.size(); i++)
        {
            if (this.list.get(i).getID() == id)
            {
                result.add(this.list.get(i));
                break;
            }
        }
        return result;
    }
    
    public ArrayList<HOADON> nhap(Date date1, Date date2)
    {
        ArrayList<HOADON> result = new ArrayList<>();
        if (date1.compareTo(date2) < 0)
        {
            Date temp = date2;
            date2 = date1;
            date1 = temp;
        }
        
        if (date1.compareTo(date2) == 0)
            for (int i = 0; i < this.list.size(); i++)
            {
                if (this.list.get(i).getDate().compareTo(date1) == 0)
                {
                    result.add(this.list.get(i));
                }
            }
        else
            for (int i = 0; i < this.list.size(); i++)
            {
                if (this.list.get(i).getDate().compareTo(date1) >= 0 &&
                        this.list.get(i).getDate().compareTo(date2) <= 0)
                {
                    result.add(this.list.get(i));
                }
            }
        return result;
    }
    
    public ArrayList<HOADON> searchDATE(Date date)
    {
        ArrayList<HOADON> result = new ArrayList<>();
        String d = null;
        if (date.getDate() < 10) d = "0" + String.valueOf(date.getDate());
        else d = String.valueOf(date.getDate());
        String m = null;
        if (date.getMonth() < 10) m = "0" + String.valueOf(date.getMonth());
        else m = String.valueOf(date.getMonth());
        String str = d + "/" + m + "/" + String.valueOf(date.getYear());;
        
        for (int i = 0; i < this.list.size(); i++)
        {
            if (this.list.get(i).toString().equals(str) == true)
                result.add(this.list.get(i));
        }
        
        return result;
    }
    
    
    
    
    
    
    public void test(ArrayList<HOADON> test)
    {
        for (int i = 0; i < test.size(); i++)
        {
            System.out.print(test.get(i).getID() + " == ");
            System.out.print(test.get(i).getIDNV() + " == ");
            System.out.print(test.get(i).getTongtien()+ " == ");
            System.out.print(test.get(i).getDate().toString() + "\n");
        }
    }
}
