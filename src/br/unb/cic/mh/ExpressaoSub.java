package br.unb.cic.mh;

/**
* Classe adaptada a partir de ExpressaoSoma.java para implementar a operação de subtração
* na linguagem Mini Haskell.
* 
* @author vamcs
*/
public class ExpressaoSub extends ExpressaoBinariaInteira {

	public ExpressaoSub(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	@Override
	public Valor avaliar() {
		ValorInteiro v1 = (ValorInteiro)sub1.avaliar();
		ValorInteiro v2 = (ValorInteiro)sub2.avaliar();
		
		return new ValorInteiro(v1.getValor() - v2.getValor());
	}

//	@Override
//	public void aceitar(Visitor v) {
//		v.visitar(this);
//	}

	@Override
	public String getOperando() {
		return "-";
	}

}
