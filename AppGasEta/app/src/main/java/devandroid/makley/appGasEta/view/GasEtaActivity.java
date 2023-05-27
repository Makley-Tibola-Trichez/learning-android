package devandroid.makley.appGasEta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.makley.appGasEta.R;
import devandroid.makley.appGasEta.controller.CombustivelController;
import devandroid.makley.appGasEta.model.Combustivel;
import devandroid.makley.appGasEta.utils.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {


    CombustivelController combustivelController;
    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    EditText editGasolina;
    EditText editEtanol;

    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    double precoGasolina;
    double precoEtanol;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        combustivelController = new CombustivelController(GasEtaActivity.this);

        setContentView(R.layout.activity_gaseta);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(editGasolina.getText())) {
                    editGasolina.setError("* Obrigatório");
                    editGasolina.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(editEtanol.getText())) {
                    editEtanol.setError("* Obrigatório");
                    editEtanol.requestFocus();
                    return;
                }

                String recomendacao = UtilGasEta.calcularMelhorOpcao(
                        Double.parseDouble(editGasolina.getText().toString()),
                        Double.parseDouble(editEtanol.getText().toString())
                );
                txtResultado.setText(recomendacao);
                btnSalvar.setEnabled(true);

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editEtanol.setText("");
                editGasolina.setText("");
                btnSalvar.setEnabled(false);
                combustivelController.limpar();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                combustivelGasolina = new Combustivel("Gasolina", precoGasolina);
                combustivelEtanol = new Combustivel("Etanol", precoEtanol);

                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));
                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));

                combustivelController.salvar(combustivelGasolina);
                combustivelController.salvar(combustivelEtanol);
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
