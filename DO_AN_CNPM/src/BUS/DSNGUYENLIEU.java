package BUS;

import DAO.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DSNGUYENLIEU
{
    private ArrayList<NGUYENLIEU> list = new ArrayList<>();
    
    public DSNGUYENLIEU()
    {
        this.importDS();
    }

    public ArrayList<NGUYENLIEU> getList() {return this.list;}
    public void setList(ArrayList<NGUYENLIEU> list) {this.list = list;}
    
     private void importDS()
    {
        ResultSet res;
        res = DAO.select("*","NGUYENLIEU",null); //select * from NCC 
        try
        {
            while (res.next())
            {
                this.list.add(new NGUYENLIEU(res.getInt(1), res.getString(2), res.getInt(4), res.getInt(3), res.getString(5)));
            }
        }
        catch (SQLException ex) {}
    }
    
    public void add(String name, int idNCC, int gia, String donvi)
    {
        String str =String.format("N'" + name + "','" + gia + "','" + idNCC + "',N'" + donvi + "'");
        DAO.insert("NGUYENLIEU", "tenNL, gia, idNCC, donvitinh", str);
        this.list.clear();
        this.importDS();
    }
    
    public boolean delete(int id)
    {
        //Kiểm tra có tồn tại idNCC trong DSNGUYENLIEU không
        DSCTPHIEUCHI ds = new DSCTPHIEUCHI();
        for (int i = 0; i < ds.getList().size(); i++)
        {
            if (ds.getList().get(i).getIDNL() == id)
            {
                //Nếu có thì trả về false
                return false;
            }
            else
            {
                //Nếu không thì xóa NGUYENLIEU dó trong ArrayList và Database
                for (int j = 0; j < this.list.size(); j++)
                {
                    if (this.list.get(j).getID() == id)
                    {
                        this.list.remove(j);
                        break;
                    }
                }
                String str = String.format("idNL = " + id);
                DAO.delete("NGUYENLIEU", str);
            }
        }
        return true;
    }
    
    public void update(int id, String name, int idNCC, int gia, String donvi)
    {
        for (int i = 0; i < this.list.size(); i++)
        {
            if (this.list.get(i).getID() == id)
            {
                this.list.get(i).setName(name);
                this.list.get(i).setIdNCC(idNCC);
                this.list.get(i).setGia(gia);
                this.list.get(i).setDonvi(donvi);
                break;
            }
        }
        String str = "tenNL = N'" + name + "', gia = '" + gia + "', idNCC = '" + idNCC + "', donvitinh = N'" + donvi +"'";
        DAO.update("NGUYENLIEU", str, "idNL = " + id);
    }
    
    public ArrayList<NGUYENLIEU> search(String str)
    {
        ArrayList<NGUYENLIEU> result = new ArrayList<>();
        String s = "NL.idNCC=NCC.idNCC AND (tenNL LIKE N'%" + str + "%' or idNL LIKE N'%" + str + "%' or NCC.tenNCC LIKE N'%"+ str +"%')"; 
        
        try
        {
            ResultSet res;
            res= DAO.select("idNL,tenNL,gia,NL.idNCC,donvitinh", "NGUYENLIEU NL, NCC", s);
            while (res.next())
            {
                result.add(new NGUYENLIEU(res.getInt(1), res.getString(2), res.getInt(4), res.getInt(3), res.getString(5)));
            }
        }
        catch (SQLException ex) {System.out.print("Error"+ex);}
        return result;
    }
    
    /*public ArrayList<NGUYENLIEU> search(String str)
    {
        int lenth = str.length();
        ArrayList<NGUYENLIEU> result = new ArrayList<>();
        for (int i = 0; i < this.list.size(); i++)
        {
            //Đồng bộ chuỗi theo kiểu chữ in
            String upCaseStr = str.toUpperCase();
            String upCaseDS = list.get(i).getName().toUpperCase();
            
            for (int j = 0; j < upCaseDS.length(); j++)
            {
                if //Kiểm tra ký tự đầu tiên trong từ
                        (
                        (j == 0) ||
                        (upCaseDS.charAt(j-1) == ' ' && upCaseDS.charAt(j) != ' ')
                        )
                {
                    if (lenth <= upCaseDS.substring(j, upCaseDS.length()).length()) //kiểm tra độ dài chuỗi từ vị trí j đên cuối
                    {
                        String check = upCaseDS.substring(j, j + lenth);
                        if (check.equals(upCaseStr))
                        {
                            result.add(list.get(i));
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }*/
    
    
    /*public ArrayList<NGUYENLIEU> search_ncc(String str)
    {
        int lenth = str.length();
        ArrayList<NGUYENLIEU> result = new ArrayList<>();
        DSNCC ncc = new DSNCC();
        for (int i = 0; i < ncc.getList().size(); i++)
        {
            //Đồng bộ chuỗi theo kiểu chữ in
            String upCaseStr = str.toUpperCase();
            String upCaseDS = ncc.getList().get(i).getName().toUpperCase();
            
            for (int j = 0; j < upCaseDS.length(); j++)
            {
                if //Kiểm tra ký tự đầu tiên trong từ
                        (
                        (j == 0) ||
                        (upCaseDS.charAt(j-1) == ' ' && upCaseDS.charAt(j) != ' ')
                        )
                {
                    if (lenth <= upCaseDS.substring(j, upCaseDS.length()).length()) //kiểm tra độ dài chuỗi từ vị trí j đên cuối
                    {
                        String check = upCaseDS.substring(j, j + lenth);
                        if (check.equals(upCaseStr))
                        {
                            //tra idNCC của hai bảng NGUYENLIEU và NCC
                            for (int k = 0; k < this.list.size(); k++)
                            {
                                if (ncc.getList().get(i).getId_NCC() == this.list.get(k).getIdNCC())
                                result.add(list.get(k));
                            }
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }*/
    
    

    
    public void test(ArrayList<NGUYENLIEU> test)
    {
        for (int i = 0; i < test.size(); i++)
        {
            System.out.print(test.get(i).getID() + " == ");
            System.out.print(test.get(i).getName() + " == ");
            
            DSNCC ncc = new DSNCC();
            for (int j = 0; j < ncc.getList().size(); j++)
            {
                if (test.get(i).getIdNCC() == ncc.getList().get(j).getID())
                {
                    System.out.print(ncc.getList().get(j).getName() + " == ");
                    break;
                }
            }
            
            System.out.print(test.get(i).getGia() + "/");
            System.out.print(test.get(i).getDonvi());
            System.out.print("\n");
        }
    }
}
