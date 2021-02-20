package com.example.informationwithsqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

var user_info="USER_INFO"

class database (var context: Context):SQLiteOpenHelper(context,"mydatabase",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        var create=" CREATE TABLE "+ user_info+"(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(256),age INTEGER)"
        p0?.execSQL(create)
    }


    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user:User){


        var db=this.writableDatabase
        var cd=ContentValues()
        cd.put("name",user.name)
        cd.put("age",user.age)
       var baska= db.insert("USER_INFO",null,cd)




    }

    fun readData() : ArrayList<User>{


        var users= ArrayList<User>()
        var db=this.readableDatabase
        var query="Select * from $user_info"
        var result=db.rawQuery(query,null)
        if(result.moveToFirst()){

            do{

                var user= User()
                user.name=result.getString(result.getColumnIndex("name"))
                user.age=result.getString(result.getColumnIndex("age")).toInt()
                users.add(user)


            }while(result.moveToNext())

        }
        result.close()
        db.close()
        return users

    }


    fun update(oldname:String,oldage:Int,cv:ContentValues){

var db=this.readableDatabase
        var query="Select * from $user_info"
        var result=db.rawQuery(query,null)
        if(result.moveToFirst()){

            do{

                db.update(user_info,cv,"name =? AND age=?",arrayOf(oldname,oldage.toString()))


            }while(result.moveToNext())


        }
        result.close()
        db.close()



    }
}