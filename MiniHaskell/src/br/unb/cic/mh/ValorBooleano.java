package br.unb.cic.mh;

public class ValorBooleano extends ValorConcreto<Boolean>{

	public ValorBooleano(Boolean valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.BOOLEANO;
	}

	
}
