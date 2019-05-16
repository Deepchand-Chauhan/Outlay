package com.example.deepchand.outlay;


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
 * Use the {@link WeekFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeekFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ListView lv1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public WeekFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeekFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeekFragment newInstance(String param1, String param2) {
        WeekFragment fragment = new WeekFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_week, container, false);

        getActivity().setTitle("Previous Transaction");
       // Bundle bundle = getArguments();
     //   String myValue = bundle.getString("message");

      //  String bank=editBank(myValue);
        lv1 = (ListView) view.findViewById(R.id.listView2);

        List<String> s;
        s = readAllMessage();

        String messagecsv = "";

        for (int i = 3; i < 6; i++) {
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
        List<String> sms = new ArrayList<String>();
      //  String bnk=bank;
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





}
