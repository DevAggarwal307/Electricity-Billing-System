package electricity.billing.system;

import java.awt.*;
import javax.swing.*;

public class Splash extends JFrame implements Runnable {
	Thread t;
	Splash() {
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconimages/india-low-carbon-electricity.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		
		setVisible(true);
		
		for (int i = 1; i < 500; i+=2){
			setSize(i, i);
			setLocation(700 - i/2, 400 - i/2);
		}
		
		t = new Thread(this);
		t.start();
		
		setVisible(true);
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
			setVisible(false);
			
			// LOGIN FRAME
			new Login();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Splash();
	}
}
