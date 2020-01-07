package com.example.advancerecyclerview.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.advancerecyclerview.Adapter.TimelineAdapter;
import com.example.advancerecyclerview.Models.TimelineItem;
import com.example.advancerecyclerview.R;
import com.example.advancerecyclerview.Utils.DataSource;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView timelineRv;
    private TimelineAdapter adapter;
    private List<TimelineItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setFullscreen();
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        iniRv();
        getListData();
        setupAdapter();
    }

    private void setupAdapter() {
        adapter = new TimelineAdapter(this, mData);
        timelineRv.setAdapter(adapter);
    }

    private void getListData() {
        mData = DataSource.getTimeLineData();
    }

    private void iniRv() {
        timelineRv = findViewById(R.id.timeline_rv);
        timelineRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setFullscreen(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
