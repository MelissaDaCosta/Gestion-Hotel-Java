import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class PeriodeModel{
	private Date madate;
	private String date;
	private String datefin;
	private int occupe;

	public PeriodeModel(Date d){
		this.madate=d;
	}

	public int rechercherOccupationP(){
		System.out.println("Rechercher date");
		System.out.println("madate "+this.madate.getJour()+" "+this.madate.getMois()+" "+this.madate.getAnnee());
		System.out.println("madate FIN "+this.madate.getJourFin()+" "+this.madate.getMoisFin()+" "+this.madate.getAnneeFin());
		date = this.madate.getAnnee()+"-"+this.madate.getMois()+"-"+this.madate.getJour();
		datefin = this.madate.getAnneeFin()+"-"+this.madate.getMoisFin()+"-"+this.madate.getJourFin();
		System.out.println("date : " + date);
		System.out.println("date FIN: " + datefin);
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			try{
				Connection co = DriverManager.getConnection("jdbc:mariadb://dwarves.arda/projetihm", "projetihm", "mhitejorp");
				try{
					PreparedStatement requete = co.prepareStatement("");
					ResultSet res = requete.executeQuery();
					res.first(); 
					int resultat = res.getInt(1);
					this.occupe=resultat;
					res.close();
					requete.close();  // ferme requete
					co.close();
				}catch(SQLException e){
					System.err.println("Probleme de requete : "+e.getMessage());
					return 0;
				}
			}catch(SQLException e){
				System.err.println("Erreur connexion : "+e.getMessage());
				return 0;
			}
		}catch(ClassNotFoundException e){
			System.err.println("Pilote indisponible");
			return 0;
		}

		return 1;
	}

	public int getProportionOccupation(){
		if(this.occupe==0){
			return 0;
		}
		else{
			return (360*this.occupe)/100;
		}
	}
}