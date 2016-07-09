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
		if(valor instanceof Lista){
			Lista aux;
			aux=this;
			while(!(aux.prox instanceof ListaVazia)){
				System.out.println("Passou");
				aux=aux.prox;
			}
			aux.prox = this;
		}
		this.prox = new ListaVazia();
	}

	// ===========================================================
	// Métodos
	// ===========================================================
	
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
