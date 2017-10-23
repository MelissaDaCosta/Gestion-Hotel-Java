import java.awt.*;
import javax.swing.*;

public class Date{
	private String jour;
	private String mois;
	private String annee;
	private String jourfin;
	private String moisfin;
	private String anneefin;

	public Date(String j, String m, String a){
		this.jour= j;
		this.mois=m;
		this.annee=a;
	}
	public Date(String j, String m, String a, String jf, String mf, String af){
		this.jour= j;
		this.mois=m;
		this.annee=a;
		this.jourfin= jf;
		this.moisfin=mf;
		this.anneefin=af;
	}

/************** Getteurs *************************/
	public String getJour(){
		return this.jour;
	}
	public String getMois(){
		return this.mois;
	}
	public String getAnnee(){
		return this.annee;
	}
	public String getJourFin(){
		return this.jourfin;
	}
	public String getMoisFin(){
		return this.moisfin;
	}
	public String getAnneeFin(){
		return this.anneefin;
	}
}