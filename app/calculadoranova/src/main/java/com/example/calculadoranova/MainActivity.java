package com.example.calculadoranova;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText numero1, numero2;
    Button btnSomar, btnSubtrair, btnMultiplicar, btnDividir;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        btnSomar = findViewById(R.id.btnSomar);
        btnSubtrair = findViewById(R.id.btnSubtrair);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        resultado = findViewById(R.id.resultado);

        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('+');
            }
        });

        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('-');
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('*');
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('/');
            }
        });
    }

    private void calcular(char operador) {
        String txtNum1 = numero1.getText().toString();
        String txtNum2 = numero2.getText().toString();

        if (txtNum1.isEmpty() || txtNum2.isEmpty()) {
            resultado.setText("Por favor, digite os dois números.");
            return;
        }

        double num1 = Double.parseDouble(txtNum1);
        double num2 = Double.parseDouble(txtNum2);
        double res = 0;

        switch (operador) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    resultado.setText("Erro: divisão por zero!");
                    return;
                }
                res = num1 / num2;
                break;
        }

        resultado.setText("Resultado: " + res);
    }
}