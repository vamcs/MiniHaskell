package br.unb.cic.mh.expressao.binaria.booleana;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorConcreto;

/**
 * Esta classe implementa a função de comparação de dois valores ou inteiros ou booleanos.
 * Para isto, foi parametrizada para apenas aceitar subclasses de valores concretos.
 * 
 * @author vamcs
 *
 * @param <T> tipo dos valores a serem comparados.
 */
public class ExpressaoIgualdade<T extends ValorConcreto<?>> extends ExpressaoBinariaBooleana {

	public ExpressaoIgualdade(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	/*
	 * TODO: implementar a verificação para veja se os tipos dos dois valores a serem
	 * comparados sejam iguais.
	 * @see br.unb.cic.mh.expressao.Expressao#avaliar()
	 */
	@Override
	public Valor avaliar() {
		T v1 = (T) sub1.avaliar();
		T v2 = (T) sub2.avaliar();
		
		return new ValorBooleano(v1.getValor() == v2.getValor());
	}

	@Override
	public String getOperador() {
		return "==";
	}

}
