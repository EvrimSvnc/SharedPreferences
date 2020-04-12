package com.example.androiddersprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText txtusername;
 EditText txtage;
 Switch appMode;
 EditText txtweight;
 EditText txtheight;
 CheckBox chkmale;
 CheckBox chkfemale;
 Button saveButton;
 Button showButton;
 Switch switchApp;

    String username;
    String age;
    String weight;
    String height;
    Boolean male;
    Boolean female;
    Boolean swhApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtusername = findViewById(R.id.username);
        txtage =findViewById(R.id.age);
        txtweight = findViewById(R.id.weight);
        txtheight = findViewById(R.id.height);
        saveButton = findViewById(R.id.btnSave);
        showButton = findViewById(R.id.btnShow);
        chkmale = findViewById(R.id.chkMale);
        chkfemale = findViewById(R.id.chkFemale);
        appMode = findViewById(R.id.appmode);
        switchApp = findViewById(R.id.appmode);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = getSharedPreferences("Enter",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                username = txtusername.getText().toString();
                age = txtage.getText().toString();
                weight = txtweight.getText().toString();
                height = txtheight.getText().toString();
                male = chkmale.isChecked();
                female = chkfemale.isChecked();
                swhApp = switchApp.isChecked();

                editor.putString("UserName",username);
                editor.putString("Age",age);
                editor.putString("Weight",weight);
                editor.putString("Height", height);
                editor.putBoolean("Male",male);
                editor.putBoolean("FeMale",female);
                editor.putBoolean("SwitchApp",swhApp);

                editor.commit();

                txtusername.getText().clear();
                txtage.getText().clear();
                txtheight.getText().clear();
                txtweight.getText().clear();
                chkfemale.setChecked(false);
                chkmale.setChecked(false);
                switchApp.setChecked(false);

                Toast.makeText(getApplicationContext(),"Kayit Yapilmistir!!",Toast.LENGTH_LONG).show();
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedVeriOku = getSharedPreferences("Enter",MODE_PRIVATE);
                txtusername.setText(sharedVeriOku.getString("UserName",""));
                txtage.setText(sharedVeriOku.getString("Age",""));
                txtweight.setText(sharedVeriOku.getString("Weight",""));
                txtheight.setText(sharedVeriOku.getString("Height",""));
                chkmale.setChecked(sharedVeriOku.getBoolean("Male",false));
                chkfemale.setChecked(sharedVeriOku.getBoolean("FeMale",false));
                switchApp.setChecked(sharedVeriOku.getBoolean("SwitchApp",false));
            }
        });
    }

}

