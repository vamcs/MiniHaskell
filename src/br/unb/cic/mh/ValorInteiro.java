package br.unb.cic.mh;

import br.unb.cic.mh.visitor.Visitor;

public class ValorInteiro extends ValorConcreto<Integer>{

	public ValorInteiro(Integer valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.INTEIRO;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
