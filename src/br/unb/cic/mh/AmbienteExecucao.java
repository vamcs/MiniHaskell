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
	// Métodos
	// ===========================================================
	
	/**
	 * Obtém a instância única da classe AmbienteExecucao
	 * @return instância única da classe. 
	 */
	public static AmbienteExecucao instance() {
		if(instance == null) {
			instance = new AmbienteExecucao();
		}
		return instance; 
	}
	
	/**
	 * Declara uma função no ambiente de execução,
	 * inserindo-a no HashMap de funções declaradas.
	 * @param funcao do tipo DeclFuncao
	 */
	public void declararFuncao(DeclFuncao funcao) {
		if(funcoesDeclaradas == null) {
			funcoesDeclaradas = new HashMap<String, DeclFuncao>();
		}
		funcoesDeclaradas.put(funcao.getNome(),funcao);
	}
	
	/**
	 * Busca por uma função existente no HashMap de funções declaradas.
	 * Retorna null caso a função não exista ou não tenha sido declarada.
	 * @param nome do tipo String
	 * @return função do tipo DeclFuncao
	 */
	public DeclFuncao obterDeclaracaoFuncao(String nome) {
		if(funcoesDeclaradas != null) {
			return funcoesDeclaradas.get(nome);
		}
		return null;
	}
	
	/**
	 * Define um novo escopo vazio no ambiente de execução.
	 */
	public void definirEscopo() {
		ambiente.push(new HashMap<String, Expressao>());
	}
	
	/**
	 * Remove o escopo do topo da pilha de execução.
	 */
	public void removerEscopo() {
		if(ambiente.size() > 0) {
			ambiente.pop();
		}
	}
	
	/**
	 * Associa uma expressão a uma string no escopo do topo da pilha
	 * de execução.
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
	 * Busca por uma expressão definida no escopo do topo da pilha de execução
	 * através de seu id.
	 * @param id associado à expressão
	 * @return expressão contida no escopo do topo da pilha de execução. 
	 * 			Null caso não exista.
	 */
	public Expressao obterExpressao(String id) {
		HashMap<String, Expressao> escopo = ambiente.peek();
		if(escopo.containsKey(id)) {
			return escopo.get(id);
		}
		return null;
	}
	
	/**
	 * Indica se uma variável já foi definida no escopo do topo da pilha de execução.
	 * @param id da variável
	 * @return true se foi definida, false a pilha esteja vazia ou a variável não tenha sido declarada.
	 */
	public boolean variavelDefinida(String id) {
		return ambiente.size() > 0 && ambiente.peek().containsKey(id);
	}
	
	/**
	 * Retorna o escopo do topo da pilha de execução atual.
	 * @return escopo do tipo HashMap
	 */
	public HashMap<String, Expressao> escopo() {
		return ambiente.peek();
	}

}
