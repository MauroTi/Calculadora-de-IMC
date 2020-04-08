package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Calcula(View view) {
        EditText etaltura = findViewById(R.id.etaltura);
        EditText etpeso = findViewById(R.id.etpeso);
        EditText etimc = findViewById(R.id.etimc);
        String altura_texto = etaltura.getText().toString();
        String peso_texto = etpeso.getText().toString();
        String frase = null;
        //String imc_texto = etimc.getText().toString();
        Double altura = null, peso = null, imc = null;
        Double resultado;

        if (etaltura.getText().toString().isEmpty() || etpeso.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Os campos peso e altura devem estar preenchidos.", Toast.LENGTH_LONG).show();
        } else {
            try {
                altura = Double.parseDouble(altura_texto);
                peso = Double.parseDouble(peso_texto);

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Opa, somente números.", Toast.LENGTH_LONG).show();
            }

            resultado = peso / (altura * altura);

            DecimalFormat df = new DecimalFormat("0.##");
            String saida = df.format(resultado);
            etimc.setText(saida);
            //Toast.makeText(this, "Seu IMC é " + resultado + ".", Toast.LENGTH_SHORT).show();
            if (resultado < 18.5) {
                frase = "Você está abaixo do peso!";
            } else if (resultado >= 18.5 && resultado < 25) {
                frase = "Você tem peso normal!";
            } else if (resultado >= 25 && resultado < 29.9) {
                frase = "Você tem sobrepeso!";
            } else if (resultado >= 30 && resultado < 34.9) {
                frase = "Você tem obesidade grau 1!";
            } else if (resultado >= 35 && resultado < 39.9) {
                frase = "Você tem obesidade grau 2!";
            } else if (resultado > 40) {
                frase = "Você tem obesidade grau 3!";
            }
            Toast.makeText(this, frase, Toast.LENGTH_LONG).show();
        }
    }

        public void consulta (View view){
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }

    }

