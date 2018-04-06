package com.example.pane.novcanik.Baza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pane on 2/12/2018.
 */

public class BazaPodataka extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "baza";


    private static final String TABLE_PRIHOD = "prihod";
    private static final String PRIHOD_ID_IZNOS = "id";
    private static final String PRIHOD_OPIS = "opis";
    private static final String PRIHOD_VREDNOST = "vrednost";
    private static final String PRIHOD_NALOG = "nalog";

    private static final String TABLE_RASHOD = "rashod";
    private static final String RASHOD_ID_IZNOS = "id";
    private static final String RASHOD_OPIS = "opis";
    private static final String RASHOD_VREDNOST = "vrednost";
    private static final String RASHOD_NALOG = "nalog";


    private static final String TABLE_NALOG = "nalozi";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DUG = "dug";

    public BazaPodataka(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_NALOG_TABLE = "CREATE TABLE " + TABLE_NALOG + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_DUG + " LONG" + ")";
        sqLiteDatabase.execSQL(CREATE_NALOG_TABLE);


        String CREATE_PRIHOD_TABLE = "CREATE TABLE " + TABLE_PRIHOD + "("
                + PRIHOD_ID_IZNOS + " INTEGER PRIMARY KEY,"+ PRIHOD_OPIS + " TEXT,"
                + PRIHOD_VREDNOST + " LONG" + ")";
        sqLiteDatabase.execSQL(CREATE_PRIHOD_TABLE);

        String CREATE_RASHOD_TABLE = "CREATE TABLE " + TABLE_RASHOD + "("
                + RASHOD_ID_IZNOS + " INTEGER PRIMARY KEY,"+ RASHOD_OPIS + " TEXT,"
                + RASHOD_VREDNOST + " LONG" + ")";
        sqLiteDatabase.execSQL(CREATE_RASHOD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NALOG);
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PRIHOD);
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_RASHOD);
        onCreate(sqLiteDatabase);
    }
    public void dodajPrihod(Prihod p){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PRIHOD_OPIS, p.getOpis());
        values.put(PRIHOD_VREDNOST, p.getIznos());
        values.put(PRIHOD_NALOG, p.getIdNaloga());

        db.insert(TABLE_PRIHOD, null, values);
        db.close(); // Closing database connection
    }

    public void dodajRashod(Rashod r){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(RASHOD_OPIS, r.getOpis());
        values.put(RASHOD_VREDNOST, r.getIznos());
        values.put(RASHOD_NALOG, r.getIdNaloga());

        db.insert(TABLE_PRIHOD, null, values);
        db.close(); // Closing database connection
    }

    public Prihod vratiPrihod(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PRIHOD, new String[] { PRIHOD_ID_IZNOS,
                        PRIHOD_OPIS, PRIHOD_VREDNOST, PRIHOD_NALOG}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Prihod p=new Prihod(Integer.parseInt(cursor.getString(0)),cursor.getString(1),Long.parseLong(cursor.getString(2)),Integer.parseInt(cursor.getString(3)));
        return p;
    }

    public Rashod vratiRashod(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_RASHOD, new String[] { RASHOD_ID_IZNOS,
                        RASHOD_OPIS, RASHOD_VREDNOST,RASHOD_NALOG}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Rashod r=new Rashod(Integer.parseInt(cursor.getString(0)),cursor.getString(1),Long.parseLong(cursor.getString(2)),Integer.parseInt(cursor.getString(3)));
        return r;
    }
    public void dodajNalog(Nalog nalog) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, nalog.get_ime());
        values.put(KEY_DUG, nalog.get_dug());

        db.insert(TABLE_NALOG, null, values);
        db.close(); // Closing database connection
    }
    public Nalog vratiNalog(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NALOG, new String[] { KEY_ID,
                        KEY_NAME, KEY_DUG }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Nalog nalog = new Nalog(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Long.parseLong(cursor.getString(2)));

        return nalog;
    }
    public List<Nalog> vratiSveNalog() {
        List<Nalog> listaNaloga = new ArrayList<Nalog>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NALOG;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Nalog nalog = new Nalog();
                nalog.set_id(Integer.parseInt(cursor.getString(0)));
                nalog.set_ime(cursor.getString(1));
                nalog.set_dug(Long.parseLong(cursor.getString(2)));
                // Adding contact to list
                listaNaloga.add(nalog);
            } while (cursor.moveToNext());
        }

        // return contact list
        return listaNaloga;
    }
    public void obrisiNalog(Nalog nalog) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NALOG, KEY_ID + " = ?",
                new String[] { String.valueOf(nalog.get_id()) });
        db.close();
    }

    public int izmeniNaloga(Nalog nalog) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, nalog.get_ime());
        values.put(KEY_DUG, nalog.get_dug());

        // updating row
        return db.update(TABLE_NALOG, values, KEY_ID + " = ?",
                new String[] { String.valueOf(nalog.get_id()) });
    }
}
