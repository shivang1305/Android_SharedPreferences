package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txt=findViewById(R.id.txtview);
        SharedPreferences sp=getSharedPreferences("myprefs",MODE_PRIVATE);
        txt.setText("WELCOME    --------->   "+sp.getString("id",""));
    }
}
