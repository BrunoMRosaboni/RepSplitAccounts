package com.gerenciador.ui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.gerenciador.entities.Expense;
import com.gerenciador.entities.User;

import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

/**
 * Class to create the dialog for the user add an expense.
 */

public class DialogAddExpense extends Dialog {

	protected Expense result;
	protected Shell shlAddNewExpense;
	
	private ArrayList<User> users;
	private Text textAmount;
	private Text textReason;
	
	/**
	 * Constructor.
	 * @param parent The shell parent of this dialog.
	 * @param users A list of the users of the selected group.
	 */

	public DialogAddExpense(Shell parent, ArrayList<User> users) {
		super(parent, SWT.DIALOG_TRIM|SWT.MODELESS);
		this.users = users;
	}



	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DialogAddExpense(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}
	
	

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Expense open() {
		createContents();
		shlAddNewExpense.open();
		shlAddNewExpense.layout();
		Display display = getParent().getDisplay();
		while (!shlAddNewExpense.isDisposed()) {
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
		shlAddNewExpense = new Shell(getParent(), SWT.DIALOG_TRIM);
		shlAddNewExpense.setSize(390, 400);
		shlAddNewExpense.setText("Adicionar novo pagamento");
		
		Label lblQuemPagou = new Label(shlAddNewExpense, SWT.NONE);
		lblQuemPagou.setBounds(20, 10, 85, 15);
		lblQuemPagou.setText("Quem Pagou?");
		
		List listPayers = new List(shlAddNewExpense, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		listPayers.setBounds(20, 31, 140, 140);
		
		Label lblPraQuem = new Label(shlAddNewExpense, SWT.NONE);
		lblPraQuem.setBounds(220, 10, 65, 15);
		lblPraQuem.setText("Pra quem?");
		
		List listReceivers = new List(shlAddNewExpense, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		listReceivers.setBounds(220, 31, 140, 140);
		
		Label lblQuanto = new Label(shlAddNewExpense, SWT.NONE);
		lblQuanto.setBounds(20, 187, 55, 15);
		lblQuanto.setText("Quanto?");
		
		textAmount = new Text(shlAddNewExpense, SWT.BORDER);
		textAmount.setBounds(20, 208, 55, 21);
//		textAmount.
		
		Label lblDescrio = new Label(shlAddNewExpense, SWT.NONE);
		lblDescrio.setBounds(20, 251, 55, 15);
		lblDescrio.setText("Descri\u00E7\u00E3o");
		
		textReason = new Text(shlAddNewExpense, SWT.BORDER);
		textReason.setBounds(20, 272, 340, 21);
		
		Button btnAdd = new Button(shlAddNewExpense, SWT.NONE);
		btnAdd.setBounds(220, 336, 140, 25);
		btnAdd.setText("Adicionar");
		
		Button btnCancel = new Button(shlAddNewExpense, SWT.NONE);
		btnCancel.setBounds(20, 336, 140, 25);
		btnCancel.setText("Cancelar");
		
		//initializations
		for (User user : users) {
			listPayers.add(user.getName());
			listReceivers.add(user.getName());
		}
		
		//listeners
		btnCancel.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				result = null;
				shlAddNewExpense.dispose();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnAdd.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<User> payers = new ArrayList<>();
				ArrayList<User> receivers = new ArrayList<>();
				if(listPayers.getSelection().length>0&&listReceivers.getSelection().length>0&&!textAmount.getText().isEmpty()&&!textReason.getText().isEmpty()){
					
					//add the selected users in the payers list 
					for (int i = 0; i < listPayers.getSelection().length; i++) {
						for (User user : users) {
							if(listPayers.getSelection()[i].equalsIgnoreCase(user.getName()))
								payers.add(user);
						}
					}
					
					//add the selected users in the receivers list 
					for (int i = 0; i < listReceivers.getSelection().length; i++) {
						for (User user : users) {
							if(listReceivers.getSelection()[i].equalsIgnoreCase(user.getName()))
								receivers.add(user);
						}
					}
					
					result =  new Expense(payers, receivers, Double.valueOf(textAmount.getText()), textReason.getText());
					shlAddNewExpense.dispose();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
