package com.example.androidtest

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.net.Inet4Address
import java.util.*

class MainActivity : AppCompatActivity() {

    private var count = 0;
    lateinit var textViewCounter: TextView
    lateinit var buttonUp: Button
    lateinit var buttonDown: Button
    lateinit var plainTextField: EditText
    lateinit var highscore: Button
    lateinit var map: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "onCreate", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onCreate")

        textViewCounter = findViewById(R.id.textViewCounter)
        buttonUp = findViewById(R.id.buttonUp)
        buttonDown = findViewById(R.id.buttonDown)
        plainTextField = findViewById(R.id.plainTextField)
        highscore = findViewById(R.id.highscore)
        map = findViewById(R.id.map)

        registerForContextMenu(textViewCounter)
        textViewCounter.setOnClickListener { v -> openContextMenu(v)}

        buttonUp.setOnClickListener() {
            count++;
            textViewCounter.text = count.toString()

            if(count >= 10){
                count = 0
                val intent = Intent(this, SuccessActivity::class.java)
                intent.putExtra("name", plainTextField.text.toString())
                startActivity(intent)
            }
        }

        highscore.setOnClickListener{
            val intent = Intent(this, activity_high::class.java)
            startActivity(intent)
        }

        map.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        buttonDown.setOnClickListener() {
            if(count > 0)
                count--
            textViewCounter.text = count.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "onStart", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "onResume", Toast.LENGTH_SHORT).show()
        Log.i("onResume", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "onPause", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext, "onRestart", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onRestart")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext, "onStop", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "onDestroy", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onDestroy")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_float, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.restore_counter -> {
                count = 0
                textViewCounter.text = count.toString()
                true
            }
            R.id.english -> {
                changeLanguage(this, "en")
                recreate()
            }
            R.id.croatian -> {
                changeLanguage(this, "hr")
                recreate()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.restore_counter){
            count = 0
            textViewCounter.text = count.toString()
        }

        return super.onContextItemSelected(item)
    }

    @Suppress("DEPRECATION")
    fun changeLanguage(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val res = context.resources
        val config = Configuration(res.configuration)
        config.setLocale(locale)
        context.createConfigurationContext(config)
        res.updateConfiguration(config, res.displayMetrics)
    }
}
