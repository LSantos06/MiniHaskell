package br.unb.cic.poo.testes;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.ExpressaoReferenciaIdentificador;
import br.unb.cic.poo.expressoes.binarias.ExpressaoSoma;
import br.unb.cic.poo.funcoes.ArgumentoFormal;
import br.unb.cic.poo.funcoes.AvaliadorExpressoes;
import br.unb.cic.poo.funcoes.DeclaracaoFuncao;
import br.unb.cic.poo.valores.ValorInteiro;

public abstract class TesteUtil {
	public Expressao soma(Expressao exp1, Expressao exp2) {
		return new ExpressaoSoma(exp1, exp2);
	}
	
	public ExpressaoReferenciaIdentificador ref(String id) {
		return new  ExpressaoReferenciaIdentificador(id);
	}
	
	public ValorInteiro vi(Integer valor) {
		return new ValorInteiro(valor);
	}
}