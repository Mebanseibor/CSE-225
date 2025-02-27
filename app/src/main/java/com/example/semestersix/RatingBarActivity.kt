package com.example.semestersix

import android.os.Bundle
import android.util.Half.toFloat
import android.util.Log
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RatingBarActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ratingbar)

        initRatingStar()
    }

    private fun initRatingStar(){
        val buttonSubmit = findViewById<Button>(R.id.submitButton)
        val ratingBarMain = findViewById<RatingBar>(R.id.ratingBar)

        buttonSubmit.setOnClickListener {
            Log.d("buttonSubmit", "Submit Button was clicked")
            val totalStars = ratingBarMain.numStars
            val userRating = ratingBarMain.rating
            Toast.makeText(this, """Rated $userRating/${totalStars.toFloat()} Stars""", Toast.LENGTH_SHORT).show()
        }
    }
}