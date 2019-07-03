package com.example.visibooksdasna.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.visibooksdasna.Model.Belief;
import com.example.visibooksdasna.Model.Member;
import com.example.visibooksdasna.Model.Student;
import com.example.visibooksdasna.Model.Worker;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by SHEGZ on 1/1/2018.
 */
public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME = "members.sqlite";
    private static final int DB_VERSION = 1;


    public Database(Context context) {



        super(context, DB_NAME, null, DB_VERSION);
    }










    public List<Member>  getAllMembers (){
        List<Member> details = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("SELECT * FROM  tb_membersprofile");
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        if(cursor.moveToFirst())

        {
            do{
                details.add(new Member(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("full_name")),
                        cursor.getString(cursor.getColumnIndex("phone_number")), cursor.getString(cursor.getColumnIndex("date_ofbirth")),
                        cursor.getString(cursor.getColumnIndex("email_address")),
                        cursor.getString(cursor.getColumnIndex("Home_address")),
                        cursor.getString(cursor.getColumnIndex("Post"))));
            }while(cursor.moveToNext());


        }


        cursor.close();
        return details;
    }

    public List<Student>  getAllStudent (){
        List<Student> details = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("SELECT * FROM  tb_schoolofnursing");
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        if(cursor.moveToFirst())

        {
            do{
                details.add(new Student(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("Full_name")),
                        cursor.getInt(cursor.getColumnIndex("Part")), cursor.getString(cursor.getColumnIndex("Date_ofbirth")),
                        cursor.getString(cursor.getColumnIndex("Phone_number")),
                        cursor.getString(cursor.getColumnIndex("Hostel_Address")),
                        cursor.getString(cursor.getColumnIndex("Email_Address"))));
            }while(cursor.moveToNext());


        }


        cursor.close();
        return details;
    }



    public List<Worker>  getWorkers (){
        List<Worker> details = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("SELECT * FROM  tb_membersprofile where Post != '%s'", "Member");
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        if(cursor.moveToFirst())

        {
            do{
                details.add(new Worker(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("full_name")),
                        cursor.getString(cursor.getColumnIndex("phone_number")), cursor.getString(cursor.getColumnIndex("date_ofbirth")),
                        cursor.getString(cursor.getColumnIndex("email_address")),
                        cursor.getString(cursor.getColumnIndex("Home_address")),
                        cursor.getString(cursor.getColumnIndex("Post"))));
            }while(cursor.moveToNext());


        }


        cursor.close();
        return details;
    }




    public List<Belief>  getBeliefs(){
        List<Belief> details = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("SELECT * FROM  tb_adventistbeliefs");
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        if(cursor.moveToFirst())

        {
            do{
                details.add(new Belief(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("title")),
                        cursor.getString(cursor.getColumnIndex("details")), cursor.getString(cursor.getColumnIndex("Bible_Verse"))));
            }while(cursor.moveToNext());


        }


        cursor.close();
        return details;
    }


    public String getBibleText(int id){
        String bibletext = "";
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("SELECT * FROM  tb_adventistbeliefs where id = '%d'", id);
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        if(cursor.moveToFirst())

        {
           bibletext =cursor.getString(cursor.getColumnIndex("Bible_Verse"));

        }


        cursor.close();
        return bibletext;
    }



}
