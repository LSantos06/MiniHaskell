package br.unb.cic.mh;

public class ValorInteiro extends ValorConcreto<Integer>{

	public ValorInteiro(Integer valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.INTEIRO;
	}

//	public boolean equals(Object outro) {
//		if(outro instanceof ValorInteiro) {
//			ValorInteiro inteiro = (ValorInteiro)outro;
//			return inteiro.valor.equals(valor);
//		}
//		return false;
//	}
	
}
