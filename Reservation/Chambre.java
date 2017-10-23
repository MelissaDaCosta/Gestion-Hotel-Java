import javax.swing.*;
import java.awt.*;


public class Chambre{
	private int numChambre;
	private int catChambre;
	private int etatChambre;

	public Chambre(int num, int cat, int etat){
	this.numChambre= num;
	this.catChambre=cat;
	this.etatChambre=etat;
	}

/************** Getteurs *************************/
	public int getNum(){
		return this.numChambre;
	}
	public int getCat(){
		return this.catChambre;
	}
	public int getEtat(){
		return this.etatChambre;
	}

}