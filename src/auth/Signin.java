package auth;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import standard.*;

public class Signin extends JPanel {

	public Signin() {
		setSize(new Dimension(1600, 900));
		setLayout(null);

		//Label
		JLabel welcomeLabel = new JLabel("Benvenuti in Virtual Casinò");
		JLabel Background = new JLabel("New label");
		JLabel registrati = new JLabel("Se non hai ancora un account clicca ");
		//TextField
		JTextField emailArea = new JTextField("Email");
		//PasswordField
		JPasswordField passwordArea = new JPasswordField("Password");
		//RoundPanel
		RoundedPanel data = new RoundedPanel();
		//Button
		JButton registratiBtn = new JButton("qui");
		JButton submit = new JButton();
		

		emailArea.setLocation(115, 187);
		emailArea.setSize(270, 35);
		emailArea.setBackground(Color.white);
		emailArea.setBorder(null);
		emailArea.setForeground(Color.BLACK);
		emailArea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		emailArea.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		
		Background.setIcon(new ImageIcon("assets/BackgroundLogin[1600x900].jpg"));
		Background.setBounds(0, 0, 1600, 900);

		passwordArea.setEchoChar((char)0);
		passwordArea.setBackground(Color.white);
		passwordArea.setBounds(115, 302, 270, 35);
		passwordArea.setBorder(null);
		passwordArea.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		passwordArea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));

		welcomeLabel.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 21));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(100, 10, 280, 35);

		registratiBtn.setBorder(null);
		registratiBtn.setBackground(Color.white);
		registratiBtn.setForeground(Color.BLUE);
		registratiBtn.setBounds(355, 365, 40, 20);

		registrati.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		registrati.setHorizontalAlignment(SwingConstants.CENTER);
		registrati.setBounds(95, 360, 280, 35);

		submit.setText("Accedi");
		submit.setBounds(115, 440, 275, 40);
		
		
		data.setBounds(569, 162, 500, 600);
		data.setBackground(Color.white);
		data.setLayout(null);
		
		data.add(emailArea);
		data.add(welcomeLabel);
		data.add(passwordArea);
		data.add(registrati);
		data.add(registratiBtn);
		data.add(submit);

		add(data);
		add(Background);

		emailArea.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (emailArea.getText().equals("Email")) {
					emailArea.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (emailArea.getText().equals("")) {
					emailArea.setText("Email");
				}
			}
		});

		passwordArea.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(passwordArea.getPassword()).equals("Password")) {
					passwordArea.setText("");
					passwordArea.setEchoChar('*');
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(passwordArea.getPassword()).equals("")) {
					passwordArea.setText("Password");
					passwordArea.setEchoChar((char)0);
				}
			}
		});

		registratiBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(submit.getText().equals("Accedi")){
					registrati.setText("Se sei gia registrato clicca ");
					submit.setText("Registrati");
				}else{
					registrati.setText("Se non hai ancora un account clicca ");
					submit.setText("Accedi");
				}
			}
		});

		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(submit.getText().equals("Accedi")){
					System.out.println("Accedi");
				}else{
					System.out.println("Registrati");
				}
			}
		});
	}
}