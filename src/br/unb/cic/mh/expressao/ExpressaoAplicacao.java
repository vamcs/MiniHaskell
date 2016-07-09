package br.unb.cic.mh.expressao;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.mh.AmbienteExecucao;
import br.unb.cic.mh.ArgumentoFormal;
import br.unb.cic.mh.DeclFuncao;
import br.unb.cic.mh.Tipo;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.visitor.Visitor;

/**
 * Classe que implementa a execu��o de uma fun��o declarada no ambiente de execu��o.
 * @author rbonifacio
 *
 */
public class ExpressaoAplicacao implements Expressao {

	// ===========================================================
	// Atributos
	// ===========================================================
	
	private String nome; 
	private List<Expressao> parametros;
	
	// ===========================================================
	// Construtores
	// ===========================================================
	
	/**
	 * Construtor que executa uma fun��o "nome" declarada.
	 * @param nome da fun��o a se executar
	 * @param argumentos : lista com todas express�es a se executar
	 */
	public ExpressaoAplicacao(String nome, List<Expressao> argumentos) {
		this.nome = nome;
		this.parametros = argumentos;
	}
	/**
	 * Construtor padrao. Apenas inicializa uma lista vazia de parametros.
	 */
	public String getnome(){
		return nome;
	}
	
	public List<Expressao> getparametros(){
		return parametros;
	}
	public ExpressaoAplicacao() {
		parametros = new ArrayList<Expressao>();
	}
	
	// ===========================================================
	// Metodos
	// ===========================================================
	
	/**
	 * Seta o nome da funcao a ser executada.
	 * @param nome
	 * @return a propria expressao aplicacao
	 */
	public ExpressaoAplicacao nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	/**
	 * Adiciona uma nova express�o a ser executada.
	 * @param exp
	 * @return a propria expressao aplicacao
	 */
	public ExpressaoAplicacao parametro(Expressao exp) {
		parametros.add(exp);
		return this;
	}
	
	@Override
	public Tipo tipo() {
		return AmbienteExecucao.instance().obterDeclaracaoFuncao(nome).getCorpo().tipo();
	}

	@Override
	public boolean checarTipo() {
		return true;
	}
	
	/**
	 * Faz a execucao da funcao declarada chamada String <b>nome</b>.
	 */
	@Override
	public Valor avaliar() {
		
		//Busca se a funcao declarada esta no ambiente de execucao.
		DeclFuncao f = AmbienteExecucao.instance().obterDeclaracaoFuncao(nome);
		
		//Caso nao tenha sido declara, lanca excecao.
		if(f == null) {
			throw new RuntimeException("Funcao " + nome + " nao declarada");
		}
		
		//Verifica se o numero de parametros passado eh funcao eh o mesmo que ela pede.
		if (parametros.size() < f.getArgumentos().size()) {
			throw new RuntimeException("Numero de parametros insuficientes.");
		}
		else if(parametros.size() > f.getArgumentos().size()) {
			throw new RuntimeException("Muitos parametros na chamada da funcao.");
		}
			
		//Faz as associacoes entre argumentos formais 
		//e parametros da chamada da funcao. 
		definirAmbiente(f);
		
		Valor resultado = f.getCorpo().avaliar();
		
		AmbienteExecucao.instance().removerEscopo();
		
		return resultado;
	}
	
	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

	/**
	 * Associar no contexto de execucao os argumentos 
	 * formais da funcao "f" aos parametros 
	 * passados na aplicacao de funcao.
	 * <br><br>
	 * <b>EDIT</b>: Um escopo se pode conter valores concretos,
	 * portanto se eh possivel definir o ambiente apos avaliar todos os parametros
	 * passados eh funcao. Dessa forma, um novo escopo vazio eh definido e as consequentes associa��es
	 * se sao feitas apos essas avaliacoes.
	 * 
	 * @author rbonifacio
	 * 
	 */
	private void definirAmbiente(DeclFuncao f) {
		List<ArgumentoFormal> argumentosFormais = f.getArgumentos();
		List<Expressao> exp = new ArrayList<Expressao>();
		
		//Executa os par�metros recebidos pela fun��o e os salva em exp.
		for(int i = 0; i < argumentosFormais.size(); i++) {
			exp.add(parametros.get(i).avaliar());
		}
		
		//Inicializa um novo escopo vazio.
		//Um novo escopo se eh inicializado apos avaliar todas express�es recebidas
		//como parametro. Caso contrario, Express�es RefId perderiam o valor corrente do escopo
		//antes de serem avaliadas. 
		//Lembrete: deve-se sempre guardar valores inteiros ou booleano no escopo.
		AmbienteExecucao.instance().definirEscopo();
		
		//Associa os argumentos as expressoes (Valores Concretos) no novo escopo vazio.
		for(int i = 0; i < argumentosFormais.size(); i++) {
			AmbienteExecucao.instance().associarExpressao(argumentosFormais.get(i).getId(), exp.get(i));
		}	
	}
}
