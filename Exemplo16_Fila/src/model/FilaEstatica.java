package model;

public class FilaEstatica implements IFila<Object> {
	
	private final int DEFAULT_MAXIMO = 100;
	private Object[] fila;
	private int inicio;
	private int fim;
	private int tamanhoMaximo;
	
	public FilaEstatica() {
		tamanhoMaximo = DEFAULT_MAXIMO;
		init();
	}
	
	public FilaEstatica(int tamanhoMaximo) {
		if(tamanhoMaximo > 0) {
			this.tamanhoMaximo = tamanhoMaximo;
		}else {
			this.tamanhoMaximo = DEFAULT_MAXIMO;
		}
		init();
	}
	
	private void init() {
		fila = new Object[tamanhoMaximo];
		inicio = 0;
		fim = -1;
	}
	
	@Override
	public boolean enqueue(Object elemento) {
		boolean deuCerto = false;
		if(elemento != null && !isFull()) {
			fim += 1;
			fila[fim] = elemento; 
			deuCerto = true;
		}
		return deuCerto;
	}

	@Override
	public Object dequeue() {
		Object c = null;
		if(!isEmpty()) {
			c = fila[inicio];
			inicio += 1;
		}
		return c;
	}

	@Override
	public boolean isEmpty() {
		return fim < inicio;
	}

	@Override
	public boolean isFull() {
		return fim == tamanhoMaximo-1;
	}
	
}


