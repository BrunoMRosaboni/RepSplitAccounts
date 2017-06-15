package com.gerenciador.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import com.gerenciador.entities.User;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Button;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.layout.RowLayout;

/**
 * Class to create the dialog for the login of the user.
 */

public class Login {

	protected Shell shlGerenciadorFinanceiro;
	private Text txtUser;
	private Text txtPassword;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
			window.open();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlGerenciadorFinanceiro.open();
		shlGerenciadorFinanceiro.layout();
		while (!shlGerenciadorFinanceiro.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlGerenciadorFinanceiro = new Shell();
		shlGerenciadorFinanceiro.setSize(450, 300);
		shlGerenciadorFinanceiro.setText("Gerenciador Financeiro");
		shlGerenciadorFinanceiro.setLayout(null);
		
		Label lblNewLabel = new Label(shlGerenciadorFinanceiro, SWT.NONE);
		lblNewLabel.setBounds(149, 10, 122, 15);
		lblNewLabel.setText("Gerenciador Financeiro");
		
		Label lblUsurio = new Label(shlGerenciadorFinanceiro, SWT.NONE);
		lblUsurio.setBounds(149, 78, 40, 15);
		lblUsurio.setText("Usu\u00E1rio");
		
		txtUser = new Text(shlGerenciadorFinanceiro, SWT.BORDER);
		txtUser.setBounds(209, 75, 76, 21);
		
		Label lblSenha = new Label(shlGerenciadorFinanceiro, SWT.NONE);
		lblSenha.setBounds(149, 120, 32, 15);
		lblSenha.setText("Senha");
		
		txtPassword = new Text(shlGerenciadorFinanceiro, SWT.BORDER);
		txtPassword.setBounds(209, 117, 76, 21);
		
		Button btnLogin = new Button(shlGerenciadorFinanceiro, SWT.CENTER);
		btnLogin.setBounds(175, 200, 100, 25);
		btnLogin.setText("Entrar");
		btnLogin.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				if(!txtUser.getText().isEmpty()&&!txtPassword.getText().isEmpty()){
					User user = new User(txtUser.getText(), txtPassword.getText());
					//send user to server and authenticate
					
					shlGerenciadorFinanceiro.dispose();
					new MainScreen().open();
				}
			}
		});

	}

}
