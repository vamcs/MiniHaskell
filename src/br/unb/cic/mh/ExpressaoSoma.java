package br.unb.cic.mh;

public class ExpressaoSoma extends ExpressaoBinariaInteira {

	/*Utiliza o construtor de ExpressaoBinaria (ExpressoaBinariaInteira -> ExpressaoBinaria)*/
	public ExpressaoSoma(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	@Override
	public Valor avaliar() {
		ValorInteiro v1 = (ValorInteiro)sub1.avaliar();
		ValorInteiro v2 = (ValorInteiro)sub2.avaliar();
		
		return new ValorInteiro(v1.getValor() + v2.getValor());
	}

//	@Override
//	public void aceitar(Visitor v) {
//		v.visitar(this);
//	}

	@Override
	public String getOperador() {
		return "+";
	}
}
