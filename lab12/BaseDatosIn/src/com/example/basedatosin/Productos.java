package com.example.basedatosin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Productos {
    public static final String CODPRO = "codigo";
    public static final String DESPRO = "descripcion";
    public static final String PREPRO = "precio";
    private static final String N_TABLA = "productos";
    private static final String N_BD = "Ventas.db";
    private static final int VERSION_BD = 1;

    private Creactua Control;
    private final Context nContexto;
    private static SQLiteDatabase pBD;

    private static class Creactua extends SQLiteOpenHelper {
        public Creactua(Context context) {
            super(context, N_BD, null, VERSION_BD);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + N_TABLA + " ( " + CODPRO
                    + " INTEGER PRIMARY KEY, " + DESPRO + " TEXT NOT NULL, "
                    + PREPRO + " DECIMAL(12,2) NOT NULL);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int av, int nv) { 
            db.execSQL("DROP TABLE IF EXISTS " + N_TABLA);
            onCreate(db);
        }
    }
    public Productos(Context c) {
        nContexto = c;
    }
    public Productos apertura() throws Exception {
        Control = new Creactua(nContexto);
        pBD = Control.getWritableDatabase();
        return this;
    }

    public long Insertar(String qcod, String qdes, String pventa) {
        ContentValues cv = new ContentValues();
        cv.put(CODPRO, qcod);
        cv.put(DESPRO, qdes);
        cv.put(PREPRO, pventa);
        return pBD.insert(N_TABLA, null, cv);
    }

    public void cerrar() {
        Control.close();
    }

    public String Listar() {
        String[] columnas = new String[] { CODPRO, DESPRO, PREPRO };
        Cursor c = pBD.query(N_TABLA, columnas, null, null, null, null, null);
        String res = "";
        int iCod = c.getColumnIndex(CODPRO);
        int iDes = c.getColumnIndex(DESPRO);
        int iPre = c.getColumnIndex(PREPRO);
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            res = res + c.getString(iCod) + " " + c.getString(iDes) + " "
                    + c.getString(iPre);
            res += '\n';
        }
        return res;
    }
    
    public String Buscar(String value) {
    	String[] columnas = new String[] { CODPRO, DESPRO, PREPRO };
        Cursor c = pBD.query(N_TABLA, columnas, null, null, null, null, null);
        String res = "";
        int iCod = c.getColumnIndex(CODPRO);
        int iDes = c.getColumnIndex(DESPRO);
        int iPre = c.getColumnIndex(PREPRO);
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
        	if(c.getString(iCod).equals(value)) {
        		res = res + c.getString(iCod) + " " + c.getString(iDes) + " "
                        + c.getString(iPre) + " ";
        		break;
        	}
        }
        return res;
    }
}