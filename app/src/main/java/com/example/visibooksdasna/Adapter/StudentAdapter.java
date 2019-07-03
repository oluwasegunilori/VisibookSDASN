package com.example.visibooksdasna.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.visibooksdasna.Model.Student;
import com.example.visibooksdasna.Model.Worker;
import com.example.visibooksdasna.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> implements SectionIndexer {
    private List<Student> studentList;
    private ArrayList<Integer> sectionPosition;
    private Context mcontex;
    public StudentAdapter(Context mcontex, List<Student> studentList) {
        this.mcontex = mcontex;
        this.studentList  = studentList;
    }

    @NonNull
    @Override
    public StudentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mcontex);
        view = inflater.inflate(R.layout.student_item, viewGroup, false);
        return new StudentAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.MyViewHolder viewHolder, final int i) {

        viewHolder.name.setText(studentList.get(i).getName());
        viewHolder.phoneNumber.setText(studentList.get(i).getPhone());
        viewHolder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+Uri.encode(studentList.get(i).getPhone())));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontex.startActivity(callIntent);



            }
        });

        viewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    @Override
    public Object[] getSections() {
        List<String> sections = new ArrayList<>(26);
        sectionPosition = new ArrayList<>(26);
        for (int i = 0, size = studentList.size(); i < size; i++) {
            String section = String.valueOf(studentList.get(i).getName().charAt(0)).toUpperCase();
            if (!sections.contains(section)) {
                sections.add(section);
                sectionPosition.add(i);
            }
        }
        return sections.toArray(new String[0]);
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return  sectionPosition.get(sectionIndex);
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        @BindView(R.id.name)
        public TextView name;
        @BindView(R.id.phone)
        public TextView phoneNumber;
        @BindView(R.id.call)
        public CircleImageView call;
        @BindView(R.id.container)
        public LinearLayout container;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }

}
