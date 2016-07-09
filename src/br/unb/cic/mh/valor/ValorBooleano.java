package br.unb.cic.mh.valor;

import br.unb.cic.mh.visitor.Visitor;
import br.unb.cic.mh.Tipo;

public class ValorBooleano extends ValorConcreto<Boolean>{

	// ===========================================================
	// Construtores
	// ===========================================================
	
	public ValorBooleano(Boolean valor) {
		super(valor);
	}

	// ===========================================================
	// Métodos
	// ===========================================================
	
	@Override
	public Tipo tipo() {
		return Tipo.BOOLEANO;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}	
}
