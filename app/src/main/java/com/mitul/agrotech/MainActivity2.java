package com.mitul.agrotech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    Button button;
    Button ques_btn;
    Button share_btn;
    Button t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.txt);
        button = findViewById(R.id.copy_bton);
        ques_btn = findViewById(R.id.ques_bton);
        share_btn = findViewById(R.id.share_bton);

        final String dCrop = getIntent().getStringExtra("crop");
        textView.setText(dCrop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Text", dCrop);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(MainActivity2.this, " কপি হয়েছে", Toast.LENGTH_SHORT).show();

            }

        });
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,dCrop);
                intent.setType("text/plain");
                intent= Intent.createChooser(intent,"Share by");
                startActivity(intent);

            }

        });
        ques_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(
                        MainActivity2.this, MainActivity3.class);
                startActivity(intent);
                Toast.makeText(MainActivity2.this, "জিজ্ঞাসা", Toast.LENGTH_SHORT).show();

            }

        });





    }

}