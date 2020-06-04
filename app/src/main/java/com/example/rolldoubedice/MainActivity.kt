package com.example.rolldoubedice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating dices
        val dices = arrayOf(Dice(6), Dice(6))

        //getting required references
        val button: Button = findViewById(R.id.roll_dice)
        val diceTextViews: Array<TextView> = arrayOf(
            findViewById(R.id.Dice1),
            findViewById(R.id.Dice2)
        )

        button.setOnClickListener { rollDices(dices, diceTextViews) }

    }

    private fun rollDices(dices: Array<Dice>, diceTextViews: Array<TextView>) {
        for (i in 0..1) {
            diceTextViews[i].text = dices[i].roll().toString()
        }
    }
}

//Dice class
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}