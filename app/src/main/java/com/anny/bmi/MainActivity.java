package com.anny.bmi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        //ctrl +alt+f 快速鍵
        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI")
                        .setMessage("BMI原來的設計是一個用於公眾健康研究的統計工具。當需要知道肥胖是否為某一疾病的致病原因時，可以把病人的身高及體重換算成BMI，再找出其數值及病發率是否有線性關連。")
                        .setPositiveButton("ok",null)
                        .show();

            }
        });
        getResources().getString(R.string.app_name);
        Log.d("MainActivity","onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    private void findViews() {
        edWeight = (EditText) findViewById(R.id.ed_weight);
        edHeight = (EditText) findViewById(R.id.ed_height);
        bHelp = (Button) findViewById(R.id.b_help);
    }
    //ctrl+alt+m (method)快速建好方法,並呼叫--->在refactor的extract\裡

    public void bmi(View view){
        //sout=System.out.println();
        Log.d("MainActivity","testing bmi method");
        Log.e("MainActivity","testing bmi method");
        Log.i("MainActivity","testing bmi method");
        Log.w("MainActivity","testing bmi method");
        float weight= Float.parseFloat(edWeight.getText().toString());
        float height= Float.parseFloat(edHeight.getText().toString());
        float bmi=weight / (height*height);
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra(getString(R.string.bmi_extra),bmi);
        startActivity(intent);
        Log.d("MainActivity","Your bmi is"+bmi);
        if (height>3){
            new AlertDialog.Builder(this)
                    .setMessage("身高單位應為公尺")
                    .setPositiveButton("OK",null)
                    .show();

        }
        if (bmi<20){
            new AlertDialog.Builder(this)
                    .setMessage(getResources().getString(R.string.your_bmi_is_) +bmi+",請多吃點") //多國語言　抽取資料　對話框　button做事
                    .setTitle(R.string.bmi_title)
                    .setPositiveButton("OK",null)
                    .show();
        }else{
            new AlertDialog.Builder(this)
                    .setMessage(getResources().getString(R.string.your_bmi_is_) +bmi)
                    .setTitle(R.string.bmi_title)
                    .setPositiveButton("OK",null)
                    .show();
        }
      /*  Toast.makeText(this,
                "Your bmi is"+bmi,
                Toast.LENGTH_LONG)
                .show();*/

        }
        }
