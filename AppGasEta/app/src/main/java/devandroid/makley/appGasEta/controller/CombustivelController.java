package devandroid.makley.appGasEta.controller;

import android.content.SharedPreferences;

import devandroid.makley.appGasEta.model.Combustivel;
import devandroid.makley.appGasEta.view.GasEtaActivity;

public class CombustivelController {

    SharedPreferences preferences;


    SharedPreferences.Editor dataPreferences;

    public static final String NOME_PREFERENCES = "pref_gaseta";


    public CombustivelController(GasEtaActivity activity) {
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);

        dataPreferences = preferences.edit();


    }


    public void salvar(Combustivel combustivel) {
        dataPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        dataPreferences.putFloat("valorCombustivel", (float) combustivel.getValorDoCombustivel());
        dataPreferences.putString("recomendacao", combustivel.getRecomendacao());
        dataPreferences.apply();
    }

    public void limpar() {

        dataPreferences.clear();
        dataPreferences.apply();
    }
}
