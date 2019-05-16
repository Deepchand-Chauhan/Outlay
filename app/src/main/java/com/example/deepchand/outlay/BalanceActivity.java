package com.example.deepchand.outlay;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BalanceActivity extends AppCompatActivity {

    Intent intent;
    TextView tv1,tv2;
    Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        intent=getIntent();
        setTitle("Balance ");

        tv1=(TextView)findViewById(R.id.textView);
       // tv2=(TextView)findViewById(R.id.textView2);
      //  tv3=(TextView)findViewById(R.id.textView3);
        bt1=(Button)findViewById(R.id.button2);
        bt2=(Button)findViewById(R.id.button3);


        List<String> s;
        s = readAllMessage();

        String messagecsv = "";

        for (int i = 0; i < 1; i++) {
            messagecsv += s.get(i) + ",";
        }

         final String debit=msg(messagecsv);
         final String date=msg2(messagecsv);
        String status=string123(messagecsv);
       // String ate=msg3(messagecsv);

        tv1.setText("Available  \n\n"+status);

      //  tv2.setText("Date "+date);
       // tv3.setText("Thru ");
        AlphaAnimation animation = new AlphaAnimation(1, 0);
        animation.setDuration(1500);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        bt1.startAnimation(animation);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view= LayoutInflater.from(BalanceActivity.this).inflate(R.layout.user_output,null);
                final TextView ttv=(TextView)view.findViewById(R.id.textViewout);
              //  Toast.makeText(BalanceActivity.this,debit,Toast.LENGTH_LONG).show();
                AlertDialog.Builder alert=new AlertDialog.Builder(BalanceActivity.this);
                alert.setView(view);
               // alert.setTitle("Status  OF Transaction");
                alert.setMessage(Html.fromHtml("<font color='#0000ff'>"+debit+"</font>"));
                alert.setInverseBackgroundForced(true);
                alert.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      ttv.setText(debit);

                    }
                });
                Dialog dialog=alert.create();
                dialog.show();
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.holo_green_light);
            }
        });


        animation = new AlphaAnimation(0, 1);
        animation.setDuration(1500);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        bt2.startAnimation(animation);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(BalanceActivity.this,date,Toast.LENGTH_LONG).show();

                View view= (LayoutInflater.from(BalanceActivity.this)).inflate(R.layout.user_output,null);
                final TextView ttv=(TextView)view.findViewById(R.id.textViewout);
                AlertDialog.Builder alert=new AlertDialog.Builder(BalanceActivity.this);
                alert.setView(view);
              //  alert.setTitle("Date OF Transaction");
                    alert.setMessage(Html.fromHtml("<font color='#0000ff'>"+date+"</font>"));
                alert.setInverseBackgroundForced(true);
                alert.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ttv.setText(date);

                    }
                });

                Dialog dialog=alert.create();
                dialog.show();
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.holo_green_light);

            }
        });



    }

    public List<String> readAllMessage() {
        List<String> sms = new ArrayList<String>();
        String[] phoneNumber = new String[]{"AM-PNBSMS"};
        Uri uriSMSURI = Uri.parse("content://sms/inbox/");
        Cursor cur = getContentResolver().query(uriSMSURI, new String[]{"_id", "thread_id", "address", "person", "date", "body", "type"}, "address=?", phoneNumber, "date DESC");

        while (cur.moveToNext()) {
            //String address = cur.getString(cur.getColumnIndex("address"));
            String body = cur.getString(cur.getColumnIndexOrThrow("body"));
            sms.add(body);
        }
        return sms;

    }




    public Intent getIntent() {
        return intent;
    }

    public String msg(String str)
    {
        String s1="";
        String s=str;
        s1=s.substring(s.indexOf("Debited with Rs."),s.indexOf(","));

        return s1;
    }
    public String msg2(String str)
    {
        String s1="";
        String s=str;
        s1=s.substring(s.indexOf(","),s.indexOf("thru"));

        return s1;
    }


    public String msg3(String str)
    {
        String s1="";
        String s=str;
        s1=s.substring(s.indexOf("thru"),s.indexOf("."));

        return s1;
    }

    public String string123(String str1)
    {
        String s1=str1;


        String s="";



        s = s1.substring(s1.indexOf("Bal Rs."),s1.indexOf("R.")+1);

        return s;

    }


}
