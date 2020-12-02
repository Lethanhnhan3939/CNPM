package BUS;

import DAO.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class test
{
    public static void main(String[] args)
    {
        
        /*DSPHIEUCHI ds = new DSPHIEUCHI();
        Date date1 = new Date();
        date1.setDate(1);
        date1.setMonth(9 + 1);
        date1.setYear(2019);
        Date date2 = new Date();
        date2.setDate(1);
        date2.setMonth(11 + 1);
        date2.setYear(2019);
        for (int i = 0; i < ds.getList().size(); i++)
        {
            int check = ds.searchDATE(date1, date2).get(i).getID();
            System.out.println(check);
        }*/
        
        DSPHIEUTHU a = new DSPHIEUTHU();
        System.out.println(a.getList().size());
        a.test(a.getList());
        Date date = new Date();
        date.setDate(23);
        date.setMonth(10 - 1);
        date.setYear(2018);
        //a.add(23000, date);
        //a.delete(11);
        a.update(4, 15000, date);
        System.out.println();
        a.test(a.getList());
    }
}
