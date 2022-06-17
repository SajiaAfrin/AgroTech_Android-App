package com.mitul.agrotech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] tCrop=getResources().getStringArray(R.array.title_crop);
        final String[] dCrop=getResources().getStringArray(R.array.details_crop);
        listView = findViewById(R.id.list);
        editText=findViewById(R.id.search);
       final  ArrayAdapter<String> adapter= new ArrayAdapter<>(this,
                R.layout.row,R.id.rowTxt,tCrop);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = dCrop[position];
                Intent intent = new Intent(
                        MainActivity.this,MainActivity2.class);
                intent.putExtra("crop",t);
                startActivity(intent);

            }

        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

}