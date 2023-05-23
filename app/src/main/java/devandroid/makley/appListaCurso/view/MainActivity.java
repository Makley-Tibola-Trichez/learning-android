package devandroid.makley.appListaCurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.makley.appListaCurso.R;
import devandroid.makley.appListaCurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {


    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editTelefone;


    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Pessoa pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Makley");
        pessoa.setSobrenome("Tibola Trichez");
        pessoa.setTelefoneContato("nenhum");
        pessoa.setTelefoneContato("9999");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefone = findViewById(R.id.editTelefone);


        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);


        editPrimeiroNome.setText(pessoa.getPrimeiroNome());


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText((""));
                editSobrenome.setText("");
                editTelefone.setText("");
                editNomeCurso.setText("");
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

            }
        });

    }
}