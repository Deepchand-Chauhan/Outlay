package com.example.deepchand.outlay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class FaqActivity extends AppCompatActivity {
TextView tv1,tv2,tv3,tv4,tv5,tv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        setTitle("FAQ..");

        tv1=(TextView)findViewById(R.id.textView2);
        tv2=(TextView)findViewById(R.id.textView3);
        tv3=(TextView)findViewById(R.id.textView4);
        tv4=(TextView)findViewById(R.id.textView5);
        tv5=(TextView)findViewById(R.id.textView6);
        tv6=(TextView)findViewById(R.id.textView7);
        tv1.setMovementMethod(new ScrollingMovementMethod());
        tv2.setMovementMethod(new ScrollingMovementMethod());
        tv3.setMovementMethod(new ScrollingMovementMethod());
        tv4.setMovementMethod(new ScrollingMovementMethod());
        tv5.setMovementMethod(new ScrollingMovementMethod());
        tv6.setMovementMethod(new ScrollingMovementMethod());
        String str="Ques.  How does the app get information on my spends, billsand transactions?";
        tv1.setText(str);
        String str2="Ans. The app picks up datafrom the SMS sent by your bank,billers or merchants to your phone. The SMS data is organized into an easy to understand view.";
        tv2.setText(str2);
        String str3="Ques.Is my data secure?";
        String str4="Ans.The app is designed with multiple llevel of security and privacy protection. "+"\n"+"1- The app doesn't have access to or task for any sensitive data -like full acoount numbers , bank login/password,otps etc."+"\n"+"2-  Your data is never shared with anyone."+"\n"+" 3- Your personal SMS are nerver read.";
        tv3.setText(str3);
        tv4.setText(str4);

        String str5="Ques. What is Outlay backup ?";
        String str6="Ans. Outlay encrypts your app data and saved it our secured servers. "+"\n Ths is automatically done once in a day when phone is connected to wifi and is charging. By default auto backup is disabled. To enable go to settings.";
tv5.setText(str5);
tv6.setText(str6);
    }
}
