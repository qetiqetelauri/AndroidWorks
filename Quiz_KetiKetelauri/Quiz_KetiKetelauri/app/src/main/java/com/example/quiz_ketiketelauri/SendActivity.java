package com.example.quiz_ketiketelauri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendActivity extends AppCompatActivity {
    private Button SendButton;
    private EditText Number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        Number = findViewById(R.id.number);
        SendButton = findViewById(R.id.SendButton);
        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:"+Number.getText().toString());
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", " Passe , Score: "+getIntent().getSerializableExtra("score")+"");
                startActivity(intent);
            }
    });
    }
}
