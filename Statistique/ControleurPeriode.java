import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControleurPeriode implements ActionListener{
    private JPanel panneau;
    private CardLayout cardlayout;

    public ControleurPeriode(CardLayout c, JPanel p){ //Constructeur
        this.panneau = p;
        this.cardlayout = c;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();

        if(action.equals("Valider")){
            System.out.println("ValiderOccupationPeriode");
        }
        else if(action.equals("Retour")){
            System.out.println("retourOccupationPeriode");
            cardlayout.show(panneau, "ChoixPeriode");
        }
    }
}
