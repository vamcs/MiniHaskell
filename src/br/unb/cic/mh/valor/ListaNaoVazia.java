package br.unb.cic.mh.valor;

/**
 * Lista que cont�m um valor e uma refer�ncia para o pr�ximo n� da lista encadeada.
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
	// M�todos
	// ===========================================================
	
	@Override
	public T avaliar() {
		assert(this == null);
		T v1 = (T) valor.avaliar();
		
		return v1;
	}
	
}
