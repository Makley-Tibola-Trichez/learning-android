package devandroid.makley.appGasEta.utils;

public class UtilGasEta {


    public static String calcularMelhorOpcao(double gasolina, double etanol) {
        double precoIdeal = gasolina * 0.70;

        if (etanol <= precoIdeal) {
            return "Abastecer com Etanol";
        }

        return "Abastecer com Gasolina";
    }

}
