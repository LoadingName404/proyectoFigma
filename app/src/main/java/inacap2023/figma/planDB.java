package inacap2023.figma;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class planDB {
    private final String DATABASE_NAME = "PLANES_DB";
    private final String DATABASE_TABLE = "PLANES";
    private final int DATABASE_VERSION = 1;

    private static final String KEY_ID = "_id";
    private static final String KEY_NOMBRE = "_nombre";
    private static final String KEY_DESCRIPCION = "_descripcion";

    private DBHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    public planDB(Context c) {
        ourContext = c;
    }

    public planDB open() {
        this.ourHelper = new DBHelper(ourContext);
        this.ourDatabase = this.ourHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.ourHelper.close();
    }

    public ArrayList<plan> getPlanes() {
        String[] columns = new String[] {KEY_ID, KEY_NOMBRE, KEY_DESCRIPCION};
        Cursor c = this.ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);

        ArrayList<plan> result = new ArrayList<plan>();

        int iId = c.getColumnIndex(KEY_ID);
        int iNombre = c.getColumnIndex(KEY_NOMBRE);
        int iDescripcion = c.getColumnIndex(KEY_DESCRIPCION);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            String id = c.getString(iId);
            String nombre = c.getString(iNombre);
            String descripcion = c.getString(iDescripcion);

            plan p = new plan(id, nombre, descripcion);
            result.add(p);
        }
        c.close();
        return result;
    }

    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE " + DATABASE_TABLE + "(" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_NOMBRE + " TEXT NOT NULL, " +
                    KEY_DESCRIPCION + " TEXT NOT NULL);";

            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
            onCreate(db);
        }
    }
}
