package em.android.boaviagem.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Emanuelle Menali on 17/05/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String BANCO_DADOS = "BoaViagem";
    private static int VERSAO = 1;


//    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE viagem (_id INTEGER PRIMARY KEY," +
                "destino TEXT, tipo_viagem INTEGER, " +
                "data_chegada TEXT, data_saida TEXT, " +
                "orcamento DOUBLE, quantidadeDePessoas INTEGER);");

        db.execSQL("CREATE TABLE gasto ( _id INTEGER PRIMARY KEY, " +
                "categoria TEXT, data DATE, valor DOUBLE, " +
                "descricao TEXT, local TEXT, viagem_id INTEGER, " +
                "FOREIGN KEY  (viagem_id) REFERENCES viagem(_id))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        //db.execSQL("ALTER TABLE gasto ADD COLUMN pessoa TEXT");

    }


}