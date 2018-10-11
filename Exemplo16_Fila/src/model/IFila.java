package model;

public interface IFila<T> {

	/**
	 * Insere o novo elemento no final da fila.
	 * 
	 * @param elemento - Objeto Genérico definido na declaração. 
	 * @return - true se conseguiu inserir ou false caso tenha ocorrido algum erro.
	 */
	public abstract boolean enqueue(T elemento);
	
	/**
	 * Remove o primeiro elemento da fila.
	 * 
	 * @return primeiro elemento da fila 
	 */
	public abstract T dequeue();
	
	/**
	 * Informa se a fila está ou não vazia.
	 * @return true se fila vazia ou false se a fila não estiver vazia.
	 */
	public abstract boolean isEmpty();
	
	/**
	 * Informa se a fila está ou não cheia.
	 * @return true se a fila esviver cheia ou false se a fila não estiver cheia.
	 */
	public abstract boolean isFull();
	
}
