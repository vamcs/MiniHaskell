package br.unb.cic.mh.valor;

import br.unb.cic.mh.Tipo;
import br.unb.cic.mh.visitor.Visitor;

/**
 * Superclasse que especifica o tipo lista, a qual contém uma lista encadeada com
 * valores inteiros, booleanos ou uma lista.
 * 
 * @author vamcs
 *
 */
//TODO: organizar classes e criar cabeca da lista
public abstract class Lista implements Valor {

	// ===========================================================
	// Atributos
	// ===========================================================
	
	protected Valor valor;
	protected Lista prox;
	
	// ===========================================================
	// Construtores
	// ===========================================================
	
	public Lista(Valor valor) {
		this.valor = valor;
		this.prox = null;
		
	}

	// ===========================================================
	// Métodos
	// ===========================================================
	
	public static void insereLista(ListaNaoVazia<?> local, Lista novo) {

		if (novo.getClass() != ListaVazia.class) {
			Lista aux ;
			aux=local;
			while(!(aux.prox instanceof ListaVazia)){
				System.out.println("Passou");
				aux=aux.prox;
			}
			aux.prox = novo;
			//novo.prox = local.prox;
			//local.prox = novo;
			System.out.println("");
		} else {
			throw new RuntimeException("Proibido inserir lista vazia.");
		}
	}
	
	public static int tamanhoLista(Lista lista) {
		int tamanho = 0;
		//for (Lista aux = lista;aux.getValor() != null;aux = aux.getProx(),tamanho++) {}
		if(lista.getProx() != null)
			return tamanhoLista(lista.getProx()) + 1;
		
		else return tamanho; 
	}

	// Aqui foi levado em conta o fato do MiniHaskell herdar a caracteristica do haskell ser fortemente tipada
	@Override
	public Tipo tipo() {
		// TODO Auto-generated method stub
		return valor.tipo();
	}

	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

	// ===========================================================
	// Getters & Setters
	// ===========================================================
	
	public Valor getValor() {
		return valor;
	}

	public Lista getProx() {
		return prox;
	}
}
