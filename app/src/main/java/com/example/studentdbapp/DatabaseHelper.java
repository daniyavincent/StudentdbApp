package com.example.studentdbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.jar.Attributes;

public class DatabaseHelper extends SQLiteOpenHelper
{
    //set variables
    static String DbName="College.db";
    static String TableName="students";
    static String col1="Id";
    static String col2="Name";
    static String col3="RollNo";
    static String col4="AdmNo";
    static String col5="college";


    public DatabaseHelper( Context context)//constructor
    {
        super(context, DbName, null, 1);//database creation on constructor
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //table create
        String query="create table "+TableName+ "("+col1+" integer primary key autoincrement,"+
                col2+" text,"+
                col3+" text,"+
                col4+" text,"+
                col5+" text)";

        //query execution
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public boolean insertData(String name,String rollno,String admno,String colg)
    {
        //object create for sqlite
        SQLiteDatabase db=this.getWritableDatabase();
        //object for ContentValues
        ContentValues content =new ContentValues();
        content.put(col2,name);
        content.put(col3,rollno);
        content.put(col4,admno);
        content.put(col5,colg);

        long status=db.insert(TableName,null,content);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
