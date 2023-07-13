package com.henriette.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //1
        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.etName)
        val  submitButton = findViewById<Button>(R.id.btnSubmit)
        //6
        val offersButton = findViewById<Button>(R.id.btnOffers)
        var enteredName = ""

        //2
        submitButton.setOnClickListener {
          //2
             enteredName = inputField.text.toString()

            //4
            if (enteredName==""){
                //6
                offersButton.visibility = INVISIBLE
//                5
                greetingTextView.text = ""

                Toast.makeText(this@MainActivity,
                    "Please Enter your Name",
                    Toast.LENGTH_SHORT
                ).show()

            }

            else{
//         2
            val message = "Welcome $enteredName"
            greetingTextView.text = message
//         3
            inputField.text.clear()
                //7
                offersButton.visibility = VISIBLE
        }

     }
        //8
        offersButton.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("USER", enteredName)
            startActivity(intent)

        }
  }
}