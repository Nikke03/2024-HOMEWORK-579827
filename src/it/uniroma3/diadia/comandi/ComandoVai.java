package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
private String direzione;
private IO io;

public ComandoVai(IO io) {
	super();
	this.io = io;
}

/**
* esecuzione del comando
*/
@Override
public void esegui(Partita partita) {
    Stanza stanzaCorrente=partita.getStanzaCorrente();
    Stanza prossimaStanza = null;
    if(direzione==null) {
            System.out.println("Dove vuoi andare?\n Devi specificare una direzione");
            return;
        }
    prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(this.direzione);
        if (prossimaStanza == null) {
            System.out.println("Direzione inesistente");
            return;
        }
        partita.setStanzaCorrente(prossimaStanza);
        
        int cfu = partita.getGiocatore().getCfu();
        partita.getGiocatore().setCfu(--cfu);


        System.out.println(partita.getStanzaCorrente().getDescrizione());
        System.out.println("CFU disponibili: "+ partita.getGiocatore().getCfu());
    }
@Override
public void setParametro(String Parametro) {
	this.direzione= Parametro;
}

@Override
public String getParametro() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getNome() {
	// TODO Auto-generated method stub
	return null;
}

}
