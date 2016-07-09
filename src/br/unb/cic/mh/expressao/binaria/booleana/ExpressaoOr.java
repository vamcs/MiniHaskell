package br.unb.cic.mh.expressao.binaria.booleana;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.valor.ValorBooleano;

/**
 * Esta classe representa a função OR.
 * Faz o cálculo com dois valores booleanos e retorna um outro valor booleano resultante.
 * 
 * @author vamcs
 */
public class ExpressaoOr extends ExpressaoBinariaBooleana {

	// ===========================================================
	// Construtores
	// ===========================================================
	
	public ExpressaoOr(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	// ===========================================================
	// Métodos
	// ===========================================================
	
	@Override
	public Valor avaliar() {
		ValorBooleano v1 = (ValorBooleano)sub1.avaliar();
		ValorBooleano v2 = (ValorBooleano)sub2.avaliar();
		
		return new ValorBooleano(v1.getValor() || v2.getValor());
	}

	// ===========================================================
	// Getters & Setters
	// ===========================================================
	
	@Override
	public String getOperador() {
		return "||";
	}

}
