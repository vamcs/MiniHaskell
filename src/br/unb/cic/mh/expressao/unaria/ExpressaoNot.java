package br.unb.cic.mh.expressao.unaria;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.valor.ValorBooleano;

public class ExpressaoNot extends ExpressaoUnaria {

	public ExpressaoNot(Expressao sub) {
		super(sub);
	}

	@Override
	public Valor avaliar() {
		ValorBooleano res = (ValorBooleano) sub.avaliar();
		return new ValorBooleano(!res.getValor());
	}

}
