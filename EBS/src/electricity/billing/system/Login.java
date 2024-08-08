package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	
	JButton login, cancel, signup;
	JTextField username, password;
	Choice logging;
	
	Login() {
		
		super("Login Page");
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		JLabel lblusername = new JLabel("Username:");
		lblusername.setBounds(300, 40, 100, 20);
		add(lblusername);
		
		username = new JTextField();
		username.setBounds(400, 40, 150, 20);
		add(username);
		
		
		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setBounds(300, 80, 100, 20);
		add(lblpassword);
		
		password = new JTextField();
		password.setBounds(400, 80, 150, 20);
		add(password);
		
		
		JLabel lbllogging = new JLabel("Login as:");
		lbllogging.setBounds(300, 120, 100, 20);
		add(lbllogging);
		
		logging = new Choice();
		logging.add("Admin");
		logging.add("Customer");
		logging.setBounds(400, 120, 150, 20);
		add(logging);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconimages/loginicon.png"));
		Image i12 = i1.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);
		login = new JButton("Login", new ImageIcon(i12));
		login.setBounds(300, 160, 125, 20);
		login.addActionListener(this);
		add(login);
		
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("iconimages/cancelicon.png"));
		Image i22 = i2.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);
		cancel = new JButton("Cancel", new ImageIcon(i22));
		cancel.setBounds(450, 160, 125, 20);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("iconimages/signupicon.png"));
		Image i32 = i3.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);
		signup = new JButton("Sign Up", new ImageIcon(i32));
		signup.setBounds(375, 200, 125, 20);
		signup.addActionListener(this);
		add(signup);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("iconimages/usericon.png"));
		Image i42 = i4.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i43 = new ImageIcon(i42);
		JLabel image = new JLabel(i43);
		image.setBounds(50, 30, 200, 200);
		add(image);
		
		
		setSize(640, 300);
		setLocation(400, 200);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == login) {
			
			String susername = username.getText();
			String spassword = password.getText();
			String user = logging.getSelectedItem();
			
			try {
				Conn c = new Conn();
				String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and user = '"+user+"';";
				
				ResultSet rs = c.s.executeQuery(query);
				
				if (rs.next()) {
					String meter = rs.getString("meter_no");
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "Welcome "+susername+"!");
                    new MainPage(user, meter);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid login");
					username.setText("");
					password.setText("");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == cancel) {
			setVisible(false);
		} else if (ae.getSource() == signup) {
			setVisible(false);
			
			new SignUp();
		}
	}
	
	
	public static void main(String[] args) {
		new Login();
	}

}
