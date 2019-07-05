package com.example.realm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.RealmResults;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    RealmResults <Person> realmResults;
    Context mContext;
    public Adapter(RealmResults<Person> persons, Context context){
        realmResults=persons;
        mContext=context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Person person=realmResults.get(position);
        assert person != null;
        holder.name.setText(person.getName());
        holder.dept.setText(person.getDept());
        holder.phone.setText(String.valueOf(person.getPhone()));
        holder.roll.setText(String.valueOf(person.getRoll_no()));
        holder.gender.setText(person.getGender()==1?"Female":"Male");
        String d= person.getDept();
        if(d.equalsIgnoreCase("cse"))
            holder.card.setBackgroundColor(Color.parseColor("#f44336"));
        else if(d.equalsIgnoreCase("it"))
            holder.card.setBackgroundColor(Color.parseColor("#3F51B5"));
        else if(d.equalsIgnoreCase("ece"))
            holder.card.setBackgroundColor(Color.parseColor("#4CAF50"));
        else
            holder.card.setBackgroundColor(Color.parseColor("#FF9800"));
    }


    @Override
    public int getItemCount() {
        return realmResults.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView phone;
        private TextView dept;
        private TextView roll;
        private TextView gender;
        private ConstraintLayout card;
        public MyViewHolder(@NonNull View view) {
            super(view);
            name=view.findViewById(R.id.name_tv);
            phone=view.findViewById(R.id.phone_tv);
            dept=view.findViewById(R.id.dept_tv);
            roll=view.findViewById(R.id.roll_tv);
            gender=view.findViewById(R.id.gender_tv);
            card=view.findViewById(R.id.rootView);
        }
    }
}
