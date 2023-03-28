package com.example.androidtest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.channels.ChannelResult.Companion.success
import kotlin.Result.Companion.success

class SuccessActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var buttonSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        textView = findViewById(R.id.textView)
        buttonSend = findViewById(R.id.buttonSend)

        val name = intent.getStringExtra("name")
        textView.text = getString(R.string.success, name);

        buttonSend.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0385979545897")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", textView.text)
            startActivity(intent)
        }
    }
}