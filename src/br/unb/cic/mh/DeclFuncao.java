package br.unb.cic.mh;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe usada para representar declaracoes de 
 * funcoes. 
 * 
 * @author rbonifacio
 */
public class DeclFuncao {

	// ===========================================================
	// Atributos
	// ===========================================================
	private String nome;
	private List<ArgumentoFormal> argumentos;
	private Expressao corpo;
	
	
	// ===========================================================
	// Construtores
	// ===========================================================
	
	/**
	 * Construtor que inicializa uma fun��o completa.
	 * @param nome da fun��o
	 * @param argumentos : lista de par�metros da fun��o
	 * @param corpo : express�o da fun��o
	 */
	public DeclFuncao(String nome, List<ArgumentoFormal> argumentos, Expressao corpo) {
		this.nome = nome;
		this.argumentos = argumentos;
		this.corpo = corpo; 
	}
	
	/**
	 * Construtor vazio. Apenas inicializa uma lista vazia de argumentos formais.
	 */
	public DeclFuncao() {
		argumentos = new ArrayList<ArgumentoFormal>();
	}
	
	// ===========================================================
	// M�todos
	// ===========================================================
	
	/**
	 * Define o nome de uma fun��o declarada.
	 * @param nome
	 * @return a pr�pria fun��o declarada
	 */
	public DeclFuncao nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	/**
	 * Adiciona argumentos formais (string, tipo) � fun��o declarada
	 * na lista de argumentos.
	 * @param arg que representa um novo par�metro da fun��o
	 * @return a pr�pria fun��o declarada
	 */
	public DeclFuncao argumento(ArgumentoFormal arg) {
		this.argumentos.add(arg);
		return this;
	}
	
	/**
	 * Define uma nova express�o para o corpo da fun��o declarada.
	 * @param corpo que define o comportamento da fun��o (express�o)
	 * @return a pr�pria fun��o declarada
	 */
	public DeclFuncao corpo(Expressao corpo) {
		this.corpo = corpo;
		return this;
	}
	
	// ===========================================================
	// Getters & Setters
	// ===========================================================	
	
	/**
	 * @return nome (String) da fun��o declarada
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @return lista de argumentos formais da fun��o declarada
	 */
	public List<ArgumentoFormal> getArgumentos() {
		return argumentos;
	}
	
	/**
	 * @return express�o corpo da fun��o declarada
	 */
	public Expressao getCorpo() {
		return corpo;
	}
	
	
}


/**
 * Classe que cont�m a defini��o dos argumentos formais.
 * S�o compostos basicamente de um identificador e um tipo.
 * @author rbonifacio
 */
class ArgumentoFormal {
	private String id;
	private Tipo tipo;
	
	public ArgumentoFormal(String id, Tipo tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	
	public String getId() {
		return id;
	}
	public Tipo getTipo() {
		return tipo;
	} 
	
	
}