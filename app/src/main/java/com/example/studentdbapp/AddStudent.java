package com.example.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
AppCompatButton btn1,btn2;
String getName,getRollNumber,getAdmissionNumber,getCollege;
DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        dbhelper=new DatabaseHelper(this);
        dbhelper.getWritableDatabase();

        ed1=(EditText) findViewById(R.id.txt1);
        ed2=(EditText) findViewById(R.id.txt2);
        ed3=(EditText) findViewById(R.id.txt3);
        ed4=(EditText) findViewById(R.id.txt4);
        btn1=(AppCompatButton) findViewById(R.id.btn1);
        btn2=(AppCompatButton) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getName=ed1.getText().toString();
                getRollNumber=ed2.getText().toString();
                getAdmissionNumber=ed3.getText().toString();
                getCollege=ed4.getText().toString();


                boolean result=dbhelper.insertData(getName,getRollNumber,getAdmissionNumber,getCollege);
                if (result==true)
                {
                    Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_SHORT).show();
                    //to clear values
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "failed to insert", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}