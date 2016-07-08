package br.unb.cic.mh.valor;

import br.unb.cic.mh.Tipo;
import br.unb.cic.mh.visitor.Visitor;

//TODO: organizar classes e criar cabeca da lista
public abstract class Lista implements Valor {

	protected Valor valor;
	protected Lista prox;
	
	public Lista(Valor valor) {
		this.valor = valor;
		this.prox = null;
		
	}

	public static void insereLista(Lista novo, ListaNaoVazia<?> local) {

		if (novo.getClass() != ListaVazia.class) {
			novo.prox = local.prox;
		} else if (local.prox != null) {
			throw new RuntimeException("Proibido inserir lista vazia nesta posicao.");
		}

		local.prox = novo;
	}
	
	@Override
	public Tipo tipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
