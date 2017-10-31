package com.anny.bmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bmi(View view){
        //sout=System.out.println();
        Log.d("MainActivity","testing bmi method");
        Log.e("MainActivity","testing bmi method");
        Log.i("MainActivity","testing bmi method");
        Log.w("MainActivity","testing bmi method");
        EditText edWeight= (EditText) findViewById(R.id.ed_weight);
        EditText edHeight= (EditText) findViewById(R.id.ed_height);
        float weight= Float.parseFloat(edWeight.getText().toString());
        float height= Float.parseFloat(edHeight.getText().toString());
        float bmi=weight / (height*height);
        Log.d("MainActivity","Your bmi is"+bmi);
        new AlertDialog.Builder(this)
                .setMessage("Your BMI is" +bmi)
                .setTitle("my title")
                .setPositiveButton("OK",null)
                .show();
      /*  Toast.makeText(this,
                "Your bmi is"+bmi,
                Toast.LENGTH_LONG)
                .show();*/

        }
        }
