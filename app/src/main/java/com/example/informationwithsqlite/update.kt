package com.example.informationwithsqlite

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_update.*

class update : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        button3.setOnClickListener {

var cv=ContentValues()
            cv.put("name",editTextTextPersonName3.text.toString())
            cv.put("age",editTextTextPersonName4.text.toString().toInt())
            var db=database(this)
            db.update(editTextTextPersonName.text.toString(),editTextTextPersonName2.text.toString().toInt(),cv)
            val users : ArrayList<User> =db.readData()
            for(i in 0 until users.size){

                textView.append(users.get(i).name+" "+users.get(i).age.toString()+"\n")

            }


        }


    }
}