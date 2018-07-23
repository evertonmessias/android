package everton.m.relogiopartilha;

import java.util.Calendar;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Contador extends CountDownTimer {
    ConstraintLayout tela;
    Context context;
    TextView tv,obs;
    long timeInFuture;
    MediaPlayer somatencao,somfim;


        public Contador(Context context, ConstraintLayout tela, TextView tv, TextView obs, long timeInFuture, long interval, MediaPlayer somatencao, MediaPlayer somfim){
        super(timeInFuture, interval);
        this.context = context;
        this.tela = tela;
        this.tv = tv;
        this.obs = obs;
        this.somatencao = somatencao;
        this.somfim = somfim;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        Log.i("Script", "Timer: "+millisUntilFinished);
        timeInFuture = millisUntilFinished;
        tv.setText(getCorretcTimer(true, millisUntilFinished)+":"+getCorretcTimer(false, millisUntilFinished));

        if (timeInFuture >= 55000 && timeInFuture <= 60000){
            Toast.makeText(context, "ATENÇÃO", Toast.LENGTH_SHORT).show();
            obs.setText("... CONCLUINDO ...");
            tela.setBackgroundColor(Color.rgb(255,255,0));
            somatencao.start();
        }

        if (timeInFuture >= 5000 && timeInFuture <= 10000){
            Toast.makeText(context, "F I M", Toast.LENGTH_SHORT).show();
            obs.setText("TEMPO ESGOTADO");
            tela.setBackgroundColor(Color.rgb(255,0,0));
            somfim.start();
        }

    }

    @Override
    public void onFinish() {
        timeInFuture -= 1000;
        tv.setText(getCorretcTimer(true, timeInFuture)+":"+getCorretcTimer(false, timeInFuture));
        Toast.makeText(context, "F I M", Toast.LENGTH_SHORT).show();
        somfim.release();somatencao.release();
    }


    private String getCorretcTimer(boolean isMinute, long millisUntilFinished){
        String aux;
        int constCalendar = isMinute ? Calendar.MINUTE : Calendar.SECOND;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millisUntilFinished);

        aux = c.get(constCalendar) < 10 ? "0"+c.get(constCalendar) : ""+c.get(constCalendar);
        return(aux);
    }

}