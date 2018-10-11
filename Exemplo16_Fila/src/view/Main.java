package view;

import model.FilaEstatica;
import model.IFila;

public class Main {

	public static void main(String args[]) {
		
		IFila fila = new FilaEstatica();
		

		fila.enqueue("aaaa");
		fila.enqueue(123);
		fila.enqueue(1239.2);
		
		System.out.print(fila.dequeue());
		System.out.print(fila.dequeue());
		System.out.print(fila.dequeue());
		
	}

}
