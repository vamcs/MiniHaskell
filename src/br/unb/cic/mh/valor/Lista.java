package br.unb.cic.mh.valor;

import br.unb.cic.mh.Tipo;
import br.unb.cic.mh.visitor.Visitor;

//TODO: organizar classes e criar cabe�a da lista
public abstract class Lista implements Valor {

//	protected Valor valor;
	protected Lista prox;
	
//	public Lista(Valor valor) {
//		this.valor = valor;
//		this.prox = null;
//		
//	}

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
