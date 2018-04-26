package id.playable.autentikasicrudandroid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandoseptianhusni on 4/12/18.
 */

public class MahasiswadbHelper extends SQLiteOpenHelper {

    //create nama database
    private static final String DB_NAME = "db_makanan";

    private static final int DB_VERSION = 1;


    public MahasiswadbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //membuat table sesuai query yang di bkin di class makanan tadi
        db.execSQL(Mahasiswa.CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + Mahasiswa.TABLE_NAME);

        onCreate(db);


    }

    public void inserMakanan(String name, String price, String restoran) {
        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Mahasiswa.NAME, name);
        values.put(Mahasiswa.ALAMAT, price);
        values.put(Mahasiswa.NOHP, restoran);


// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Mahasiswa.TABLE_NAME, null, values);

        db.close();
    }

    //ini method untuk ambil array dari database local
    public List<Mahasiswa> getMahasiswa() {

        SQLiteDatabase db = this.getWritableDatabase();

        //set query ambil data
        String q = "SELECT * FROM " + Mahasiswa.TABLE_NAME;

        //eksekusi query nya
        Cursor hasil = db.rawQuery(q, null);

        //bikin array untuk angkut data yang ambil dari database local
        ArrayList<Mahasiswa> makan = new ArrayList<>();

        //deklrasi object makanan biar set makanan


        while (hasil.moveToNext()) {
            Mahasiswa m = new Mahasiswa();

            //waktu proses masing2 data ke masukkan ke objext makanan

            m.setId(hasil.getInt(hasil.getColumnIndex(Mahasiswa.ID)));
            m.setName(hasil.getString(hasil.getColumnIndex(Mahasiswa.NAME)));
            m.setAlamat(hasil.getString(hasil.getColumnIndex(Mahasiswa.ALAMAT)));
            m.setNohp(hasil.getString(hasil.getColumnIndex(Mahasiswa.NOHP)));
            makan.add(m);


        }
        hasil.close();

        return makan;
    }

    public int updateMahasiswa(Mahasiswa mahasiswa) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Mahasiswa.ALAMAT,mahasiswa.getAlamat());
        values.put(Mahasiswa.NOHP,mahasiswa.getNohp());

        // updating row
        return db.update(Mahasiswa.TABLE_NAME, values, Mahasiswa.ID + " = ?",
                new String[]{String.valueOf(mahasiswa.getId())});
    }

    public void deleteMahasiswa(Mahasiswa mahasiswa) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Mahasiswa.TABLE_NAME, Mahasiswa.ID + " = ?",
                new String[]{String.valueOf(mahasiswa.getId())});
        db.close();
    }
}