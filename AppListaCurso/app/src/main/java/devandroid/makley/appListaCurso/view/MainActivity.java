package devandroid.makley.appListaCurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.makley.appListaCurso.R;
import devandroid.makley.appListaCurso.controller.CursoController;
import devandroid.makley.appListaCurso.controller.PessoaController;
import devandroid.makley.appListaCurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController pessoaController;
    CursoController cursoController;
    List<String> nomesDosCursos;
    Pessoa pessoa;
    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editTelefone;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;



    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        pessoaController = new PessoaController(MainActivity.this);

        pessoa = new Pessoa();

        pessoaController.buscar(pessoa);

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefone = findViewById(R.id.editTelefone);



        Log.d("Pessoa", pessoa.toString());

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editTelefone.setText(pessoa.getTelefoneContato());
        editNomeCurso.setText(pessoa.getCursoDesejado());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);


        //Adapter
        //Layout
        //Injetar o Adapter ao Spinner - a lista gerada

        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosParaSpinner();
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cursoController.dadosParaSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);;
        spinner.setAdapter(adapter);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText((""));
                editSobrenome.setText("");
                editTelefone.setText("");
                editNomeCurso.setText("");

                pessoaController.limpar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobrenome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefone.getText().toString());


                Toast.makeText(MainActivity.this, "Salvo " + pessoa, Toast.LENGTH_LONG).show();

                pessoaController.salvar(pessoa);

            }
        });
    }
}