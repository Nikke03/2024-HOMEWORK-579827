package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
 private Attrezzo scarpa;
 private StanzaMagica aula;
 private StringBuilder stringa;
 
 	@BeforeEach
 	void setUp() {
 		scarpa = new Attrezzo("scarpa", 2);
 		aula = new StanzaMagica("aula");
 		stringa = new StringBuilder(this.scarpa.getNome());
 	}
 	
 	
	@Test
	final void AggiungiAttrezzoTest() {
		assertTrue(this.aula.addAttrezzo(scarpa)); 
	}
	
	@Test
	final void ModificaAttrezzoTest() {
		this.aula.addAttrezzo(scarpa);
		this.stringa = this.stringa.reverse();
		assertTrue(this.aula.hasAttrezzo(stringa.reverse().toString()));
	}

}
