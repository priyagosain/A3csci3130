package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailViewActivity extends Activity {

    private EditText nameField, businessField, pbusinessField, addressField, provinceField;
    Contact receivedPersonInfo;
    private DatabaseReference appState;

    // to fill the data of the contact in the views
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        appState = FirebaseDatabase.getInstance().getReference();

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
        }
    }

    /**
     *
     * update the values of the data in the fireBase database
     */

    public void updateContact(View v){
        //TODO: Update contact funcionality

        DatabaseReference ref = appState.child("contacts").child(receivedPersonInfo.uid);

        Log.d("uid", ref.getKey());
        String business = businessField.getText().toString();
        ref.child("business").setValue(business);
        String name = nameField.getText().toString();
        ref.child("name").setValue(name);
        String pbusiness = pbusinessField.getText().toString();
        ref.child("pbusiness").setValue(pbusiness);
        String address = addressField.getText().toString();
        ref.child("address").setValue(address);
        String province = provinceField.getText().toString();
        ref.child("province").setValue(province);

        // return to main menu
        finish();
    }

    /**
     *
     * erase the values of the data in the fireBase database
     */
    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        // erase values in firebase for the personID

        DatabaseReference ref = appState.child("contacts");
        DatabaseReference c = ref.child(receivedPersonInfo.uid);
        Log.d("uid", c.getKey());
        ref.child(c.getKey()).removeValue();

        // return to main menu
        finish();
    }
}

