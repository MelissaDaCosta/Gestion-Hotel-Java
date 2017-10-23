import javax.swing.*;
import java.awt.*;

public class Main{

    public static void main(String[] args){
        //Creation fenetre
        JFrame fenetre = new JFrame("Statisiques");
        fenetre.setSize(700, 500);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout monCardlayout = new CardLayout();

        //Creation panneau principal
        JPanel panneauPrincipal = new JPanel();
        panneauPrincipal.setLayout(monCardlayout);

        //Creation interfaces
        JPanel pAccueilStatistique = new AccueilStatistique(monCardlayout, panneauPrincipal);
        JPanel pChoixDate = new ChoixDate(monCardlayout, panneauPrincipal);
        JPanel pChoixPeriode = new ChoixPeriode(monCardlayout, panneauPrincipal);
        
        //Ajout interfaces au panneau principal
        panneauPrincipal.add(pAccueilStatistique, "AccueilStatistique");
        panneauPrincipal.add(pChoixDate, "ChoixDate");
        panneauPrincipal.add(pChoixPeriode, "ChoixPeriode");

        //Ajout panneau principale a la fenetre
        fenetre.add(panneauPrincipal);
        
        fenetre.setVisible(true);
    }
}
