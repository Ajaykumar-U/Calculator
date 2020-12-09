package com.example.calculator.presenter;

import com.example.calculator.InfView;
import com.example.calculator.MainActivity;

public class logic implements InfLogic {

    InfView view;

    public logic(MainActivity mainActivity) {
        this.view=mainActivity;
    }

    @Override
    public String add(double i1, double i2) {
        double res=i1+i2;
        int value = (int)res;
        String str=String.valueOf(value);
        view.result(str);
        return str;
    }

    @Override
    public String sub(double i1, double i2) {
        double res=i1-i2;
        int value = (int)res;
        String str=String.valueOf(value);
        view.result(str);
        return str;
    }

    @Override
    public String mul(double i1, double i2) {
        double res=i1*i2;
        int value = (int)res;
        String str=String.valueOf(value);
        view.result(str);
        return str;
    }

    @Override
    public String div(double i1, double i2) {
        double res=i1/i2;
        int value = (int)res;
        String str=String.valueOf(value);
        view.result(str);
        return str;
    }

    @Override
    public String equ(double i1, double i2) {
        return "out";
    }

    @Override
    public String mod(double i1, double i2) {
        return "out";
    }

}
