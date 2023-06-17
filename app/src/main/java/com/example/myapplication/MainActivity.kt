package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var nameEd : EditText
    lateinit var surnameEd : EditText
    lateinit var pnEd : EditText
    lateinit var phAddress : EditText
    lateinit var mailAddress : EditText
    lateinit var butt : Button

    val database = Firebase.database
    val studentDB = database.reference.child("students")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        listeners()
    }

    private fun listeners(){
        butt.setOnClickListener(){
            if(pnEd.text.length > 13){
                return@setOnClickListener
                    //Toast.makeText( "write less than 13 digits", Toast.LENGTH_SHORT).show()
            }
            if(mailAddress.text.contains("@") == false){
                return@setOnClickListener
            }

            val st = Student(nameEd.text.toString(), surnameEd.text.toString(), pnEd.text.toString(), phAddress.text.toString(), mailAddress.text.toString())
            studentDB.push().setValue(st);
            startActivity(Intent(this,MainActivity2::class.java))
        }

    }


    private fun init(){
        nameEd = findViewById(R.id.nameId)
        surnameEd = findViewById(R.id.surnameId)
        pnEd = findViewById(R.id.personalNumbId)
        phAddress = findViewById(R.id.photoId)
        mailAddress = findViewById(R.id.emailId)
        butt = findViewById(R.id.buttonInsertId)
    }
}