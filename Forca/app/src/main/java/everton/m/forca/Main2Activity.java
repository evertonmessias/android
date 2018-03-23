package everton.m.forca;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Main2Activity extends AppCompatActivity {

    boolean comsom = true;
    CheckBox som;
    Button ok;

    public void clique(View view){
        som = findViewById(R.id.som);

        if (som.isChecked()){
            comsom = true;
        }else{comsom = false;}

        Intent transicao = new Intent(Main2Activity.this, MainActivity.class);
        transicao.putExtra("comsom",comsom);
        startActivity(transicao);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

}
