package com.example.everton.gravarler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView saida;
    EditText entrada;
    String path,textoin,nomearquivo = "arquivo.txt";

    public void gravar(View view) {

        entrada = findViewById(R.id.in);

        textoin = entrada.toString();

        try {
            path = salvarInterno(textoin); //Gravar na memória Interna

            Toast.makeText(this, "Arquivo gravado em" + path,Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private String salvarInterno(String text) throws IOException {

        FileOutputStream out = openFileOutput(nomearquivo,	MODE_PRIVATE);
        PrintWriter pw = new PrintWriter(out); //Tratativa para escrita

        try {
            pw.print(text);
            return getFilesDir().getPath() + File.separator + nomearquivo;
        } finally {
            pw.close();
        }
    }


    public void ler(View view) {

        saida = findViewById(R.id.out);

        try {
            LerInterno();

        } catch (IOException e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT);
            e.printStackTrace();
        }

    }

    private void LerInterno() throws IOException {
        FileInputStream infl = openFileInput(nomearquivo);

        Scanner scanner = new Scanner(infl);
        try{
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                sb.append(line).append(System.lineSeparator());
            }
            saida.setText(sb.toString());
        }finally{
            scanner.close();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
