public class UsaEstoque {
    public static void main(String[] args) {
        
        Estoque estoque1 = new Estoque();
        Estoque estoque2 = new Estoque();
        Estoque estoque3 = new Estoque();
        
        estoque1.setNome("Produto 1");
        estoque1.setQtdAtual(10);
        estoque1.setQtdMinima(5);

        estoque2.setNome("Produto 2");
        estoque2.setQtdAtual(3);
        estoque2.setQtdMinima(6);

        estoque3.setNome("Produto 3");
        estoque3.setQtdAtual(8);
        estoque3.setQtdMinima(4);

        estoque1.darBaixa(5);
        estoque2.repor(7);
        estoque3.darBaixa(4);

        System.out.println("Precisa repor estoque 1? " + estoque1.precisaRepor());
        System.out.println("Precisa repor estoque 2? " + estoque2.precisaRepor());
        System.out.println("Precisa repor estoque 3? " + estoque3.precisaRepor());
        System.out.println();

        estoque1.mostrar();
        estoque2.mostrar();
        estoque3.mostrar();
    }
}
