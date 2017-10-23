import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControleurBouton implements ActionListener{
    private JPanel panneau;
    private CardLayout cardlayout;

    public ControleurBouton(CardLayout c, JPanel p){
        this.panneau = p;
        this.cardlayout = c;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();

        if(action.equals("Statistiques par date")){
            System.out.println("Statistiques par date");
            cardlayout.show(panneau, "ChoixDate");
        } 
        else if(action.equals("Statistiques par p\u00E9riode")){
            System.out.println("Statistiques par p\u00E9riode");
            cardlayout.show(panneau, "ChoixPeriode");
        } 
        else if(action.equals("Accueil")){
            System.out.println("Accueil");
            cardlayout.show(panneau, "AccueilStatistique");
        }
        else if(action.equals("Quitter")){
            System.out.println("Quitter");
            System.exit(0);
        }
    }
}
