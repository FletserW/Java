public class PrincipalApolice{
    public static void main(String[] args) {
        Apolice apolice = new Apolice();
        
        apolice.setName("Nicolas Silva");
        apolice.setIdade(21);
        apolice.setValorPremio(1000);
        
        apolice.imprimir();
        System.out.println("------");
        apolice.calcularPremioApolice();
        apolice.imprimir();
        System.out.println("------");
        apolice.oferecerDesconto("Curitiba");
        apolice.imprimir();
        System.out.println("------");
        apolice.oferecerDesconto("Rio de Janeiro");
        apolice.imprimir();
        System.out.println("------");
        apolice.oferecerDesconto("São Paulo");
        apolice.imprimir();
        System.out.println("------");
        apolice.oferecerDesconto("Belo Horizonte");
        apolice.imprimir();
    }
}
