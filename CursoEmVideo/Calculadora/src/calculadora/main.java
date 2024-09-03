/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

/**
 *
 * @author reido
 */
public class main {

    enum Operadores{
        SOMAR("+") {
            @Override
            public double exectarOperacao(double x, double y) {
                return x + y;
            }
        }, SUBTRAIR("-") {
            @Override
            public double exectarOperacao(double x, double y) {
                return x - y;
            }
        }, MULTIPLICAR("*") {
            @Override
            public double exectarOperacao(double x, double y) {
                return x * y;
            }
        }, DIVIDIR("/") {
            @Override
            public double exectarOperacao(double x, double y) {
                return x / y;
            }
        };
        
        private String simbolo;
       
        
        Operadores(String simbolo){
            this.simbolo = simbolo;
        }
        
         public abstract  double exectarOperacao(double x, double y);

        @Override
        public String toString() {
            return this.simbolo;
        }
        
        
    }
    
    public static void main(String[] args) {
        double x = 2.0;
        double y = 3.0;
        
        for(Operadores op : Operadores.values()){
            System.out.print(x + " ");
            System.out.print(op.toString()  + "");
            System.out.print(y + " ");
            System.out.println(op.exectarOperacao(x, y));
        }
    }
    
}
