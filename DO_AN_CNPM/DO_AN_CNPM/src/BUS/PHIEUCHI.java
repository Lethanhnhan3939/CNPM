package BUS;

import java.util.Date;

public class PHIEUCHI
{
    private int id;
    private Date date = new Date();
    private int sotien;
    private String ghichu;
    
    public PHIEUCHI (int id, Date date, int sotien, String ghichu)
    {
        this.id = id;
        this.date = date;
        this.sotien = sotien;
        this.ghichu = ghichu;
    }

    public int getID() {return id;}
    public Date getDate() {return date;}
    public int getSotien() {return sotien;}
    public String getGhiChu() {return ghichu;}

    public void setID(int id) {this.id = id;}
    public void setDate(Date date) {this.date = date;}
    public void setSotien(int sotien) {this.sotien = sotien;}
    public void setGhiChu(String ghichu) {this.ghichu = ghichu;}
    
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
    public String getTimeText()
    {
        return this.date.getHours() + "h" + this.date.getMinutes() + "m" + this.date.getSeconds() + "s";
    }
}
