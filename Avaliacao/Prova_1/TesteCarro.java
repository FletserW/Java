public class TesteCarro
{
    public static void main(String[] args) {
        Carro carro = new Carro();
        
        carro.setModelo("HB20");
        carro.setMarca("Ronda");
        carro.setVelocidade(20);
        
        carro.acelerar();
        carro.acelerar();
        carro.acelerar();
        carro.acelerar();
        carro.imprimir();
        if(carro.verificarVelocidade(60))
            System.out.println("Esta acima do limite");
        else
            System.out.println("Esta abaixo do limite");
        carro.freiar();
        carro.freiar();
        carro.imprimir();
        carro.parar();
        carro.imprimir();
    }
}
