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
	
	/**
	 * Remove um valor da lista.
	 * @param local - nó a ser removido.
	 * @return nov
	 */
//	public Lista removeLista(Lista old) {
//		
//		Lista pos = this;
//		
//		if (this == old) {
//			return this.getProx();
//		}
//		else {
//			while (!(pos instanceof ListaVazia) && pos != old) {
//				pos = pos.getProx();
//			}
//			return pos.getProx();
//		}
//	}
	
	public ListaNaoVazia(Valor valor) {
		super(valor);
//		if(valor instanceof Lista){
//			Lista aux;
//			aux=this;
//			while(!(aux.prox instanceof ListaVazia)){
//				System.out.println("Passou");
//				aux=aux.prox;
//			}
//			aux.prox = this;
//		}
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
