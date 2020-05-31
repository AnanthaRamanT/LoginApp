package com.example.loginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button btn;
    private boolean backpress=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_second);

        btn=(Button)findViewById(R.id.btn_logout);
        btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               logout();
           }
       });

    }
      public void logout(){

          SharedPreferences preferences=getSharedPreferences("Login",MODE_PRIVATE);

         SharedPreferences.Editor editor=preferences.edit();
         editor.clear();
         editor.apply();
         finish();

          Intent i=new Intent(SecondActivity.this,MainActivity.class);
          startActivity(i);

      }

    @Override
    public void onBackPressed() {


        if(backpress){
             logout();
             super.onBackPressed();
             return;
         }

        this.backpress=true;
        Toast.makeText(this, "Please click BACK again to EXIT and LOGOUT", Toast.LENGTH_SHORT).show();

         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 backpress=false;
             }
         },2000);


    }
}
