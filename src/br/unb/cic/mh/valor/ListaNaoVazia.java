package br.unb.cic.mh.valor;

public class ListaNaoVazia<T extends Valor> extends Lista {

	public ListaNaoVazia(Valor valor, Lista prox) {
		super(valor);
		this.prox = prox;
	}
	
	public ListaNaoVazia<T> cons(T valor) {
		ListaNaoVazia<T> novo = new ListaNaoVazia<T>(valor, null);
		novo.prox = this;
		return novo;
	}

	//TODO: consertar o retorno de getProx().
	public Lista getProx() {
		return this.prox;
	}
	
	@Override
	public T avaliar() {
		assert(this == null);
		T v1 = (T) valor.avaliar();
		
		return v1;
	}
	
}
