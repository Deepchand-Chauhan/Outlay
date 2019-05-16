package com.example.deepchand.outlay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About Us");

        tv1=(TextView)findViewById(R.id.textView2);
        String str="OUTLAY is an android app which provides an efficient platform to the user to keep track of the total transaction done by them from their bank account."+"\n It will give the details of all transaction done by the user in present day, previous day, and last month."+"\n It will also give the balance detail of the users that how much money is left in the bank account of user."+"\n User don’t need to store his/her bank detail in the app. "+"\n App will read the message which will come from bank after every transaction, by reading the transaction message it will calculate the amount of money left in the account the user.\n" +
                "\n";
        tv1.setText(str);
    }
}
