package com.example.vvipul15.a2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity{
    private EditText et_name,et_email,et_phone,et_password,et_cpassword;
    private String name,email,password,cpassword,phone;
   // private Integer array;
    Button regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        et_name= (EditText) findViewById(R.id.name);
        et_email= (EditText) findViewById(R.id.email);
        et_phone= (EditText) findViewById(R.id.phone);
        et_password= (EditText) findViewById(R.id.password);
        et_cpassword= (EditText) findViewById(R.id.cpassword);
        regbtn = (Button) findViewById(R.id.regbtn);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        if(email.isEmpty() ||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_email.setError("Please enter valid email");
            valid =false;
        }
        if(password.isEmpty()){
            et_password.setError("Please enter valid password");
            valid = false;
        }
        if(cpassword.isEmpty()) {
            et_cpassword.setError("Please enter valid password");
            valid = false;
        }
        if(phone.isEmpty() || phone.length()<10 || phone.length()>10) {
            et_phone.setError("Please enter valid phone");
            valid = false;
        }
        return valid;
    }
public void initialize(){
    name = et_name.getText().toString().trim();
    email = et_email.getText().toString().trim();
    phone = et_phone.getText().toString().trim();
    password = et_password.getText().toString().trim();
    cpassword = et_cpassword.getText().toString().trim();
}
}