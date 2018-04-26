package id.playable.autentikasicrudandroid.database;

/**
 * Created by nandoseptianhusni on 4/12/18.
 */
//TODO 1 bikin table dan object penyimpanan

public class Mahasiswa {


    //delrasi nama field table
    public static final String TABLE_NAME = "makanan";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ALAMAT = "alamat";
    public static final String NOHP = "nohp";

    public Mahasiswa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    int id ;
    String name,alamat,nohp ;


    public static final  String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    NAME + " TEXT," +
                    ALAMAT + " TEXT," +
                    NOHP +" TEXT )" ;








}
