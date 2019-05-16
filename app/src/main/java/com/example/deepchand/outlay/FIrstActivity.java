package com.example.deepchand.outlay;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FIrstActivity extends AppCompatActivity {

    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        lv1 = (ListView) findViewById(R.id.listView1);

        List<String> s;
        s = readAllMessage();

        String messagecsv = "";

        for (int i = 0; i < s.size(); i++) {
            messagecsv += s.get(i) + ",";
        }

        String messageArray[];

        messageArray = messagecsv.split(",");

        //Create Array Adapter and Pass ArrayOfValues to it.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, messageArray);

        //BindAdpater with our Actual ListView
        lv1.setAdapter(adapter);

        //Do something on click on ListView Click on Items
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // Here you can add code like forward, reply, etc
            }
        });
    }

    public List<String> readAllMessage() {
        List<String> sms = new ArrayList<String>();
        String[] phoneNumber = new String[]{"AM-PNBSMS"};
        Uri uriSMSURI = Uri.parse("content://sms/inbox/");
        Cursor cur = getContentResolver().query(uriSMSURI, new String[]{"_id", "thread_id", "address", "person", "date", "body", "type"}, "address=?", phoneNumber, null);

        while (cur.moveToNext()) {
            //String address = cur.getString(cur.getColumnIndex("address"));
            String body = cur.getString(cur.getColumnIndexOrThrow("body"));
            sms.add(body);
        }
        return sms;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
