package com.example.visibooksdasna;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.visibooksdasna.Adapter.MemberAdapter;
import com.example.visibooksdasna.Model.Member;
import com.example.visibooksdasna.database.Database;

import java.util.List;

import in.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView;


public class Members extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    List<Member> memberList;
    MemberAdapter adapter;
    IndexFastScrollRecyclerView memberRecyclerView;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);
        initialize();
        loadView();
        navigationView.getMenu().getItem(2).setChecked(true);



    }

    private void loadView() {

        memberList = new Database(this).getAllMembers();
        adapter = new MemberAdapter(this, memberList);
        memberRecyclerView.setAdapter(adapter);
        memberRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        memberRecyclerView.setIndexTextSize(12);
        memberRecyclerView.setIndexBarColor("#33334c");
        memberRecyclerView.setIndexBarCornerRadius(0);
        memberRecyclerView.setIndexBarTransparentValue((float) 0.4);
        memberRecyclerView.setIndexbarMargin(0);
        memberRecyclerView.setIndexbarWidth(40);
        memberRecyclerView.setPreviewPadding(0);
        memberRecyclerView.setIndexBarTextColor("#FFFFFF");

        memberRecyclerView.setIndexBarVisibility(true);
        memberRecyclerView.setIndexbarHighLateTextColor("#33334c");
        memberRecyclerView.setIndexBarHighLateTextVisibility(true);
    }

    private void initialize() {
        memberRecyclerView = findViewById(R.id.memberrecycler);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Members");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            this.moveTaskToBack(true);

        }
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

        }
        else if(id == R.id.churchworkers){
            startActivity(new Intent(this,Workers.class));

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
