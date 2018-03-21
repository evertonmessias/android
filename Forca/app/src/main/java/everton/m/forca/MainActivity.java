package everton.m.forca;

import android.graphics.Color;
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


public class MainActivity extends AppCompatActivity {

    String palavra, scoringa, aleatorio[];
    char coringa[] ,repetido[], apalavra[], caracter;
    int xx, ii, acum, jogada , figura, chances, sorteio;
    int acompletar;
    boolean acerto, ok, iniciado=false;

    Drawable forca0, forca1, forca2, forca3, forca4,forca5, forca6, forca7;
    TextView avisos, msg, dica, palavras;
    ImageView forca;
    Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;

    public void sortear(){
        aleatorio = new String[]{"prato", "liquidificador", "geladeira", "arroz", "batedeira", "microondas", "colher", "frigideira", "detergente", "escorredor"};
        sorteio = (int)(Math.random() * 10);
        palavra = aleatorio[sorteio];
    }

    public void componentes(){
        avisos = findViewById(R.id.avisos);
        msg = findViewById(R.id.msg);
        dica = findViewById(R.id.dica);
        palavras = findViewById(R.id.palavras);
        forca = findViewById(R.id.forca);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        e = findViewById(R.id.e);
        f = findViewById(R.id.f);
        g = findViewById(R.id.g);
        h = findViewById(R.id.h);
        i = findViewById(R.id.i);
        j = findViewById(R.id.j);
        k = findViewById(R.id.k);
        l = findViewById(R.id.l);
        m = findViewById(R.id.m);
        n = findViewById(R.id.n);
        o = findViewById(R.id.o);
        p = findViewById(R.id.p);
        q = findViewById(R.id.q);
        r = findViewById(R.id.r);
        s = findViewById(R.id.s);
        t = findViewById(R.id.t);
        u = findViewById(R.id.u);
        v = findViewById(R.id.v);
        w = findViewById(R.id.w);
        x = findViewById(R.id.x);
        y = findViewById(R.id.y);
        z = findViewById(R.id.z);
    }

    public void figuras(){
        forca0 = getResources().getDrawable(R.drawable.forca0);
        forca1 = getResources().getDrawable(R.drawable.forca1);
        forca2 = getResources().getDrawable(R.drawable.forca2);
        forca3 = getResources().getDrawable(R.drawable.forca3);
        forca4 = getResources().getDrawable(R.drawable.forca4);
        forca5 = getResources().getDrawable(R.drawable.forca5);
        forca6 = getResources().getDrawable(R.drawable.forca6);
        forca7 = getResources().getDrawable(R.drawable.forca7);
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
        componentes();figuras();

        if(iniciado == true){

            ok = true;
            for (xx=0;xx<26;xx++){if(repetido[xx]==letra){ok = false;}}

            if(ok){

            if (chances > 0 && acompletar > 0 ) {

        busca(letra);
        repetido[jogada] = letra;

        if(acerto == true){
            avisos.setText("Jogada "+ (jogada+1) +"  ,  Letra  [ "+letra+" ]  ,  Chance "+chances+"/6");
            msg.setTextColor(Color.rgb(0,255,0));
            msg.setText("**** ACERTOU ****");
            acompletar=acompletar-acum;}
        else {chances--;
              avisos.setText("Jogada "+ (jogada+1) +"  ,  Letra  [ "+letra+" ]  ,  Chance "+chances+"/6");
              msg.setTextColor(Color.rgb(255,0,0));
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
                msg.setText("*** V E N C E U ***");
                forca.setImageDrawable(forca7);}
            else if (chances <= 0){msg.setTextColor(Color.rgb(255,0,0));
                msg.setText("*F I M   D O   J O G O*");
                dica.setText(palavra);
            }
        }

        }
        else {msg.setTextColor(Color.rgb(255,0,0));
            msg.setText("INICIE O JOGO NO MENU ACIMA");}
    }

    // ------------------------------TECLADO-----------------------------------------

    public void a(View view) {
        jogar('a');a.setBackgroundColor(Color.rgb(255,0,0));}

    public void b(View view) {
        jogar('b');b.setBackgroundColor(Color.rgb(255,0,0));}

    public void c(View view) {
        jogar('c');c.setBackgroundColor(Color.rgb(255,0,0));}

    public void d(View view) {
        jogar('d');d.setBackgroundColor(Color.rgb(255,0,0));}

    public void e(View view) {
        jogar('e');e.setBackgroundColor(Color.rgb(255,0,0));}

    public void f(View view) {
        jogar('f');f.setBackgroundColor(Color.rgb(255,0,0));}

    public void g(View view) {
        jogar('g');g.setBackgroundColor(Color.rgb(255,0,0));}

    public void h(View view) {
        jogar('h');h.setBackgroundColor(Color.rgb(255,0,0));}

    public void i(View view) {
        jogar('i');i.setBackgroundColor(Color.rgb(255,0,0));}

    public void j(View view) {
        jogar('j');j.setBackgroundColor(Color.rgb(255,0,0));}

    public void k(View view) {
        jogar('k');k.setBackgroundColor(Color.rgb(255,0,0));}

    public void l(View view) {
        jogar('l');l.setBackgroundColor(Color.rgb(255,0,0));}

    public void m(View view) {
        jogar('m');m.setBackgroundColor(Color.rgb(255,0,0));}

    public void n(View view) {
        jogar('n');n.setBackgroundColor(Color.rgb(255,0,0));}

    public void o(View view) {
        jogar('o');o.setBackgroundColor(Color.rgb(255,0,0));}

    public void p(View view) {
        jogar('p');p.setBackgroundColor(Color.rgb(255,0,0));}

    public void q(View view) {
        jogar('q');q.setBackgroundColor(Color.rgb(255,0,0));}

    public void r(View view) {
        jogar('r');r.setBackgroundColor(Color.rgb(255,0,0));}

    public void s(View view) {
        jogar('s');s.setBackgroundColor(Color.rgb(255,0,0));}

    public void t(View view) {
        jogar('t');t.setBackgroundColor(Color.rgb(255,0,0));}

    public void u(View view) {
        jogar('u');u.setBackgroundColor(Color.rgb(255,0,0));}

    public void v(View view) {
        jogar('v');v.setBackgroundColor(Color.rgb(255,0,0));}

    public void w(View view) {
        jogar('w');w.setBackgroundColor(Color.rgb(255,0,0));}

    public void x(View view) {
        jogar('x');x.setBackgroundColor(Color.rgb(255,0,0));}

    public void y(View view) {
        jogar('y');y.setBackgroundColor(Color.rgb(255,0,0));}

    public void z(View view) {
        jogar('z');z.setBackgroundColor(Color.rgb(255,0,0));}


    // ------------------------------INICIO-----------------------------------------

    public void iniciar() {
        componentes();figuras();mudacor();sortear();

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

        avisos.setText("Digite um Letra,   Chances: 6");
        msg.setTextColor(Color.rgb(0,255,0));
        msg.setText("Boa Sorte!");
        dica.setText("Dica: Tem na cozinha com "+ii+" letras");

        coringa = palavra.toCharArray();
        apalavra = palavra.toCharArray();

        for(xx=0;xx<ii;xx++){coringa[xx] = caracter;}
        for(xx=0;xx<ii;xx++){scoringa = scoringa + coringa[xx];}

        palavras.setText(scoringa);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
