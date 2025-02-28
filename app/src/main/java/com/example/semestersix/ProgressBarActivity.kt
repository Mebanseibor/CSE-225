package com.example.semestersix

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ProgressBarActivity : AppCompatActivity() {
    private lateinit var progressBar1 : ProgressBar
    private lateinit var progressBar2 : ProgressBar
    private lateinit var btnStart : Button
    private lateinit var btnReset : Button
    private lateinit var txtProgressText : TextView

    override fun onCreate (savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_progressbar)

        initProgressBars()
    }

    private fun initProgressBars(){
        progressBar1 = findViewById(R.id.progressBar1)
        progressBar2 = findViewById(R.id.progressBar2)
        btnStart = findViewById(R.id.btnStart)
        btnReset = findViewById(R.id.btnReset)
        txtProgressText = findViewById(R.id.progressTextIndicator)

        progressBar2.visibility = View.INVISIBLE

        btnStart.setOnClickListener {
            progressBar2.visibility = View.VISIBLE

            var progressTracker = progressBar1.progress

            Thread{
                while(progressTracker<progressBar1.max){
                    progressTracker+=1
                    Handler(Looper.getMainLooper()).post {
                        progressBar1.progress = progressTracker
                        txtProgressText.text = progressTracker.toString() + "%"

                        if (progressTracker >= progressBar1.max) {
                            progressBar2.visibility = View.INVISIBLE
                            txtProgressText.text = "COMPLETED"
                        }

                    }
                    try {
                        Thread.sleep(50)
                    }
                    catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }.start()
        }

        btnReset.setOnClickListener{
            progressBar1.progress = 0
            txtProgressText.text = 0.toString() + "%"
            Toast.makeText(this,"Progress bar Reset Succefully", Toast.LENGTH_SHORT).show()
        }
    }
}