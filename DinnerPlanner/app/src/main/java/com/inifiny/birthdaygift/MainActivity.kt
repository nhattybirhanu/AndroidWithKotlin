package com.inifiny.birthdaygift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var foods= arrayListOf<String>("HamBurger","Pizza","Mexican","American","Chinese");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        decide.setOnClickListener {
            tv.text=foods.get(Random.nextInt(foods.size));
        }

        addbutton.setOnClickListener{
            val input=food_input.text.toString()
            val newfood=if (input.isEmpty())null else input;
            newfood?.let { foods.add(newfood); tv.text=newfood }
                ?:let { Toast.makeText(this,"Please enter food you want to eat",Toast.LENGTH_SHORT).show() };

        }
    }
}