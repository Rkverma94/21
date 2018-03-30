package com.example.vvipul15.a2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.Arrays;



public class list_generator extends AppCompatActivity {

    private ArrayList<String> arrayList, arrayList2;
    private ArrayAdapter<String> adapter, adapter2;
    EditText txtInput, txtInput2,et_name;
    // private EditText textView7;

    TextView et_txtview,et_txtview2;
    String name,textitem,textitem2;

    Firebase myFirebase,myFirebase2;

    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_generator);


    //    et_txtview= (TextView) findViewById(R.id.textitem);
      //  et_txtview2= (TextView) findViewById(R.id.textitem2);



        final ListView listView = (ListView) findViewById(R.id.listv);
        String[] items = {"Apple"};


        arrayList = new ArrayList<String>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.textitem, arrayList);

        final ListView listView2 = (ListView) findViewById(R.id.listv2);
        String[] items1 = {"1"};


        arrayList2 = new ArrayList<String>(Arrays.asList(items1));
        adapter2 = new ArrayAdapter<String>(this, R.layout.list_item2, R.id.textitem2, arrayList2);

        //  ListView listV=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
        txtInput = (EditText) findViewById(R.id.txtinput);
        listView2.setAdapter(adapter2);
        txtInput2 = (EditText) findViewById(R.id.txtinput2);

    //  et_name= (EditText) findViewById(R.id.name);

      //  Firebase.setAndroidContext(this);
       // name = et_name.getText().toString();

        Button btAdd = (Button) findViewById(R.id.button3);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newItem = txtInput.getText().toString();
                arrayList.add(newItem);

         //       myFirebase = new Firebase("https://hotel-15.firebaseio.com/ecommerce/customer/" + name  );

                myFirebase2 = new Firebase("https://hotel-15.firebaseio.com/ecommerce/customer/Rakesh/BIll Database"  );
                Firebase myNewChild1 = myFirebase.child(newItem);
                String newItem1 = txtInput2.getText().toString();
                arrayList2.add(newItem1);
                myNewChild1.setValue(newItem1);

                // add new item to arraylist

             //   String newItem1 = txtInput2.getText().toString();
             //   arrayList2.add(newItem1);

              //  myFirebase = new Firebase("https://hotel-15.firebaseio.com/ecommerce/customer" + name  );
              //  Firebase myNewChild2 = myFirebase.child("Quantity");
              //  myNewChild2.setValue(newItem1);
                // notify listview of data changed
                adapter.notifyDataSetChanged();
                adapter2.notifyDataSetChanged();



            }

        });



        Button btAdd2 = (Button) findViewById(R.id.button4);
        btAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                ListView listView = (ListView) findViewById(R.id.listv);
                String[] items = {"Apple"};

                arrayList = new ArrayList<String>(Arrays.asList(items));
                adapter = new ArrayAdapter<String>(list_generator.this, R.layout.list_item, R.id.textitem, arrayList);

                ListView listView2 = (ListView) findViewById(R.id.listv2);
                String[] items1 = {"1"};

                arrayList2 = new ArrayList<String>(Arrays.asList(items1));
                adapter2 = new ArrayAdapter<String>(list_generator.this, R.layout.list_item2, R.id.textitem2, arrayList2);

                Firebase.setAndroidContext(list_generator.this);
                name = et_name.getText().toString();
                textitem = et_txtview.getText().toString();
                textitem2 = et_txtview2.getText().toString();

                Firebase myNewChild = myFirebase.child(name);
                myFirebase = new Firebase("https://hotel-15.firebaseio.com/ecommerce/customer" + name  );
                Firebase myNewChild1 = myFirebase.child("Food Item");
                myNewChild1.setValue(textitem);
                Firebase myNewChild2 = myFirebase.child("Quantity");
                myNewChild2.setValue(textitem2);
                */
                Intent intent = new Intent(list_generator.this, list_generator.class);
                startActivity(intent);
               Toast.makeText(list_generator.this, "Your Bill has sent to NearBy Retailers!!", Toast.LENGTH_SHORT).show();

            }
        });
  /*      Firebase.setAndroidContext(this);
        name = et_name.getText().toString();
        textitem = et_txtview.getText().toString();
        textitem2 = et_txtview2.getText().toString();
        Firebase myNewChild = myFirebase.child(name);
        myFirebase = new Firebase("https://hotel-15.firebaseio.com/ecommerce/customer" + name  );
        Firebase myNewChild1 = myFirebase.child("Food Item");
        myNewChild1.setValue(textitem);
        Firebase myNewChild2 = myFirebase.child("Quantity");
        myNewChild2.setValue(textitem2);
*/
    }
}



