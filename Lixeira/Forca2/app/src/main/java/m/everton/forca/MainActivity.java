package m.everton.forca;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String palavra;
    char letra;
    int x,acum,jogada=0,i,figura=0;
    int chances = 6;
    int acompletar=i;
    boolean acerto, ok;
    char coringa[];
    char repetido[];

    Drawable forca0, forca1, forca2, forca3, forca4,forca5, forca6;
    TextView avisos, msg, chance, dica, palavras, repetidos;
    EditText digito;
    ImageView forca;

    public void componentes(){
        avisos = findViewById(R.id.avisos);
        msg = findViewById(R.id.msg);
        chance = findViewById(R.id.chance);
        dica = findViewById(R.id.dica);
        palavras = findViewById(R.id.palavras);
        repetidos = findViewById(R.id.repetidos);
        digito = findViewById(R.id.letra);
        forca = findViewById(R.id.forca);
    }

    public void busca(char letra){
        repetido = new char[26];
        acum=0;
        acerto = false;
        ok = true;
        for (x=0;x<26;x++){
            if(repetido[x]==letra){
                ok = false;
                return;}}
        for (x=0;x<i;x++){
            if(palavra.charAt(x)==letra){
                acum++;
                coringa[x] = letra;
                acerto = true;}}
    }

    public void jogar(char letra){
        componentes();

        forca0 = getResources().getDrawable(R.drawable.forca0);
        forca1 = getResources().getDrawable(R.drawable.forca1);
        forca2 = getResources().getDrawable(R.drawable.forca2);
        forca3 = getResources().getDrawable(R.drawable.forca3);
        forca4 = getResources().getDrawable(R.drawable.forca4);
        forca5 = getResources().getDrawable(R.drawable.forca5);
        forca6 = getResources().getDrawable(R.drawable.forca6);

        avisos.setText("JOGADA "+ (jogada+1) +", LETRA "+letra);
        busca(letra);
        repetido[jogada] = letra;
        if(ok == false){msg.setText("Letra Repetida !");}
        else if(acerto == true){msg.setText("** Acertou **");
            acompletar=acompletar-acum;}
        else if(acerto == false){msg.setText("ERROU");figura++;
            switch (figura){
                case 1:
                    forca.setImageDrawable(forca1);
                    break;
                case 2:
                    forca.setImageDrawable(forca2);
                    break;
                case 3:
                    forca.setImageDrawable(forca3);
                    break;
                case 4:
                    forca.setImageDrawable(forca4);
                    break;
                case 5:
                    forca.setImageDrawable(forca5);
                    break;
                case 6:
                    forca.setImageDrawable(forca6);
                    break;
                default:
                    forca.setImageDrawable(forca0);
            }chances--;}
        chance.setText("Chance "+chances+"/6");
        jogada++;
    }

    // ------------------------------BOTÕES-----------------------------------------


    public void clique(View view) {
        componentes();

        if (digito.getText().length() > 0) {
            letra = digito.getText().toString().charAt(0);
            while (chances > 0 && acompletar > 0 && jogada < 26) {
                jogar(letra);
                for (x = 0; x < i; x++) {
                    palavras.setText(coringa[x]);}}

            if (acompletar <= 0) {msg.setText("*** VENCEU ***");}
            else {msg.setText("*fim do jogo!*");}
        }
        else {msg.setText("Digite uma Letra!");}
    }

    public void clique2(View view) {
        componentes();

        String palavra = "prato";
        i=palavra.length();

        avisos.setText("Digite um Legra:");
        msg.setText("Boa Sorte!");
        chance.setText("Chance 6/6");
        dica.setText("Dica: Tem na cozinha com "+i+" letras");

        coringa = new char[i];

        for(x=0;x<i;x++){coringa[x]='#';}
        /*for(x=0;x<i;x++){palavras.setText(coringa[x]);}*/
        palavras.setText(palavra);
    }

    // ------------------------------INICIO-----------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}