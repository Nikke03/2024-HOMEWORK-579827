package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

import org.junit.jupiter.api.BeforeEach;

class LabirintoTest {
private Labirinto labirinto;
private Stanza Biblioteca;
private Stanza Atrio;

@BeforeEach
void setUp() {
	this.labirinto = new Labirinto();
	this.Biblioteca = this.labirinto.getStanzaVincente();
	this.Atrio = this.labirinto.getStanzaIniziale(); 
}

@Test
void testGetStanzaVincente() {
	assertEquals(Biblioteca, this.labirinto.getStanzaVincente());
}

@Test
void testGetStanzaIniziale() {
	assertEquals(Atrio, this.labirinto.getStanzaIniziale());
}

}
