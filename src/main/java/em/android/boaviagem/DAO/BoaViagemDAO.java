package em.android.boaviagem.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

import em.android.boaviagem.DataBase.DatabaseHelper;
import em.android.boaviagem.Modelo.Viagem;

/**
 * Created by Emanuelle Menali on 22/07/2016.
 */
public class BoaViagemDAO {

    private DatabaseHelper helper;
    private SQLiteDatabase db;


    //recebe o contexto da aplicação e instancia um DatabaseHelper.
    public BoaViagemDAO(Context context) {
        helper = new DatabaseHelper(context);
    }

    //Se necessario iniica um metodo que retorna a instancia de SQLiteDatabase
    public SQLiteDatabase getDb() {
        if (db == null){
            db = helper.getWritableDatabase();
        }
        return db;
    }

    public void close(){
        helper.close();
    }


    public List<Viagem> listarViagens(){
        Cursor cursor = getDb().query(DatabaseHelper.Viagem.TABELA,
                DatabaseHelper.Viagem.COLUNAS,
                null, null, null, null, null);
        List<Viagem> viagens = new ArrayList<Viagem>();

        while (cursor.moveToNext()){
            Viagem viagem = criarViagem(Cursor);
            viagens.add(viagem);
        }
        cursor.close();
        return viagens;
    }
}
