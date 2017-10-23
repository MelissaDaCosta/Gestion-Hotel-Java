import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DateModel{
	private Date madate;
	private String date;
	private int occupe;

	public DateModel(Date d){
		this.madate=d;
	}

	public int rechercherOccupation(){
		System.out.println("Rechercher date");
		System.out.println("madate "+this.madate.getJour()+" "+this.madate.getMois()+" "+this.madate.getAnnee());
		date = this.madate.getAnnee()+"-"+this.madate.getMois()+"-"+this.madate.getJour();
		System.out.println("date : " + date);
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			try{
				Connection co = DriverManager.getConnection("jdbc:mariadb://dwarves.arda/projetihm", "projetihm", "mhitejorp");
				try{
					PreparedStatement requete = co.prepareStatement("SELECT COUNT(debut) FROM Reservation WHERE ADDDATE(debut,nuits)>='"+date+"'"+" AND debut<'"+date+"'");
					ResultSet res = requete.executeQuery();
					res.first(); 
					int resultat = res.getInt(1);
					System.out.println("Requete executee : "+resultat);
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

	public int rechercherNonPres(){
		System.out.println("Rechercher date");
		System.out.println("madate "+this.madate.getJour()+" "+this.madate.getMois()+" "+this.madate.getAnnee());
		date = this.madate.getAnnee()+"-"+this.madate.getMois()+"-"+this.madate.getJour();
		System.out.println("date : " + date);
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			try{
				Connection co = DriverManager.getConnection("jdbc:mariadb://dwarves.arda/projetihm", "projetihm", "mhitejorp");
				try{
					PreparedStatement requete = co.prepareStatement("SELECT COUNT(debut) FROM Reservation WHERE ADDDATE(debut,nuits)>='"+date+"'"+" AND debut<'"+date+"'");
					ResultSet res = requete.executeQuery();
					res.first(); 
					int resultat = res.getInt(1);
					System.out.println("Requete executee : "+resultat);
					this.occupe=resultat;
					res.close();

					//requete = co.prepareStatement("SELECT")

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

	/*public int getProportionNonPres(){
		//
	}*/

}