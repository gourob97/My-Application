package com.example.appdevnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val nameEditTextView = findViewById<EditText>(R.id.etName)
        val submitButton = findViewById<Button>(R.id.btnSubmit)
        val offersButon = findViewById<Button>(R.id.btnOffers)
        var enteredName = ""
        submitButton.setOnClickListener{
            enteredName = nameEditTextView.text.toString()
            if (enteredName == ""){
                offersButon.visibility = INVISIBLE
                greetingTextView.text = ""
                Toast.makeText(
                    this,
                    "Enter a Valid name",
                    Toast.LENGTH_SHORT
                ).show()

            }
            else{
                greetingTextView.text = " Welcome $enteredName"
                nameEditTextView.text.clear()
                offersButon.visibility = VISIBLE
                nameEditTextView.visibility = INVISIBLE
                submitButton.visibility = GONE
            }

            offersButon.setOnClickListener{
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("USER", enteredName)
                startActivity(intent)
            }

        }



    }
}