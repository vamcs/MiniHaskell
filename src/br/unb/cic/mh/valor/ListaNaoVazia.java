package br.unb.cic.mh.valor;

public class ListaNaoVazia<T extends Valor> extends Lista {

	public ListaNaoVazia(Valor valor) {
		super(valor);
		this.prox = new ListaVazia();
	}
	
	public ListaNaoVazia<T> cons(T valor) {
		ListaNaoVazia<T> novo = new ListaNaoVazia<T>(valor);
		novo.prox = this;
		return novo;
	}
	
	@Override
	public T avaliar() {
		assert(this == null);
		T v1 = (T) valor.avaliar();
		
		return v1;
	}
	
}
