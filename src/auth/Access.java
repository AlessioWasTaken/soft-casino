package auth;

import javax.imageio.ImageIO;
import javax.swing.*;

import App.VirtualCasino;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

import backend.Auth.*;

public class Access extends JPanel {
	private VirtualCasino istanceOfApp;
	private Authentication Auth;

	public Access(VirtualCasino istanceOfApp) {
		this.istanceOfApp = istanceOfApp;
		Auth=new Authentication();
		setSize(new Dimension(1300, 800));
		setBackground(Color.white);
		setLayout(null);
		init();
	}

	private void init() {
		// Background
		JLabel Background = new JLabel("");
		try {
            Image img = ImageIO.read(getClass().getResource("../assets/bg-access.jpg")).getScaledInstance(600, 600, Image.SCALE_SMOOTH);
            Background.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
		Background.setBounds(0, 20, 600, 600);
		add(Background);

		// Data panel
		JPanel data = new JPanel();
		data.setBounds(640, 30, 500, 650);
		data.setBackground(new Color(34, 40, 44));
		data.setLayout(null);
		add(data);

		// Tipo di accesso
		JLabel textMode = new JLabel("Registrazione");
		textMode.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 21));
		textMode.setHorizontalAlignment(SwingConstants.LEFT);
		textMode.setForeground(Color.white);
		textMode.setBounds(90, 40, 280, 35);
		data.add(textMode);

		// Nome utente
		JLabel nome = new JLabel("Nome");
		nome.setForeground(Color.white);
		nome.setBounds(90, 130, 100, 35);
		nome.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		data.add(nome);

		// Area nome utente
		JTextField nomeArea = new JTextField("Nome");
		nomeArea.setLocation(90, 170);
		nomeArea.setSize(300, 35);
		nomeArea.setBackground(new Color(34, 40, 44));
		nomeArea.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
		nomeArea.setForeground(Color.white);
		nomeArea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		nomeArea.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (nomeArea.getText().equals("Nome")) {
					nomeArea.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (nomeArea.getText().equals("")) {
					nomeArea.setText("Nome");
				}
			}
		});
		data.add(nomeArea);

		// Cognome utente
		JLabel cognome = new JLabel("Cognome");
		cognome.setForeground(Color.white);
		cognome.setBounds(90, 230, 100, 35);
		cognome.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		data.add(cognome);

		// Area cognome utente
		JTextField cognomeArea = new JTextField("Cognome");
		cognomeArea.setLocation(90, 270);
		cognomeArea.setSize(300, 35);
		cognomeArea.setBackground(new Color(34, 40, 44));
		cognomeArea.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
		cognomeArea.setForeground(Color.white);
		cognomeArea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		cognomeArea.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (cognomeArea.getText().equals("Cognome")) {
					cognomeArea.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (cognomeArea.getText().equals("")) {
					cognomeArea.setText("Cognome");
				}
			}
		});
		data.add(cognomeArea);

		// Email utente
		JLabel email = new JLabel("Email");
		email.setForeground(Color.white);
		email.setBounds(90, 330, 100, 35);
		email.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		data.add(email);

		// Area email utente
		JTextField emailArea = new JTextField("Email");
		emailArea.setLocation(90, 370);
		emailArea.setSize(300, 35);
		emailArea.setBackground(new Color(34, 40, 44));
		emailArea.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
		emailArea.setForeground(Color.white);
		emailArea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
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
		data.add(emailArea);

		// Password utente
		JLabel password = new JLabel("Password");
		password.setForeground(Color.white);
		password.setBounds(90, 430, 100, 35);
		password.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		data.add(password);

		// Area password utente
		JPasswordField passwordArea = new JPasswordField("Password");
		passwordArea.setLocation(90, 470);
		passwordArea.setSize(300, 35);
		passwordArea.setBackground(new Color(34, 40, 44));
		passwordArea.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
		passwordArea.setForeground(Color.white);
		passwordArea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
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
		data.add(passwordArea);

		JButton access = new JButton("Registrati");
		JButton switchLogin = new JButton("Hai già un account? Accedi");
		// Bottone switch login
		switchLogin.setBounds(90, 580, 300, 35);
		switchLogin.setBackground(new Color(21, 25, 28));
		switchLogin.setForeground(Color.white);
		switchLogin.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		switchLogin.setFocusPainted(false);
		switchLogin.setBorder(null);
		switchLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(switchLogin.getText().equals("Non hai un account? Registrati")) {
					textMode.setText("Registrazione");
					access.setText("Registrati");
					nome.setVisible(true);
					nomeArea.setVisible(true);
					cognome.setVisible(true);
					cognomeArea.setVisible(true);
					switchLogin.setText("Hai già un account? Accedi");
				}else{
					textMode.setText("Accesso");
					access.setText("Accedi");
					nome.setVisible(false);
					nomeArea.setVisible(false);
					cognome.setVisible(false);
					cognomeArea.setVisible(false);
					switchLogin.setText("Non hai un account? Registrati");
				}
			}
		});
		data.add(switchLogin);

		// Bottone di accesso
		access.setBounds(90, 530, 300, 35);
		access.setBackground(new Color(21, 25, 28));
		access.setForeground(Color.white);
		access.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		access.setFocusPainted(false);
		access.setBorder(null);
		access.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(access.getText().equals("Registrati")) {
					// TODO Collegare il backend
					try{
						Auth.setPath(emailArea.getText());
						if(Auth.Check()){	
							System.out.println("Email gia registrata");	
						}
						else{
							Auth.createPrinter();
							Auth.Register(nomeArea.getText(), cognomeArea.getText(), emailArea.getText(), new String(passwordArea.getPassword()));
						}
						
					}
					catch(Exception EX){
						System.out.println(EX);
					}

					textMode.setText("Metodo di pagamento");
					nome.setText("Intestatario carta");
					nomeArea.setText("Intestatario carta");
					cognome.setText("Numero carta");
					cognomeArea.setText("Numero carta");
					email.setText("Data di scadenza");
					emailArea.setText("Data di scadenza");
					password.setText("CVV");
					passwordArea.setText("CVV");
					access.setText("Aggiungi metodo");
					switchLogin.setVisible(false);
				}else if(access.getText().equals("Aggiungi metodo")){
					// TODO Collegare il backend
					try{
						Auth.AggiungiPagamento(nomeArea.getText(), cognomeArea.getText(), emailArea.getText(), new String(passwordArea.getPassword()));
					}
					catch(Exception EX){
						System.out.println(EX);
					}
				}else{
					// TODO Collegare il backend
					try{
						Auth.setPath(emailArea.getText());
						if(Auth.Check()){
							if(Auth.Login(new String(passwordArea.getPassword()))){
								istanceOfApp.login();
							}
							else{
								System.out.println("PasswordErrata");
							}
						}
						else{
							System.out.println("Email non registrata");
						}
					}
					catch(Exception EX){
						System.out.println(EX);
					}
					
				}
			}
		});
		data.add(access);
	}
}