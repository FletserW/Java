class CarroPasseio extends Veiculo {
    private String cor;
    private String modelo;

    public CarroPasseio(double peso, int velocMax, double preco, String cor, String modelo) {
        super(peso, velocMax, preco);
        this.cor = cor;
        this.modelo = modelo;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Cor: " + cor);
        System.out.println("Modelo: " + modelo);
    }
}