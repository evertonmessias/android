package m.everton.forca;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // toda a classe aqui





    // ------------------------------BOTÃO-----------------------------------------
    public void clique(View view) {

        ImageView forca = findViewById(R.id.forca); // forca0

        Drawable forca6 = getResources().getDrawable(R.drawable.forca6);
        forca.setImageDrawable(forca6);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
