package com.example.vvitcodelabs.uicontrolexample;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText contact_name, contact_number, contact_email;
    //EditText number;
    Spinner contact_type;
    Button save;
    AlertDialog.Builder builder;

    DBhelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contact_name = findViewById(R.id.id_contact_name);
        contact_number= findViewById(R.id.id_contact_number);
        contact_email = findViewById(R.id.id_email);
        //number = findViewById(R.id.id_contact_number);
        contact_type = findViewById(R.id.id_contact_type);
        save = findViewById(R.id.id_contact_save);
        helper = new DBhelper(this, null, null, 0);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you wish to save the contact");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Contact contact = new Contact();
                        contact.setContact_name(contact_name.getText().toString());
                        contact.setContact_email(contact_email.getText().toString());
                        contact.setContact_number(contact_number.getText().toString());
                        contact.setContact_type(contact_type.getSelectedItem().toString());

                        helper.storeData(contact);


                        Toast.makeText(getApplicationContext(), "contact saved", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
    }

    //@SuppressLint("NewApi")
    //public void printToast(View view) {
      //  Toast.makeText(this, contact_name.getText().toString(), Toast.LENGTH_SHORT).show();
        // Toast.makeText(this, number.getText().toString(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+contact_type.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    
}


