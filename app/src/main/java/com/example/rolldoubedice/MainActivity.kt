package com.example.rolldoubedice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating dices
        val dices = arrayOf(Dice(6), Dice(6))

        //getting required references
        val button: Button = findViewById(R.id.roll_dice)
        val diceImgViews: Array<ImageView> = arrayOf(
            findViewById(R.id.Vdice_1),
            findViewById(R.id.Vdice_2)
        )

        //rolling dices on clicking roll button
        button.setOnClickListener { rollDices(dices, diceImgViews) }

        //rolling both dice once
        rollDices(dices,diceImgViews)

    }

    private fun rollDices(dices: Array<Dice>, diceImgViews: Array<ImageView>) {

        for (diceNumber in 0..1) {
            //rolling dice at every iteration
            val diceRoll = dices[diceNumber].roll();
            val drawableResource = when (diceRoll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            //updating the image resource depending on resulting dice
            diceImgViews[diceNumber].setImageResource(drawableResource)
            //updating content description for accessibility purpose
            diceImgViews[diceNumber].contentDescription = diceRoll.toString()
        }
    }
}

//Dice class
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}