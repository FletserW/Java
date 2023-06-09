public class Estoque {
    private String nome;
    private int qtdAtual;
    private int qtdMinima;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }
    public int getQtdAtual() {
        return qtdAtual;
    }

    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }
    public int getQtdMinima() {
        return qtdMinima;
    }
    
    public void repor(int qtd) {
        qtdAtual = qtdAtual + qtd;
    }

    public void darBaixa(int qtd) {
        qtdAtual = qtdAtual - qtd;
    }

    public void mostrar() {
        System.out.println("Nome: " + nome);
        System.out.println("Quantidade Mínima: " + qtdMinima);
        System.out.println("Quantidade Atual: " + qtdAtual);
        System.out.println("-----------");
    }

    public boolean precisaRepor() {
        return qtdAtual <= qtdMinima;
    }
}
