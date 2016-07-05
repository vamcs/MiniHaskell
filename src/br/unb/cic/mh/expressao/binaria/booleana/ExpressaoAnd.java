package br.unb.cic.mh.expressao.binaria.booleana;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.valor.ValorBooleano;

public class ExpressaoAnd extends ExpressaoBinariaBooleana {

	public ExpressaoAnd(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	@Override
	public Valor avaliar() {
		ValorBooleano v1 = (ValorBooleano)sub1.avaliar();
		ValorBooleano v2 = (ValorBooleano)sub2.avaliar();
		
		return new ValorBooleano(v1.getValor() && v2.getValor());
	}

	@Override
	public String getOperador() {
		return "&&";
	}

}
