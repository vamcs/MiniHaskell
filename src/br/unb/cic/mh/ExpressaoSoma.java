package br.unb.cic.mh;

import br.unb.cic.mh.visitor.Visitor;

public class ExpressaoSoma extends ExpressaoBinaria {

	public ExpressaoSoma(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	@Override
	public Valor avaliar() {
		ValorInteiro v1 = (ValorInteiro)sub1.avaliar();
		ValorInteiro v2 = (ValorInteiro)sub2.avaliar();
		
		return new ValorInteiro(v1.getValor() + v2.getValor());
	}

	@Override
	public Tipo tipo() {
		Tipo t1 = sub1.tipo();
		Tipo t2 = sub2.tipo();
		
		if(t1.equals(Tipo.INTEIRO) && t2.equals(Tipo.INTEIRO)) {
			return Tipo.INTEIRO;
		}
		return Tipo.ERRO;
	}

	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.INTEIRO);
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
