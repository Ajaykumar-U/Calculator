package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.calculator.presenter.InfLogic;
import com.example.calculator.presenter.logic;


public class MainActivity extends AppCompatActivity implements InfView {

    TextView tvDisplay,tvAns;
    TextView tvClear,tvDelete;
    TextView tvAdd,tvSub,tvMul,tvDiv;
    TextView tvEqual;
    TextView tvOne,tvTwo,tvThree,tvFour,tvFive,tvSix,tvSeven,tvEight,tvNine,tvPoint,tvZero;
    int x1=0,x2=0,x3=0,x4=0;
    int press=0;
    int equal=0;
    String a1,b1;
    double a,b;

    InfLogic logic;

    StringBuffer input1=new StringBuffer();
    StringBuffer input2=new StringBuffer();
    StringBuffer DataList = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logic=new logic(this);

        input1.append('0');
        input2.append('0');

        //Dispay Objects
        tvDisplay=findViewById(R.id.tvDisplay);
        tvAns=findViewById(R.id.tvAns);

        //Clear & Delete Options
        tvDelete=findViewById(R.id.tvDelete);
        tvClear=findViewById(R.id.tvClear);

//        //To show result
        tvEqual=findViewById(R.id.tvEqual);

//        //Actions Done in Calculator App
        tvAdd=findViewById(R.id.tvAddition);
        tvSub=findViewById(R.id.tvSubtract);
        tvMul=findViewById(R.id.tvMultiply);
        tvDiv=findViewById(R.id.tvDivide);

//        //Input we are giving
        tvZero=findViewById(R.id.tvZero);
        tvOne=findViewById(R.id.tvOne);
        tvTwo=findViewById(R.id.tvTwo);
        tvThree=findViewById(R.id.tvThree);
        tvFour=findViewById(R.id.tvFour);
        tvFive=findViewById(R.id.tvFive);
        tvSix=findViewById(R.id.tvSix);
        tvSeven=findViewById(R.id.tvSeven);
        tvEight=findViewById(R.id.tvEight);
        tvNine=findViewById(R.id.tvNine);
        tvPoint=findViewById(R.id.tvPoint);

        TextView tvResultHistory = findViewById(R.id.tvResultHistory);
        tvResultHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickFalse();
                rule(x1,x2,x3,x4);
                x1=1;
                x2=0;
                x3=0;
                x4=0;
                press=1;
                tvAdd.setClickable(false);
                DataList.append('+');
                tvDisplay.setText(DataList);
            }
        });

        tvSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickFalse();
                rule(x1,x2,x3,x4);
                x2=1;
                x1=0;
                x3=0;
                x4=0;
                press=1;
                DataList.append('-');
                tvDisplay.setText(DataList);
            }
        });

        tvMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickFalse();
                rule(x1,x2,x3,x4);
                x3=1;
                x1=0;
                x2=0;
                x4=0;
                press=1;
                DataList.append('*');
                tvDisplay.setText(DataList);
            }
        });

        tvDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickFalse();
                rule(x1,x2,x3,x4);
                x4=1;
                x1=0;
                x2=0;
                x3=0;
                press=1;
                DataList.append('/');
                tvDisplay.setText(DataList);
            }
        });

        tvEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rule(x1,x2,x3,x4);
                input1=new StringBuffer();
                equal=1;
                press=0;
                x1=0;x2=0;x3=0;x4=0;
            }
        });

        tvPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equal==1){
                    DataList=new StringBuffer();
                    tvDisplay.setText(DataList);
                    equal=0;
                    press=0;
                }
                if(press==0){
                    DataList.append('.');
                    tvDisplay.setText(DataList);
                    input1.append('.');
                }
                else if(press==1){
                    DataList.append('.');
                    tvDisplay.setText(DataList);
                    input2.append('.');
                }
                setClickTrue();
            }
        });

        tvZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equal==1){
                    DataList=new StringBuffer();
                    tvDisplay.setText(DataList);
                    equal=0;
                    press=0;
                }
                if(press==0){
                    DataList.append('0');
                    tvDisplay.setText(DataList);
                    input1.append('0');
                }
                else if(press==1){
                    DataList.append('0');
                    tvDisplay.setText(DataList);
                    input2.append('0');
                }
                setClickTrue();
            }
        });

        tvOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equal==1){
                    DataList=new StringBuffer();
                    tvDisplay.setText(DataList);
                    equal=0;
                    press=0;
                }
                if(press==0){
                    DataList.append('1');
                    tvDisplay.setText(DataList);
                    input1.append('1');
                }
                else if(press==1){
                    DataList.append('1');
                    tvDisplay.setText(DataList);
                    input2.append('1');
                }
                setClickTrue();
            }
        });

        tvTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equal==1){
                    DataList=new StringBuffer();
                    tvDisplay.setText(DataList);
                    equal=0;
                    press=0;
                }
                if(press==0){
                    DataList.append('2');
                    tvDisplay.setText(DataList);
                    input1.append('2');
                }
                else if(press==1){
                    DataList.append('2');
                    tvDisplay.setText(DataList);
                    input2.append('2');
                }
                setClickTrue();
            }
        });

        tvThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equal==1){
                    DataList=new StringBuffer();
                    tvDisplay.setText(DataList);
                    equal=0;
                    press=0;
                }
                if(press==0){
                    DataList.append('3');
                    tvDisplay.setText(DataList);
                    input1.append('3');
                }
                else if(press==1){
                    DataList.append('3');
                    tvDisplay.setText(DataList);
                    input2.append('3');
                }
                setClickTrue();
            }
        });

        tvFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equal==1){
                    DataList=new StringBuffer();
                    tvDisplay.setText(DataList);
                    equal=0;
                    press=0;
                }
                if(press==0){
                    DataList.append('4');
                    tvDisplay.setText(DataList);
                    input1.append('4');
                }
                else if(press==1){
                    DataList.append('4');
                    tvDisplay.setText(DataList);
                    input2.append('4');
                }
                setClickTrue();
            }
        });

        tvFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equal==1){
                    DataList=new StringBuffer();
                    tvDisplay.setText(DataList);
                    equal=0;
                    press=0;
                }
                if(press==0){
                    DataList.append('5');
                    tvDisplay.setText(DataList);
                    input1.append('5');
                }
                else if(press==1){
                    DataList.append('5');
                    tvDisplay.setText(DataList);
                    input2.append('5');
                }
                setClickTrue();
            }
        });

        tvSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equal==1){
                    DataList=new StringBuffer();
                    tvDisplay.setText(DataList);
                    equal=0;
                    press=0;
                }
                if(press==0){
                    DataList.append('6');
                    tvDisplay.setText(DataList);
                    input1.append('6');
                }
                else if(press==1){
                    DataList.append('6');
                    tvDisplay.setText(DataList);
                    input2.append('6');
                }
                setClickTrue();
            }
        });

        tvSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equal==1){
                    DataList=new StringBuffer();
                    tvDisplay.setText(DataList);
                    equal=0;
                    press=0;
                }
                if(press==0){
                    DataList.append('7');
                    tvDisplay.setText(DataList);
                    input1.append('7');
                }
                else if(press==1){
                    DataList.append('7');
                    tvDisplay.setText(DataList);
                    input2.append('7');
                }
                setClickTrue();
            }
        });

        tvEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equal==1){
                    DataList=new StringBuffer();
                    tvDisplay.setText(DataList);
                    equal=0;
                    press=0;
                }
                if(press==0){
                    DataList.append('8');
                    tvDisplay.setText(DataList);
                    input1.append('8');
                }
                else if(press==1){
                    DataList.append('8');
                    tvDisplay.setText(DataList);
                    input2.append('8');
                }
                setClickTrue();
            }
        });

        tvNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equal==1){
                    DataList=new StringBuffer();
                    tvDisplay.setText(DataList);
                    equal=0;
                    press=0;
                }
                if(press==0){
                    DataList.append('9');
                    tvDisplay.setText(DataList);
                    input1.append('9');
                }
                else if(press==1){
                    DataList.append('9');
                    tvDisplay.setText(DataList);
                    input2.append('9');
                }
                setClickTrue();
            }
        });

        tvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(press==0){
                    StringBuffer inputend=new StringBuffer();
                    for(int i=0;i<input1.length()-1;i++){
                        char ch=input1.charAt(i);
                        inputend.append(ch);
                    }
                    input1=inputend;
                }
                else if(press==1){
                    StringBuffer inputend=new StringBuffer();
                    for(int i=0;i<input2.length()-1;i++){
                        char ch=input2.charAt(i);
                        inputend.append(ch);
                    }
                    input2=inputend;
                }
                //Display
                StringBuffer DisplayInput=new StringBuffer();
                for (int i=0;i<DataList.length()-1;i++){
                    char ch=DataList.charAt(i);
                    DisplayInput.append(ch);
                }
                DataList=DisplayInput;
                tvDisplay.setText(DataList);

            }
        });
    }
    void clear(){
        input1=new StringBuffer();
        tvAns.setText("");
        DataList=new StringBuffer();
        tvDisplay.setText(DataList);
        press=0;
        x1=0;x2=0;x3=0;x4=0;
    }

    @Override
    public void result(String str) {
        tvAns.setText(str);
    }

    void reorder(String res){
        input1=new StringBuffer();
        input2=new StringBuffer();
        input1.append(res);
    }

    void rule(int x1,int x2,int x3,int x4){
        if(x1==1){
            a1=input1.toString();
            b1=input2.toString();
            a=Double.parseDouble(a1);
            b=Double.parseDouble(b1);
            String output=logic.add(a,b);
            reorder(output);
        }
        else if(x2==1){
            a1=input1.toString();
            b1=input2.toString();
            a=Double.parseDouble(a1);
            b=Double.parseDouble(b1);
            String output=logic.sub(a,b);
            reorder(output);
        }
        else if(x3==1){
            a1=input1.toString();
            b1=input2.toString();
            a=Double.parseDouble(a1);
            b=Double.parseDouble(b1);
            String output=logic.mul(a,b);
            reorder(output);
        }
        else if(x4==1){
            a1=input1.toString();
            b1=input2.toString();
            a=Double.parseDouble(a1);
            b=Double.parseDouble(b1);
            String output=logic.div(a,b);
            reorder(output);
        }
    }
    void setClickTrue(){
        tvAdd.setClickable(true);
        tvSub.setClickable(true);
        tvMul.setClickable(true);
        tvDiv.setClickable(true);
    }

    void setClickFalse(){
        tvAdd.setClickable(false);
        tvSub.setClickable(false);
        tvMul.setClickable(false);
        tvDiv.setClickable(false);
    }
}
