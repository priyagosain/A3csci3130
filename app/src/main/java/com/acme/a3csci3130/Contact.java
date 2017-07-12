package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  String uid;
    public  String business;
    public  String name;
    public  String pbusiness;
    public  String address;
    public  String province;



    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String business, String name, String pbusiness, String address, String province){
        this.uid = uid;
        this.business = business;
        this.name = name;
        this.pbusiness = pbusiness;
        this.address = address;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("business", business);
        result.put("name", name);
        result.put("pbusiness", pbusiness);
        result.put("address", address);
        result.put("province", province);


        return result;
    }
}
