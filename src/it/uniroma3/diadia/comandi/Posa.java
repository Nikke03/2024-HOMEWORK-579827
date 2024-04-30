package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class Posa implements Comando{
	
	private String nome = "posa";
	private String nomeAttrezzo;
	private IO io;
	
	public Posa(IO io) {
		super();
		this.io = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		
		if(borsa.hasAttrezzo(nomeAttrezzo) == true) {
			Attrezzo attrezzoDaPosare = borsa.getAttrezzo(nomeAttrezzo);
			if(stanzaCorrente.addAttrezzo(attrezzoDaPosare)) {
				io.mostraMessaggio("l'attrezzo " + nomeAttrezzo + " e' stato posato nella stanza " + stanzaCorrente.getNome());
				borsa.removeAttrezzo(nomeAttrezzo);
			}
			else
				io.mostraMessaggio("ci sono gia troppi attrezzi nella stanza!");
		}
		else
			io.mostraMessaggio("l'attrezzo " + nomeAttrezzo + " non e' nella borsa");

		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo = parametro;
		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
