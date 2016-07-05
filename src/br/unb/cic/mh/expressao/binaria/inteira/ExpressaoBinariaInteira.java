package br.unb.cic.mh.expressao.binaria.inteira;

import br.unb.cic.mh.Tipo;
import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.expressao.binaria.ExpressaoBinaria;

/**
*	Esta classe foi criada para evitar a repetição dos métodos tipo() e checarTipo()
*	para todas as expressões binárias inteiras.
*
*	@author vamcs
*/
public abstract class ExpressaoBinariaInteira extends ExpressaoBinaria {

	/*Utilização do construtor de ExpressaoBinaria.*/
	public ExpressaoBinariaInteira(Expressao s1, Expressao s2) {
		super(s1, s2);
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
	
}
