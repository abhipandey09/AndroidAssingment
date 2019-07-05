package com.example.realm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText dept;
    EditText roll;
    EditText phone;
    Switch gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.main_name_et);
        dept=findViewById(R.id.main_dept_et);
        roll=findViewById(R.id.main_roll_et);
        phone=findViewById(R.id.main_phone_et);
        gender=findViewById(R.id.main_gender_s);
    }

    public void Submit(View view) {
        Realm r=Realm.getDefaultInstance();
        r.beginTransaction();
        try{
            Person p=r.createObject(Person.class,System.currentTimeMillis()/1000);
            p.setName(name.getText().toString());
            p.setDept(dept.getText().toString());
            p.setRoll_no(Integer.parseInt(roll.getText().toString()));
            p.setPhone(Long.parseLong(phone.getText().toString()));
            p.setGender(gender.isChecked()?1:0);
            r.commitTransaction();
            r.close();
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            r.cancelTransaction();
            Toast.makeText(this,"Failure" + e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    public void Display(View view) {
        Intent i=new Intent(this,DisplayActivity.class);
        startActivity(i);
    }
}
