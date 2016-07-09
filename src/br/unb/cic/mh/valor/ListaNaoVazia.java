package br.unb.cic.mh.valor;

/**
 * Lista que contém um valor e uma referência para o próximo nó da lista encadeada.
 * 
 * @author vamcs
 *
 * @param <T> que pode ser um valor inteiro, booleano ou outra lista.
 */
public class ListaNaoVazia<T extends Valor> extends Lista {

	// ===========================================================
	// Construtores
	// ===========================================================
	
	public ListaNaoVazia(Valor valor) {
		super(valor);
		this.prox = new ListaVazia();
	}

	// ===========================================================
	// Métodos
	// ===========================================================
	
	@Override
	public T avaliar() {
		assert(this == null);
		T v1 = (T) valor.avaliar();
		
		return v1;
	}
	
}
