package com.skynoff.smapp2018.background.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import org.jetbrains.anko.db.*

/**
 * Created by cesar.smith on 11/1/2017.
 */
class SQLiteHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, name = "Smappc2", factory = null, version = 1) {
    val tablaSecciones: String = "secciones"
    val tablaLecciones: String = "lecciones"
    val tablaAsignaturas: String = "asignaturas"
    val tablaTipoExamen: String = "tipo_examen"
    lateinit var db:FirebaseFirestore
    companion object {
        private var instance: SQLiteHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): SQLiteHelper {
            if (instance == null) {
                instance = SQLiteHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }
    override fun onCreate(db: SQLiteDatabase) {
         db.createTable(tablaTipoExamen,true,"uid" to INTEGER + PRIMARY_KEY + UNIQUE ,"id" to INTEGER,
                 "name" to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData()
    {
        db= FirebaseFirestore.getInstance()
        db.collection("tipo_examen").get().addOnCompleteListener {
            snap->
            for (tipo in snap.result)
            {
                this.writableDatabase.insert(tablaTipoExamen,"name" to tipo.id,
                                                                "id" to tipo["id"])
                       Log.e("siiiiii", tipo.id)
            }
        }
    }
    fun getTipoExamen():MutableList<String>{
   Log.e("VERSION",this.readableDatabase.path)

        return this.readableDatabase.select(tablaTipoExamen,"name").parseList(StringParser).toMutableList()

    }

   fun deleteTipoEx(){
       this.writableDatabase.delete(tablaTipoExamen)
   }

}
val Context.database: SQLiteHelper
    get() = SQLiteHelper.getInstance(applicationContext)