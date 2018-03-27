package com.example.everton.gravarler;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    TextView saida;
    EditText entrada;
    String path,textoin, nomearquivo = "arquivo.txt";

    public void gravar(View view) {
        saida = findViewById(R.id.out);
        entrada = findViewById(R.id.in);

        textoin = entrada.toString();

        try {
            path = salvarInterno(textoin); //Gravar na memória Interna

            //Mensagem
            Toast.makeText(this, "Arquivo gravado em" + path,Toast.LENGTH_SHORT).show();
            finish();
        } catch (IOException e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private String salvarInterno(String text) throws IOException {

        //Tratativa para Modo Privado
        FileOutputStream out = openFileOutput(nomearquivo,	MODE_PRIVATE);
        PrintWriter pw = new PrintWriter(out); //Tratativa para escrita

        try {
            pw.print(text);
            return getFilesDir().getPath() + File.separator + nomearquivo;
        } finally {
            pw.close();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
