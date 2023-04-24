package com.example.androidtest

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SuccessActivity : AppCompatActivity() {
    lateinit var textViewMessage: TextView
    lateinit var buttonSend: Button

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        buttonSend = findViewById(R.id.buttonSend)

        textViewMessage = findViewById(R.id.textViewMessage)
        var name = intent.getStringExtra("name")
        textViewMessage.text = getString(R.string.success, name)

        buttonSend.setOnClickListener() {
            val uri: Uri = Uri.parse("smsto:0991234566")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", name)
            startActivity(intent)
        }

    }
}