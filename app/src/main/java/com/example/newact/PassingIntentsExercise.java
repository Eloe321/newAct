package com.example.newact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class PassingIntentsExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);
        Spinner dropdown1 = findViewById(R.id.spinner1);

        String[] items1 = new String[]{"1st Year", "2nd Year", "3rd Year", "4th Year", "5th Year"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        dropdown1.setAdapter(adapter);

        Spinner dropdown2 = findViewById(R.id.spinner2);

        String[] items2 = new String[]{"BSCS", "BSIT", "BSBA", "BSCE", "BSCPE", "BSFA"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);



        startProgram();
    }

    void startProgram(){

            EditText[] edi = new EditText[6];

            for(int i =0; i<11; i++) {
                String oke = "edi" + Integer.toString(i++);
                int resID = getResources().getIdentifier(oke, "id", getPackageName());
                edi[i] = (EditText) findViewById(resID);
                if(i < 6) {
                    int finalI = i;
                    edi[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (edi[finalI].getText().equals("First Name") || edi[finalI].getText().equals("Last Name"))
                                edi[finalI].setText("");
                        }
                    });
                }
            }

        RadioButton rMale = findViewById(R.id.rMale);
        RadioButton rFem = findViewById(R.id.rFemale);
        RadioButton roth = findViewById(R.id.rOthers);



            Button sub = (Button) findViewById(R.id.Submit);
            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String fName = edi[0].getText().toString();
                    String lName = edi[1].getText().toString();
                    String MFName = edi[2].getText().toString();
                    String MLName = edi[3].getText().toString();
                    String FrFName = edi[4].getText().toString();
                    String FrLName = edi[5].getText().toString();
                    String eAddress = edi[6].getText().toString();
                    String bDate = edi[7].getText().toString();
                    String pNumber = edi[8].getText().toString();
                    String pEmerNumber = edi[9].getText().toString();
                    String emailAdd = edi[10].getText().toString();



                    String gender;
                    if(rMale.isChecked())
                        gender = "Male";
                    else if (rFem.isChecked())
                        gender = "Female";
                    else if (roth.isChecked())
                        gender = "Others";
                    else
                        gender = "Unknown";

                    Intent intent = new Intent(  PassingIntentsExercise. this, PassingIntentsExercise2.class);
                    intent.putExtra( "key1", fName);
                    intent.putExtra( "key2", lName);
                    intent.putExtra( "key3", MFName);
                    intent.putExtra( "key4", MLName);
                    intent.putExtra( "key5", FrFName);
                    intent.putExtra( "key6", FrLName);
                    intent.putExtra( "key7", eAddress);
                    intent.putExtra( "key8", gender);
                    intent.putExtra( "key9",bDate);
                    intent.putExtra( "key10", emailAdd);
                    intent.putExtra( "key11", pNumber);
                    intent.putExtra( "key12", pEmerNumber);
                    startActivity(intent);
                }
            });
    }
}