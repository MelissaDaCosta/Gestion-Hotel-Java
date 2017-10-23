import java.awt.*;
import javax.swing.*;

public class AccueilStatistique extends JPanel{
    private JPanel panneau;
    private CardLayout cardlayout;

    public AccueilStatistique(CardLayout c, JPanel p){
        this.panneau = p;
        this.cardlayout = c;

        this.afficherAccueil();
    }

    public void afficherAccueil(){
        this.setLayout(new GridLayout(5, 1));//5 lignes 1 colonne
        Color couleur= new Color(200, 200, 255);
        this.setBackground(couleur);  // modifie couleur panneau
        
        //Creation etiquettes
        JLabel etiquette1 = new JLabel("Statistiques");
        etiquette1.setHorizontalAlignment(JLabel.CENTER);
        etiquette1.setFont(new Font("", Font.BOLD, 35));
        JLabel etiquette2 = new JLabel("Vous souhaitez voir :");
        etiquette2.setHorizontalAlignment(JLabel.CENTER);

        JPanel vide = new JPanel(); //laisser un espace
        vide.setBackground(couleur);
        //Creation boutons
        JButton bouton1 = new JButton("Statistiques par date");
        JButton bouton2 = new JButton("Statistiques par p\u00E9riode");

        //Creation panneau bouton
        JPanel panBouton = new JPanel();
        panBouton.setLayout(new GridBagLayout());
        panBouton.setBackground(couleur);

        //Creation contraintes
        GridBagConstraints contraintes = new GridBagConstraints();
        contraintes.gridx = 0;
        contraintes.gridy = 0;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;

        panBouton.add(bouton1, contraintes);

        contraintes.gridx = 0;
        contraintes.gridy = 1;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;

        panBouton.add(bouton2, contraintes);

        //Creation panneau bouton quitter + bouton quitter
        JPanel panBoutonQuit = new JPanel();
        JButton quitter = new JButton("Quitter");
        panBoutonQuit.add(quitter);
        panBoutonQuit.setBackground(couleur);

        //Controleur
        ControleurBouton c = new ControleurBouton(cardlayout, panneau);
        bouton1.addActionListener(c);
        bouton2.addActionListener(c);
        quitter.addActionListener(c);
       
        this.add(etiquette1);
        this.add(etiquette2);
        this.add(panBouton);
        this.add(vide);
        this.add(panBoutonQuit);
    }
}
