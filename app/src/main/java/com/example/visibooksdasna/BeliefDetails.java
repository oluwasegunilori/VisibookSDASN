package com.example.visibooksdasna;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.visibooksdasna.Adapter.BeliefDetailsAdapter;
import com.example.visibooksdasna.Model.Belief;
import com.example.visibooksdasna.database.Database;

import java.util.List;

import static com.example.visibooksdasna.common.Common.SHARED_PREFERENCES_FILE_NAME;

public class BeliefDetails extends AppCompatActivity {
ViewPager viewPager;
BeliefDetailsAdapter adapter;
List<Belief> belieflist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belief_details);

        viewPager = findViewById(R.id.viewPager);
        belieflist = new Database(this).getBeliefs();
        adapter = new BeliefDetailsAdapter(this, belieflist);

        setView();
    }

    private void setView() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, MODE_PRIVATE);
       int id = sharedPreferences.getInt("id", 0);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(id);

    }


    public void displayMessage(String title, String content){
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(getApplicationContext());

        alertdialog.setTitle(title);
        alertdialog.setMessage(content);
        alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();



            }
        });
        alertdialog.show();




    }
}
