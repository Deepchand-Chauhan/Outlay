package com.example.deepchand.outlay;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment extends Fragment {
    ListView lv1;
Intent intent;
    public TodayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_today, container, false);



      //  Bundle bundle =getArguments();
      ////  String myValue = bundle.getString("message");

        //String bank=editBank(myValue);

getActivity().setTitle("Recent Transaction");

        lv1 = (ListView) view.findViewById(R.id.listView1);;
        intent=getIntent();
        List<String> s;
        s = readAllMessage();

        String messagecsv = "";

        for (int i = 0; i < 3; i++) {
            messagecsv += s.get(i) + ",";
        }

        String messageArray[];

        messageArray = messagecsv.split("Helpline 18001802222,");

        //Create Array Adapter and Pass ArrayOfValues to it.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, messageArray);

        //BindAdpater with our Actual ListView
        lv1.setAdapter(adapter);

        //Do something on click on ListView Click on Items
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // Here you can add code like forward, reply, etc
            }
        });
        return view;
    }

    public List<String> readAllMessage() {
       // String bnk=bank;
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





}
