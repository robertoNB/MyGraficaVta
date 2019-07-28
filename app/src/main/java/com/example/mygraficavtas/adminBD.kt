package com.example.mygraficavtas

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class adminBD (context: Context): SQLiteOpenHelper(context,DATABASE,null,1)
{
    companion object{
        val DATABASE="Ventas"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "Create Table Empleado(" +
                    "_id int primary key, " +
                    "NomEmp text, " +
                    "Ventas float)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun Ejecuta (sentencia: String) : Int
    {
        try {
            val db=this.writableDatabase
            db.execSQL(sentencia)
            db.close()
            return 1
        }
        catch (ex:Exception)
        {
            Log.d("NBRA",ex.toString())
            return 0
        }
    }

    fun consulta(select: String): Cursor?
    {
        try
        {
            val  db=this.readableDatabase
            return db.rawQuery(select,null)
        }
        catch (ex:Exception)
        {
            return null
        }
    }
}