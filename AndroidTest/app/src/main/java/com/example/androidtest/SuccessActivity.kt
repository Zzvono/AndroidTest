package com.example.androidtest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SuccessActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var buttonSend: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        textView = findViewById(R.id.textView)
        buttonSend = findViewById(R.id.buttonSend)
        val name = intent.getStringExtra("name")
        textView.text = "$name uspješno ste došli do 10 koraka."

        buttonSend.setOnClickListener{
            val uri: Uri = Uri.parse("smsto:00385919094163")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", textView.text)
            startActivity(intent)
        }

    }
}