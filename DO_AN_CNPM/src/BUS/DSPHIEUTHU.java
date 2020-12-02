package BUS;

import DAO.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DSPHIEUTHU
{
    private ArrayList<PHIEUTHU> list = new ArrayList<>();
    
    public DSPHIEUTHU()
    {
        this.importDS();
    }

    public ArrayList<PHIEUTHU> getList() {return this.list;}
    
    private void importDS()
    {
        ResultSet res;
        res = DAO.select("*","PHIEUTHU",null);
        try
        {
            while (res.next())
            {
                this.list.add(new PHIEUTHU(res.getInt(1), res.getInt(3), res.getDate(2)));
            }
        }
        catch (SQLException ex) {}
    }
    
    public ArrayList<PHIEUTHU> importDS_theothang(int month, int year)
    {
        ResultSet res;
        res = DAO.select("*","PHIEUTHU","month(ngaythu) = " + month + " and year(ngaythu) = " + year);
        ArrayList<PHIEUTHU> dsthang = new ArrayList<>();
        try
        {
            while (res.next())
            {
                dsthang.add(new PHIEUTHU(res.getInt(1), res.getInt(3), res.getDate(2)));
            }
        }
        catch (SQLException ex) {}
        return dsthang;
    }
    
    public void add(int tongtien, Date date)
    {
        int day = date.getDate();
        int month = date.getMonth() + 1;
        int year = date.getYear() + 1900;
        String date_format = String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(day);
        String str = String.format("'" + tongtien + "','" 
                + date_format + "'");
        DAO.insert("PHIEUTHU", "tongtien, ngaythu", str);
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
        String str = String.format("idPT = " + id);
        DAO.delete("PHIEUTHU", str);
    }
    
    public void update(int id, int tongtien, Date date)
    {
        for (int i = 0; i < this.list.size(); i++)
        {
            if (this.getList().get(i).getID() == id)
            {
                this.getList().get(i).setDate(date);
                this.getList().get(i).setTongtien(tongtien);
                break;
            }
        }
        int day = date.getDate();
        int month = date.getMonth() - 1;
        int year = date.getYear() + 1900;
        String date_format = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
        String str = "tongtien = '" + tongtien + "', ngaythu = '" + date_format + "'";
        DAO.update("PHIEUTHU", str, "idPT = " + id);
    }
    
    public ArrayList<PHIEUTHU> searchID(int id)
    {
        ArrayList<PHIEUTHU> result = new ArrayList<PHIEUTHU>();
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
    
    public ArrayList<PHIEUTHU> searchDATE(Date date)
    {
        ArrayList<PHIEUTHU> result = new ArrayList<>();
        
        String d = null;
        if (date.getDate() < 10) d = "0" + String.valueOf(date.getDate());
        else d = String.valueOf(date.getDate());
        String m = null;
        if (date.getMonth() < 10) m = "0" + String.valueOf(date.getMonth());
        else m = String.valueOf(date.getMonth());
        String str = d + "/" + m + "/" + String.valueOf(date.getYear());
        
        for (int i = 0; i < this.list.size(); i++)
        {
            if (this.list.get(i).toString().equals(str) == true)
                result.add(this.list.get(i));
        }
        
        return result;
    }
    
    
    
    
    public void test(ArrayList<PHIEUTHU> test)
    {
        for (int i = 0; i < test.size(); i++)
        {
            System.out.print(test.get(i).getID() + " == ");
            System.out.print(test.get(i).getTongtien()+ " == ");
            System.out.print(test.get(i).getDate().toString() + "\n");
        }
    }
}
