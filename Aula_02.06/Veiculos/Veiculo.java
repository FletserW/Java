class Veiculo {
    private double peso;
    private int velocMax;
    private double preco;

    public Veiculo(double peso, int velocMax, double preco) {
        this.peso = peso;
        this.velocMax = velocMax;
        this.preco = preco;
    }

    public void mostrarDados() {
        System.out.println("Peso: " + peso + " Kg");
        System.out.println("Velocidade Máxima: " + velocMax + " Km/h");
        System.out.println("Preço: R$ " + preco);
    }
}
