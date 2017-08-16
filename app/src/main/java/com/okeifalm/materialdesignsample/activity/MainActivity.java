package com.okeifalm.materialdesignsample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.okeifalm.materialdesignsample.R;
import com.okeifalm.materialdesignsample.adapter.CardRecyclerAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        String myDataset[] = {"aaaaa", "bbbbb", "ccccc"};

        mAdapter = new CardRecyclerAdapter(myDataset, getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
    }
}
