package com.example.tugasmobile8020190013;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyBDhelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "motor.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "motor";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_MEREK = "merek";
    private static final String COLUMN_JENIS = "jenis";
    private static final String COLUMN_HARGA = "harga";

    public MyBDhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MEREK + " TEXT, " +
                COLUMN_JENIS + " TEXT, " +
                COLUMN_HARGA + " INTEGER " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    void tambahbuku(String merek, String jenis, int harga ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_MEREK, merek);
        cv.put(COLUMN_JENIS, jenis);
        cv.put(COLUMN_HARGA, harga);

        long result = db.insert(TABLE_NAME, null, cv);

        if (result==-1){
            Toast.makeText(context, "data gagal ditambahkan!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"data berhasil ditambahkan",Toast.LENGTH_SHORT).show();
        }
    }
    Cursor bacasemuadata()
    {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor datasaya = null;
        if (db != null)
        {
            datasaya = db.rawQuery(query,null);
        }
        return datasaya;
    }
    void ubahmotor(String baris_id, String merek, String jenis, String harga){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues datakita = new ContentValues();
        datakita.put(COLUMN_MEREK,merek);
        datakita.put(COLUMN_JENIS,jenis);
        datakita.put(COLUMN_HARGA,harga);

        long hasil = db.update(TABLE_NAME, datakita, "_id=?", new String[]{baris_id});

        if (hasil==-1)
        {
            Toast.makeText(context,"ada gangguan",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"berhasil diupdate",Toast.LENGTH_SHORT).show();
        }
    }
    void hapusbuku(String row_id){
        SQLiteDatabase dbkita = this.getReadableDatabase();
        long result = dbkita.delete(TABLE_NAME,"_id=?",new String[]{row_id});

        if(result==-1){
            Toast.makeText(context,"Gagal menghapus",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context,"berhasil dihapus",Toast.LENGTH_SHORT).show();
        }
    }
}

