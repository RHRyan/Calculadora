package com.example.calculadorac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String OldNumber ="";
    String op ="+";
    Boolean IsNewOpe = true;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1= findViewById(R.id.editText);
    }

    public void NumberEvent(View view) {
        if(IsNewOpe)
            et1.setText("");
        IsNewOpe = false;
        String number = et1.getText().toString();
        switch (view.getId()){
            case R.id.buno:
                number +="1";
                break;
            case R.id.bdos:
                number +="2";
                break;
            case R.id.btres:
                number +="3";
                break;
            case R.id.bCuatro:
                number +="4";
                break;
            case R.id.bCinco:
                number +="5";
                break;
            case R.id.bSeis:
                number +="6";
                break;
            case R.id.bsiete:
                number +="7";
                break;
            case R.id.bocho:
                number +="8";
                break;
            case R.id.bNueve:
                number +="9";
                break;
            case R.id.bZero:
                number +="0";
                break;
            case R.id.bDot:
                number +=".";
                break;
            case R.id.bPlMin:
                number +="-"+number;
                break;
        }
        et1.setText(number);
    }

    public void operatorEvent(View view) {
        IsNewOpe = true;
        OldNumber = et1.getText().toString();

        switch (view.getId()){
            case R.id.bDiv: op = "/"; break;
            case R.id.bMul: op = "*"; break;
            case R.id.bPlus: op = "+"; break;
            case R.id.bMinus: op = "-"; break;

        }
    }

    public void EqualEvent(View view) {
        String newNumber = et1.getText().toString();
        double Resultado = (0.0);

        switch(op){
            case "+":
                Resultado = Double.parseDouble(OldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                Resultado = Double.parseDouble(OldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                Resultado = Double.parseDouble(OldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                Resultado = Double.parseDouble(OldNumber) / Double.parseDouble(newNumber);
                break;
        }
        et1.setText(Resultado+"");
    }

    public void AcEvent(View view) {
        et1.setText("0");
        IsNewOpe = true;
    }

    public void PercentEvent(View view) {
        double no = Double.parseDouble(et1.getText().toString())/100;
        et1.setText(no+"");
        IsNewOpe = true;
    }
}