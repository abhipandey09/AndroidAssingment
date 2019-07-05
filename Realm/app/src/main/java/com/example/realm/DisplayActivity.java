package com.example.realm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.Realm;
import io.realm.RealmResults;

public class DisplayActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        rv=findViewById(R.id.recyclerPerson);
        Realm r=Realm.getDefaultInstance();
        RealmResults<Person> results=r.where(Person.class).findAll();
        Adapter m=new Adapter(results,this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(m);
    }
}
