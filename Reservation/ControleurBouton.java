import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ControleurBouton implements ActionListener{
	private JPanel panneau;
	private CardLayout moncardlayout;
	private Client monclient;

	public ControleurBouton(CardLayout card, JPanel pann, Client client){
		this.panneau= pann;
		this.moncardlayout= card;
		this.monclient=client;
	}

	@Override
	 public void actionPerformed(ActionEvent event){
	 	String action = event.getActionCommand();// donne le texte du bouton cliqué

		if(action.equals("Quitter")){
			System.out.println("QUITTER ");
	   		System.exit(0);
		}else if(action.equals("Accueil")){
			System.out.println("Accueil");
			moncardlayout.show(panneau, "Accueil");  // affiche l'accueil

		}
	}

}