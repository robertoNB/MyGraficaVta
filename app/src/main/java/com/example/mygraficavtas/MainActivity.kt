package com.example.mygraficavtas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun graficaClic(v:View){
        val intGraf=Intent(this,MainActivityGrafica::class.java)
        startActivity(intGraf)
    }
    fun guardarClic(v:View){
        if(etNom.text.isEmpty()||etVtas.text.isEmpty()){
            Toast.makeText(this, "Falta informacion de capturar", Toast.LENGTH_SHORT).show();
            etNom.requestFocus()
        }else{
            val admin=adminBD(this)
            val nom= etNom.text.toString()
            val vta= etVtas.text.toString().toFloat()
            val sentencia = "insert into Empleado (NomEmp,Ventas) values" +
                    "('${nom}',${vta})"
            if(admin.Ejecuta(sentencia)==1){
                Toast.makeText(this, "Empleado guardado", Toast.LENGTH_SHORT).show();
                etNom.setText("")
                etVtas.setText("0")
                etNom.requestFocus()
            }else{
                Toast.makeText(this, "Error de capa 8, No guardo", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
