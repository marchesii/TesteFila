package model;

public class FilaCircular implements IFila<Object> {
	
	private final int DEFAULT_MAXIMO = 100;
	private Object filaCircular[];
	private int inicio;
	private int fim;
	private int tamanhoAtual;
	private int tamanhoMaximo;
	
	public FilaCircular() {
		tamanhoMaximo = DEFAULT_MAXIMO;
		init();
	}
	
	public FilaCircular(int tamanhoMaximo) {
		this.tamanhoMaximo = tamanhoMaximo > 0 ? tamanhoMaximo : DEFAULT_MAXIMO;
		init();
	}
	
	private void init() {
		filaCircular = new Object[tamanhoMaximo];
		inicio = 0;
		fim = 0;
		tamanhoAtual = 0;
	}

	@Override
	public boolean enqueue(Object elemento) {
		boolean deuCerto = false;
		if(elemento != null && !isFull()) {
			filaCircular[fim] = elemento;
			if(fim == tamanhoMaximo-1) {
				fim = 0;
			}else {
				fim += 1;
			}
			tamanhoAtual += 1;
			deuCerto = true;
		}
		return deuCerto;
	}

	@Override
	public Object dequeue() {
		Object c = null;
		if(!isEmpty()) {
			c = filaCircular[inicio];
			inicio = inicio == tamanhoMaximo-1 ? 0 : inicio + 1;
			tamanhoAtual -= 1;
		}
		return c;
	}

	@Override
	public boolean isEmpty() {
		return tamanhoAtual == 0;
	}

	@Override
	public boolean isFull() {
		return tamanhoAtual == tamanhoMaximo;
	}

}
