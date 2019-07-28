package com.example.mygraficavtas

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.activity_main_grafica.*

class MainActivityGrafica : AppCompatActivity() {
    val entries = ArrayList<BarEntry>()
    val labels = ArrayList<String>()
    var cursor: Cursor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_grafica)
        cargarDato()
        setBarChart()
    }
    fun cargarDato(){
        val admin= adminBD(this)
        cursor =admin.consulta("Select * from Empleado order by Ventas")
    }
    fun setBarChart() {
        //Agregamos datos de tipo float, en el primer paramtro
        // se indica el angulo de las Y y en en
        // segundo parametro el lado de X
        var i=0
        if (cursor!!.moveToFirst())
        {
            do{
                val nom= cursor!!.getString(1)
                val vtas= cursor!!.getFloat(2)
                labels.add(nom)
                entries.add(BarEntry(vtas, i))
                i++
            }while (cursor!!.moveToNext())
            val barDataSet = BarDataSet(entries, "Ventas")
            val data = BarData(labels, barDataSet)
            barChart.data = data
            barChart.setDescription("Ventas por empleado")
            barDataSet.color = resources.getColor(R.color.colorAccent)
            barChart.animateY(5000)
        }

    }

}
