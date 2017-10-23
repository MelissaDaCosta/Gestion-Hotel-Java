import javax.swing.*;
import java.awt.*;

public class CamembertOccupationDate extends JComponent{
	private DateModel monmodel;

	public CamembertOccupationDate(DateModel dm){
		this.monmodel=dm;
	}

	@Override
	public void paintComponent(Graphics g){
		int angle = monmodel.getProportionOccupation();
		int angleDepart = 90 -angle/2;

		int x = (this.getWidth()-100)/2;
		int y = (this.getHeight()-100)/2;
		g.setColor(Color.GREEN);
		g.fillArc(x, y, 100, 100, angleDepart, angle);

		g.setColor(Color.RED);
		g.fillArc(x, y, 100, 100, angleDepart+angle, 360-angle);
	}
}