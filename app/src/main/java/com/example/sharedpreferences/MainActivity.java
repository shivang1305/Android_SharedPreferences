package com.example.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id,pass;
    Button login,signup;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp=getSharedPreferences("myprefs",MODE_PRIVATE);
        if(!sp.getString("id","kaddu").equals("kaddu"))
        {
            Intent in=new Intent(MainActivity.this,Home.class);
            startActivity(in);
        }
        setContentView(R.layout.activity_main);
        id=findViewById(R.id.home_id);
        pass=findViewById(R.id.home_pass);
        login=findViewById(R.id.home_loginbtn);
        signup=findViewById(R.id.home_signupbtn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,Signup.class);
                startActivity(in);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ""+id.getText(), Toast.LENGTH_SHORT).show();
                MyData m=new MyData();
                Boolean result= m.isValid(id.getText().toString(),pass.getText().toString());
                if(result==true)
                {
                    SharedPreferences sp=getSharedPreferences("myprefs",MODE_PRIVATE);
                    SharedPreferences.Editor ed=sp.edit();
                    ed.putString("id",id.getText().toString());
                //    Toast.makeText(MainActivity.this, ""+sp.getString("id",null), Toast.LENGTH_SHORT).show();
                    ed.commit();
                    intent=new Intent(MainActivity.this,Home.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Sorry Invalid ID or Password ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
