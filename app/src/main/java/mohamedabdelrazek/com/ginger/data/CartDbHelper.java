package mohamedabdelrazek.com.ginger.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mohamedabdelrazek.com.ginger.User;

/**
 * Created by Mohamed AbdelraZek on 4/3/2017.
 */

public class CartDbHelper {


    public static final String EMP_PHOTO = "photo";

    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "EmployessDB.db";
    private static final int DATABASE_VERSION = 1;

    private static final String USER_TABLE = "Users";

    private static final String CREATE_EMPLOYEES_TABLE = "create table "
            + USER_TABLE + " ( " + EMP_PHOTO
            + "  blob not null );";

    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_EMPLOYEES_TABLE);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
            onCreate(db);
        }
    }

    public void Reset() {
        mDbHelper.onUpgrade(this.mDb, 1, 1);
    }

    public CartDbHelper(Context ctx) {
        mCtx = ctx;
        mDbHelper = new DatabaseHelper(mCtx);
    }

    public CartDbHelper open() throws SQLException {
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public void insertUser(User user) {
        ContentValues cv = new ContentValues();
        cv.put(EMP_PHOTO, Utility.getBytes(user.getBitmap()));

        mDb.insert(USER_TABLE, null, cv);
    }

    public ArrayList<byte[]> retrieveUserDetails() throws SQLException {
        ArrayList<byte[]> users = new ArrayList<>();
        Cursor cur = mDb.query(true, USER_TABLE, new String[]{EMP_PHOTO,}, null, null, null, null, null, null);
        cur.moveToFirst();
        while (cur.moveToNext()) {
            byte[] blob = cur.getBlob(cur.getColumnIndex(EMP_PHOTO));
            users.add(blob);
        }
        cur.close();
        return users;
    }
}
