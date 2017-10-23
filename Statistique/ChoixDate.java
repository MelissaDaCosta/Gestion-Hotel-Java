import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ChoixDate extends JPanel{
    private JPanel panneau;
    private CardLayout cardlayout;

    public ChoixDate(CardLayout c, JPanel p){
        this.panneau = p;
        this.cardlayout = c;

        this.afficherDate();
    }

    public void afficherDate(){
        this.setLayout(new GridLayout(4, 1)); //4 lignes 1 colonne
        Color couleur= new Color(200, 200, 255);
        this.setBackground(couleur);  // modifie couleur panneau
        
        //Creation eiquette
        JLabel etiquette1 = new JLabel("S\u00E9lectionner une date");
        etiquette1.setHorizontalAlignment(JLabel.CENTER);
        etiquette1.setFont(new Font("", Font.BOLD, 35));

        //Creation panneau date
        JPanel panDate = new JPanel();
        JLabel etiquette2 = new JLabel("Date (jj/mm/aaaa) : ");
        panDate.setLayout(new GridBagLayout());
        panDate.setBackground(couleur);

        JComboBox<String> jour = new JComboBox<String>();
        for(int i = 1; i <= 31; i++){
            String j;
            if(i<=9){
                j = "0"+String.valueOf(i);
            }
            else{
                j = String.valueOf(i);
            }
            jour.addItem(j);
        }

        JComboBox<String> mois = new JComboBox<String>();
        for(int i = 1; i <= 12; i++){
            String j;
            if(i<=9){
                j="0"+String.valueOf(i);
            }
            else{
                j = String.valueOf(i);
            }
            mois.addItem(j);
        }

        int anneeEnCours = Calendar.getInstance().get(Calendar.YEAR);
        int anneeCreation = 2005;
        JComboBox<String> annee = new JComboBox<String>();
        for(int i = anneeEnCours+1; i >= anneeCreation; i--){
            String an = String.valueOf(i);
            annee.addItem(an);
        }

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

        panDate.add(etiquette2, contraintes);

        contraintes.gridx = 1;
        contraintes.gridy = 0;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;

        panDate.add(jour, contraintes);

        contraintes.gridx = 2;
        contraintes.gridy = 0;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;

        panDate.add(mois, contraintes);

        contraintes.gridx = 3;
        contraintes.gridy = 0;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;

        panDate.add(annee, contraintes);

        //Creation boutons
        JButton bouton1 = new JButton("Taux d'occupation par date");
        JButton bouton2 = new JButton("Taux de non-pr\u00E9sentation");
        contraintes.gridx = 1;
        contraintes.gridy = 2;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;

        panDate.add(bouton1, contraintes);

        contraintes.gridx = 2;
        contraintes.gridy = 2;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;

        panDate.add(bouton2, contraintes);

        //Creation panneau bouton accueil + bouton accueil
        JPanel panBouton = new JPanel();
        JButton accueil = new JButton("Accueil");
        JButton quitter = new JButton("Quitter");
        panBouton.add(accueil);
        panBouton.add(quitter);
        panBouton.setBackground(couleur);

        //Aide : Savoir quel item est selectionne
        ItemState etat = new ItemState();
        jour.addItemListener(etat);
        mois.addItemListener(etat);
        annee.addItemListener(etat);

        //Controleur
        ControleurBouton c = new ControleurBouton(cardlayout, panneau);
        accueil.addActionListener(c);
        quitter.addActionListener(c);

        ControleurBox cb = new ControleurBox(cardlayout, panneau, jour, mois, annee);
        bouton1.addActionListener(cb);
        bouton2.addActionListener(cb);

        this.add(etiquette1);
        this.add(panDate);
        this.add(panBouton);
    }
}
