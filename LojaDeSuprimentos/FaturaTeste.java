public class FaturaTeste {
    public static void main(String[] args) {
        
        Fatura fatura = new Fatura();
        
        fatura.setNumeroFatura(1010);
        fatura.setDescricao("Monitor LED 27 polegadas");
        fatura.setQuantidadeComprada(3);
        fatura.setPrecoPorItem(1000);
        
        System.out.println("Número da Fatura: " + fatura.getNumeroFatura());
        System.out.println("Descrição: " + fatura.getDescricao());
        System.out.println("Quantidade Comprada: " + fatura.getQuantidadeComprada());
        System.out.println("Preço por Item: " + fatura.getPrecoPorItem());
        System.out.println("Total da Fatura: " + fatura.totalFatura());
        
    }
}