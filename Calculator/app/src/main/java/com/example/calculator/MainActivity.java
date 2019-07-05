package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button m;
    EditText e1;
    EditText e2;
    EditText e3;
    static int mode = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m=findViewById(R.id.main_mode_bt);
        m.setText("Mode\nAdd");
        e1=findViewById(R.id.main_num1_et);
        e2=findViewById(R.id.main_num2_et);
        e3=findViewById(R.id.main_num3_et);
    }

    public void mode_change(View view) {
        mode=(mode+1)%4;
        if(mode==0)
            m.setText("Mode\nAdd");
        else if(mode==1)
            m.setText("Mode\nSubtract");
        else if(mode==2)
            m.setText("Mode\nMultiply");
        else if(mode==3)
            m.setText("Mode\nDivide");
    }

    public void calculate(View view) {
        String x;
        double a=0,b=0;
        try{
            a = Double.parseDouble(e1.getText().toString());
            b = Double.parseDouble(e2.getText().toString());
        }
        catch (NumberFormatException e){
            Toast v=Toast.makeText(this,"Enter number",Toast.LENGTH_SHORT);
            v.show();
            return;
        }
        if(mode==0)
            x=String.valueOf(a+b);
        else if(mode==1)
            x=String.valueOf(a-b);
        else if(mode==2)
            x=String.valueOf(a*b);
        else
            x=String.valueOf(a/b);
        e3.setText(x);
    }
}
