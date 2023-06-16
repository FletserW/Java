public class Caminhao extends Veiculo {
    private float toneladas;
    private int alturaMax;
    private int comprimento;

    public Caminhao(double peso, int velocMax, double preco, float toneladas, int alturaMax, int comprimento) {
        super(peso, velocMax, preco);
        this.toneladas = toneladas;
        this.alturaMax = alturaMax;
        this.comprimento = comprimento;
    }

    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Toneladas: " + toneladas);
        System.out.println("Altura Máxima: " + alturaMax + " metros");
        System.out.println("Comprimento: " + comprimento + " metros");
    }
}