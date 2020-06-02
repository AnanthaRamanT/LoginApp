package com.example.loginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etdata1,etdata2;
    Button btn;
    SharedPreferences pref;
    String email,password;
    String id;
    private Boolean userid=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        etdata1 = (EditText) findViewById(R.id.etdata1);
        etdata2 = (EditText) findViewById(R.id.etdata2);
        btn = (Button) findViewById(R.id.login_btn);

        pref = getSharedPreferences("Login", MODE_PRIVATE);

        id= Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);




        userid=pref.getBoolean("saveid",false);

        String deviceid=pref.getString("log","0");
        String loginuser=pref.getString("logid","0");




        if(userid==true){

            Intent i = new Intent(this, SecondActivity.class);
            startActivity(i);
            finish();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = etdata1.getText().toString();
                password = etdata2.getText().toString();


                if (email!=null && email.length()>6) {
                    if (password!=null && password.length()>6) {
                        if (email.equals("test@test.com") && password.equals("Test@123")) {
                            nextpage();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "User Login Failed...", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        etdata2.setError("Enter Password must be 6 to 12");
                    }
                }else{
                    etdata1.setError("Please Enter a Valid Email id");
                }

            }
        });



    }

    public void nextpage(){

        SharedPreferences.Editor editor=pref.edit();
        editor.putString("mail",email);
        editor.putString("password",password);
        editor.putString("log",id);
        editor.putBoolean("saveid",true);
        editor.commit();

                Intent i = new Intent(this, SecondActivity.class);
                startActivity(i);
                finish();

    }
    }


