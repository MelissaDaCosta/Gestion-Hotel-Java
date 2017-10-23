import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControleurDate implements ActionListener{
    private JPanel panneau;
    private CardLayout cardlayout;

    public ControleurDate(CardLayout c, JPanel p){ //Constructeur
        this.panneau = p;
        this.cardlayout = c;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();

        if(action.equals("Valider")){
            System.out.println("ValiderDate");
        }
        else if(action.equals("Retour")){
            System.out.println("retourDate");
            cardlayout.show(panneau, "ChoixDate");
        }
    }
}
