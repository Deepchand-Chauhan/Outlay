package com.example.deepchand.outlay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Homescreen extends AppCompatActivity {

    EditText editText,editText3;
    Button button;

    UserSesssion session;
   // Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        setTitle("Register");
        session = new UserSesssion(getApplicationContext());



       editText3= (EditText)findViewById(R.id.editText3);
        editText= (EditText)findViewById(R.id.editText);
      //  spinner=(Spinner)findViewById(R.id.spinner);


     //   Toast.makeText(getApplicationContext(),
              //  "User Login Status: " + session.isUserLoggedIn(),
              //  Toast.LENGTH_LONG).show();


        button =  (Button)findViewById(R.id.button);
      //  Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=editText3.getText().toString();
                String s2=editText.getText().toString();

                if(s1.trim().length()>0 && s2.trim().length()>0){

                    session.createUserLoginSession(s1, s2);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("nm",s1);
                    intent.putExtra("email",s2);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                    finish();

                }else{

                    // user didn't entered username or password
                    Toast.makeText(getApplicationContext(), "Please enter Username and Email", Toast.LENGTH_LONG).show();

                }


            }
        });






    }
}
