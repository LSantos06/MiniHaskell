package br.unb.cic.poo.expressoes;

import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.visitor.Visitor;

public class ExpressaoAplicacaoFuncao implements Expressao{

	@Override
	public Tipo tipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Valor avaliar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);	
	}
}
