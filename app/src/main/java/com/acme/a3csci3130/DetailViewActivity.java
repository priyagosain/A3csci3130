package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, businessField, pbusinessField, addressField, provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        businessField  = (EditText) findViewById(R.id.business);
        nameField = (EditText) findViewById(R.id.name);
        pbusinessField = (EditText) findViewById(R.id.pbusiness);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            businessField.setText(receivedPersonInfo.business);
            nameField.setText(receivedPersonInfo.name);
            pbusinessField.setText(receivedPersonInfo.pbusiness);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);

            //emailField.setText(receivedPersonInfo.email);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality

        String personID = receivedPersonInfo.uid;
        String business = businessField.getText().toString();
        String name = nameField.getText().toString();
        String pbusiness = pbusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();

        Contact contact = new Contact(personID, business, name, pbusiness, address, province);

        // set values in firebase for the personID
        appState.firebaseReference.child(receivedPersonInfo.uid).setValue(contact);
        // return to main menu
        finish();

    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        // erase values in firebase for the personID
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();
        // return to main menu
        finish();
    }
}
