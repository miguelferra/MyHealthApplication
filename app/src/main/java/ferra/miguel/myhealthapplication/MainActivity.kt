package ferra.miguel.myhealthapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso:EditText = findViewById(R.id.peso) as EditText
        val altura:EditText = findViewById(R.id.altura) as EditText
        val calcular:Button = findViewById(R.id.calculate) as Button
        val imc:TextView = findViewById(R.id.imc) as TextView
        val rango:TextView = findViewById(R.id.range) as TextView


        calcular.setOnClickListener {
            /** kilogramos / altura
             * menor a 18.5 por debajo
             * si esta entre 18.5 24.9 saludable
             * si esta entre 25 29.9 sobrepeso
             * si esta entre 39.9 obesidad
             * mayor a 40
             */

            var p:Float = peso.text.toString().toFloat()
            var a: Float = altura.text.toString().toFloat()

            var imcC: Float = p / (a*a)

            if (imcC < 18.5){
                rango.setText("Por debajo de tu peso")
                rango.setBackgroundResource(R.color.green)
            }else if (imcC > 18.5 && imcC < 24.9){
                rango.setText("Saludable")
                rango.setBackgroundResource(R.color.guasave)
            }else if (imcC > 25 && imcC < 29.9){
                rango.setText("Sobrepeso")
                rango.setBackgroundResource(R.color.yellow)
            }else if (imcC > 30 && imcC < 39.9){
                rango.setText("Obesidad")
                rango.setBackgroundResource(R.color.orange)
            }else{
                rango.setText("Estas obesamente morbido")
                rango.setBackgroundResource(R.color.red)

            }

            imc.setText(""+imcC)

        }
    }
}
