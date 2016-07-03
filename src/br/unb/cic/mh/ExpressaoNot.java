package br.unb.cic.mh;

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
