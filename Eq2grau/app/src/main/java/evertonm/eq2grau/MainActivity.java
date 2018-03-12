package evertonm.eq2grau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {

    float valorA, valorB, valorC, d, x1, x2, vc[] = new float[4];
    int op;
    char q = (char) 178;

    String escrever() {
        String eq, a, b, c;
        a = format("%.1f", valorA);
        b = format("%.1f", valorB);
        c = format("%.1f", valorC);
        if (valorB < 0 && valorC < 0) {
            eq = a + "x" + q + " " + b + "x " + c + " = 0";
        } else if (valorB >= 0 && valorC < 0) {
            eq = a + "x" + q + " +" + b + "x " + c + " = 0";
        } else if (valorB < 0 && valorC >= 0) {
            eq = a + "x" + q + " " + b + "x +" + c + " = 0";
        } else {
            eq = a + "x" + q + " +" + b + "x +" + c + " = 0";
        }
        return eq;
    }

    float[] calcular() {
        if (valorA == 0) {
            vc[0] = 0;
            vc[1] = 0;
            vc[2] = 0;
            vc[3] = 0;
        }// vc[3] == 0 => "A Não pode ser Zero!"
        else {
            d = (float) ((pow(valorB, 2)) - (4 * valorA * valorC)); // cálculo do delta
            if (d < 0) {
                vc[0] = d;
                vc[1] = 0;
                vc[2] = 0;
                vc[3] = 1;
            }// vc[3] == 1 => "Não Existe Raizes Reais!"
            else {
                x1 = (float) (((-1 * valorB) + (sqrt(d))) / (2 * valorA)); // cálculo de Basckara
                x2 = (float) (((-1 * valorB) - (sqrt(d))) / (2 * valorA));
                vc[0] = d;
                vc[1] = x1;
                vc[2] = x2;
                vc[3] = 2;
            }
        } // vc[3] == 2 => ok
        return vc;
    }

    String resposta(int op) {
        switch (op) {
            case 0:
                return "Valor 'A' não pode ser Zero!";
            case 1:
                return "Não Existem Raizes Reais!";
            default:
                return escrever();
        }
    }

    // ------------------------------BOTÕES-----------------------------------------

    public void clique1(View view) {

        // tipo variavel = (typecast) metodo de captura
        EditText va = findViewById(R.id.va);
        EditText vb = findViewById(R.id.vb);
        EditText vc = findViewById(R.id.vc);
        TextView resposta = findViewById(R.id.resposta);
        TextView valores = findViewById(R.id.valores);

        if (va.getText().length() > 0 && vb.getText().length() > 0 && vc.getText().length() > 0) {

            String a = va.getText().toString();
            String b = vb.getText().toString();
            String c = vc.getText().toString();

            valorA = Float.valueOf(a);
            valorB = Float.valueOf(b);
            valorC = Float.valueOf(c);

            op = (int) calcular()[3];
            resposta.setText(resposta(op));
            String de = format("%.1f", calcular()[0]);
            String r1 = format("%.1f", calcular()[1]);
            String r2 = format("%.1f", calcular()[2]);
            valores.setText("delta = " + de +"  |  x1 = " + r1 + "  |  x2 = " + r2);
        } else {
            resposta.setText("Digite os Valores!");
        }
    }

    public void clique2(View view) {

        // tipo variavel = (typecast) metodo de captura
        EditText va = findViewById(R.id.va);
        EditText vb = findViewById(R.id.vb);
        EditText vc = findViewById(R.id.vc);
        TextView resposta = findViewById(R.id.resposta);
        TextView valores = findViewById(R.id.valores);

        va.setText("");
        vb.setText("");
        vc.setText("");
        resposta.setText("Resposta:");
        valores.setText("delta = 0  |  x1 = 0  |  x2 = 0");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}

