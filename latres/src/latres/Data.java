package latres;

public class Data {
    private String nama;
    private String no_telp;
    private String keterangan;

    public Data(String nama,String no_telp,String keterangan){
        this.nama = nama;
        this.no_telp = no_telp;
        this.keterangan = keterangan;
    }

    public String getNama() {
        return nama;
    }

    public String getNo_telp() {
        return no_telp;
    }
    
    public String getKeterangan() {
        return keterangan;
    }

}
