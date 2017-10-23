import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ChoixPeriode extends JPanel{
    private JPanel panneau;
    private CardLayout cardlayout;

    public ChoixPeriode(CardLayout c, JPanel p){
        this.panneau = p;
        this.cardlayout = c;

        this.afficherPeriode();
    }

    public void afficherPeriode(){
        this.setLayout(new GridLayout(5, 1));
        Color couleur= new Color(200, 200, 255);
        this.setBackground(couleur);  // modifie couleur panneau

        //Creation etiquette
        JLabel etiquette1 = new JLabel("S\u00E9lectionner une p\u00E9riode");
        etiquette1.setHorizontalAlignment(JLabel.CENTER);
        etiquette1.setFont(new Font("", Font.BOLD, 35));

        //Creation panneau dates
        JPanel panDate = new JPanel();
        JLabel etiquette2 = new JLabel("Date d\u00E9but (jj/mm/aaaa) : ");
        JLabel etiquette3 = new JLabel("Date fin (jj/mm/aaaa) : ");
        panDate.setLayout(new GridBagLayout());
        panDate.setBackground(couleur);

        JComboBox<String> jourd = new JComboBox<String>();
        JComboBox<String> jourf = new JComboBox<String>();
        for(int i = 1; i <= 31; i++){
            String j;
            if(i<=9){
                j= "0"+String.valueOf(i);
            }
            else{
                j = String.valueOf(i);
            }
            jourd.addItem(j);
            jourf.addItem(j);
        }

        JComboBox<String> moisd = new JComboBox<String>();
        JComboBox<String> moisf = new JComboBox<String>();
        for(int i = 1; i <= 12; i++){
            String j;
            if (i<=9){
                j= "0"+String.valueOf(i);
            }
            else{
                j= String.valueOf(i);
            }
            moisd.addItem(j);
            moisf.addItem(j);
        }

        int anneeEnCours = Calendar.getInstance().get(Calendar.YEAR);
        int anneeCreation = 2005;
        JComboBox<String> anneed = new JComboBox<String>();
        JComboBox<String> anneef = new JComboBox<String>();
        for(int i = anneeEnCours+1; i >= anneeCreation; i--){
            String an = String.valueOf(i);
            anneed.addItem(an);
            anneef.addItem(an);
        }

        JButton valider = new JButton("Valider");

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
        
        panDate.add(jourd, contraintes);
        
        contraintes.gridx = 2;
        contraintes.gridy = 0;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;
        
        panDate.add(moisd, contraintes);
        
        contraintes.gridx = 3;
        contraintes.gridy = 0;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;
        
        panDate.add(anneed, contraintes);
        
        contraintes.gridx = 0;
        contraintes.gridy = 1;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = 2;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;
        
        panDate.add(etiquette3, contraintes);
        
        contraintes.gridx = 1;
        contraintes.gridy = 1;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;
        
        panDate.add(jourf, contraintes);
        
        contraintes.gridx = 2;
        contraintes.gridy = 1;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;
        
        panDate.add(moisf, contraintes);
        
        contraintes.gridx = 3;
        contraintes.gridy = 1;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.weightx = 0.0f;
        contraintes.weighty = 1.0f;
        
        panDate.add(anneef, contraintes);
        
        //Creation panneau bouton
        JPanel panBouton = new JPanel();
        JButton bouton1 = new JButton("Taux d'occupation par p\u00E9riode");
        panBouton.add(bouton1);
        panBouton.setBackground(couleur);

        JPanel panBoutonacc = new JPanel();
        JButton accueil = new JButton("Accueil");
        JButton quitter = new JButton("Quitter");
        panBoutonacc.add(accueil);
        panBoutonacc.add(quitter);
        panBoutonacc.setBackground(couleur);

        //Controleur
        ControleurBouton c = new ControleurBouton(cardlayout, panneau);
        bouton1.addActionListener(c);
        accueil.addActionListener(c);
        quitter.addActionListener(c);
        ControleurBox cb = new ControleurBox(cardlayout, panneau, jourd, moisd, anneed, jourf, moisf, anneef);
        bouton1.addActionListener(cb);


        this.add(etiquette1);
        this.add(panDate);
        this.add(panBouton);
        this.add(panBoutonacc);
    }
}
