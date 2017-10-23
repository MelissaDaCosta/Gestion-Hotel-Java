import java.awt.*;
import javax.swing.*;

public class OccupationDate extends JPanel{
    private JPanel panneau;
    private CardLayout cardlayout;
    private String jour;
    private String mois;
    private String annee;
    private CamembertOccupationDate cam;

    public OccupationDate(CardLayout c, JPanel p, String j, String m, String a, CamembertOccupationDate ca){ 
        this.panneau = p;
        this.cardlayout = c;
        this.jour = j;
        this.mois = m;
        this.annee = a;
        this.cam = ca;

        this.afficherOccupationD();
    }

    public void afficherOccupationD(){
        System.out.println("OccupationDate");
        this.setLayout(new GridLayout(4,1));
        Color couleur= new Color(200, 200, 255);
        this.setBackground(couleur);  // modifie couleur panneau

        //Creation etiquettes
        JLabel etiquette1 = new JLabel("Taux d'occupation de l'h\u00F4tel");
        etiquette1.setHorizontalAlignment(JLabel.CENTER);
        etiquette1.setFont(new Font("", Font.BOLD, 35));
        JLabel etiquette2 = new JLabel("\u00E0 la date du "+this.jour+"-"+this.mois+"-"+this.annee);
        etiquette2.setHorizontalAlignment(JLabel.CENTER);


        //Creation panneau boutons
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
        ControleurDate cd = new ControleurDate(cardlayout, panneau);
        retour.addActionListener(cd);

        //Ajout elements
        this.add(etiquette1);
        this.add(etiquette2);
        this.add(this.cam);
        this.add(panBouton);

        panneau.add(this, "OccupationDate");
        this.cardlayout.show(panneau, "OccupationDate");
    }
}
