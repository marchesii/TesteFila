package teste;

import org.junit.*;
import model.FilaEstatica;
import junit.framework.TestCase;

public class FilaEstaticaTest extends TestCase {
	FilaEstatica fila1 = new FilaEstatica();
	FilaEstatica fila2 = new FilaEstatica(2);
	FilaEstatica fila3 = new FilaEstatica(5);
	boolean resultadoEsperadoSim = true;
	boolean resultadoEsperadoNao = false;
	
	
	/**
	 * 	Testando o Enqueue
	 * 	utilizado para testar se está os objetos estão entrando na fila,
	 * 	utilizado para testar se o objeto entra mesmo se a fila está cheia
	 * 
	 */
	@BeforeClass
	public void testEnqueue() {

		Object ops = "ops";
		
		assertEquals(resultadoEsperadoSim, fila1.enqueue("Elemento azul"));
		
		assertEquals(resultadoEsperadoSim, fila1.enqueue(12345));
		
		assertEquals(resultadoEsperadoSim, fila1.enqueue(ops));
		
		assertEquals(resultadoEsperadoSim, fila2.enqueue("Linha als"));
		
		assertEquals(resultadoEsperadoSim, fila2.enqueue(ops));
		
		assertEquals(resultadoEsperadoSim, fila3.enqueue("Test"));
		
		assertEquals(resultadoEsperadoSim, fila3.enqueue(123));
		
		assertEquals(resultadoEsperadoSim, fila3.enqueue(ops));
		
		assertEquals(resultadoEsperadoSim, fila3.enqueue(1457878));
		
		assertEquals(resultadoEsperadoNao, fila2.enqueue(1578));
		
	}
	
	/**
	 * Teste isEmpty
	 * Verifica se a fila está vazia ou não
	 * Caso a fila esteja vazia, o método retornaria true, caso tenha objetos, não
	 * 
	 */
	@Test
	public void testIsEmpty() {

		fila1.enqueue(12457);
		fila2.enqueue("Teste mais um");
		fila2.enqueue(15478.548);
		
		assertEquals(resultadoEsperadoNao, fila1.isEmpty());
		// assertEquals(resultadoEsperadoCerto, fila1.isEmpty());
		
		assertEquals(resultadoEsperadoNao, fila2.isEmpty());
		
		assertEquals(resultadoEsperadoSim, fila3.isEmpty());
		// assertEquals(resultadoEsperadoErrado, fila2.isEmpty());
		
		fila1.dequeue();
		fila2.dequeue();
		fila3.dequeue();
		
		assertEquals(resultadoEsperadoSim, fila1.isEmpty());
		assertEquals(resultadoEsperadoNao, fila2.isEmpty());
		assertEquals(resultadoEsperadoSim, fila3.isEmpty());
		
		fila2.dequeue();
		
		assertEquals(resultadoEsperadoSim, fila2.isEmpty());
		
		fila1.enqueue(12457);
		fila2.enqueue("Teste mais um");
		fila2.enqueue(15478);
		fila3.enqueue(15478.548);
		
		assertEquals(resultadoEsperadoNao, fila1.isEmpty());
		assertEquals(resultadoEsperadoSim, fila2.isEmpty());
		assertEquals(resultadoEsperadoNao, fila3.isEmpty());
		
		
		
	}
	
	
	/**
	 * Teste isFull
	 * verifica se a fila está cheia ou não
	 * caso esteja cheia true, caso tenha espaço false
	 * 
	 */
	@Test
	public void testIsFull() {
		
		fila1.enqueue(12457);
		fila2.enqueue("Teste mais um");
		fila2.enqueue(15478.548);
		fila3.enqueue("  ");
		
		assertEquals(resultadoEsperadoNao, fila1.isFull());
		// assertEquals(resultadoEsperadoCerto, fila1.isFull());
		
		assertEquals(resultadoEsperadoSim, fila2.isFull());
		// assertEquals(resultadoEsperadoErrado, fila2.isFull());
		
		assertEquals(resultadoEsperadoNao, fila3.isFull());
		
		for(int i = 0; i < 99; i++) {
			fila1.enqueue(i);
		}
		
		assertEquals(resultadoEsperadoSim, fila1.isFull());
		
		for(int i = 0; i < 4; i++) {
			fila3.enqueue(i);
		}
		
		assertEquals(resultadoEsperadoSim, fila3.isFull());
		
	}
	
	/**
	 * Teste Dequeue
	 * verifica se o elemento está sendo retirado da fila corretamente
	 * caso esteja, retorna o elemento que foi retirado, caso não, nulo
	 */
	@BeforeClass
	public void testDequeue() {
		
		Object resultadoEsperado1 = "Elemento azul";
		Object resultadoEsperado2 = "Linha als";
		Object resultadoEsperado3 = 3;
		
		fila1.enqueue("Elemento azul");
		fila2.enqueue("Linha als");
		fila3.enqueue(3);
		fila1.enqueue(1);
		fila2.enqueue(2);
		fila3.enqueue("Test");
		fila1.enqueue("Outro Test");
		fila2.enqueue("Mais um Test");
		fila3.enqueue(4);
		
		assertEquals(resultadoEsperado1, fila1.dequeue());
		assertEquals(resultadoEsperado2, fila2.dequeue());
		assertEquals(resultadoEsperado3, fila3.dequeue());
		
		resultadoEsperado1 = 1;
		resultadoEsperado2 = 2;
		resultadoEsperado3 = "Test";
		
		assertEquals(resultadoEsperado1, fila1.dequeue());
		assertEquals(resultadoEsperado2, fila2.dequeue());
		assertEquals(resultadoEsperado3, fila3.dequeue());
		
		resultadoEsperado1 = "Outro Test";
		resultadoEsperado2 = null;
		resultadoEsperado3 = 4;
		
		assertEquals(resultadoEsperado1, fila1.dequeue());
		assertEquals(resultadoEsperado2, fila2.dequeue());
		assertEquals(resultadoEsperado3, fila3.dequeue());
		
		resultadoEsperado1 = null;
		
		assertEquals(resultadoEsperado1, fila1.dequeue());
		
	}

}
