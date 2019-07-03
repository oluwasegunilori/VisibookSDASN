package com.example.visibooksdasna;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.visibooksdasna.Adapter.StudentAdapter;
import com.example.visibooksdasna.Adapter.WorkersAdapter;
import com.example.visibooksdasna.Model.Student;
import com.example.visibooksdasna.Model.Worker;
import com.example.visibooksdasna.database.Database;

import java.util.List;

import in.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView;

public class Workers extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private List<Worker> workerList;
    WorkersAdapter adapter;
    IndexFastScrollRecyclerView studentrecycler;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workers);
        initialize();
        setView();
        navigationView.getMenu().getItem(1).setChecked(true);
    }

    private void initialize() {
        studentrecycler = findViewById(R.id.workerrecycler);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Workers");


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setView() {

        workerList = new Database(this).getWorkers();
        adapter = new WorkersAdapter(this, workerList);
        studentrecycler.setAdapter(adapter);
        studentrecycler.setLayoutManager(new LinearLayoutManager(this));
        studentrecycler.setIndexTextSize(12);
        studentrecycler.setIndexBarColor("#33334c");
        studentrecycler.setIndexBarCornerRadius(0);
        studentrecycler.setIndexBarTransparentValue((float) 0.4);
        studentrecycler.setIndexbarMargin(0);
        studentrecycler.setIndexbarWidth(40);
        studentrecycler.setPreviewPadding(0);
        studentrecycler.setIndexBarTextColor("#FFFFFF");

        studentrecycler.setIndexBarVisibility(true);
        studentrecycler.setIndexbarHighLateTextColor("#33334c");
        studentrecycler.setIndexBarHighLateTextVisibility(true);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(GravityCompat.START);

        }
        else {

            this.moveTaskToBack(true);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.workers, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


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

        if (id == R.id.home) {
            startActivity(new Intent(this, Home.class));

            // Handle the camera action
        } else if (id == R.id.members){
            startActivity(new Intent(this, Members.class));

        }
        else if(id == R.id.churchworkers){

        }
        else if (id == R.id.student) {
            startActivity(new Intent(this, Students.class));

        }


        else if (id == R.id.beliefs) {

            startActivity(new Intent(this, Beliefs.class));

        }
        else if (id == R.id.nav_share) {
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Chapel of Redemption Visibook");
                String shareMessage= "\nDownload From PlayStore\n\n";
                shareMessage = shareMessage + getString(R.string.playstoreid) + BuildConfig.APPLICATION_ID +"\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
            } catch(Exception e) {
                //e.toString();
            }
        }
        else if (id == R.id.nav_send) {

        }
        else if(id == R.id.article){

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else{

        }
        return true;

    }
}
