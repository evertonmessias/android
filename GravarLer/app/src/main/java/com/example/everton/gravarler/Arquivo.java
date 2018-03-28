package com.example.everton.gravarler;


import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Arquivo extends AppCompatActivity {

    public Boolean sd;
    public String nomearquivo;

    public Arquivo(Boolean sd, String nomearquivo) {
        this.sd = sd;
        this.nomearquivo = nomearquivo;
    }

    // ***************************  GRAVAR  *************************************


    public void gravar(String textoin) throws IOException {

        if (this.sd) {salvarExterno(textoin);} //Gravar na memória Externa
        else{salvarInterno(textoin);}   //Gravar na memória Interna
    }


    public void salvarInterno(String textoin){
        try {
            FileOutputStream fOut = openFileOutput(this.nomearquivo, MODE_PRIVATE);
            fOut.write(textoin.getBytes());
            fOut.close();
            Toast.makeText(getBaseContext(),"ARQUIVO SALVO",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void salvarExterno(String textoin) throws IOException {
        //Tratativa para memória externa
        String status = Environment.getExternalStorageState();
        //Verifica se está montado o SD Card
        if( !status.equals(Environment.MEDIA_MOUNTED)){
            throw new IOException("O SD Card não montado ou não disponível!!!");
        }
        //Em caso de montado, irá pegar o diretorio padrão
        File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(dir, this.nomearquivo); //Criar arquivo ou reutilizar
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


    public String ler() throws IOException {
        String textoout;
        if (this.sd) {textoout = LerExterno();}else {textoout = LerInterno();}
        return textoout;
    }


    //Função: LerInterno() - Função para pegar o arquivo na memória Interna e abrir e mostrar o conteúdo.
    public String LerInterno(){
        String texto="";
        try{
            FileInputStream fin = openFileInput(this.nomearquivo);
            int c;
            while( (c = fin.read()) != -1){
                texto = texto + Character.toString((char)c);}
            fin.close();
            Toast.makeText(getBaseContext(),"ARQUIVO LIDO",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(getBaseContext(),"ARQUIVO NÃO LIDO",Toast.LENGTH_SHORT).show();
            e.printStackTrace();}
        return texto;
    }

    //Função: LerExterno() - Função para pegar o arquivo na memória Externa e abrir e mostrar o conteúdo.
    public String LerExterno() throws IOException{
        String texto="";
        String status = Environment.getExternalStorageState();
        if (!status.equals(Environment.MEDIA_MOUNTED)){
            throw new IOException("SD Card não encontrado !!");}

        File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        Scanner scanner = new Scanner( new File(dir, this.nomearquivo));

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
            Toast.makeText(getBaseContext(),"ARQUIVO NÃO LIDO",Toast.LENGTH_SHORT).show();
            e.printStackTrace();}
        return texto;
    }
}
