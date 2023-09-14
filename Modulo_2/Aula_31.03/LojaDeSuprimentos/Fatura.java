public class Fatura {
    private int numeroFatura;
    private String descricao;
    private int quantidadeComprada;
    private double precoPorItem;

    public int getNumeroFatura() {
        return this.numeroFatura;
    }
    public void setNumeroFatura(int numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeComprada() {
        return this.quantidadeComprada;
    }
    public void setQuantidadeComprada(int quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public double getPrecoPorItem() {
        return this.precoPorItem;
    }
    public void setPrecoPorItem(double precoPorItem) {
        this.precoPorItem = precoPorItem;
    }

    public double totalFatura() {
        return this.quantidadeComprada * precoPorItem;
    }
}
