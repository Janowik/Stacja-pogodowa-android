package com.example.jacek.stacjapogodowa;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.kosalgeek.asynctask.AsyncResponse;
public class MainActivity extends AppCompatActivity implements AsyncResponse {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.informacje:
                Intent intent = new Intent(this, InfoActivity.class);
                this.startActivity(intent);
                return true;
    }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void processFinish(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

}


