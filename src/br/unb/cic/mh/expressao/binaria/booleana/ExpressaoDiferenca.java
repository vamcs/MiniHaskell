package br.unb.cic.mh.expressao.binaria.booleana;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorConcreto;

/**
 * Classe que implementa a função de comparação de diferença.
 * Compara dois valores inteiros ou dois valores booleanos e retorna o valor booleano do resultado.
 * 
 * @author vamcs
 *
 * @param <T> estende ValorConcreto
 */
public class ExpressaoDiferenca<T extends ValorConcreto<?>> extends ExpressaoBinariaBooleana {

	// ===========================================================
	// Construtores
	// ===========================================================
	
	public ExpressaoDiferenca(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	// ===========================================================
	// Métodos
	// ===========================================================
	
	@Override
	public Valor avaliar() {
		T v1 = (T) sub1.avaliar();
		T v2 = (T) sub2.avaliar();
		
		return new ValorBooleano(v1.getValor() != v2.getValor());
	}
	
	// ===========================================================
	// Getters & Setters
	// ===========================================================
	
	@Override
	public String getOperador() {
		return "/=";
	}

}
