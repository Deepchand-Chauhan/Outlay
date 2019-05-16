package com.example.deepchand.outlay;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalcFragment extends Fragment {
    Intent intent;
    ListView lv1;
TextView tv1,tv2,tv3,tv4,tv5;
    CircleImageView circle_image;
    public CalcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity().setTitle("Detail");

        View view = inflater.inflate(R.layout.fragment_calc, container, false);

        lv1 = (ListView) view.findViewById(R.id.listView1);
        tv1=(TextView) view.findViewById(R.id.textView1);
      //  tv2=(TextView) view.findViewById(R.id.textView3);

        circle_image=(CircleImageView)view.findViewById(R.id.circle_image);

        final Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(2000);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        circle_image.startAnimation(animation);

        circle_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(),"Balance",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getContext(),BalanceActivity.class);
                startActivity(intent);
            }
        });


        intent=getIntent();
        List<String> s;
        s = readAllMessage();

        String messagecsv = "";

        for (int i = 0; i < 1; i++) {
            messagecsv += s.get(i) + ",";
        }

        String messageArray[];

        messageArray = messagecsv.split("Helpline 18001802222,");


        String acc=messagecsv.substring(2,19);
       String status=string123(messagecsv);


        tv1.setText("Account No \n\n"+acc);
     //   tv2.setText("Balance \n"+status);

        return view;
    }

    public List<String> readAllMessage() {
        List<String> sms = new ArrayList<String>();
        String[] phoneNumber = new String[]{"AM-PNBSMS"};
        Uri uriSMSURI = Uri.parse("content://sms/inbox/");
        Cursor cur = getActivity().getContentResolver().query(uriSMSURI, new String[]{"_id", "thread_id", "address", "person", "date", "body", "type"}, "address=?", phoneNumber, "date DESC");

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



    public String string123(String str1)
    {
        String s1=str1;


        String s="";



            s = s1.substring(s1.indexOf("Aval Bal Rs."),s1.indexOf("R.")+1);

           return s;

    }



}
