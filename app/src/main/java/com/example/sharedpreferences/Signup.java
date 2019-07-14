package com.example.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText et1_id,et2_pass,et3_cpass,et4_email,et5_pno;
    Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et1_id=findViewById(R.id.signup_id);
        et2_pass=findViewById(R.id.signup_pass);
        et3_cpass=findViewById(R.id.signup_confirmpass);
        et4_email=findViewById(R.id.signup_email);
        et5_pno=findViewById(R.id.signup_pno);
        btn_save=findViewById(R.id.signup_savebtn);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyData d=new MyData();
                String s= d.save(et1_id.getText().toString(),et2_pass.getText().toString(),et4_email.getText().toString(),et5_pno.getText().toString());
                Toast.makeText(Signup.this, s, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
