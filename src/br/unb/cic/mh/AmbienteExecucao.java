package br.unb.cic.mh;

import java.util.HashMap;
import java.util.Stack;

/**
 * Classe (singleton) que representa um 
 * ambiente de execucao.
 * 
 * @author rbonifacio
 */
public class AmbienteExecucao {

	private HashMap<String, DeclFuncao> funcoesDeclaradas; 
	private Stack<HashMap<String, Expressao>> ambiente;
	
	/*
	 * construtor privado, de acordo com o padrao 
	 * de projeto singleton. 
	 */
	private AmbienteExecucao() {
		funcoesDeclaradas = new HashMap<String, DeclFuncao>();
		ambiente = new Stack<HashMap<String,Expressao>>();
	}
	
	/* instancia unica, de acordo com o padrao de 
	 * projeto singleton. 
	 */
	private static AmbienteExecucao instance;
	
	/**
	 * Obtem a instancia unica da classe AmbienteExecucao
	 * @return instancia unica da classe. 
	 */
	public static AmbienteExecucao instance() {
		if(instance == null) {
			instance = new AmbienteExecucao();
		}
		return instance; 
	}
	
	public void declararFuncao(DeclFuncao funcao) {
		if(funcoesDeclaradas == null) {
			funcoesDeclaradas = new HashMap<String, DeclFuncao>();
		}
		funcoesDeclaradas.put(funcao.getNome(),funcao);
	}
	
	public DeclFuncao obterDeclaracaoFuncao(String nome) {
		if(funcoesDeclaradas != null) {
			return funcoesDeclaradas.get(nome);
		}
		return null;
	}
	public void definirEscopo() {
		ambiente.push(new HashMap<String, Expressao>());
	}
	
	public void removerEscopo() {
		if(ambiente.size() > 0) {
			ambiente.pop();
		}
	}
	
	public void associarExpressao(String id, Expressao exp) {
		if(ambiente.size() == 0) {
			definirEscopo();
		}
		ambiente.peek().put(id, exp);
	}
	
	public Expressao obterExpressao(String id) {
		HashMap<String, Expressao> escopo = ambiente.peek();
		if(escopo.containsKey(id)) {
			return escopo.get(id);
		}
		return null;
	}
	
	public boolean variavalDefinida(String id) {
		return ambiente.size() > 0 && ambiente.peek().containsKey(id);
	}

	public HashMap<String, Expressao> escopo() {
		return ambiente.peek();
	}
}
