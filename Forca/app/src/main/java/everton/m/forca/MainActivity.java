package everton.m.forca;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static everton.m.forca.R.*;

public class MainActivity extends AppCompatActivity {

    String palavra, dika, scoringa;
    char coringa[] ,repetido[], apalavra[], caracter;
    int xx, ii, acum, jogada , figura, chances, sorteio;
    int acompletar;
    boolean acerto, ok, iniciado=false, comsom=true;

    Drawable forca0, forca1, forca2, forca3, forca4,forca5, forca6, forca7;
    TextView avisos, msg, dica, palavras;
    ImageView forca;
    Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    MediaPlayer somacerto, somerro, somganha, somperde, somin;

    public void sortear(){
        BancoDados aleatorio = new BancoDados();
        sorteio = (int)(Math.random() * 100);

        palavra = aleatorio.matriz[sorteio][0];
        dika = aleatorio.matriz[sorteio][1];
    }

    public void componentes(){
        avisos = findViewById(id.avisos);
        msg = findViewById(id.msg);
        dica = findViewById(id.dica);
        palavras = findViewById(id.palavras);
        forca = findViewById(id.forca);
        a = findViewById(id.a);
        b = findViewById(id.b);
        c = findViewById(id.c);
        d = findViewById(id.d);
        e = findViewById(id.e);
        f = findViewById(id.f);
        g = findViewById(id.g);
        h = findViewById(id.h);
        i = findViewById(id.i);
        j = findViewById(id.j);
        k = findViewById(id.k);
        l = findViewById(id.l);
        m = findViewById(id.m);
        n = findViewById(id.n);
        o = findViewById(id.o);
        p = findViewById(id.p);
        q = findViewById(id.q);
        r = findViewById(id.r);
        s = findViewById(id.s);
        t = findViewById(id.t);
        u = findViewById(id.u);
        v = findViewById(id.v);
        w = findViewById(id.w);
        x = findViewById(id.x);
        y = findViewById(id.y);
        z = findViewById(id.z);
    }

    public void som() {
        somacerto = MediaPlayer.create(this, R.raw.acerto);
        somerro = MediaPlayer.create(this, R.raw.erro);
        somin = MediaPlayer.create(this, raw.inicio);
        somganha = MediaPlayer.create(this, raw.ganhou);
        somperde = MediaPlayer.create(this, raw.perdeu);
    }

    public void resetsom(){
        somacerto.release();
        somerro.release();
        somin.release();
    }

    public void figuras(){
        forca0 = getResources().getDrawable(drawable.forca0);
        forca1 = getResources().getDrawable(drawable.forca1);
        forca2 = getResources().getDrawable(drawable.forca2);
        forca3 = getResources().getDrawable(drawable.forca3);
        forca4 = getResources().getDrawable(drawable.forca4);
        forca5 = getResources().getDrawable(drawable.forca5);
        forca6 = getResources().getDrawable(drawable.forca6);
        forca7 = getResources().getDrawable(drawable.forca7);
    }

    public void mudacor(){
        a.setBackgroundColor(Color.rgb(204,204,204));
        b.setBackgroundColor(Color.rgb(204,204,204));
        c.setBackgroundColor(Color.rgb(204,204,204));
        d.setBackgroundColor(Color.rgb(204,204,204));
        e.setBackgroundColor(Color.rgb(204,204,204));
        f.setBackgroundColor(Color.rgb(204,204,204));
        g.setBackgroundColor(Color.rgb(204,204,204));
        h.setBackgroundColor(Color.rgb(204,204,204));
        i.setBackgroundColor(Color.rgb(204,204,204));
        j.setBackgroundColor(Color.rgb(204,204,204));
        k.setBackgroundColor(Color.rgb(204,204,204));
        l.setBackgroundColor(Color.rgb(204,204,204));
        m.setBackgroundColor(Color.rgb(204,204,204));
        n.setBackgroundColor(Color.rgb(204,204,204));
        o.setBackgroundColor(Color.rgb(204,204,204));
        p.setBackgroundColor(Color.rgb(204,204,204));
        q.setBackgroundColor(Color.rgb(204,204,204));
        r.setBackgroundColor(Color.rgb(204,204,204));
        s.setBackgroundColor(Color.rgb(204,204,204));
        t.setBackgroundColor(Color.rgb(204,204,204));
        u.setBackgroundColor(Color.rgb(204,204,204));
        v.setBackgroundColor(Color.rgb(204,204,204));
        w.setBackgroundColor(Color.rgb(204,204,204));
        x.setBackgroundColor(Color.rgb(204,204,204));
        y.setBackgroundColor(Color.rgb(204,204,204));
        z.setBackgroundColor(Color.rgb(204,204,204));
    }

    public void ativadesativabtn(boolean estado){
        a.setClickable(estado);
        b.setClickable(estado);
        c.setClickable(estado);
        d.setClickable(estado);
        e.setClickable(estado);
        f.setClickable(estado);
        g.setClickable(estado);
        h.setClickable(estado);
        i.setClickable(estado);
        j.setClickable(estado);
        k.setClickable(estado);
        l.setClickable(estado);
        m.setClickable(estado);
        n.setClickable(estado);
        o.setClickable(estado);
        p.setClickable(estado);
        q.setClickable(estado);
        r.setClickable(estado);
        s.setClickable(estado);
        t.setClickable(estado);
        u.setClickable(estado);
        v.setClickable(estado);
        w.setClickable(estado);
        x.setClickable(estado);
        y.setClickable(estado);
        z.setClickable(estado);
    }

    public void busca(char letra){
        acum=0;
        acerto = false;
        for (xx=0;xx<ii;xx++){
            if(apalavra[xx]==letra){
                acum++;
                coringa[xx] = letra;
                acerto = true;}}
    }

    public void jogar(char letra){

        if(iniciado == true){

            ok = true;
            for (xx=0;xx<26;xx++){if(repetido[xx]==letra){ok = false;}}

            if(ok){

            if (chances > 0 && acompletar > 0 ) {

        busca(letra);
        repetido[jogada] = letra;

        if(acerto == true){
            avisos.setText("Jogada "+ (jogada+1) +"  ,  Letra  [ "+letra+" ]  ,  Chance "+chances+"/6");
            msg.setTextColor(Color.rgb(0,255,0));if (comsom){somacerto.start();}
            msg.setText("**** ACERTOU ****");
            acompletar=acompletar-acum;}
        else {chances--;
              avisos.setText("Jogada "+ (jogada+1) +"  ,  Letra  [ "+letra+" ]  ,  Chance "+chances+"/6");
              msg.setTextColor(Color.rgb(255,0,0));if (comsom){somerro.start();}
              msg.setText("- - ERROU - -");figura++;
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
            }}
        jogada++;
                scoringa="";
                for(xx=0;xx<ii;xx++){scoringa = scoringa + coringa[xx];}
                palavras.setText(scoringa);
            }
            if (acompletar <= 0) {msg.setTextColor(Color.rgb(0,0,255));
                msg.setText("*** V E N C E U ***");if (comsom){somganha.start();resetsom();}
                forca.setImageDrawable(forca7);ativadesativabtn(false);
            }
            else if (chances <= 0){msg.setTextColor(Color.rgb(255,0,0));
                msg.setText("*F I M   D O   J O G O*");if (comsom){somperde.start();resetsom();}
                dica.setText(palavra);ativadesativabtn(false);
            }
        }

        }
        else {msg = findViewById(id.msg);
        msg.setTextColor(Color.rgb(255,0,0));
            msg.setText("INICIE O JOGO NO MENU :");}
    }

    // ------------------------------TECLADO-----------------------------------------

    public void a(View view) {
        jogar('a');if(iniciado == true){a.setBackgroundColor(Color.rgb(255,0,0));}}

    public void b(View view) {
        jogar('b');if(iniciado == true){b.setBackgroundColor(Color.rgb(255,0,0));}}

    public void c(View view) {
        jogar('c');if(iniciado == true){c.setBackgroundColor(Color.rgb(255,0,0));}}

    public void d(View view) {
        jogar('d');if(iniciado == true){d.setBackgroundColor(Color.rgb(255,0,0));}}

    public void e(View view) {
        jogar('e');if(iniciado == true){e.setBackgroundColor(Color.rgb(255,0,0));}}

    public void f(View view) {
        jogar('f');if(iniciado == true){f.setBackgroundColor(Color.rgb(255,0,0));}}

    public void g(View view) {
        jogar('g');if(iniciado == true){g.setBackgroundColor(Color.rgb(255,0,0));}}

    public void h(View view) {
        jogar('h');if(iniciado == true){h.setBackgroundColor(Color.rgb(255,0,0));}}

    public void i(View view) {
        jogar('i');if(iniciado == true){i.setBackgroundColor(Color.rgb(255,0,0));}}

    public void j(View view) {
        jogar('j');if(iniciado == true){j.setBackgroundColor(Color.rgb(255,0,0));}}

    public void k(View view) {
        jogar('k');if(iniciado == true){k.setBackgroundColor(Color.rgb(255,0,0));}}

    public void l(View view) {
        jogar('l');if(iniciado == true){l.setBackgroundColor(Color.rgb(255,0,0));}}

    public void m(View view) {
        jogar('m');if(iniciado == true){m.setBackgroundColor(Color.rgb(255,0,0));}}

    public void n(View view) {
        jogar('n');if(iniciado == true){n.setBackgroundColor(Color.rgb(255,0,0));}}

    public void o(View view) {
        jogar('o');if(iniciado == true){o.setBackgroundColor(Color.rgb(255,0,0));}}

    public void p(View view) {
        jogar('p');if(iniciado == true){p.setBackgroundColor(Color.rgb(255,0,0));}}

    public void q(View view) {
        jogar('q');if(iniciado == true){q.setBackgroundColor(Color.rgb(255,0,0));}}

    public void r(View view) {
        jogar('r');if(iniciado == true){r.setBackgroundColor(Color.rgb(255,0,0));}}

    public void s(View view) {
        jogar('s');if(iniciado == true){s.setBackgroundColor(Color.rgb(255,0,0));}}

    public void t(View view) {
        jogar('t');if(iniciado == true){t.setBackgroundColor(Color.rgb(255,0,0));}}

    public void u(View view) {
        jogar('u');if(iniciado == true){u.setBackgroundColor(Color.rgb(255,0,0));}}

    public void v(View view) {
        jogar('v');if(iniciado == true){v.setBackgroundColor(Color.rgb(255,0,0));}}

    public void w(View view) {
        jogar('w');if(iniciado == true){w.setBackgroundColor(Color.rgb(255,0,0));}}

    public void x(View view) {
        jogar('x');if(iniciado == true){x.setBackgroundColor(Color.rgb(255,0,0));}}

    public void y(View view) {
        jogar('y');if(iniciado == true){y.setBackgroundColor(Color.rgb(255,0,0));}}

    public void z(View view) {
        jogar('z');if(iniciado == true){z.setBackgroundColor(Color.rgb(255,0,0));}}


    // ------------------------------INICIO-----------------------------------------

    public void iniciar() {
        onRestart();
        componentes();som();figuras();mudacor();sortear();ativadesativabtn(true);
        if (comsom){somin.start();}
        iniciado = true;
        jogada = 0;
        figura = 0;
        chances = 6;
        repetido = new char[26];
        forca.setImageDrawable(forca0);
        caracter = '*';

        scoringa = "";

        ii=palavra.length();

        acompletar = ii;

        avisos.setText("Digite uma Letra,   Chances: 6");
        msg.setTextColor(Color.rgb(0,255,0));
        msg.setText("Boa Sorte!");
        dica.setText("Dica: "+dika+", com "+ii+" letras");

        coringa = palavra.toCharArray();
        apalavra = palavra.toCharArray();

        for(xx=0;xx<ii;xx++){coringa[xx] = caracter;}
        for(xx=0;xx<ii;xx++){scoringa = scoringa + coringa[xx];}

        palavras.setText(scoringa);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "everton.messias@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.iniciar) {
            iniciar();
            return true;
        }

        if (id == R.id.tirasom) {
            if (comsom){
                comsom = false;
                item.setTitle("Com Som");
            }else {
                comsom = true;
                item.setTitle("Sem Som");
            }
            return true;
        }

        if (id == R.id.fechar) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}