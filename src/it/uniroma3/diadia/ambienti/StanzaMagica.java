package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza{

	private static final int SOGLIA_MAGICA_DEFULT = 2;

	int sogliaMagica;

	public StanzaMagica(String nome, int sogliaMagica) {
		super(nome);
		this.sogliaMagica = sogliaMagica;
	}
	
	public StanzaMagica(String nome) {
		super(nome);
		this.sogliaMagica = SOGLIA_MAGICA_DEFULT;
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		
		return attrezzo;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(super.getAttrezzi().size() >= this.sogliaMagica)
			attrezzo = modificaAttrezzo(attrezzo);
			
		return super.addAttrezzo(attrezzo);

	}

	public boolean isMagica() {
		return this.sogliaMagica > 0;
	}

}
