package com.example.newact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        Button ret = (Button) findViewById(R.id.ret);
        TextView[] tx = new TextView[11];
        for(int i =0; i<11; i++) {
            String oke = "txt" + Integer.toString(i++);
            int resID = getResources().getIdentifier(oke, "id", getPackageName());
            tx[i] = (TextView) findViewById(resID);

            }




        Intent intent = getIntent();
        String[] keys = new String[12];

        for(int i =0; i<11; i++) {
        String oke = "key" + Integer.toString(i++);
        keys[i] = oke;
        tx[i].setText(keys[i]);
        }

        String fname = intent.getStringExtra(  "fname_key");
        String gender = intent.getStringExtra( "gender_key");
        String pnum = intent.getStringExtra( "pnum_key");
        String name = intent.getStringExtra( "Iname_key");
        String bdate= intent.getStringExtra( "bdate_key");
         String email = intent.getStringExtra( "eadd_key");
//        tFname.setText(fname);
//        tLname.setText(name);
//        tGender.setText(gender);
//        tBdate.setText(bdate);
//        tPnum.setText(pnum);
//        tEmail.setText(email);


        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}