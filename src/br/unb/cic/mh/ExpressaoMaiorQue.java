package br.unb.cic.mh;

public class ExpressaoMaiorQue extends ExpressaoBinariaBooleana {

	public ExpressaoMaiorQue(Expressao s1, Expressao s2) {
		super(s1, s2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Valor avaliar() {
		ValorInteiro v1 = (ValorInteiro) sub1.avaliar();
		ValorInteiro v2 = (ValorInteiro) sub2.avaliar();
		
		return new ValorBooleano(v1.getValor() > v2.getValor());
	}

	@Override
	public String getOperador() {
		return ">";
	}

}
