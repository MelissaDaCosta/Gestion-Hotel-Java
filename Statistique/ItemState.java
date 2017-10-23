import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ItemState implements ItemListener{


   @Override
    public void itemStateChanged(ItemEvent e) {
        String test = e.getItem().toString();
    	System.out.println("Element selectionne : "+test);
    }
}