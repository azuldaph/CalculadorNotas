package com.example.practicacalificada1pm.vistas

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.practicacalificada1pm.R
import java.math.BigDecimal
import java.math.MathContext
import java.text.DecimalFormat


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        title = "Calculadora del Trica"

        val spinner =
            arrayOf("A: 30% T + 70 % L", "B: 50% T + 50% L", "C: 20% T + 80% L")

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinner)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val combo = findViewById<View>(R.id.spinner) as Spinner
        combo.adapter = adaptador

        combo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, v: View, position: Int, id: Long) {
                Toast.makeText(
                    this@HomeActivity,
                    "Seleccionado: " + spinner[position],
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(
                    this@HomeActivity,
                    "No ha seleccionado",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        var numero1 = findViewById<View>(R.id.numero1) as EditText
        var numero2 = findViewById<View>(R.id.numero2) as EditText
        var numerol1 = findViewById<View>(R.id.numerol1) as EditText
        var numerol2 = findViewById<View>(R.id.numerol2) as EditText
        var numerol3 = findViewById<View>(R.id.numerol3) as EditText
        var numerol4 = findViewById<View>(R.id.numerol4) as EditText


        var respuesta1 = findViewById<View>(R.id.respuesta1) as TextView
        var respuesta2 = findViewById<View>(R.id.respuesta2) as TextView
        var promedio = findViewById<View>(R.id.promedio) as TextView
        var mensaje = findViewById<View>(R.id.mensaje) as TextView

        var btnCalcular = findViewById<View>(R.id.btnCalcular) as Button

        btnCalcular.setOnClickListener(View.OnClickListener {
            var resultado1 = (numero1.text.toString().toDouble() + numero2.text.toString().toDouble())/2

            var resultado2 = (numerol1.text.toString().toDouble() + numerol2.text.toString().toDouble() + numerol3.text.toString().toDouble() + numerol4.text.toString().toDouble())/4

            var final = (resultado1 * 0.3) + (resultado2 * 0.7)

            respuesta1.setText(resultado1.toString());
            respuesta2.setText(resultado2.toString());
            promedio.setText(final.toString());
            mensaje.setText(
                if(final > 13){
                    "Aprobado!"
                }else{
                   "Desaprobado"
                }
            )
        })

//        btnReiniciar.setOnClickListener{
//            numero1.text.clear()
//            numero2.text.clear()
//            numerol1.text.clear()
//            numerol2.text.clear()
//            numerol3.text.clear()
//            numerol4.text.clear()
//            respuesta1.text=""
//            respuesta2.text=""
//            promedio.text=""
//            mensaje.text=""
//        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)
        return true
    }

}