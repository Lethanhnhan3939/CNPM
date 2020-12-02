package BUS;

import DAO.DAO;
import java.sql.*;
import java.util.ArrayList;

public class DSNCC
{
    private ArrayList<NCC> list = new ArrayList<>();
    
    public DSNCC()
    {
        this.importDS();
    }

    public ArrayList<NCC> getList() {return list;}
    public void setList(ArrayList<NCC> list) {this.list = list;}
    
    private void importDS()
    {
        ResultSet res;
        res = DAO.select("*","NCC",null); //select * from NCC 
        try
        {
            while (res.next())
            {
                this.list.add(new NCC(res.getInt(1), res.getString(2), res.getString(3)));
            }
        }
        catch (SQLException ex) {}
    }
    
    public void add(String name, String SDT)
    {
        String str =String.format("N'" + name + "','" + SDT + "'");
        DAO.insert("NCC", "tenNCC,sdt", str);
        this.list.clear();
        this.importDS();
    }
    
    public boolean delete(int id)
    {
        //Kiểm tra có tồn tại idNCC trong DSNGUYENLIEU không
        DSNGUYENLIEU ds = new DSNGUYENLIEU();
        for (int i = 0; i < ds.getList().size(); i++)
        {
            if (ds.getList().get(i).getIdNCC() == id)
            {
                //Nếu có thì trả về false
                return false;
            }
            else
            {
                //Nếu không thì xóa NCC dó trong ArrayList và Database
                for (int j = 0; j < this.list.size(); j++)
                {
                    if (this.list.get(j).getID() == id)
                    {
                        this.list.remove(j);
                        break;
                    }
                }
                String str = String.format("idNCC = " + id);
                DAO.delete("NCC", str);
            }
        }
        return true;
    }
    
    public void update(int id, String name, String SDT)
    {
        for (int i = 0; i < this.list.size(); i++)
        {
            if (this.list.get(i).getID() == id)
            {
                this.list.get(i).setName(name);
                this.list.get(i).setSdt(SDT);
                break;
            }
        }
        String str = "tenNCC = N'" + name + "', sdt = '" + SDT + "'";
        System.out.println(str);
        DAO.update("NCC", str, "idNCC = " + id);
    }
    
    public ArrayList<NCC> search(String str)
    {
        ArrayList<NCC> result = new ArrayList<>();
        String s = "tenNCC LIKE N'%" + str + "%' or sdt LIKE N'%" + str + "%' or idNCC LIKE N'%" + str + "%'"; 
        
        try
        {
            ResultSet res;
            res= DAO.select("*", "NCC", s);
            while (res.next())
            {
                result.add(new NCC(res.getInt(1), res.getString(2), res.getString(3)));
            }
        }
        catch (SQLException ex) {System.out.print("Error"+ex);}
        return result;
    }
    

    
    public void test(ArrayList<NCC> kq)
    {
        for (int i = 0; i < kq.size(); i++)
        {
            System.out.print(kq.get(i).getID() + " == ");
            System.out.print(kq.get(i).getName() + " == ");
            System.out.print(kq.get(i).getSdt() + "\n");
        }
    }
}
