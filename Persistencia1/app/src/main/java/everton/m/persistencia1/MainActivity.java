package everton.m.persistencia1;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    final static String PREFS = "arquivo1_pref";
    final static String ACESSO = "acesso";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onResume () {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        String data = prefs.getString(ACESSO, null);

        TextView msg = findViewById(R.id.mensagem);
        Button addNameButton = findViewById(R.id.bt_gravar);

        if (data != null) {
            msg.setText("Ultimo acesso em: " + data);
            addNameButton.setText("Retomar a aplicação...");
        } else {
            msg.setText("Nunca acessou a aplicação!");
            addNameButton.setText ("Iniciar a aplicação...");
        }
        addNameButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(MainActivity.this,
                        GravadoraDeDados.class);
                startActivity(intent);
            }
        });
    }
}