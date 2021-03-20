package com.example.covidawareregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;

    TextView orlogin;

    //errors
    TextView usernameerror;
    TextView passworderror;
    TextView phonenumbererror;

    //edittext fields
    EditText usernamefield;
    EditText passwordfield;
    EditText repassfield;
    EditText phonenumberfield;
    EditText Aadharnumberfield;

    //storing creds
    String username;
    String password;
    String phonenumber;
    String aadharnumber;


    //sign up process
    public void signup(View v){
        //get users details and store them in variables
        final int[] allfieldsvalid = {0};
        username = usernamefield.getText().toString();

        if(usernamefield.getText().toString().matches("") || usernamefield.getText().toString().contains("\\s")){
            usernameerror.setText("Please enter a valid username");

        }
        else{
            usernameerror.setText(""); //reset the error textview
            allfieldsvalid[0]++;


        }

        //checking phone number field
        if(phonenumberfield.getText().toString().matches("") || phonenumberfield.length() < 10){
            phonenumbererror.setText("Please enter a valid phone number");
        }
        else{      //if valid phone number
            phonenumbererror.setText("");
            allfieldsvalid[0]++;
        }
        Log.i("checkey", Integer.toString(allfieldsvalid[0]));

        //checking aadhar number field
        if(Aadharnumberfield.getText().toString().matches("") || Aadharnumberfield.length() < 12){
            phonenumbererror.setText("Please enter a valid Aadhar card number");
        }
        else{      //if valid phone number
            phonenumbererror.setText("");
            allfieldsvalid[0]++;
        }

        //once all criteria has been met
        if(allfieldsvalid[0] == 3){
            phonenumber = phonenumberfield.getText().toString();
            aadharnumber = Aadharnumberfield.getText().toString();

            Log.i("creds", username + " "+ phonenumber+ " "+ aadharnumber);  //Access creds from here

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.blueappcolorthemedark));
        try {
            getSupportActionBar().hide();
        }catch (NullPointerException e){
            Log.i("check",e.getMessage());
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Textview orlogin for jumping to login activity

        orlogin = (TextView) findViewById(R.id.orlogin);
        orlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                //startActivity(intent);                                START INTENT FROM HERE
            }
        });

        //error textviews
        usernameerror = (TextView) findViewById(R.id.usernameerror);

        phonenumbererror = (TextView) findViewById(R.id.phonenumbererror);



        //initializing user creds
        username = "";
        phonenumber = "";
        aadharnumber = "";

        //Background
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintlayout);

        //user's details fields
        usernamefield = (EditText) findViewById(R.id.usernamefield);
        phonenumberfield = (EditText) findViewById(R.id.phonenumberfield);
        Aadharnumberfield = (EditText) findViewById(R.id.aadharnumberfield);





        //Setting keyboard to drop if clicked anywhere els

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
                catch (java.lang.NullPointerException e){
                    e.printStackTrace();
                }
            }
        });



    }
}