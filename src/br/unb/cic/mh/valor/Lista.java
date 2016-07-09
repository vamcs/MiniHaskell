package br.unb.cic.mh.valor;

import br.unb.cic.mh.Tipo;
import br.unb.cic.mh.visitor.PPVisitor;
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
	
	public static Lista pop(Lista lista) {
		return lista.getProx();
	}
	
	public Lista cons(ListaNaoVazia<?> novo) {
		assert(novo.tipo().equals(this.tipo()));
		novo.prox = this;
		return novo;
	}
	
	public static Valor elemento(Lista lista, int i) {
		for (int j = 1; j < i; j++) {
			lista = lista.getProx();
		}
		
		return lista.getValor();
	}
	
	public static void insere(Lista local, Lista novo) {
		assert(novo.tipo().equals(local.tipo()));
		if (!(novo instanceof ListaVazia)) {
			novo.prox = local.prox;
			local.prox = novo;
		} else {
			throw new RuntimeException("Proibido inserir lista vazia.");
		}
	}
	
	public static int tamanho(Lista lista) {
		int tamanho = 0;
		//for (Lista aux = lista;aux.getValor() != null;aux = aux.getProx(),tamanho++) {}
		if(lista.getProx() != null) {
			return tamanho(lista.getProx()) + 1;
		}
			
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
		Lista lista = this;
		Boolean res = true;
		
		while (!(lista.prox instanceof ListaVazia) && res == true) {
			if (lista.tipo().equals(prox.tipo())) {
				lista = lista.prox;
			}
			else {
				res = false;
			}
		}
		
		return res;
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
