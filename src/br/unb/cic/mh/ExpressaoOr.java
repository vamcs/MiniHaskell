package br.unb.cic.mh;

public class ExpressaoOr extends ExpressaoBinariaBooleana {

	public ExpressaoOr(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	@Override
	public Valor avaliar() {
		ValorBooleano v1 = (ValorBooleano)sub1.avaliar();
		ValorBooleano v2 = (ValorBooleano)sub2.avaliar();
		
		return new ValorBooleano(v1.getValor() || v2.getValor());
	}

	@Override
	public String getOperador() {
		return "||";
	}

}
