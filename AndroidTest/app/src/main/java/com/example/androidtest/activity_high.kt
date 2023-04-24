package com.example.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class activity_high : AppCompatActivity() {

    private lateinit var insert_button: Button
    private lateinit var name_input: EditText
    private lateinit var steps_input: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high)

        insert_button=findViewById(R.id.insert_button)
        name_input=findViewById(R.id.name_input)
        steps_input=findViewById(R.id.steps_input)

        insert_button.setOnClickListener {
            val name = name_input.text.toString()
            val steps = steps_input.text.toString().toInt()

            val db = Data(this)
            db.addHighScore(name.trim(), steps)
        }
    }
}