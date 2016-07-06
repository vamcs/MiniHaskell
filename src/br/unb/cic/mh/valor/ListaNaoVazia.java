package br.unb.cic.mh.valor;

public class ListaNaoVazia<T extends Valor> extends Lista {

	private T valor;
	
	public ListaNaoVazia(T valor, Lista prox) {
		this.valor = valor;
		this.prox = prox;
	}
	
	public ListaNaoVazia<T> cons(T valor) {
		ListaNaoVazia<T> novo = new ListaNaoVazia<T>(valor, null);
		novo.prox = this;
		return novo;
	}
	
	//TODO: criar cabeça da lista.
	public void insereLista(Lista lista, ListaNaoVazia<T> local) {
		
		if (lista.getClass() != ListaVazia.class) {
			lista.prox = local.prox;
		} else if (local.prox != null) {
			throw new RuntimeException("Proibido inserir lista vazia nesta posição.");
		}

		local.prox = lista;
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
