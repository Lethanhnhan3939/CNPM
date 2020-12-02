package BUS;

import java.util.*;

public class CTPHIEUCHI
{
    private int idPC;
    private int idNL;
    private int soLuong;
    
    public CTPHIEUCHI(int idPC, int idNL, int soluong)
    {
        this.idPC = idPC;
        this.idNL = idNL;
        this.soLuong = soluong;
    }

    public int getIDPC() {return idPC;}
    public int getIDNL() {return idNL;}
    public int getSoLuong() {return soLuong;}

    public void setIDPC(int idPC) {this.idPC = idPC;}
    public void setIDNL(int idNL) {this.idNL = idNL;}
    public void setSoLuong(int soLuong) {this.soLuong = soLuong;}
}
