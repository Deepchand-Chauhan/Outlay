package com.example.deepchand.outlay;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {


    public FeedbackFragment() {
        // Required empty public constructor
    }


    String str[]={"Feedback","FAQ","About","Rate Us"};


ListView lv1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        List<String> list;


        final View view=inflater.inflate(R.layout.fragment_feedback, container, false);
        getActivity().setTitle("More ");
        lv1=(ListView)view.findViewById(R.id.listView);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, str);

        //BindAdpater with our Actual ListView
        lv1.setAdapter(adapter);

        //Do something on click on ListView Click on Items
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // Here you can add code like forward, reply, etc

                if(str[arg2].equals("Feedback"))
                {

                    Intent intent=new Intent(getActivity().getApplication(),FeedbackActivity.class);
                    startActivity(intent);

                }
                else if(str[arg2].equals("FAQ"))
                {

                    Intent intent=new Intent(getActivity().getApplication(),FaqActivity.class);
                    startActivity(intent);
                }
                else if(str[arg2].equals("About"))
                {

                    Intent intent=new Intent(getActivity().getApplication(),AboutActivity.class);
                    startActivity(intent);
                }
                else if(str[arg2].equals("Rate Us"))
                {

                    Intent intent=new Intent(getActivity().getApplication(),RateActivity.class);
                    startActivity(intent);
                }
            }
        });
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.fragment_feedback,R.id.textView,str);
      //  lv1.setAdapter(adapter);

        return view;
    }

}
