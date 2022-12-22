package com.example.basiclistviewt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvDays;
    private List<String> dataSource;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvDays = findViewById(R.id.lvDays);
        // Them du lieu: thực tế dữ liệu cần lấy ra từ CSDL
        dataSource = new ArrayList<>();
        dataSource.add("Thứ 2");
        dataSource.add("Thứ 3");
        dataSource.add("Thứ 4");
        dataSource.add("Thứ 5");
        dataSource.add("Thứ 6");
        dataSource.add("Thứ 7");
        dataSource.add("Chủ nhật");
        // Adapter
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSource);

        // Set Adapter cho lisstview
        lvDays.setAdapter(arrayAdapter);
        // Onclick, onLongClick
        lvDays.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,dataSource.get(i).toUpperCase(),Toast
                        .LENGTH_SHORT).show();
            }
        });

    }
}