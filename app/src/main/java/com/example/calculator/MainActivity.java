package com.example.calculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual;
    TextView myTexter;

    float valueOne, valueTwo;

    boolean addTF = false;
    boolean subTF = false;
    boolean mulTF = false;
    boolean divTF = false;

    boolean afterEqual = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        myTexter = (TextView) findViewById(R.id.texter);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAfterEqual();
                myTexter.setText(myTexter.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAfterEqual();
                myTexter.setText(myTexter.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAfterEqual();
                myTexter.setText(myTexter.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAfterEqual();
                myTexter.setText(myTexter.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAfterEqual();
                myTexter.setText(myTexter.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAfterEqual();
                myTexter.setText(myTexter.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAfterEqual();
                myTexter.setText(myTexter.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAfterEqual();
                myTexter.setText(myTexter.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAfterEqual();
                myTexter.setText(myTexter.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAfterEqual();
                myTexter.setText(myTexter.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                if (checkTextViewValue())
                    valueOne = Float.parseFloat(myTexter.getText() + "");
                setTrue('+');
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                if (checkTextViewValue())
                    valueOne = Float.parseFloat(myTexter.getText() + "");
                setTrue('-');
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                if (checkTextViewValue())
                    valueOne = Float.parseFloat(myTexter.getText() + "");
                setTrue('*');
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                if (checkTextViewValue())
                    valueOne = Float.parseFloat(myTexter.getText() + "");
                setTrue('/');
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTrue('0');
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempText = myTexter.getText().toString();
                char[] tempArr = tempText.toCharArray();
                int dotCount=0;

                for (int i=0;i<tempArr.length;i++) {
                    if(tempArr[i] == '.')
                        dotCount++;
                }

                if(dotCount==0)
                    myTexter.setText(myTexter.getText() + ".");

            }
        });
    }
    public void setTrue(Character sign) {
        addTF = false;
        subTF = false;
        divTF = false;
        mulTF = false;

        if (sign == '+')
            addTF = true;
        if (sign == '-')
            subTF = true;
        if (sign == '/')
            divTF = true;
        if (sign == '*')
            mulTF = true;

        myTexter.setText(null);
    }
    public void checkAfterEqual() {
        if (afterEqual) {
            myTexter.setText(null);
            afterEqual = false;
        }
    }
    public boolean checkTextViewValue() {
        if (myTexter.getText() == null || myTexter.getText().toString().isEmpty())
            return false;
        return true;
    }
    public boolean makeEquals() {
        if (addTF || subTF || divTF || mulTF)
            return true;
        return false;
    }
    public void calculate() {
        if (addTF || subTF || divTF || mulTF) {
            valueTwo = Float.parseFloat(myTexter.getText() + "");

            if (addTF == true) {
                myTexter.setText(valueOne + valueTwo + "");
                addTF = false;
            }

            if (subTF == true) {
                myTexter.setText(valueOne - valueTwo + "");
                subTF = false;
            }

            if (mulTF == true) {
                myTexter.setText(valueOne * valueTwo + "");
                mulTF = false;
            }

            if (divTF == true) {
                if (valueTwo == 0) {
                    myTexter.setText(null);
                    Toast.makeText(MainActivity.this, "Can not divide by 0", Toast.LENGTH_LONG).show();
                    valueOne = 0;
                } else {
                    myTexter.setText(valueOne / valueTwo + "");
                }
                divTF = false;
            }
            afterEqual = true;
        }
    }
}
