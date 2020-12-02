package BUS;

public class NCC
{
    private int id;
    private String name;
    private String sdt;
    //private String diachi;

    public NCC(int id, String name, String sdt)
    {
        this.id = id;
        this.name = name;
        this.sdt = sdt;
    }

    public int getID() {return id;}
    public String getName() {return name;}
    public String getSdt() {return sdt;}
    //public String getDiachi() {return diachi;}

    public void setID(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setSdt(String sdt) {this.sdt = sdt;}
    //public void setDiachi(String diachi) {this.diachi = diachi;}
    
    @Override
    public String toString()
    {
        return this.name;
    }
}
