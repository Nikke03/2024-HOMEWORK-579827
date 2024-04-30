package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class PosaTest {

	private Attrezzo bastone;
	private Partita partita;
	private Stanza aula;
	private Posa comandoPosa;
	private Borsa borsa;
	private Giocatore giocatore;
	private IOConsole io;
	
	@BeforeEach
	void setUp() {
		io = new IOConsole();
		
		this.bastone = new Attrezzo("bastone", 2);
		this.partita = new Partita();
		this.aula = new Stanza("aula");
		this.comandoPosa = new Posa(this.io);
		this.borsa = new Borsa();
		this.giocatore = new Giocatore();
		
		this.partita.setGiocatore(this.giocatore);
		this.giocatore.setBorsa(this.borsa);
		this.partita.setStanzaCorrente(this.aula);
		this.comandoPosa.setParametro("bastone");
	}
	
	@Test
	void testGetNome() {
		assertEquals("posa",this.comandoPosa.getNome());
	}

	@Test
	void testGetParametro() {
		assertEquals("bastone", this.comandoPosa.getParametro());
	}

	@Test
	void testEsegui() {
		this.giocatore.getBorsa().addAttrezzo(this.bastone);
		this.comandoPosa.esegui(this.partita);
		assertTrue(this.aula.hasAttrezzo("bastone"));
	}
	
	@Test 
	void testEseguiConAttrezzoNonPresente() {
		this.comandoPosa.setParametro("bastone");
		this.giocatore.getBorsa().addAttrezzo(bastone);
		this.comandoPosa.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("granata"));
	}

}
