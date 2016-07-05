package br.unb.cic.mh.expressao.binaria.booleana;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorInteiro;

public class ExpressaoMenorIgual extends ExpressaoBinariaBooleana {

	public ExpressaoMenorIgual(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	@Override
	public Valor avaliar() {
		ValorInteiro v1 = (ValorInteiro) sub1.avaliar();
		ValorInteiro v2 = (ValorInteiro) sub2.avaliar();
		
		return new ValorBooleano(v1.getValor() <= v2.getValor());
	}

	@Override
	public String getOperador() {
		return "<=";
	}

}
