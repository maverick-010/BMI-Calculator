package com.maverick.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import soup.neumorphism.NeumorphTextView

class ResultActivity : AppCompatActivity() {
   lateinit var container: LinearLayout
    lateinit var containerR: LinearLayout
    lateinit var bmiValueTv:NeumorphTextView
    lateinit var bmiLabelTv:TextView
    lateinit var commentTv:TextView
    lateinit var adviceTv:TextView
    lateinit var advice2Tv:TextView
    lateinit var advice3Tv:TextView
    lateinit var bmiFlagImgV:ImageView
    lateinit var adviceImg:ImageView
    lateinit var advice2Img:ImageView
    lateinit var advice3Img:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
//        container = findViewById(R.id.container)
        containerR = findViewById(R.id.containerR)
        bmiValueTv = findViewById(R.id.bmiValueTv)
        bmiLabelTv = findViewById(R.id.bmiLabelTv)
        commentTv = findViewById(R.id.commentTv)
        adviceTv = findViewById(R.id.adviceTv)
        advice2Tv = findViewById(R.id.advice2Tv)
        advice3Tv = findViewById(R.id.advice3Tv)
        bmiFlagImgV = findViewById(R.id.bmiFlagImgV)
        adviceImg = findViewById(R.id.adviceImg)
        advice2Img = findViewById(R.id.advice2Img)
        advice3Img = findViewById(R.id.advice3Img)

        val bmi = intent.getDoubleExtra("bmi",-1.0)
        if (bmi==-1.0){
            //container.visibility = View.GONE
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
        }else{
            bmiValueTv.text = bmi.toString()
            if (bmi<18.5){
                containerR.setBackgroundResource(R.drawable.yello_bg)
                bmiFlagImgV.setImageResource(R.drawable.exclamation)
                bmiLabelTv.text = "You have an UnderWeight!"
                commentTv.text = "Here are some advice to help you increase your weight"
                adviceImg.setImageResource(R.drawable.nowater)
                adviceTv.text="Don't drink water before meals"
                advice2Img.setImageResource(R.drawable.dight)
                advice2Tv.text="Use bigger plate"
                advice3Tv.text="Get quality sleep"
            }else{
                if (bmi > 25){
                   containerR.setBackgroundResource(R.drawable.red_bg)
                    bmiFlagImgV.setImageResource(R.drawable.warning)
                    bmiLabelTv.text = "You have an OverWeight!"
                    commentTv.text = "Here are some advice to help you decrease your weight"
                    adviceImg.setImageResource(R.drawable.water)
                    adviceTv.text="Don't drink water a half hour before meals"
                    advice2Img.setImageResource(R.drawable.twoeggs)
                    advice2Tv.text="Eat only two meals per day and make sure that they contains a high protein"
                    advice3Img.setBackgroundResource(R.drawable.sugar)
                    advice3Tv.text="Drink coffee or tea and avoid sugary food"
                }
            }
        }
    }
}