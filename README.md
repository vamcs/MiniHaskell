# MiniHaskell

POO UnB 2016/1
==============

Requisitos do Trabalho
----------------------

Alunos:

* Alexandre Correia, matricula: 12/0151294
* Matheus Cruz Crestani, matricula:12/0129647
* Victor Augusto Machado, matricula: 12/0023474

Implementações realizadas:

	* Novas expressoes logicas (and, or, not), expressoes envolvendo inteiros 		  (*, /, -) e operadores relacionais (==, !=, <, >, <=, >=):
		
		
		* and, or, not:
		
			+ ExpressaoAnd(src/br.unb.cic.mh.expressao.binaria.booleana);
			+ ExpressaoOr(src/br.unb.cic.mh.expressao.binaria.booleana);
			+ ExpressaoNot(src/br.unb.cic.mh.expressao.unaria);
		
		* *, /, -:
		
			+ ExpressaoSub(src/br.unb.cic.mh.expressao.binaria.inteira);
			+ ExpressaoMult(src/br.unb.cic.mh.expressao.binaria.inteira);
			+ ExpressaoDiv(src/br.unb.cic.mh.expressao.binaria.inteira);
		
		* ==, !=, <, >, <=, >=:
			
			+ ExpressaoIgualdade(src/br.unb.cic.mh.expressao.binaria.booleana);
			+ ExpressaoDiferenca(src/br.unb.cic.mh.expressao.binaria.booleana);
			+ ExpressaoMaiorIgual(src/br.unb.cic.mh.expressao.binaria.booleana);
			+ ExpressaoMaiorQue(src/br.unb.cic.mh.expressao.binaria.booleana);
			+ ExpressaoMenorIgual(src/br.unb.cic.mh.expressao.binaria.booleana);
			+ ExpressaoMenorQue(src/br.unb.cic.mh.expressao.binaria.booleana);
		 
	
		*  casos de testes para as expressoes Let e Aplicacao de Funcao;
		
			+ TesteExpressaoAplicacao(src-test/br.unb.cic.mh);
			+ TesteExpressaoLet(src-test/br.unb.cic.mh);
		
		* Escrever mais testes para a expressão aplicação de função;
		
			+ TesteExpressaoAplicacao(src-test/br.unb.cic.mh);
		
		*  Corrigir os visitors implementados, mas que estão "quebrados" na 			   versão 	03 da implementação do projeto MiniHaskell;
		
			+ Visitor(src/br.unb.cic.mh.visitor);
			+ Adaptador(src/br.unb.cic.mh.visitor);
			+ PPVisitor(src/br.unb.cic.mh.visitor);
			
		*  Incluir suporte ao tipo Lista, que pode ser uma lista vazia ou uma 			lista 	com um elemento seguido de uma outra lista (é um tipo recursivo). 			Em Haskell,seria algo como:"data List a = Nill | a (List a)".
		
			+ Lista(br.unb.cic.mh.valor);
			+ ListaVazia(br.unb.cic.mh.valor);
			+ ListaNaoVazia(br.unb.cic.mh.valor);
			
		*  Tambem foram impĺementantados testes adicionais:
			
			+ ExpressaoAnd(src-testes/br.unb.cic.mh);
			+ ExpressaoOr(src-testes/br.unb.cic.mh);
			+ ExpressaoNot(src-testes/br.unb.cic.mh);
			+ ExpressaoSub(src-testes/br.unb.cic.mh);
			+ ExpressaoMult(src-testes/br.unb.cic.mh);
			+ ExpressaoDiv(src-testes/br.unb.cic.mh);
			+ ExpressaoIgualdade(src-testes/br.unb.cic.mh);
			+ ExpressaoDiferenca(src-testes/br.unb.cic.mh);
			+ ExpressaoMaiorIgual(src-testes/br.unb.cic.mh);
			+ ExpressaoMaiorQue(src/br.unb.cic.mh/br.unb.cic.mh);
			+ ExpressaoMenorIgual(src-testes/br.unb.cic.mh/br.unb.cic.mh);
			+ ExpressaoMenorQue(src-testes/br.unb.cic.mh/br.unb.cic.mh);
			+ TesteLista(src-testes/br.unb.cic.mh/br.unb.cic.mh);
			+ TesteVisitor(src-testes/br.unb.cic.mh/br.unb.cic.mh);
