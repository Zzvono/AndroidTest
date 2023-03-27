package com.example.androidtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private var counter = 0
lateinit var textViewCounter: TextView
lateinit var buttonUp: Button
lateinit var buttonDown: Button
lateinit var formInput: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "onCreate", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onCreate")

        textViewCounter = findViewById(R.id.textViewCounter)
        buttonUp = findViewById(R.id.insert_button)
        buttonDown = findViewById(R.id.buttonDown)
        formInput = findViewById(R.id.formInput)

        buttonUp.setOnClickListener {
            counter ++
            if(counter == 10) {
                counter = 0
                val intent = Intent( this, SuccessActivity::class.java).apply{
                    putExtra("name", findViewById<TextView>(R.id.steps_input).text.toString())
                }
                startActivity(intent)
            }
            textViewCounter.text = counter.toString()
        }
        buttonDown.setOnClickListener {
            counter --
            if(counter < 0) {
                counter ++
            }
            textViewCounter.text = counter.toString()
        }
        formInput.setOnClickListener{

            val intent = Intent(this, HighActivity::class.java)

            startActivity(intent)

        }
    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "onStart", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onStart")
    }
    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "onPause", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onPause")
    }
    override fun  onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "onResume", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onResume")
    }
    override fun  onStop() {
        super.onStop()
        Toast.makeText(applicationContext, "onStop", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onStop")
    }
    override fun  onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "onDestroy", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onDestroy")
    }
    override fun  onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext, "onRestart", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onRestart")
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.restore_counter -> {
                counter=0
                textViewCounter.text=counter.toString()
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}