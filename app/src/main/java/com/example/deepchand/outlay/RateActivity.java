package com.example.deepchand.outlay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateActivity extends AppCompatActivity {
Button bt1;
    RatingBar rb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        setTitle("Rating...");

 addListenerOnButtonClick();


    }



    public void addListenerOnButtonClick(){
        rb1=(RatingBar)findViewById(R.id.ratingBar);
        bt1=(Button)findViewById(R.id.button1);
        //Performing action on Button Click
        bt1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                //Getting the rating and displaying it on the toast
                String rating=String.valueOf(rb1.getRating());
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
            }

        });
    }


}
