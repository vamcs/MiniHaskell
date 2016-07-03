package br.unb.cic.mh;

public class ExpressaoIgualdade<T extends ValorConcreto<?>> extends ExpressaoBinariaBooleana {

	public ExpressaoIgualdade(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	@Override
	/*	TODO: implementar a express�o igualdade para ValorInteiro e ValorBooleano.
	 * */
	public Valor avaliar() {
		T v1 = (T) sub1.avaliar();
		T v2 = (T) sub2.avaliar();
		
		return new ValorBooleano(v1.getValor() == v2.getValor());
	}

	@Override
	public String getOperador() {
		return "==";
	}

}
