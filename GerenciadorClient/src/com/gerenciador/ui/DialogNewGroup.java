package com.gerenciador.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.gerenciador.entities.FinGroup;
import com.gerenciador.entities.User;

/**
 * Class to create the dialog for the user add a new group.
 */

public class DialogNewGroup extends Dialog {

	protected FinGroup result;
	protected Shell shell;
	private User user;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DialogNewGroup(Shell parent, User user) {
		super(parent, SWT.DIALOG_TRIM|SWT.APPLICATION_MODAL);
		this.user = user;
		setText("Criar Novo Grupo");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public FinGroup open() {
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
		shell.setSize(450, 300);
		shell.setText(getText());

	}

}
