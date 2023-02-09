package com.example.hw_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText gmail, theme, massage;
    private Button btnSend;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gmail = findViewById(R.id.et_gmail);
        theme = findViewById(R.id.et_theme);
        massage = findViewById(R.id.et_massage);
        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ggmail = gmail.getText().toString().trim();
                String ttheme = theme.getText().toString().trim();
                String mmassage = massage.getText().toString().trim();

                sendEmail(ggmail, ttheme, mmassage);
            }
        });
    }

    private void sendEmail(String gmail, String theme, String massage){
        Intent gmailIntent = new Intent(Intent.ACTION_SEND);
        gmailIntent.setData(Uri.parse("mailto"));
        gmailIntent.setType("text/plain");

        gmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{gmail});
        gmailIntent.putExtra(Intent.EXTRA_SUBJECT, theme);
        gmailIntent.putExtra(Intent.EXTRA_TEXT, massage);
        try {
            startActivity(Intent.createChooser(gmailIntent, "Choose an Email Client"));
        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}