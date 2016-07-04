package br.unb.cic.mh;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoLet extends TesteUtil {

	@Test
	public void testeExpressaoLetSimples() {
		// let x = 5
		// in x + x
		ExpressaoLet let1 = new ExpressaoLet("x", new ValorInteiro(5),
				new ExpressaoSoma(new ExpressaoRefId("x"), new ExpressaoRefId("x")));

		assertEquals(new ValorInteiro(10), let1.avaliar());
		
		let1.aceitar(prettyPrinter);
		System.out.println("");
	}

	@Test
	public void testeExpressaoLetAninhada() {
		//let x = 5 in x + y
		ExpressaoLet letInterno = new ExpressaoLet("x", vi(5), 
				soma(ref("x"), ref("y")));  
	
		//let y = 10 in let x = 5 in x + y
		ExpressaoLet letExterno = new ExpressaoLet("y", vi(10), letInterno);
		
		
		assertEquals(vi(15), letExterno.avaliar());
		
		letExterno.aceitar(prettyPrinter);
		System.out.println("");
	}
	
	@Test
	public void testeExpressaoLetAninhadaExp() {
		//let x = 5 in x + y
		ExpressaoLet letInterno = new ExpressaoLet("x", vi(5), 
				soma(ref("x"), ref("y")));  
	
		//let y = 10 in let x = 5 in x + y
		ExpressaoLet letExterno = new ExpressaoLet("y", soma(ref("x"), vi(1)), letInterno);
		
		
		assertEquals(vi(11), letExterno.avaliar());
		
		letExterno.aceitar(prettyPrinter);
		System.out.println("");
	}
	
	@Test
	public void testeExpressaoLetAninhadaEspecial() {
		//let x = 10 in let x = 5 in x + x
		ExpressaoLet letInterno = new ExpressaoLet("x", vi(6), soma(ref("x"), ref("x")));  
	
		ExpressaoLet letExterno = new ExpressaoLet("x", vi(10), letInterno);
		
		assertEquals(vi(12), letExterno.avaliar());
		
		letExterno.aceitar(prettyPrinter);
		System.out.println("");
	}
	
}
