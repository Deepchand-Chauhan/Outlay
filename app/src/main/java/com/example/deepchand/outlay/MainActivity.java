package com.example.deepchand.outlay;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
 static String title = "OutLay";
Intent intent;
    TextView tv1,tv2;
    UserSesssion session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
        session = new UserSesssion(getApplicationContext());
        intent=getIntent();
     //  String name=intent.getStringExtra("nm");
      //  String email=intent.getStringExtra("email");

        NavigationView navigationView1=(NavigationView)findViewById(R.id.nav_view);
        View headerview=navigationView1.getHeaderView(0);

        HashMap<String, String> user = session.getUserDetails();

        // get name
        String name = user.get(UserSesssion.KEY_NAME);

        // get email
        String email = user.get(UserSesssion.KEY_EMAIL);



          tv1=(TextView)headerview.findViewById(R.id.textView1);
        tv2=(TextView)headerview.findViewById(R.id.textView2);
              tv1.setText(name);
        tv2.setText(email);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_camera);
            setFragment(new TodayFragment(), title);
        } else {
            title = savedInstanceState.getString("title");
            setTitle(title);
        }


        if(session.checkLogin())
            finish();

    }

    @Override
    public void onBackPressed() {
       moveTaskToBack(true);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("title", title);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        title = item.getTitle().toString();
        if (id == R.id.nav_camera) {

            Toast.makeText(this, "Recent Transaction", Toast.LENGTH_SHORT).show();
            Fragment today = new TodayFragment();
            FragmentManager manager = getSupportFragmentManager();

            manager.beginTransaction().replace(R.id.relative_layout_for_fragment, today, today.getTag()).commit();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "Previous Transaction", Toast.LENGTH_SHORT).show();
            Fragment week = WeekFragment.newInstance("deep", "chand");
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment, week).commit();

        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, "All transaction", Toast.LENGTH_SHORT).show();
            setFragment(new MonthFragment(), title);
        }
        else if (id == R.id.nav_calc) {
            Toast.makeText(this, "Balance Enquiry", Toast.LENGTH_SHORT).show();
            setFragment(new CalcFragment(), title);
        }
        else if (id == R.id.nav_share) {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_feedback) {
            Toast.makeText(this, "More ", Toast.LENGTH_SHORT).show();
            setFragment(new FeedbackFragment(),title);
        }

        item.setChecked(true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setFragment(final Fragment fragment,final String title) {
        setTitle(title);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relative_layout_for_fragment, fragment)
                .commit();

    }




}
