package com.maverick.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
import soup.neumorphism.NeumorphButton
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    lateinit var calculateBtn:NeumorphButton
    lateinit var weightEdt:EditText
    lateinit var heightEdt:EditText
    lateinit var container:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateBtn=findViewById(R.id.calculateBtn)
        weightEdt=findViewById(R.id.weightEdt)
        heightEdt=findViewById(R.id.heightEdt)
       container = findViewById(R.id.container)

        calculateBtn.setOnClickListener {
            if (weightEdt.text.isNotEmpty() && heightEdt.text.isNotEmpty()){
                val weight = weightEdt.text.toString().toDouble()
                val height = heightEdt.text.toString().toDouble()/100

                if (weight>0 && weight<600 && height>=0.50 && height<2.5){
                    val intent = Intent(this@MainActivity,ResultActivity::class.java)
                    intent.putExtra("bmi",calculateBmi(weight,height))
                    startActivity(intent)
                }else{
                    showError("Incorrect Value")
                }
            }else{
                showError("A field is missing")
            }
        }
    }

    private fun showError(errorMsg:String){
        val snakBar = Snackbar.make(container,"error: ${errorMsg} !",Snackbar.LENGTH_LONG)
        snakBar.view.setBackgroundResource(R.color.colorRed)
        snakBar.show()
    }

    private fun calculateBmi(weight:Double,height:Double) = BigDecimal(weight/(height*height))
        .setScale(2,RoundingMode.HALF_EVEN).toDouble()
}