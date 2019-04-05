package com.r.task_recyclerchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView b1, b2;
    EditText e1;
    ArrayList list;


    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList();
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        e1 = findViewById(R.id.edit1);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        adapter = new MultiViewTypeAdapter(list);
     LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//     linearLayoutManager.setStackFromEnd(true);
//     linearLayoutManager.setSmoothScrollbarEnabled(true);
//        linearLayoutManager.setStackFromEnd(true);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button1:
                String s = e1.getText().toString();
                list.add(new Student(Student.chat_left, s));
                adapter.notifyDataSetChanged();
                clear();
                break;

            case R.id.button2:
                String s1 = e1.getText().toString();
                list.add(new Student(Student.chat_right, s1));
                adapter.notifyDataSetChanged();
                clear();
                break;

        }

    }
    public void clear() {
        e1.setText("");
    }
}
