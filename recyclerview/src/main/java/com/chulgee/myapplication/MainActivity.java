package com.chulgee.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView rView;
    RecyclerView.Adapter rAdapter;
    RecyclerView.LayoutManager rLayoutManager;
    int CACHE_SIZE = 10;
    Map<String, Object> cache = new LinkedHashMap<String, Object>(){
        @Override
        protected boolean removeEldestEntry(Entry<String, Object> eldest) {
            return size() > CACHE_SIZE;
        }
    };

    public void add(String key, Object o){
        cache.put(key, o);
    }

    public Object get(String key){
        return cache.get(key);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rView = (RecyclerView)findViewById(R.id.rcy);
        rView.setHasFixedSize(true);

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.drawable.a, "미키마우스"));
        items.add(new Item(R.drawable.a, "광마우스"));
        items.add(new Item(R.drawable.a, "미키마우스"));
        items.add(new Item(R.drawable.a, "미ㅁㅁㅁ키마우스"));
        items.add(new Item(R.drawable.a, "미키마ㅇㅇ우스"));
        items.add(new Item(R.drawable.a, "미키마ㅇㅇ우스"));
        items.add(new Item(R.drawable.a, "미키마ㅇㅇ우스"));

        rLayoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(rLayoutManager);

        rAdapter = new MyAdapter(getApplicationContext(), items);
        rView.setAdapter(rAdapter);
    }
}
