package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;


public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{

	private IO io;
	
	public FabbricaDiComandiFisarmonica(IO io) {
		super();
		this.io = io;
	}
	
	@Override
	public Comando costruisciComando(String istruzione) {
		 Scanner scannerDiParole = new Scanner(istruzione);
		 String nomeComando = null;
		 String parametro = null;
		 Comando comando = null;
		 if (scannerDiParole.hasNext())
		 nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		 if (scannerDiParole.hasNext())
		 parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
		
		if (nomeComando == null)
		 comando = new ComandoNonValido(this.io);
		 else if (nomeComando.equals("vai"))
		 comando = new ComandoVai(this.io); //da controllare
		 else if (nomeComando.equals("prendi"))
		 comando = new Prendi(this.io);
		 else if (nomeComando.equals("posa"))
		 comando = new Posa(this.io);
		 else if (nomeComando.equals("aiuto"))
		 comando = new Aiuto(this.io);
		 else if (nomeComando.equals("fine"))
		 comando = new Fine(this.io);
		 else if (nomeComando.equals("guarda"))
		 comando = new Guarda(this.io);
		 else comando = new ComandoNonValido(this.io);
		 comando.setParametro(parametro);
		 return comando;
		 }
}
