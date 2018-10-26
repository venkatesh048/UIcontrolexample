package com.example.vvitcodelabs.uicontrolexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {
    TextView display_name, display_email, display_type, display_number;
    DBhelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        display_name = findViewById(R.id.display_name);
        display_number = findViewById(R.id.display_number);
        display_email = findViewById(R.id.display_email);
        display_type = findViewById(R.id.display_type);

        helper = new DBhelper(this,null,null,0);
        Contact contact = helper.getData();
        if (contact!=null){
            display_name.setText(contact.getContact_name());
            display_email.setText(contact.getContact_email());
            display_number.setText(contact.getContact_number());
            display_type.setText(contact.getContact_type());
        }
        else {
            Toast.makeText(this, "No contact saved", Toast.LENGTH_SHORT).show();
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
