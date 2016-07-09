package br.unb.cic.mh.expressao.binaria.inteira;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.valor.ValorInteiro;

/**
 * Implementa a função de soma de dois inteiros.
 * 
 * @author rbonifacio
 *
 */
public class ExpressaoSoma extends ExpressaoBinariaInteira {

	// ===========================================================
	// Construtores
	// ===========================================================
	
	/*Utiliza o construtor de ExpressaoBinaria (ExpressoaBinariaInteira -> ExpressaoBinaria)*/
	public ExpressaoSoma(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	// ===========================================================
	// Métodos
	// ===========================================================
	
	@Override
	public Valor avaliar() {
		ValorInteiro v1 = (ValorInteiro)sub1.avaliar();
		ValorInteiro v2 = (ValorInteiro)sub2.avaliar();
		
		return new ValorInteiro(v1.getValor() + v2.getValor());
	}

	// ===========================================================
	// Getters & Setters
	// ===========================================================
	
	@Override
	public String getOperador() {
		return "+";
	}
}
