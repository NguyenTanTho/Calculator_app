package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private TextView Screen;
    private String input,Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Screen = (TextView) findViewById(R.id.tv1);

    }
    public void ButtonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "CE":
                input="";
                break;
            case "=":
                Solve();
                Answer=input;
                break;
            default:
                if( data.equals("+") || data.equals("-") || data.equals("÷")||data.equals("x")){
                    Solve();
                }
                input+=data;
        }
        Screen.setText(input);
    }
    public void Solve(){
        if(input.split("x").length==2){
            String numbers[]=input.split("x");

                double mul=Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
                input=mul+"";
        }

        else if(input.split("\\÷").length==2){
            String numbers[]=input.split("\\÷");
                double div=Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                input=div+"";
        }

        else if(input.split("\\+").length==2){
            String numbers[]=input.split("\\+");

                double sum=Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
                input=sum+"";

        }

        else if(input.split("\\-").length>1){
            String numbers[]=input.split("\\-");


                double sub = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                input = sub + "";

        }

        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
        Screen.setText(input);

    }

}
