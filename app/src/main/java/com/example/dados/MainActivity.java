package com.example.dados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    /*
     *@author:<Fabiola Rodrigues dos Santos / RA: 1110482313011>
     */
    private RadioButton rbUm;
    private RadioButton rbDois;
    private RadioButton rbTres;
    private Spinner spQtd;
    private Button btnRolar;
    private TextView txtSaida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbUm = findViewById(R.id.rbUm);
        rbDois = findViewById(R.id.rbDois);
        rbTres = findViewById(R.id.rbTres);
        btnRolar = findViewById(R.id.btnRolar);
        txtSaida = findViewById(R.id.txtSaida);
        spQtd = findViewById(R.id.spQtd);

        preencherSpinner();
        btnRolar.setOnClickListener(op -> rolar());
    }

    private void rolar() {
        StringBuffer buffer = new StringBuffer();
        int roladas = getQuantidade();
        int tipoDado = getNumeroFaces((String) spQtd.getSelectedItem());
        Random random = new Random();
        for(int i = 0; i< roladas; i++){
            buffer.append(random.nextInt(tipoDado) + 1 + " ");
        }
        txtSaida.setText(buffer.toString());
    }

    private int getQuantidade(){
        if(rbUm.isChecked()) return 1;
        if(rbDois.isChecked()) return 2;
        if(rbTres.isChecked()) return 3;
        return 0;
    }
    private void preencherSpinner() {
        List<String> lista = new ArrayList<>();
        lista.add("D4");
        lista.add("D6");
        lista.add("D8");
        lista.add("D10");
        lista.add("D12");
        lista.add("D20");
        lista.add("D100");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQtd.setAdapter(adapter);

    }
    public static int getNumeroFaces(String tipoDado) {
        switch (tipoDado) {
            case "D4":
                return 4;
            case "D6":
                return 6;
            case "D8":
                return 8;
            case "D10":
                return 10;
            case "D12":
                return 12;
            case "D20":
                return 20;
            case "D100":
                return 100;
            default:
                throw new IllegalArgumentException("Tipo de dado inválido.");
        }
    }
}