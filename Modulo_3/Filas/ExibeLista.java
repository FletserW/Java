package Modulo_3.Filas;

import java.util.List;
import java.util.LinkedList;

public class ExibeLista {
    public static void main (String[] args){
        LinkedList<Integer> p1 = new LinkedList<Integer>();
        LinkedList<Integer> p2 = new LinkedList<Integer>();
        LinkedList<Integer> p3 = new LinkedList<Integer>();
        LinkedList<Integer> A1 = new LinkedList<Integer>();
        LinkedList<Integer> A2 = new LinkedList<Integer>();
        int key = 0;
        //Pilha p1
        p1.addFirst(40);
        p1.addFirst(30);
        p1.addFirst(25);
        p1.addFirst(10);
        //Pilha P2
        p2.addFirst(34);
        p2.addFirst(60);
        p2.addFirst(28);
        p2.addFirst(15);
        //Pilha P3
        p3.addFirst(20);
        p3.addFirst(35);
        while(key > 4){
            A1.addFirst(p1.getFirst());
            p1.removeFirst();
            key += 1;
        }
        key = 0;
        while(key > 4){
            A1.addFirst(p2.getFirst());
            p2.removeFirst();
            key += 1;
        }
        key = 0;
        while(key > 3){
            A1.addFirst(p3.getFirst());
            p3.removeFirst();
            key += 1;
        }
        key = 0;
        while(A1.size() != 0){
            A2.addFirst(A1.getFirst());
            A1.removeFirst();
        }
        for(key = 0; key < 4; key++){
        System.out.println("Pilha A2: "+A2);
            A2.removeFirst();
        }
    }
}