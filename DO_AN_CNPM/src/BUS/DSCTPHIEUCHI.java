package BUS;

import DAO.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DSCTPHIEUCHI
{
    private ArrayList<CTPHIEUCHI> list = new ArrayList<>();

    public DSCTPHIEUCHI()
    {
        this.importDS();
    }
    
    public ArrayList<CTPHIEUCHI> getList() {return this.list;}
    public void setList(ArrayList<CTPHIEUCHI> list) {this.list = list;}
    
    private void importDS()
    {
        ResultSet res;
        res = DAO.select("*","CTPHIEUCHI",null);
        try
        {
            while (res.next())
            {
                this.list.add(new CTPHIEUCHI(res.getInt(1), res.getInt(2), res.getInt(3)));
            }
        }
        catch (SQLException ex) {}
    }
    
    public void add(int idPC, int idNL, int soluong)
    {
        String str = String.format("'" + idPC + "','" + idNL + "','" + soluong + "'");
        DAO.insert("CTPHIEUCHI", "idPC, idNL, soluong", str);
        this.list.clear();
        this.importDS();
    }
}
