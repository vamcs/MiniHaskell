package br.unb.cic.mh;

import java.util.HashMap;
import java.util.Stack;

import br.unb.cic.mh.expressao.Expressao;

/**
 * Classe (singleton) que representa um 
 * ambiente de execucao.
 * 
 * @author rbonifacio
 */
public class AmbienteExecucao {

	// ===========================================================
	// Atributos
	// ===========================================================
	
	/* instancia unica, de acordo com o padrao de 
	 * projeto singleton. 
	 */
	private static AmbienteExecucao instance;
	private HashMap<String, DeclFuncao> funcoesDeclaradas; 
	private Stack<HashMap<String, Expressao>> ambiente;

	// ===========================================================
	// Construtores
	// ===========================================================	
	
	/*
	 * construtor privado, de acordo com o padrao 
	 * de projeto singleton. 
	 */
	private AmbienteExecucao() {
		funcoesDeclaradas = new HashMap<String, DeclFuncao>();
		ambiente = new Stack<HashMap<String,Expressao>>();
	}

	// ===========================================================
	// M�todos
	// ===========================================================
	
	/**
	 * Obt�m a inst�ncia �nica da classe AmbienteExecucao
	 * @return inst�ncia �nica da classe. 
	 */
	public static AmbienteExecucao instance() {
		if(instance == null) {
			instance = new AmbienteExecucao();
		}
		return instance; 
	}
	
	/**
	 * Declara uma fun��o no ambiente de execu��o,
	 * inserindo-a no HashMap de fun��es declaradas.
	 * @param funcao do tipo DeclFuncao
	 */
	public void declararFuncao(DeclFuncao funcao) {
		if(funcoesDeclaradas == null) {
			funcoesDeclaradas = new HashMap<String, DeclFuncao>();
		}
		funcoesDeclaradas.put(funcao.getNome(),funcao);
	}
	
	/**
	 * Busca por uma fun��o existente no HashMap de fun��es declaradas.
	 * Retorna null caso a fun��o n�o exista ou n�o tenha sido declarada.
	 * @param nome do tipo String
	 * @return fun��o do tipo DeclFuncao
	 */
	public DeclFuncao obterDeclaracaoFuncao(String nome) {
		if(funcoesDeclaradas != null) {
			return funcoesDeclaradas.get(nome);
		}
		return null;
	}
	
	/**
	 * Define um novo escopo vazio no ambiente de execu��o.
	 */
	public void definirEscopo() {
		ambiente.push(new HashMap<String, Expressao>());
	}
	
	/**
	 * Remove o escopo do topo da pilha de execu��o.
	 */
	public void removerEscopo() {
		if(ambiente.size() > 0) {
			ambiente.pop();
		}
	}
	
	/**
	 * Associa uma express�o a uma string no escopo do topo da pilha
	 * de execu��o.
	 * @param id
	 * @param exp
	 */
	public void associarExpressao(String id, Expressao exp) {
		if(ambiente.size() == 0) {
			definirEscopo();
		}
		ambiente.peek().put(id, exp);
	}
	
	/**
	 * Busca por uma express�o definida no escopo do topo da pilha de execu��o
	 * atrav�s de seu id.
	 * @param id associado � express�o
	 * @return express�o contida no escopo do topo da pilha de execu��o. 
	 * 			Null caso n�o exista.
	 */
	public Expressao obterExpressao(String id) {
		HashMap<String, Expressao> escopo = ambiente.peek();
		if(escopo.containsKey(id)) {
			return escopo.get(id);
		}
		return null;
	}
	
	/**
	 * Indica se uma vari�vel j� foi definida no escopo do topo da pilha de execu��o.
	 * @param id da vari�vel
	 * @return true se foi definida, false a pilha esteja vazia ou a vari�vel n�o tenha sido declarada.
	 */
	public boolean variavelDefinida(String id) {
		return ambiente.size() > 0 && ambiente.peek().containsKey(id);
	}
	
	/**
	 * Retorna o escopo do topo da pilha de execu��o atual.
	 * @return escopo do tipo HashMap
	 */
	public HashMap<String, Expressao> escopo() {
		return ambiente.peek();
	}

}
