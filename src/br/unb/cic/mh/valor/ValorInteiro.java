package br.unb.cic.mh.valor;

import br.unb.cic.mh.visitor.Visitor;
import br.unb.cic.mh.Tipo;

public class ValorInteiro extends ValorConcreto<Integer>{

	// ===========================================================
	// Construtores
	// ===========================================================
	
	public ValorInteiro(Integer valor) {
		super(valor);
	}

	// ===========================================================
	// Métodos
	// ===========================================================
	
	@Override
	public Tipo tipo() {
		return Tipo.INTEIRO;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
