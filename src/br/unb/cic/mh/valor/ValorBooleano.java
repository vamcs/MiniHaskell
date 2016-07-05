package br.unb.cic.mh.valor;

import br.unb.cic.mh.visitor.Visitor;
import br.unb.cic.mh.Tipo;

public class ValorBooleano extends ValorConcreto<Boolean>{

	public ValorBooleano(Boolean valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.BOOLEANO;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}	
}
