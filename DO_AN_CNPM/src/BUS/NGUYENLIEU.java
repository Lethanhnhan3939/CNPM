package BUS;

public class NGUYENLIEU
{
    private int id;
    private String name;
    private int idNCC;
    private String donvi;
    private int gia;
    
    public NGUYENLIEU(int id, String name, int idNCC, int gia, String donvi)
    {
        this.id = id;
        this.name = name;
        this.idNCC = idNCC;
        this.gia = gia;
        this.donvi = donvi;
    }

    public int getID() {return id;}
    public int getIdNCC() {return idNCC;}
    public String getName() {return name;}
    public int getGia() {return gia;}
    public String getDonvi() {return donvi;}

    public void setID(int id) {this.id = id;}
    public void setIdNCC(int idNCC) {this.idNCC = idNCC;}
    public void setName(String name) {this.name = name;}
    public void setGia(int gia) {this.gia = gia;}
    public void setDonvi(String donvi) {this.donvi = donvi;}
    
    @Override
    public String toString()
    {
        return this.name;
    }
}
