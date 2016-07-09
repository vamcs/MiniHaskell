package br.unb.cic.mh.expressao.unaria;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.valor.ValorBooleano;

/**
 * Implementa a operação booleana NOT.
 * Retorna o complemento do valor recebido em um valor booleano.
 * 
 * @author vamcs
 *
 */
public class ExpressaoNot extends ExpressaoUnaria {

	// ===========================================================
	// Construtores
	// ===========================================================
	
	public ExpressaoNot(Expressao sub) {
		super(sub);
	}

	// ===========================================================
	// Métodos
	// ===========================================================
	
	@Override
	public Valor avaliar() {
		ValorBooleano res = (ValorBooleano) sub.avaliar();
		return new ValorBooleano(!res.getValor());
	}

}
