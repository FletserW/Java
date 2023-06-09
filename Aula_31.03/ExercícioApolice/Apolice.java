public class Apolice {
    private String nomeSegurado;
    private int idade;
    private double valorPremio;

    public void setName(String nomeSegurado){
        this.nomeSegurado=nomeSegurado;
    }
    public String getNomeSegurado(){
        return this.nomeSegurado;
    }
    public void setIdade(int idade){
        this.idade=idade;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setValorPremio(double valorPremio){
        this.valorPremio=valorPremio;
    }
    public double getValorPremio(){
        return this.valorPremio;
    }
    public void imprimir() {
        System.out.println("Nome do segurado: " + nomeSegurado);
        System.out.println("Idade do segurado: " + idade);
        System.out.println("Valor do prêmio: " + valorPremio);
    }

    public void calcularPremioApolice() {
        if (idade >= 18 && idade <= 25) {
            valorPremio = valorPremio + ((20*valorPremio)/100);
        } 
        else 
            if (idade > 25 && idade <= 36) {
                valorPremio = valorPremio + ((15*valorPremio)/100);
            } 
            else 
                if (idade > 36) {
                    valorPremio = valorPremio + ((10*valorPremio)/100);
            }
    }

    public void oferecerDesconto(String cidade) {
        switch (cidade) {
            case "Curitiba":
                valorPremio = valorPremio + ((20*valorPremio)/100);
                break;
            case "Rio de Janeiro":
                valorPremio = valorPremio + ((15*valorPremio)/100);
                break;
            case "São Paulo":
                valorPremio = valorPremio + ((10*valorPremio)/100);
                break;
            case "Belo Horizonte":
                valorPremio = valorPremio + ((5*valorPremio)/100);
                break;
        }
    }
}