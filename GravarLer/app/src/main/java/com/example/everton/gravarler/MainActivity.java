package com.example.everton.gravarler;

import android.os.Bundle;
import android.os.Environment;
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

    Boolean sd = false;
    TextView saida;
    EditText entrada;
    String textoout,textoin,nomearquivo = "arquivo.txt";


    // ***************************  GRAVAR  *************************************


    public void gravar(View view) throws IOException {

        entrada = findViewById(R.id.in);
        textoin = entrada.getText().toString();

        if (sd) {salvarExterno(textoin);} //Gravar na memória Externa
        else{salvarInterno(textoin);}   //Gravar na memória Interna
    }

    private void salvarInterno(String textoin){

        try {
            FileOutputStream fOut = openFileOutput(nomearquivo, MODE_PRIVATE);
            fOut.write(textoin.getBytes());
            fOut.close();
            Toast.makeText(getBaseContext(),"ARQUIVO SALVO",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void salvarExterno(String textoin) throws IOException {
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
            pw.print(textoin);
            pw.close();
            Toast.makeText(getBaseContext(),"ARQUIVO SALVO",Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }}


    // ***************************   LER  *************************************


    public void ler(View view) throws IOException {

        saida = findViewById(R.id.out);
        if (sd) {textoout = LerExterno();}else {textoout = LerInterno();}
        saida.setText(textoout);
    }


    //Função: LerInterno() - Função para pegar o arquivo na memória Interna e abrir e mostrar o conteúdo.
    private String LerInterno(){
        String texto="";
        try{
            FileInputStream fin = openFileInput(nomearquivo);
            int c;
            while( (c = fin.read()) != -1){
                texto = texto + Character.toString((char)c);}
            fin.close();
            Toast.makeText(getBaseContext(),"ARQUIVO LIDO",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();}
        return texto;
    }

    //Função: LerExterno() - Função para pegar o arquivo na memória Externa e abrir e mostrar o conteúdo.
    private String LerExterno() throws IOException{
        String texto="";
        String status = Environment.getExternalStorageState();
        if (!status.equals(Environment.MEDIA_MOUNTED)){
            throw new IOException("SD Card não encontrado !!");}

        File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        Scanner scanner = new Scanner( new File(dir, nomearquivo));

        try{
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                sb.append(line).append(System.lineSeparator());
            }
            texto = sb.toString();
            scanner.close();
            Toast.makeText(getBaseContext(),"ARQUIVO LIDO",Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();}
        return texto;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
