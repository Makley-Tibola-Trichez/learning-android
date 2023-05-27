package devandroid.makley.appGasEta.model;

public class Combustivel {


    private String nomeDoCombustivel;
    private double valorDoCombustivel;
    private String recomendacao;

    public String getNomeDoCombustivel() {
        return nomeDoCombustivel;
    }

    public double getValorDoCombustivel() {
        return valorDoCombustivel;
    }

    public Combustivel(String nomeDoCombustivel, double valorDoCombustivel) {
        this.nomeDoCombustivel = nomeDoCombustivel;
        this.valorDoCombustivel = valorDoCombustivel;

    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

}
