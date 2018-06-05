package com.example.admin.calculator;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.admin.calculator.R.id.b_1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b0;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b_plus;
    Button b_min;
    Button b_div;
    Button b_mult;
    Button b_C;
    Button b_CE;
    Button b_point;
    Button b_sign;
    Button b_bcksps;
    Button b_equals;
    Button b_sin;
    Button b_sin1;
    Button b_cos;
    Button b_cos1;
    Button b_tan;
    Button b_tan1;
    Button b_x2;
    Button b_x3;
    Button b_xy;
    Button b_1x;

    TextView screen;
    Boolean point;
    Boolean operation;
    Boolean init;
    String sign, temp;
    double operator1, operator2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        screen = findViewById(R.id.tv_result);
        b0 = findViewById(R.id.b_0);
        b0.setOnClickListener(this);
        b1 = findViewById(b_1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.b_2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.b_3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.b_4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.b_5);
        b5.setOnClickListener(this);
        b6 = findViewById(R.id.b_6);
        b6.setOnClickListener(this);
        b7 = findViewById(R.id.b_7);
        b7.setOnClickListener(this);
        b8 = findViewById(R.id.b_8);
        b8.setOnClickListener(this);
        b9 = findViewById(R.id.b_9);
        b9.setOnClickListener(this);
        b_bcksps = findViewById(R.id.b_bckspc);
        b_bcksps.setOnClickListener(this);
        b_C = findViewById(R.id.b_C);
        b_C.setOnClickListener(this);
        b_CE = findViewById(R.id.b_CE);
        b_CE.setOnClickListener(this);
        b_plus = findViewById(R.id.b_plus);
        b_plus.setOnClickListener(this);
        b_point = findViewById(R.id.b_point);
        b_point.setOnClickListener(this);
        b_min = findViewById(R.id.b_minus);
        b_min.setOnClickListener(this);
        b_mult = findViewById(R.id.b_mult);
        b_mult.setOnClickListener(this);
        b_div = findViewById(R.id.b_divd);
        b_div.setOnClickListener(this);
        b_equals = findViewById(R.id.b_equal);
        b_equals.setOnClickListener(this);
        b_sign = findViewById(R.id.b_sign);
        b_sign.setOnClickListener(this);
        b_sin = findViewById(R.id.b_sin);
        b_sin.setOnClickListener(this);
        b_sin1 = findViewById(R.id.b_sin_1);
        b_sin1.setOnClickListener(this);
        b_cos = findViewById(R.id.b_cos);
        b_cos.setOnClickListener(this);
        b_cos1 = findViewById(R.id.b_cos_1);
        b_cos1.setOnClickListener(this);
        b_tan = findViewById(R.id.b_tan);
        b_tan.setOnClickListener(this);
        b_tan1 = findViewById(R.id.b_tan_1);
        b_tan1.setOnClickListener(this);
        b_x2 = findViewById(R.id.b_x2);
        b_x2.setOnClickListener(this);
        b_x3 = findViewById(R.id.b_x3);
        b_x3.setOnClickListener(this);
        b_xy = findViewById(R.id.b_xy);
        b_xy.setOnClickListener(this);
        b_1x = findViewById(R.id.b_1x);
        b_1x.setOnClickListener(this);
        point = false;
        operation = false;
        init = false;


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    public void onClick(View v) {
        if (!init) {
            screen.setText("");
            init = true;
        }
        Button b = (Button) v;
        System.out.println(b.getText());
        String op = String.valueOf(b.getText());
        switch (op) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                appendText(String.valueOf(b.getText()));
                break;
            case "+":
            case "-":
            case "/":
            case "*":
            case "x^y":
                if (!operation) {
                    operator1 = Double.valueOf(String.valueOf(screen.getText()));
                    operation = true;
                    sign = String.valueOf(b.getText());
                    screen.setText("");
                } else {
                    screen.setText("Error");
                    operator1 = 0;
                    operation = false;
                    init = false;
                }
                point = false;
                break;
            case "C":
                screen.setText("");
                break;
            case "CE":
                screen.setText("");
                operator1 = 0;
                operation = false;
                point = false;
                break;
            case "bksp":
                temp = String.valueOf(screen.getText());
                if(temp.substring(temp.length() -1 ) == "."){
                    point = false;
                }
                if (init) {
                    if (temp.length() > 0) {
                        temp = temp.substring(0, temp.length() - 1);
                        screen.setText(temp);
                    }

                }
                break;
            case "+/-":
                operator2 = Double.valueOf(String.valueOf(screen.getText()) + 0);
                screen.setText(String.valueOf(operator2 * -1));
                break;
            case "x^3":
                operator1 = Integer.valueOf(String.valueOf(screen.getText()));
                result = Math.pow(operator1, 3);
                operation = false;
                screen.setText(String.valueOf(result));
                init = false;
                point = false;
                break;
            case "x^2":
                operator1 = Integer.valueOf(String.valueOf(screen.getText()));
                result = Math.pow(operator1, 2);
                operation = false;
                screen.setText(String.valueOf(result));
                init = false;
                point = false;
                break;
            case "1/x":
                operator1 = Integer.valueOf(String.valueOf(screen.getText()));
                result = (1 / operator1);
                operation = false;
                screen.setText(String.valueOf(result));
                init = false;
                point = false;
                break;
            case "sin":
                operator1 = Integer.valueOf(String.valueOf(screen.getText()));
                result = Math.sin(operator1);
                operation = false;
                screen.setText(String.valueOf(result));
                init = false;
                point = false;
                break;
            case "cos":
                operator1 = Integer.valueOf(String.valueOf(screen.getText()));
                result = Math.cos(operator1);
                operation = false;
                screen.setText(String.valueOf(result));
                init = false;
                point = false;
                break;
            case "tan":
                operator1 = Integer.valueOf(String.valueOf(screen.getText()));
                result = Math.tan(operator1);
                operation = false;
                screen.setText(String.valueOf(result));
                init = false;
                point = false;
                break;
            case "sin-1":
                operator1 = Integer.valueOf(String.valueOf(screen.getText()));
                result = Math.asin(operator1);
                operation = false;
                screen.setText(String.valueOf(result));
                init = false;
                point = false;
                break;
            case "cos-1":
                operator1 = Integer.valueOf(String.valueOf(screen.getText()));
                result = Math.acos(operator1);
                operation = false;
                screen.setText(String.valueOf(result));
                init = false;
                point = false;
                break;
            case "tan-1":
                operator1 = Integer.valueOf(String.valueOf(screen.getText()));
                result = Math.atan(operator1);
                operation = false;
                screen.setText(String.valueOf(result));
                init = false;
                point = false;
                break;
            case "=":
                operator2 = Double.valueOf(String.valueOf(screen.getText()));
                switch (sign) {
                    case "+":
                        result = operator1 + operator2;
                        break;
                    case "-":
                        result = operator1 - operator2;
                        break;
                    case "*":
                        result = operator1 * operator2;
                        break;
                    case "/":
                        result = operator1 / operator2;
                        break;
                    case "x^y":
                        result = Math.pow(operator1, operator2);
                        break;
                }
                operation = false;
                screen.setText(String.valueOf(result));
                init = false;
                point = false;
                break;
            case ".":
                if (!point) {
                    appendText(String.valueOf(b.getText()));
                    point = true;
                }

        }


    }

    private void appendText(String num) {
        screen.setText(String.valueOf(screen.getText()) + num);
    }


}
