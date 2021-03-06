package br.unb.cic.mh.expressao.binaria.booleana;

import br.unb.cic.mh.Tipo;
import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.expressao.binaria.ExpressaoBinaria;

/**
*	Esta classe foi criada para evitar a repeticao dos metodos tipo() e checarTipo()
*	para todas as expressoes binarias booleanas.
*
*	@author vamcs
*/
public abstract class ExpressaoBinariaBooleana extends ExpressaoBinaria {
	
	/*Utilizacao do construtor de ExpressaoBinaria.*/
	public ExpressaoBinariaBooleana(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	@Override
	public Tipo tipo() {
		Tipo t1 = sub1.tipo();
		Tipo t2 = sub2.tipo();
		
		if (t1.equals(Tipo.BOOLEANO) && t2.equals(Tipo.BOOLEANO)) {
			return Tipo.BOOLEANO;
		}
		else if (t1.equals(Tipo.INTEIRO) && t2.equals(Tipo.INTEIRO)) {
			return Tipo.INTEIRO;
		}
		return Tipo.ERRO;
	}

	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.BOOLEANO);
	}

}
