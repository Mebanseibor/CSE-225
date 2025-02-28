package com.example.semestersix

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ProgressBarActivity : AppCompatActivity() {
    private lateinit var progressBar1 : ProgressBar
    private lateinit var progressBar2 : ProgressBar

    override fun onCreate (savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_progressbar)

        initProgressBars()
    }

    private fun initProgressBars(){

    }
}