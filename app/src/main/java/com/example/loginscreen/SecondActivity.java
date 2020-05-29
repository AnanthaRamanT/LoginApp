package com.example.loginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button btn;

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
               logout(v);
           }
       });

    }
      public void logout(View view){

          SharedPreferences preferences=getSharedPreferences("Login",MODE_PRIVATE);

         SharedPreferences.Editor editor=preferences.edit();
         editor.clear();
         editor.commit();

         MainActivity.userid="0";
          Intent i=new Intent(SecondActivity.this,MainActivity.class);
          startActivity(i);



      }


}
