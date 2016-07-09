package br.unb.cic.mh;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.unb.cic.mh.expressao.ExpressaoAplicacao;
import br.unb.cic.mh.expressao.ExpressaoIfThenElse;
import br.unb.cic.mh.expressao.ExpressaoRefId;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoDiferenca;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoIgualdade;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoMult;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoSoma;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoSub;
import br.unb.cic.mh.valor.Lista;
import br.unb.cic.mh.valor.ListaNaoVazia;
import br.unb.cic.mh.valor.ListaVazia;
import br.unb.cic.mh.valor.ValorInteiro;

import org.junit.Assert;

public class TesteExpressaoAplicacao extends TesteUtil {

	@Test
	public void testeFuncaoIncrementa() {

		ExpressaoRefId x = ref("x");

		DeclFuncao inc = (new DeclFuncao()).nome("inc").argumento(new ArgumentoFormal("x", Tipo.INTEIRO))
				.corpo(soma(x, vi(1)));

		AmbienteExecucao.instance().declararFuncao(inc);

		ExpressaoAplicacao ap = (new ExpressaoAplicacao()).nome("inc").parametro(soma(vi(3), vi(2)));
		Assert.assertEquals(vi(6), ap.avaliar());

		ap = (new ExpressaoAplicacao()).nome("inc").parametro(vi(7));
		Assert.assertEquals(vi(8), ap.avaliar());

	}

	@Test
	public void testeSomaRefId() {
		ExpressaoRefId x = ref("x");
		ExpressaoRefId y = ref("y");

		DeclFuncao soma = (new DeclFuncao()).nome("soma").argumento(new ArgumentoFormal("x", Tipo.INTEIRO))
				.argumento(new ArgumentoFormal("y", Tipo.INTEIRO)).corpo(soma(x, y));

		AmbienteExecucao ambiente = AmbienteExecucao.instance();

		ambiente.declararFuncao(soma);

		ExpressaoAplicacao ap = (new ExpressaoAplicacao()).nome("soma").parametro(vi(2)).parametro(vi(3));

		Assert.assertEquals(vi(5), ap.avaliar());
	}

	/**
	 * Implementacao da funcao recursiva fatorial.
	 * Sao utilizadas duas
	 * expressoes aplicacao, uma expressao sub, uma expressao mult, uma
	 * expressao refid, uma expressao igualdade e uma expressao IfThenElse.
	 * 
	 * A expressao aplicacao interna executa a chamada recursiva de fatorial
	 * passando o valor n - 1, enquanto a aplicacao externa inicia a chamada da
	 * funcao fatorial.
	 * 
	 * @author vamcs
	 */
	@Test
	public void testeFatorial() {
		ValorInteiro v1 = vi(1);
		ValorInteiro v0 = vi(0);
		ExpressaoRefId n = ref("n");
		ExpressaoSub sub = sub(n, v1);
		ExpressaoIgualdade<ValorInteiro> igual = new ExpressaoIgualdade<ValorInteiro>(n, v0);

		AmbienteExecucao ambiente = AmbienteExecucao.instance();

		// fat(n - 1)
		ExpressaoAplicacao apInterna = (new ExpressaoAplicacao()).nome("fat").parametro(sub);

		// mult(n, fat(n - 1))
		ExpressaoMult mult = mult(n, apInterna);

		// if n == 0 then 0 else mult(n, fat(n - 1))
		ExpressaoIfThenElse ite = new ExpressaoIfThenElse(igual, v1, mult);
		DeclFuncao fat = (new DeclFuncao()).nome("fat").argumento(new ArgumentoFormal("n", Tipo.INTEIRO)).corpo(ite);

		// declara funcao no ambiente de execucao
		ambiente.declararFuncao(fat);

		// fat(.) -- inicio da funcao fatorial
		ExpressaoAplicacao ap = (new ExpressaoAplicacao()).nome("fat").parametro(vi(10));

		Assert.assertEquals(vi(3628800), ap.avaliar());

		// Exemplo de quando nao eh fornecida a quantidade necessaria de
		// parametros
		ap = (new ExpressaoAplicacao()).nome("fat");
		try {
			ap.avaliar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testeSomaElementosLista() {
		
		//[27, 8, 5, 7]
		Lista lista = new ListaNaoVazia<ValorInteiro>(vi(5));
		lista = lista.cons(new ListaNaoVazia<ValorInteiro>(vi(8)));
		Lista.insere(lista.getProx(), new ListaNaoVazia<ValorInteiro>(vi(7)));
		lista = lista.cons(new ListaNaoVazia<ValorInteiro>(vi(27)));
		
		ExpressaoRefId s1 = ref("s1");
		
		// tamanho da lista != 0
		ExpressaoDiferenca<ValorInteiro> dif = new ExpressaoDiferenca<ValorInteiro>(vi(Lista.tamanho(lista)), vi(0));
		
		// somaElementos(lista.prox)
		ExpressaoAplicacao apInterna = new ExpressaoAplicacao()
				.nome("somaElementos")
				.parametro(lista.getProx());
		
		// soma(lista.valor, somaElementos(lista.prox))
		ExpressaoSoma soma = soma(lista.getValor(), apInterna);

		// if (tamanho != 0) then soma else 0
		ExpressaoIfThenElse ite = new ExpressaoIfThenElse(dif, soma, vi(0));
		
		AmbienteExecucao ambiente = AmbienteExecucao.instance();
		
		DeclFuncao somaElementos = new DeclFuncao()
				.nome("somaElementos")
				.argumento(new ArgumentoFormal("s1", Tipo.INTEIRO))
				.corpo(ite);
		
		ambiente.declararFuncao(somaElementos);
		
		ExpressaoAplicacao ap = new ExpressaoAplicacao()
				.nome("somaElementos")
				.parametro(lista);
		
		ValorInteiro res = (ValorInteiro) ap.avaliar();
		
		res.aceitar(prettyPrinter);
		
	}
}
