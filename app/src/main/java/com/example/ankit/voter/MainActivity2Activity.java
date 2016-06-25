package com.example.ankit.voter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity2Activity extends Activity {
EditText email,gender,pass,age,name;
    Button register;
    SQLiteDatabase db;
    int status=0,id=10080;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        email=(EditText)findViewById(R.id.editText);
        gender=(EditText)findViewById(R.id.editText1);
        age=(EditText)findViewById(R.id.editText2);
        pass=(EditText)findViewById(R.id.editText3);
        name=(EditText)findViewById(R.id.editText5);
        register=(Button)findViewById(R.id.button3);
        db=openOrCreateDatabase("VoterDetails", Context.MODE_PRIVATE,null);
           try {
            db.execSQL("Create table login_details (name varchar(30), email varchar(30), pass varchar(30), age int(5),gender varchar(10))");/*,votestatus int (2),id int(8)*/
                    Toast.makeText(this, "Table Created", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error In Creating Table" + e, Toast.LENGTH_SHORT).show();
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname1=name.getText().toString();
                String email1=email.getText().toString();
                String pass1=pass.getText().toString();
                String age1=age.getText().toString();
                int age2=Integer.parseInt(age1);
                String gender1=gender.getText().toString();
                db.execSQL("Insert into login_details values ( '" + uname1 + "','" + email1 + "','" + pass1 + "','" + age2 + "','" + gender1 +  "')"); /*+ status +"','" + id + "')")*/;
                Toast.makeText(MainActivity2Activity.this, "Records Inserted", Toast.LENGTH_SHORT).show();
                id++;
                Intent i=new Intent(MainActivity2Activity.this,Login.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
