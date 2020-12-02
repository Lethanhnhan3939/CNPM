package BUS;

import DAO.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DSPHIEUCHI
{
    private ArrayList<PHIEUCHI> list = new ArrayList<>();
    
    public DSPHIEUCHI()
    {
        this.importDS();
    }

    public ArrayList<PHIEUCHI> getList() {return list;}
    public void setList(ArrayList<PHIEUCHI> list) {this.list = list;}
    
    private void importDS()
    {
        ResultSet res;
        res = DAO.select("*","PHIEUCHI",null);
        try
        {
            while (res.next())
            {
                this.list.add(new PHIEUCHI(res.getInt(1), res.getDate(2), res.getInt(3), res.getString(4)));
            }
        }
        catch (SQLException ex) {}
    }
    
    public ArrayList<PHIEUCHI> importDS_theothang(int month, int year)
    {
        ResultSet res;
        res = DAO.select(
                "*",
                "PHIEUCHI",
                "month(thoigian) = " + month + " and year(thoigian) = " + year);
        ArrayList<PHIEUCHI> dsthang = new ArrayList<>();
        try
        {
            while (res.next())
            {
                dsthang.add(new PHIEUCHI(res.getInt(1), res.getDate(2), res.getInt(3), res.getString(4)));
            }
        }
        catch (SQLException ex) {}
        return dsthang;
    }
    
    public void add(Date date, int sotien, String ghichu)
    {
        int day = date.getDate();
        int month = date.getMonth() + 1;
        int year = date.getYear() + 1900;
        String date_format = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
        String time_format = String.valueOf(date.getHours()) + ":" + String.valueOf(date.getMinutes()) + ":" + String.valueOf(date.getSeconds());
        String str = String.format("'" + date_format + "T" + time_format + "','" + sotien + "','" + ghichu + "'");
        DAO.insert("PHIEUCHI", "thoigian, tongtien, ghichu", str);
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
        String str1 = String.format("idPC = " + id);
        DAO.delete("PHIEUCHI", str1);
        
        DSCTPHIEUCHI ds = new DSCTPHIEUCHI();
        for (int i = 0; i < ds.getList().size(); i++)
        {
            if (ds.getList().get(i).getIDPC() == id)
            {
                ds.getList().remove(i);
            }
        }
        String str2 = String.format("idPC = " + id);
        DAO.delete("CTPHIEUCHI", str2);
    }
    
    public ArrayList<PHIEUCHI> searchID(int id)
    {
        ArrayList<PHIEUCHI> result = new ArrayList<PHIEUCHI>();
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
    
    
    public ArrayList<PHIEUCHI> searchDATE(Date date)
    {
        ArrayList<PHIEUCHI> result = new ArrayList<>();
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
    
    
    
    
    public void test(ArrayList<PHIEUCHI> test)
    {
        for (int i = 0; i < test.size(); i++)
        {
            System.out.print(test.get(i).getID() + " == ");
            System.out.print(test.get(i).getDate().toString() + " == ");
            System.out.print(test.get(i).getSotien() + " == ");
            System.out.print(test.get(i).getGhiChu() + "\n");
        }
    }
}
