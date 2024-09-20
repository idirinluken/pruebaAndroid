package com.example.praktika02

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var Botoia: Button
    lateinit var Textua: TextView
    lateinit var LehenengoZenbakia: EditText
    lateinit var BigarrenZenbakia: EditText
    lateinit var CheckBoxBiderketa: CheckBox
    lateinit var CheckBoxZatiketa: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        Botoia=findViewById(R.id.eragiketaBotoia)
        Textua=findViewById(R.id.emaitza)
        LehenengoZenbakia=findViewById(R.id.zenbakia1)
        BigarrenZenbakia=findViewById(R.id.zenbakia2)
        CheckBoxBiderketa=findViewById(R.id.checkBoxBiderketa)
        CheckBoxZatiketa=findViewById(R.id.checkBoxZatiketa)

        CheckBoxBiderketa.setOnClickListener {
            if (CheckBoxZatiketa.isChecked) {
                CheckBoxZatiketa.isChecked = false
            }
        }

        CheckBoxZatiketa.setOnClickListener {
            if (CheckBoxBiderketa.isChecked) {
                CheckBoxBiderketa.isChecked = false
            }
        }

        Botoia.setOnClickListener {
            Log.d("Oharra","Botoia sakatu da")
            if (LehenengoZenbakia.text.isEmpty()) {
                Textua.text = "Lehenengo zenbakia ez duzu sartu"
            } else if (BigarrenZenbakia.text.isEmpty()) {
                Textua.text = "Bigarren zenbakia ez duzu sartu"
            } else if (!CheckBoxBiderketa.isChecked && !CheckBoxZatiketa.isChecked) {
                Textua.text = "Eragiketa mota aukeratu"
            } else {
                // Convertir los valores de EditText a int
                val z1 = LehenengoZenbakia.text.toString().toInt()
                val z2 = BigarrenZenbakia.text.toString().toInt()

                // Realiza la operación correspondiente
                if (CheckBoxBiderketa.isChecked) {
                    val emaitza = z1 * z2
                    Textua.text = "Emaitza: $emaitza"
                } else if (CheckBoxZatiketa.isChecked) {
                    // Verifica que el segundo número no sea 0 para evitar división por 0
                    if (z2 != 0) {
                        val emaitza = z1 / z2
                        Textua.text = "Emaitza: $emaitza"
                    } else {
                        Textua.text = "Errorea: 0z zatitu nahi duzu"
                    }
                }
            }
        }
    }
}