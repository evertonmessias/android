package exemplo.lergravararquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import exemplo.lergravararquivos.Constantes.Type;

public class GravacaoActivity extends Activity {

	private Type type;
	private EditText edTexto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gravacao);

		// Instanciar o edit ao criar para ser utilizado

		edTexto = (EditText) findViewById(R.id.ed_texto);
		type = (Type) getIntent().getSerializableExtra(Constantes.STORAGE_TYPE);

	}

	//Fun��o: fSalvarTexto - A��o do bot�o gravar
	public void fSalvarTexto(View view) {

		String text = edTexto.getText().toString();
		String path;

		try {
			if (type == Type.INTERNAL) {
				path = salvarInterno(text); //Gravar na mem�ria Interna
			} else {
				path = salvarExterno(text);//Gravar na mem�ria Externa
			}
			//Mensagem
			Toast.makeText(this, "Arquivo gravado em" + path,Toast.LENGTH_SHORT).show();
			finish();
		} catch (IOException e) {
			Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}

	}

	//Fun��o: salvarInterno(Text) - Ir� salvar o texto digitado no EditText na mem�ria Interna
	private String salvarInterno(String text) throws IOException {
		
		//Tratativa para Modo Privado 
		FileOutputStream out = openFileOutput(Constantes.FILE_NAME,	MODE_PRIVATE); 
		PrintWriter pw = new PrintWriter(out); //Tratativa para escrita
		
		try {
			pw.print(text);
			return getFilesDir().getPath() + File.separator
					+ Constantes.FILE_NAME;
		} finally {
			pw.close();
		}

	}

	//Fun��o: salvarExterno(Text) - Ir� salvar o texto digitado no EditText na mem�ria Externa
	private String salvarExterno(String text) throws IOException {
		//Tratativa para mem�ria externa
		String status = Environment.getExternalStorageState();
		
		//Verifica se est� montado o SD Card
		if( !status.equals(Environment.MEDIA_MOUNTED)){
			throw new IOException("O SD Card n�o montado ou n�o dispon�vel!!!");
		}
		//Em caso de montado, ir� pegar o diretorio padr�o 
		File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
		File file = new File(dir, Constantes.FILE_NAME); //Criar arquivo ou reutilizar
		PrintWriter pw = new PrintWriter(file);	//Funcao para escrita
		
		try{
			pw.print(text);
			return file.getPath();
		}finally {
			pw.close();
		}
		

	}

}
