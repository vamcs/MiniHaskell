package br.unb.cic.mh;

import br.unb.cic.mh.visitor.Visitor;

public abstract class ExpressaoBinaria implements Expressao{

	protected Expressao sub1;
	protected Expressao sub2;

	public ExpressaoBinaria(Expressao s1, Expressao s2) {
		this.sub1 = s1;
		this.sub2 = s2;
	}
	
	public Expressao getSub1() {
		return sub1;
	}
	
	public Expressao getSub2() {
		return sub2;
	}

	public abstract String getOperando();
	
	/*A função aceitar vale para todas as subclasses.*/
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
