package com.example.viewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    CheckBox mCheckBox;
    RadioButton enable;
    RadioButton disable;
    Switch mSwitch;
    ImageButton mImageButton;
    ImageView mImageView;
    Button mButton;
    int c = 0, b = 0, e = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheckBox = findViewById(R.id.checkBox);
        mSwitch = findViewById(R.id.switch1);
        mButton = findViewById(R.id.button);
        mImageButton = findViewById(R.id.imageButton);
        mImageView = findViewById(R.id.imageView);
        enable = findViewById(R.id.enable);
        disable = findViewById(R.id.disable);

    }
    public void onSwitch(View view){
        c++;
        c = c % 2;

    }
    public void onEnable(View view){
        e = 0;
    }

    public void onDisable(View view){
        e = 1;

    }
    public void onCheck(View view){
        b++;
        b = b % 2;
    }
    public void onRefresh(View view){

        switch (c){
            case 0:mImageView.setVisibility(View.VISIBLE);
                break;
            case 1:mImageView.setVisibility(View.INVISIBLE);
                break;
        }
        switch (b){
            case 0:mImageButton.setVisibility(View.INVISIBLE);
                break;
            case 1:mImageButton.setVisibility(View.VISIBLE);
                break;
        }
        switch (e){
            case 0:mImageButton.setClickable(true);
                   break;
            case 1:mImageButton.setClickable(false);
                   break;
        }

    }


}
