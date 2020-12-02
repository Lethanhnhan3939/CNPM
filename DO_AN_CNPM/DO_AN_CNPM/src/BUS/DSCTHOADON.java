package BUS;

import DAO.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DSCTHOADON
{
    ArrayList<CTHOADON> list = new ArrayList<>();
    
    public DSCTHOADON()
    {
        this.importDS();
    }

    public ArrayList<CTHOADON> getList() {return list;}
    
    private void importDS()
    {
        ResultSet res;
        res = DAO.select("*","CTHOADON",null);
        try
        {
            while (res.next())
            {
                this.list.add(new CTHOADON(res.getInt(1), res.getInt(2), res.getInt(3)));
            }
        }
        catch (SQLException ex) {}
    }
    
    public void add(int idHD, int idMA, int soluong)
    {
        String str = String.format("'" + idHD + "','" + idMA + "','" + soluong + "'");
        DAO.insert("CTPHIEUCHI", "idHD, idMA, soluong", str);
        this.list.clear();
        this.importDS();
    }
}
