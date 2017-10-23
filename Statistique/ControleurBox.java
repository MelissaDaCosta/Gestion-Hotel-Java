import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ControleurBox implements ActionListener{
    private JPanel panneau;
    private CardLayout cardlayout;
    private JComboBox jcbj;
    private JComboBox jcbm;
    private JComboBox jcba;
    private JComboBox jcbjf;
    private JComboBox jcbmf;
    private JComboBox jcbaf;
    private String jour;
    private String mois;
    private String annee;
    private String jourfin;
    private String moisfin;
    private String anneefin;

    public ControleurBox(CardLayout c, JPanel p, JComboBox j, JComboBox m, JComboBox a){ //Constructeur
        this.panneau = p;
        this.cardlayout = c;
        this.jcbj = j;
        this.jcbm = m;
        this.jcba = a;
    }

    public ControleurBox(CardLayout c, JPanel p, JComboBox j, JComboBox m, JComboBox a, JComboBox jf, JComboBox mf, JComboBox af){ //Constructeur
        this.panneau = p;
        this.cardlayout = c;
        this.jcbj = j;
        this.jcbm = m;
        this.jcba = a;
        this.jcbjf = jf;
        this.jcbmf = mf;
        this.jcbaf = af;
    }

    @Override
    public void actionPerformed(ActionEvent e){
    	String action = e.getActionCommand();
        this.jour=this.jcbj.getSelectedItem().toString();
        this.mois=this.jcbm.getSelectedItem().toString();
        this.annee=this.jcba.getSelectedItem().toString();
      
    	if(action.equals("Taux d'occupation par date") ){
            System.out.println("Item selectionne : "+ this.jour +" "+this.mois+" "+this.annee);
            Date madate = new Date(this.jour, this.mois, this.annee);
            DateModel monmodel = new DateModel(madate);
            if(monmodel.rechercherOccupation()==1){
                CamembertOccupationDate cam = new CamembertOccupationDate(monmodel);
                System.out.println("Taux d'occupation date");
                JPanel pOccupationDate = new OccupationDate(this.cardlayout, this.panneau, this.jour, this.mois, this.annee, cam);
            }
            else{
                 System.out.println("Erreur");
            }
        }
        else if(action.equals("Taux de non-pr\u00E9sentation")){
            Date madate = new Date(this.jour, this.mois, this.annee);
            System.out.println("Item selectionne : "+ this.jour +" "+this.mois+" "+this.annee);
            System.out.println("Taux non presentation date");
            /*if(monmodel.rechercherNonPres()==1){
                CamembertOccupationDate cam = new CamembertOccupationDate(monmodel);
                System.out.println("Taux d'occupation date");*/
               JPanel pNonPresentationDate = new NonPresentationDate(this.cardlayout, this.panneau, this.jour, this.mois, this.annee/*, cam*/);
           /* }
            else{
                 System.out.println("Erreur");
            }*/
            
        }
        else if(action.equals("Taux d'occupation par p\u00E9riode")){
            this.jourfin=this.jcbjf.getSelectedItem().toString();
            this.moisfin=this.jcbmf.getSelectedItem().toString();
            this.anneefin=this.jcbaf.getSelectedItem().toString();
            Date madate = new Date(this.jour, this.mois, this.annee, this.jourfin, this.moisfin, this.anneefin);
            System.out.println("Item selectionne : "+ this.jour +" "+this.mois+" "+this.annee);
            System.out.println("Item selectionne : "+ this.jourfin +" "+this.moisfin+" "+this.anneefin);
            PeriodeModel monmodel= new PeriodeModel(madate);
            /*if(monmodel.rechercherOccupationP()==1){
                CamembertOccupationPeriode cam = new CamembertOccupationPeriode(monmodel);
                System.out.println("Taux d'occupation periode");*/
                JPanel pOccupationPeriode = new OccupationPeriode(this.cardlayout, this.panneau, this.jour, this.mois, this.annee, this.jourfin, this.moisfin, this.anneefin/*, cam*/);
           /* }
            else{
                System.out.println("Erreur");
            }*/
        }
    }
}