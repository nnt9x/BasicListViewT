package com.example.basiclistviewt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvDays;
    private EditText edtInput;

    private List<String> dataSource;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvDays = findViewById(R.id.lvDays);
        edtInput = findViewById(R.id.edtInput);
        // Them du lieu: thực tế dữ liệu cần lấy ra từ CSDL
        dataSource = new ArrayList<>();

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

    public void addNew(View view) {
        String s = edtInput.getText().toString();
        if(s.isEmpty()){
            edtInput.setError("Không để trống!");
            return;
        }
        dataSource.add(s);
        // Khi du lieuj thay doi -> thong bao cho adapter -> render lai listview
        arrayAdapter.notifyDataSetChanged();
        edtInput.setText("");


    }
}