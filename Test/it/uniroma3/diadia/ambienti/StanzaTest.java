package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	private Stanza stanzaVuota;
	private Stanza stanzaNonVuota;
	private Attrezzo osso;
	
	@BeforeEach
	void setup() {
		
		stanzaVuota = new Stanza("Stanza vuota");
		stanzaNonVuota = new Stanza("Stanza non vuota");
		osso = new Attrezzo("osso", 1);
		stanzaNonVuota.addAttrezzo(osso);
		this.stanzaVuota.impostaStanzaAdiacente("nord", this.stanzaNonVuota);
		this.stanzaNonVuota.impostaStanzaAdiacente("sud", this.stanzaVuota);
	}
	
	@Test
	final void testHasAttrezzo() {
		assertFalse(this.stanzaVuota.hasAttrezzo("osso"), "la stanza vuota non ha l'attrezzo");
		assertTrue(this.stanzaNonVuota.hasAttrezzo("osso"), "la stanza vuota non ha l'attrezzo");
	}
	
	@Test
	final void testRemoveAttrezzo() {
		assertTrue(this.stanzaNonVuota.removeAttrezzo(this.osso));
		assertFalse(this.stanzaVuota.removeAttrezzo(this.osso));
	}
	
	@Test
	final void testGetStanzaAdiacenze() {
		assertEquals(this.stanzaVuota.getNome(), this.stanzaNonVuota.getStanzaAdiacente("sud").getNome());
		assertEquals(this.stanzaNonVuota.getNome(), this.stanzaVuota.getStanzaAdiacente("nord").getNome(), "stanzaVuota non ha una stanza adiacente a sud");
	}
	
	@Test
	final void  testAddAttrezzo() {
		assertTrue(this.stanzaNonVuota.addAttrezzo(osso));
	}

}
