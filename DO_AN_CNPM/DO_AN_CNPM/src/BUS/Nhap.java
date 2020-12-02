package BUS;

import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAO.DAO;

public class Nhap
{
    Scanner scan = new Scanner(System.in);
    private int n = 7;
    String[] danhsach = new String[this.n];

    public int getN(){return this.n;}
    public String[] getDanhsach() {return this.danhsach;}
    
    
    public void nhap()
    {
        System.out.print("Nhap so luong: ");
        this.n = scan.nextInt();
        scan.nextLine();
        
        for (int i = 0; i < this.n; i++)
        {
            this.danhsach[i] = scan.nextLine();
        }
    }
    
    public void timkiem()
    {
        System.out.print("Nhap tu: ");
        String str = scan.nextLine();
        int lenth = str.length();
        
        for (int i = 0; i < this.n; i++)
        {
            int k = 0;
            String upCaseStr = str.toUpperCase();
            String upCaseDS = this.danhsach[i].toUpperCase();
            
            for (int j = 0; j < upCaseDS.length(); j++)
            {
                if
                        (
                        (j == 0) ||
                        (upCaseDS.charAt(j-1) == ' ' && upCaseDS.charAt(j) != ' ')
                        )
                {
                    if (lenth <= upCaseDS.substring(j, upCaseDS.length()).length()) //kiểm tra độ dài chuỗi từ vị trí y đên cuối
                    {
                        String check = upCaseDS.substring(j, j + lenth);
                        if (check.equals(upCaseStr))
                        {
                            k++;
                            break;
                        }
                    }
                }
            }
            
            if (k > 0)
            System.out.print(this.danhsach[i] + "\n");
        }
    }
    
    public void timkiem_theo_tu_trong_chuoi(String str, String[] ds, int n)
    {
        int lenth = str.length();
        
        for (int i = 0; i < n; i++)
        {
            int k = 0;
            String upCaseStr = str.toUpperCase();
            String upCaseDS = ds[i].toUpperCase();
            
            for (int j = 0; j < upCaseDS.length(); j++)
            {
                if
                        (
                        (j == 0) ||
                        (upCaseDS.charAt(j-1) == ' ' && upCaseDS.charAt(j) != ' ')
                        )
                {
                    if (lenth <= upCaseDS.substring(j, upCaseDS.length()).length()) //kiểm tra độ dài chuỗi từ vị trí y đên cuối
                    {
                        String check = upCaseDS.substring(j, j + lenth);
                        if (check.equals(upCaseStr))
                        {
                            k++;
                            break;
                        }
                    }
                }
            }
            
            if (k > 0)
            System.out.print(ds[i] + "\n");
        }
    }
    
    public void timkiem_database(String str, String table, String search_options)
    {
        String condition = search_options + " LIKE N'%" + str + "%'";
        
        ResultSet res;
        res = DAO.select("*",table,condition);
        
        try {
            while (res.next()){
                System.out.format("%d %s %s %s \n",res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("sai");  
        }
    }
}


/*
vu
VU DUC HAU

*/