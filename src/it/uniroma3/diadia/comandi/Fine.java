package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class Fine implements Comando {
	private IOConsole IO = new IOConsole();
	private String nome = "fine";


	@Override
	public void esegui(Partita partita) {
		IO.mostraMessaggio("Grazie di aver giocato!");
		partita.setFinita();

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getParametro() {
		return null;
	}

	@Override
	public void setIo(it.uniroma3.diadia.IO io) {
		// TODO Auto-generated method stub
		
	}

}