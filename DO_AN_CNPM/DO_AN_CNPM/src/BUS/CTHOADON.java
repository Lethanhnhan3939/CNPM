package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

public class CTHOADON
{
    private int IDHD;
    private int IDMA;
    private int soluong;
    
    private String monan;
    ArrayList list = new ArrayList();
    
    
    public CTHOADON(int IDHD, int IDMA, int soluong)
    {
        this.IDHD = IDHD;
        this.IDMA = IDMA;
        this.soluong = soluong;
    }

    public int getIDHD() {return IDHD;}
    public int getIDMA() {return IDMA;}
    public int getSoluong() {return soluong;}

    public void setIDHD(int IDHD) {this.IDHD = IDHD;}
    public void setIDMA(int IDMA) {this.IDMA = IDMA;}
    public void setSoluong(int soluong) {this.soluong = soluong;}
}
