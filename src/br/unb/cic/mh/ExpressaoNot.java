package br.unb.cic.mh;

import br.unb.cic.mh.visitor.Visitor;

public class ExpressaoNot extends ExpressaoUnaria {

	public ExpressaoNot(Expressao sub) {
		super(sub);
	}

	@Override
	public Valor avaliar() {
		ValorBooleano res = (ValorBooleano) sub.avaliar();
		return new ValorBooleano(!res.getValor());
	}
	
	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
