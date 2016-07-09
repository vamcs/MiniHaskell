package br.unb.cic.mh.expressao.binaria.booleana;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorInteiro;

/**
 * Implementa a operação > e compara dois valores inteiros.
 * Retorna um valor booleano do resultado: true se valor1 > valor2, false caso contrário.
 * 
 * @author vamcs
 *
 */
public class ExpressaoMaiorQue extends ExpressaoBinariaBooleana {

	// ===========================================================
	// Atributos
	// ===========================================================
	
	public ExpressaoMaiorQue(Expressao s1, Expressao s2) {
		super(s1, s2);
		// TODO Auto-generated constructor stub
	}

	// ===========================================================
	// Métodos
	// ===========================================================
	
	@Override
	public Valor avaliar() {
		ValorInteiro v1 = (ValorInteiro) sub1.avaliar();
		ValorInteiro v2 = (ValorInteiro) sub2.avaliar();
		
		return new ValorBooleano(v1.getValor() > v2.getValor());
	}

	// ===========================================================
	// Getters & Setters
	// ===========================================================
	
	@Override
	public String getOperador() {
		return ">";
	}

}
