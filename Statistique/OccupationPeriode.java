import java.awt.*;
import javax.swing.*;

public class OccupationPeriode extends JPanel{
    private CardLayout cardlayout;
    private JPanel panneau;
    private String jour;
    private String mois;
    private String annee;
    private String jourfin;
    private String moisfin;
    private String anneefin;

    public OccupationPeriode(CardLayout c, JPanel p, String j, String m, String a, String jf, String mf, String af){ //Constructeur
        this.panneau = p;
        this.cardlayout = c;
        this.jour = j;
        this.mois = m;
        this.annee = a;
        this.jourfin = jf;
        this.moisfin = mf;
        this.anneefin = af;

        this.afficherOccupationP();
    }

    public void afficherOccupationP(){
        System.out.println("OccupationPeriode");
        this.setLayout(new GridLayout(5, 1));
        Color couleur= new Color(200, 200, 255);
        this.setBackground(couleur);  // modifie couleur panneau

        //Creation etiquettes
        JLabel etiquette1 = new JLabel("Taux d'occupation de l'h\u00F4tel");
        etiquette1.setHorizontalAlignment(JLabel.CENTER);
        etiquette1.setFont(new Font("", Font.BOLD, 35));
        JLabel etiquette2 = new JLabel("pour la p\u00E9riode du "+this.jour+"-"+this.mois+"-"+this.annee+" au "+this.jourfin+"-"+this.moisfin+"-"+this.anneefin);
        etiquette2.setHorizontalAlignment(JLabel.CENTER);

        //Creation panneau bouton + boutons accueil et quitter
        JPanel panBouton = new JPanel();
        JButton accueil = new JButton("Accueil");
        JButton quitter = new JButton("Quitter");
        JButton retour = new JButton("Retour");
        panBouton.add(accueil);
        panBouton.add(quitter);
        panBouton.add(retour);
        panBouton.setBackground(couleur);

        //Controleur
        ControleurBouton c = new ControleurBouton(cardlayout, panneau);
        accueil.addActionListener(c);
        quitter.addActionListener(c);

        ControleurPeriode cp = new ControleurPeriode(cardlayout, panneau);
        retour.addActionListener(cp);

        //Ajout element
        this.add(etiquette1);
        this.add(etiquette2);
        this.add(panBouton);

        panneau.add(this, "OccupationPeriode");
        this.cardlayout.show(panneau, "OccupationPeriode");
    }
}
