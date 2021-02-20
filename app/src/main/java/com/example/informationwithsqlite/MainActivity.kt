package com.example.informationwithsqlite

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val db=database(this)
        //var silinecek=db.writableDatabase
        //silinecek.delete("USER_INFO",null,null)
        val users : ArrayList<User> =db.readData()
        for(i in 0 until users.size){

            textView.append(users.get(i).name+" "+users.get(i).age.toString()+"\n")

        }


        button.setOnClickListener {
           textView.setText(null)


if(Name.text.toString().isNotEmpty()&&Age.text.toString().isNotEmpty()) {
    var name=Name.text.toString()
    var age=Age.text.toString().toInt()
    var user=User(name,age)
    db.insertData(user)
}
            else{
                Toast.makeText(applicationContext,"you must entry name and age",Toast.LENGTH_SHORT).show()
            }

            val db=database(this)
            val users : ArrayList<User> =db.readData()
            for(i in 0 until users.size){

                textView.append(users.get(i).name+" "+users.get(i).age.toString()+"\n")

            }


        }

        button2.setOnClickListener {

var intent= Intent(applicationContext,update::class.java)
            startActivity(intent)


        }

        button4.setOnClickListener {

          var db_2=db.writableDatabase
            var nameler=Name.text.toString()
          db_2.delete("USER_INFO","name=? AND age=?", arrayOf(Name.text.toString(),Age.text.toString()))
          db_2.close()
            textView.setText(null)
            val users : ArrayList<User> =db.readData()
            for(i in 0 until users.size){

                textView.append(users.get(i).name+" "+users.get(i).age.toString()+"\n")

            }



        }



    }
}