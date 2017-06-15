package com.gerenciador.ui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.gerenciador.entities.User;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class DialogCreateUser extends Dialog {

	protected User result;
	protected Shell shell;
	private Text textName;
	private Text textLogin;
	private Text textPassword;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DialogCreateUser(Shell parent) {
		super(parent, SWT.DIALOG_TRIM|SWT.MODELESS);
		setText("Criar Novo Usuário");
	}
	

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public User open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(420, 240);
		shell.setText(getText());
		
		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(10, 10, 55, 15);
		lblNome.setText("Nome:");
		
		textName = new Text(shell, SWT.BORDER);
		textName.setBounds(10, 31, 171, 21);
		
		Label lblLogin = new Label(shell, SWT.NONE);
		lblLogin.setBounds(10, 81, 55, 15);
		lblLogin.setText("Username:");
		
		textLogin = new Text(shell, SWT.BORDER);
		textLogin.setBounds(10, 102, 171, 21);
		
		Label lblSenha = new Label(shell, SWT.NONE);
		lblSenha.setBounds(230, 81, 55, 15);
		lblSenha.setText("Senha:");
		
		textPassword = new Text(shell, SWT.BORDER);
		textPassword.setBounds(230, 102, 171, 21);
		
		Button btnAdd = new Button(shell, SWT.NONE);
		btnAdd.setBounds(230, 176, 171, 25);
		btnAdd.setText("Adicionar");
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(10, 176, 171, 25);
		btnCancel.setText("Cancel");
		
		//listeners
		
		btnAdd.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				if(!textLogin.getText().isEmpty()&&!textName.getText().isEmpty()&&!textPassword.getText().isEmpty()){
					result =  new User(textName.getText(), textLogin.getText(), textPassword.getText());
					shell.dispose();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnCancel.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				result = null;
				shell.dispose();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

	}
}
