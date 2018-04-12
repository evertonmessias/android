package everton.m.persistencia1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GravadoraDeDados extends Activity {
    private SharedPreferences prefs ;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.grava);
        prefs = getSharedPreferences(MainActivity.PREFS,MODE_PRIVATE);
        Button btVoltar = findViewById(R.id.bt_voltar);
        btVoltar.setOnClickListener (new OnClickListener () {
            @Override
            public void onClick (View v) {
                SimpleDateFormat dateFormat =
                        new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
                String dataAcesso = dateFormat.format(new Date());
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(MainActivity.ACESSO, dataAcesso);
                editor.commit();
                finish();
            }
        }) ;
    }
}






