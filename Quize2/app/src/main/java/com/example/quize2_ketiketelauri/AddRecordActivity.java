package com.example.quize2_ketiketelauri;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRecordActivity extends Activity implements View.OnClickListener {
    private Button addTodoBtn;
    private EditText UserIdEditText;
    private EditText TitleEditText;
    private EditText CompletedEditText;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Record");

        setContentView(R.layout.activity_add);

        UserIdEditText = (EditText) findViewById(R.id.UserID_edittext);
        TitleEditText = (EditText) findViewById(R.id.Title_edittext);
        CompletedEditText = (EditText) findViewById(R.id.Completed_edittext);


        addTodoBtn = (Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
                final Long userId = Long. parseLong(UserIdEditText.getText().toString());
                final String Title = TitleEditText.getText().toString();
                final String Completed = CompletedEditText.getText().toString();

                dbManager.insert(Title,Completed,userId);

                Intent main = new Intent(AddRecordActivity.this, MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
        }

}
