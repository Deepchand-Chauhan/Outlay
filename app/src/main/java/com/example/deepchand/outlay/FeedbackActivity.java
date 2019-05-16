package com.example.deepchand.outlay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    EditText et1,et2;
    Button btn1;
    RadioGroup rg1;
    RadioButton rb1,rb2,rb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setTitle("Feedback");

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        btn1 = (Button) findViewById(R.id.button1);
        rg1=(RadioGroup)findViewById(R.id.radioGroup) ;
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
      btn1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Toast.makeText(FeedbackActivity.this,"Feedback Submitted",Toast.LENGTH_SHORT).show();
          //  FeedbackFragment today1 = new FeedbackFragment();
           //  FragmentManager manager = getSupportFragmentManager();
          //    manager.beginTransaction().replace(R.id.feedback1, today1).commit();

          }
      });



        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                String str = "You have Selected :";
                switch (checkedId) {
                    case R.id.radioButton:
                        str = str + "Feedback";
                        break;

                    case R.id.radioButton2:
                        str = str + "Bug";
                        break;

                    case R.id.radioButton3:
                        str = str + "Other";
                        break;

                }
                Toast.makeText(FeedbackActivity.this,str,Toast.LENGTH_SHORT).show();
            }

        });



    }
}
