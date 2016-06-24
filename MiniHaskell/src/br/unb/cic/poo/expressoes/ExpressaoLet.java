package br.unb.cic.poo.expressoes;

import br.unb.cic.poo.main.AmbienteExecucao;
import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.visitor.Visitor;

/**
 * @author LSantos06
 * 
 * Uma expressao LET pode ser exemplificada como:
 * 		
 * 		let x = 10
 * 		in x * 2
 * 
 * A expressao associa uma outra expressao a uma variavel,
 * e depois avalia o corpo que pode ou nao utilizar esta variavel.
 */
public class ExpressaoLet implements Expressao{
	
	private String id;
	private Expressao expressao;
	private Expressao corpo;
	
	public ExpressaoLet(String id, Expressao expressao, Expressao corpo) {
		this.id = id;
		this.expressao = expressao;
		this.corpo = corpo;
	}

	/**
	 * @author LSantos06
	 * 
	 * O tipo da expressao LET eh o mesmo tipo do corpo da mesma.
	 */
	@Override
	public Tipo tipo() {
		if(checarTipo()) {
			return corpo.tipo();
		}
		return Tipo.ERRO;
	}

	/**
	 * @author LSantos06
	 * 
	 * Se o tipo da expressao && o tipo do corpo da expressao LET forem validos
	 * 		return TRUE
	 * Senao
	 * 		return FALSE
	 */
	@Override
	public boolean checarTipo() {
		return expressao.checarTipo() && corpo.checarTipo();
	}

	/**
	 * @author LSantos06
	 * 
	 * A variavel da expressao LET eh criada no ambiente de execucao,
	 * e o corpo da expressao LET avaliado.
	 */
	@Override
	public Valor avaliar() {
		AmbienteExecucao.getInstancia().declaraVariavel(id, expressao);
		return corpo.avaliar();
	}

	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);	
	}
}
