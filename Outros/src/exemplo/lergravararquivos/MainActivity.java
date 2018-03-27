package exemplo.lergravararquivos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// Fun��es para Grava��o e Leitura na Mem�ria Interna
	// Funcao: fGravarInterna - Ir� gravar os dados na mem�ria Interna
	public void fGravarInterna(View view) {
		Intent it = new Intent(this, GravacaoActivity.class);
		it.putExtra(Constantes.STORAGE_TYPE, Constantes.Type.INTERNAL);
		startActivity(it);
	}

	// Fun��o: fLerInterna - Ir� ler o conte�do do arquivo na mem�ria Interna
	public void fLerInterna(View view) {
		Intent it = new Intent(this, LeituraActivity.class);
		it.putExtra(Constantes.STORAGE_TYPE, Constantes.Type.INTERNAL);
		startActivity(it);

	}

	// Fun��es para Grava��o e Leitura na Mem�ria Externa
	// Fun��o: fGravarExterna - Ir� gravar o conte�do do arquivo na mem�ria
	// externa (SD Card por exemplo)
	public void fGravarExterna(View view) {
		Intent it = new Intent(this, GravacaoActivity.class);
		it.putExtra(Constantes.STORAGE_TYPE, Constantes.Type.EXTERNAL);
		startActivity(it);

	}

	// Fun��o: fLerExterna - Ir� ler o conte�do do arquivo na mem�ria externa
	// (SD Card por exemplo)
	public void fLerExterna(View view) {
		Intent it = new Intent(this, LeituraActivity.class);
		it.putExtra(Constantes.STORAGE_TYPE, Constantes.Type.EXTERNAL);
		startActivity(it);

	}

}
