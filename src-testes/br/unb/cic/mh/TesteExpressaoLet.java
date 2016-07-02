package br.unb.cic.mh;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoLet {

	@Test
	public void testExpressaoLetSimples() {
		// let x = 10
		// in x + x
		ExpressaoLet let1 = new ExpressaoLet("x", new ValorInteiro(5),
				new ExpressaoSoma(new ExpressaoRefId("x"), new ExpressaoRefId("x")));

		assertEquals(new ValorInteiro(10), let1.avaliar());
	}

	@Test
	public void testExpressaoLetAninhada() {
		//let x = 5 in x + y
		ExpressaoLet letInterno = new ExpressaoLet("x", vi(5), 
				soma(ref("x"), ref("y")));  
	
		//let y = 10 in let x = 5 in x + y
		ExpressaoLet letExterno = new ExpressaoLet("y", vi(10), letInterno);
		
		
		assertEquals(vi(15), letExterno.avaliar());
	}
	
	public ExpressaoSoma soma(Expressao exp1, Expressao exp2) {
		return new ExpressaoSoma(exp1, exp2);
	}
	
	public ValorInteiro vi(Integer v) {
		return new ValorInteiro(v);
	}
	
	public ExpressaoRefId ref(String id) {
		return new ExpressaoRefId(id);
	}

}
