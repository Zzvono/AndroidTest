package com.example.androidtest

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SuccessActivity : AppCompatActivity() {
    lateinit var textViewMessage: TextView
    lateinit var buttonSend: Button
    lateinit var downloadButton: Button

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        buttonSend = findViewById(R.id.buttonSend)
        downloadButton = findViewById(R.id.downloadButton)
        textViewMessage = findViewById(R.id.textViewMessage)

        var name = intent.getStringExtra("name")
        textViewMessage.text = getString(R.string.success, name)

        buttonSend.setOnClickListener() {
            val uri: Uri = Uri.parse("smsto:0991234566")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", name)
            startActivity(intent)
        }
        downloadButton.setOnClickListener{

            val url = "https://ih1.redbubble.net/image.724682828.9041/flat,750x,075,f-pad,750x1000,f8f8f8.u1.jpg"
            val request = DownloadManager.Request(Uri.parse(url))
                .setTitle("Skola")
                .setDescription("Skola")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setAllowedNetworkTypes (DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
            val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            downloadManager.enqueue(request)
        }

    }
}