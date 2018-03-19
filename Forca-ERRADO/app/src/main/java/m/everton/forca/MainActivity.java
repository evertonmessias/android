package m.everton.forca;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String palavra = "prato";
    char letra;
    int x,acum,jogada=0,i=palavra.length(),figura=0;
    int chances = 6;
    int acompletar=i;
    boolean acerto, ok;
    char[] coringa = new char[i];
    char[] repetido = new char[26];

    TextView avisos = findViewById(R.id.avisos);
    TextView msg = findViewById(R.id.msg);
    TextView chance = findViewById(R.id.chance);
    TextView dica = findViewById(R.id.dica);
    TextView palavras = findViewById(R.id.palavras);
    //TextView repetidos = findViewById(R.id.repetidos);
    EditText digito = findViewById(R.id.letra);

    ImageView forca = findViewById(R.id.forca); // 0
    Drawable forca0 = getResources().getDrawable(R.drawable.forca0);
   /* Drawable forca1 = getResources().getDrawable(R.drawable.forca1);
    Drawable forca2 = getResources().getDrawable(R.drawable.forca2);
    Drawable forca3 = getResources().getDrawable(R.drawable.forca3);
    Drawable forca4 = getResources().getDrawable(R.drawable.forca4);
    Drawable forca5 = getResources().getDrawable(R.drawable.forca5);*/
    Drawable forca6 = getResources().getDrawable(R.drawable.forca6);


    public void busca(char letra){
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
        avisos.setText("JOGADA "+ (jogada+1) +", LETRA "+letra);
        busca(letra);
        repetido[jogada] = letra;
        if(ok == false){msg.setText("Letra Repetida !");}
        else if(acerto == true){msg.setText("** Acertou **");
            acompletar=acompletar-acum;}
        else if(acerto == false){msg.setText("ERROU");figura++;figuras(figura);chances--;}
        chance.setText("Chance "+chances+"/6");
        jogada++;
    }

    public void figuras(int figura){
        switch (figura){
        /*    case 1:
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
                break;      */
            case 1:
                forca.setImageDrawable(forca6);
                break;
            default:
                forca.setImageDrawable(forca0);
        }

    }

    MainActivity teste = new MainActivity();

    // ------------------------------BOTÃO-----------------------------------------
    public void clique(View view) {

        if (digito.getText().length() > 0) {
            letra = digito.getText().toString().charAt(0);
            while (teste.chances > 0 && teste.acompletar > 0 && teste.jogada < 26) {
                teste.jogar(letra);
                for (x = 0; x < teste.i; x++) {
                    palavras.setText(teste.coringa[x]);}}

            if (teste.acompletar <= 0) {msg.setText("*** VENCEU ***");}
            else {msg.setText("*fim do jogo!*");}
        }
        else {msg.setText("Digite uma Letra!");}
    }

// ------------------------------INICIO-----------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avisos.setText("Digite um Legra:");
        msg.setText("Boa Sorte!");
        chance.setText("Chance 6/6");
        dica.setText("Dica: Tem na cozinha com "+teste.i+" letras");

        for(x=0;x<teste.i;x++){teste.coringa[x]='#';}
        for(x=0;x<teste.i;x++){palavras.setText(teste.coringa[x]);}

    }
}
