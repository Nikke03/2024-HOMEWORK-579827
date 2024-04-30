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

class PrendiTest {
	
	private Attrezzo bastone;
	private Partita partita;
	private Stanza aula;
	private Prendi comandoPrendi;
	private Borsa borsa;
	private Giocatore giocatore;
	private IOConsole io;
	
	@BeforeEach
	void setUp() {
		io = new IOConsole();
		
		this.bastone = new Attrezzo("bastone", 2);
		this.partita = new Partita();
		this.aula = new Stanza("aula");
		this.comandoPrendi = new Prendi(this.io);
		this.borsa = new Borsa();
		this.giocatore = new Giocatore();
		
		this.partita.setGiocatore(this.giocatore);
		this.giocatore.setBorsa(this.borsa);
		this.partita.setStanzaCorrente(this.aula);
		this.comandoPrendi.setParametro("bastone");
	}

	@Test
	void testGetNome() {
		assertEquals("prendi",this.comandoPrendi.getNome());
	}
	
	@Test
	void testGetParametro() {
		assertEquals("bastone",this.comandoPrendi.getParametro());
	}
	
	@Test
	void testEseguiConAttrezzoPresente() {
		this.partita.getStanzaCorrente().addAttrezzo(this.bastone);
		this.comandoPrendi.esegui(this.partita);
		assertTrue(this.borsa.hasAttrezzo("bastone"));
	}
	
	@Test 
	void testEseguiConAttrezzoNonPresente() {
		this.comandoPrendi.setParametro("martello");
		this.partita.getStanzaCorrente().addAttrezzo(bastone);
		this.comandoPrendi.esegui(partita);
		assertFalse(this.borsa.hasAttrezzo("granata"));
	}

}
