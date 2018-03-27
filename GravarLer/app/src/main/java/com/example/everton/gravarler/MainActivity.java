package com.example.everton.gravarler;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Boolean sd = false;
    TextView saida;
    EditText entrada;
    String path,textoin,nomearquivo = "arquivo3.txt";


  // ***************************  GRAVAR  *************************************


    public void gravar(View view) {

        entrada = findViewById(R.id.in);

        textoin = entrada.toString();

        try {
            if (sd) {salvarExterno(textoin); //Gravar na memória Externa
            }else{salvarInterno(textoin);}   //Gravar na memória Interna

            Toast.makeText(this, "Arquivo gravado em" + path,Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void salvarInterno(String textoin){

        try {
            FileOutputStream fOut = openFileOutput(nomearquivo, MODE_PRIVATE);
            fOut.write(textoin.getBytes());
            fOut.close();
            Toast.makeText(getBaseContext(),"ARQUIVO SALVO",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            //
            e.printStackTrace();
        }
    }



    /*
    //Função: salvarInterno(Text) - Irá salvar o texto digitado no EditText na memória Interna
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

    }*/


    //Função: salvarExterno(Text) - Irá salvar o texto digitado no EditText na memória Externa
    private String salvarExterno(String text) throws IOException {
        //Tratativa para memória externa
        String status = Environment.getExternalStorageState();

        //Verifica se está montado o SD Card
        if( !status.equals(Environment.MEDIA_MOUNTED)){
            throw new IOException("O SD Card não montado ou não disponível!!!");
        }
        //Em caso de montado, irá pegar o diretorio padrão
        File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(dir, nomearquivo); //Criar arquivo ou reutilizar
        PrintWriter pw = new PrintWriter(file);	//Funcao para escrita

        try{
            pw.print(text);
            return file.getPath();
        }finally {
            pw.close();
        }}


    // ***************************   LER  *************************************


    public void ler(View view) {

        saida = findViewById(R.id.out);

        try {
            if (sd) {LerExterno();}else {LerInterno();}


        } catch (IOException e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT);
            e.printStackTrace();
        }

    }


    public void LerInterno(){
        try{
            FileInputStream fin = openFileInput(nomearquivo);
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            saida.setText(temp);
            Toast.makeText(getBaseContext(),"ARQUIVO LIDO",
                    Toast.LENGTH_SHORT).show();

        }catch(Exception e){

        }
    }




    /*

    //Função: LerInterno() - Função para pegar o arquivo na memória Interna e abrir e mostrar o conteúdo.
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


*/

    //Função: LerExterno() - Função para pegar o arquivo na memória Externa e abrir e mostrar o conteúdo.
    private void LerExterno() throws IOException{
        String status = Environment.getExternalStorageState();

        if (!status.equals(Environment.MEDIA_MOUNTED)){
            throw new IOException("O SD Card não montado ou encontrado");
        }

        File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        Scanner scanner = new Scanner( new File(dir, nomearquivo));

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
