package everton.m.relogiopartilha;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout tela;
    EditText tempo;
    TextView visor,obs;
    int minutos;
    Contador timer;
    MediaPlayer somatencao,somfim;
    boolean iniciado = false;

    public void escondeTeclado(){
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void iniciar(View view) {

        escondeTeclado();

        if (!iniciado){

            iniciado = true;

            somfim = MediaPlayer.create(this, R.raw.fim);
            somatencao = MediaPlayer.create(this, R.raw.atencao);

            tela = findViewById(R.id.tela);
            tempo = findViewById(R.id.tempo);
            visor = findViewById(R.id.visor);
            obs = findViewById(R.id.obs);

            if (tempo.getText().length() > 0) {

                minutos = Integer.valueOf(tempo.getText().toString());

                if (minutos >= 1 && minutos <= 30) {

                    minutos = minutos + 1;
                    tela.setBackgroundColor(Color.rgb(0, 255, 0));
                    obs.setText("*** PARTILHANDO ***");
                    timer = new Contador(this, tela, visor, obs, minutos * 60 * 1000, 1000, somatencao, somfim);
                    timer.start();

                } else {
                    visor.setText("ERRO");iniciado = false;
                }
            } else {
                visor.setText("??:??");iniciado = false;
            }

        }

    }

    public void parar(View view){
        escondeTeclado();
        iniciado = false;
        if(timer != null){
            timer.cancel();
            timer = null;
            tela.setBackgroundColor(Color.rgb(255,255,255));
            somatencao.release();somfim.release();
        }visor.setText("00:00");obs.setText("(Tempo de Partilha + 1 min)");onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
