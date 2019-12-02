package com.example.montasar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class Connect extends SQLiteOpenHelper {

    public Connect(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.queryData("CREATE TABLE IF NOT EXISTS VOYAGE(Id INTEGER PRIMARY KEY AUTOINCREMENT, designation VARCHAR, continant VARCHAR, image BLOB, superficie DOUBLE)");
    }

    public void queryData(String sql)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public void insertTravel(Voyage voyage)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into voyage values(null, ?, ?, ?, ?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, voyage.getDesignation());
        statement.bindString(2, voyage.getContinant());
        statement.bindBlob(3, voyage.getImage());
        statement.bindDouble(4, voyage.getSuperficie());

        statement.executeInsert();
    }

    public Cursor getVoyage(String sql)
    {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    public static void deleteDestination(SQLiteDatabase database, int id)
    {
        database.execSQL("DELETE FROM Voyage Where id = ?",
                new Object[]{id});
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
