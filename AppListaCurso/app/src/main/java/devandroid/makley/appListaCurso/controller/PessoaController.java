package devandroid.makley.appListaCurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.makley.appListaCurso.model.Pessoa;
import devandroid.makley.appListaCurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

    }

    public void salvar(Pessoa pessoa) {
        Log.i("MVC_Controller","Salvo" + pessoa.toString());

        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        listaVip.putString("nomeCurso", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();
    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome",""));
        pessoa.setSobrenome(preferences.getString("sobrenome",""));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso",""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato",""));

        return pessoa;
    }

    public void limpar() {

        listaVip.clear();
        listaVip.apply();
    }


}
