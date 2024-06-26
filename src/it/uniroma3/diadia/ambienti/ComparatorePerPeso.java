package it.uniroma3.diadia.ambienti;

import java.util.Comparator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComparatorePerPeso implements Comparator<Attrezzo>{

	@Override
	public int compare(Attrezzo a1, Attrezzo a2) {
		if (a1.getPeso() != a2.getPeso())
			return a1.getPeso() - a2.getPeso();
		else {
			return a1.getNome().compareTo(a2.getNome());
		}
	}

}
