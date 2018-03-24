package everton.m.forca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

    private String arquivo; // caminho completo do arquivo
    private File file;
    private BufferedWriter writer;
    private BufferedReader reader;

    public Arquivo(String arquivo)throws IOException {
        this.arquivo = arquivo;
        this.file = new File(this.arquivo);
        //if (!file.exists()) {file.createNewFile();}
    }

    public void gravar(String texto) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(this.file));
        this.writer.write(texto);
        this.writer.flush();
        this.writer.close();
    }

    public String ler()throws IOException{
        this.reader = new BufferedReader(new FileReader(this.file));
        String texto = this.reader.readLine();
        this.reader.close();
        return texto;
    }
}