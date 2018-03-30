package com.example.vvipul15.a2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity{

        EditText et_name,et_id,et_phone,et_location;
        String name,id,location,phone;
   // private Integer array;
        Button regbtn;
   // String myStringData,myEmailData,myPhoneData,myPassword,myCpassword;
Firebase myFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        et_name= (EditText) findViewById(R.id.name);
        et_id= (EditText) findViewById(R.id.id);
        et_phone= (EditText) findViewById(R.id.phone);
       et_location= (EditText) findViewById(R.id.location);
      //  et_cpassword= (EditText) findViewById(R.id.cpassword);
        regbtn = (Button) findViewById(R.id.regbtn);


        Firebase.setAndroidContext(this);

       // String DeviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(),Settings.Secure.ANDROID_ID);
        myFirebase = new Firebase("https://hotel-15.firebaseio.com/ecommerce/customer"  );
     //  myFirebase = FirebaseDatabase.getInstance().getReference();
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   name = et_name.getText().toString();
                   id = et_id.getText().toString();
                   location = et_location.getText().toString();
                   phone = et_phone.getText().toString();
                   //  cpassword = et_cpassword.getText().toString();

              Firebase myNewChild = myFirebase.child(name);
                myFirebase = new Firebase("https://hotel-15.firebaseio.com/ecommerce/customer/" + name  );

                Firebase myNewChild1 = myFirebase.child("Id");
                myNewChild1.setValue(id);
                Firebase myNewChild2 = myFirebase.child("Location");
                  myNewChild2.setValue(location);
                Firebase myNewChild3 = myFirebase.child("Phone");
                myNewChild3.setValue(phone);
                Intent intent = new Intent(register.this, list_generator.class);
                startActivity(intent);
               //  myNewChild.setValue(password);
              //    myNewChild.setValue(cpassword);
               //     myNewChild.setValue(email);
            //    Toast.makeText(register.this, name + "is updated with" + phone, Toast.LENGTH_SHORT).show();
                 registerr();
                }

        });
    }
    public void registerr(){
        initialize();
        if (!validate()) {
            Toast.makeText(this,"Signup has failed",Toast.LENGTH_SHORT).show();
        }
        else{
            onSignupSuccess();
        }
    }
    public void onSignupSuccess(){
//TODO
    }
    public boolean validate(){
boolean valid = true;
        if(name.isEmpty() ||name.length()>32){
            et_name.setError("Please enter valid name");
            valid = false;
        }
     if(id.isEmpty() ||!Patterns.EMAIL_ADDRESS.matcher(id).matches()){
            et_id.setError("Please enter valid id");
            valid =false;
        }
        if(location.isEmpty()){
            et_location.setError("Please enter single word location");
            valid = false;
        }
     //   if(cpassword.isEmpty()) {
       //     et_cpassword.setError("Please enter valid password");
       //     valid = false;
       // }
        if(phone.isEmpty() || phone.length()<10 || phone.length()>10) {
            et_phone.setError("Please enter valid phone");
            valid = false;
        }

        return valid;
    }
public void initialize(){
    name = et_name.getText().toString().trim();
    id = et_id.getText().toString().trim();
    phone = et_phone.getText().toString().trim();
    location = et_location.getText().toString().trim();
   // cpassword = et_cpassword.getText().toString().trim();
}
}