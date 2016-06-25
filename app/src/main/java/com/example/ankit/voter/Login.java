package com.example.ankit.voter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends Activity {
    EditText email, pass;
    TextView tv1;
    Button login;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.editText4);
        pass = (EditText) findViewById(R.id.editText5);
        login = (Button) findViewById(R.id.button5);
        tv1=(TextView)findViewById(R.id.textView6);
        db = openOrCreateDatabase("VoterDetails", Context.MODE_PRIVATE, null);
        /*try {
            db.execSQL("Create table login_details (name varchar(30), email varchar(30), pass varchar(30), phone int(12))");
            Toast.makeText(this, "Table Created", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error In Creating Table" + e, Toast.LENGTH_LONG).show();
        }*/
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = email.getText().toString();
                String ps = pass.getText().toString();
                Cursor c = db.rawQuery("Select id from login_Details where email='" + uname + "' and pass='" + ps + "'", null);
                if (c.moveToNext()) {
                    Intent a = new Intent(Login.this, MainActivity22Activity.class);
                    startActivity(a);
                } else {
                    tv1.setText("Invalid Usrname Or Passord");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    public void login(View view) {
        Intent i = new Intent(Login.this, MainActivity22Activity.class);
        startActivity(i);
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
