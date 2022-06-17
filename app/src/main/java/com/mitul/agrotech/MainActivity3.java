package com.mitul.agrotech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {
    EditText t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void process(View view) {
        t1=(EditText)findViewById(R.id.t1);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference root=db.getReference();
        root.setValue(t1.getText().toString());
        t1.setText("");
        Toast.makeText(getApplicationContext(), "আপনার প্রশ্ন সংরক্ষিত হয়েছে", Toast.LENGTH_SHORT).show();
    }
}