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

	// Funções para Gravação e Leitura na Memória Interna
	// Funcao: fGravarInterna - Irá gravar os dados na memória Interna
	public void fGravarInterna(View view) {
		Intent it = new Intent(this, GravacaoActivity.class);
		it.putExtra(Constantes.STORAGE_TYPE, Constantes.Type.INTERNAL);
		startActivity(it);
	}

	// Função: fLerInterna - Irá ler o conteúdo do arquivo na memória Interna
	public void fLerInterna(View view) {
		Intent it = new Intent(this, LeituraActivity.class);
		it.putExtra(Constantes.STORAGE_TYPE, Constantes.Type.INTERNAL);
		startActivity(it);

	}

	// Funções para Gravação e Leitura na Memória Externa
	// Função: fGravarExterna - Irá gravar o conteúdo do arquivo na memória
	// externa (SD Card por exemplo)
	public void fGravarExterna(View view) {
		Intent it = new Intent(this, GravacaoActivity.class);
		it.putExtra(Constantes.STORAGE_TYPE, Constantes.Type.EXTERNAL);
		startActivity(it);

	}

	// Função: fLerExterna - Irá ler o conteúdo do arquivo na memória externa
	// (SD Card por exemplo)
	public void fLerExterna(View view) {
		Intent it = new Intent(this, LeituraActivity.class);
		it.putExtra(Constantes.STORAGE_TYPE, Constantes.Type.EXTERNAL);
		startActivity(it);

	}

}
