package com.gerenciador.ui;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import javax.swing.plaf.TabbedPaneUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.gerenciador.entities.Expense;
import com.gerenciador.entities.FinGroup;
import com.gerenciador.entities.User;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.jface.viewers.ListViewer;

public class MainScreen {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainScreen window = new MainScreen();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	private ArrayList<FinGroup> groups = new ArrayList<FinGroup>();
	private ArrayList<Expense> expenses = new ArrayList<Expense>();
	
	public void createMockObjects(){
		User u1 = new User("Raul", "r", "123");
		User u2 = new User("Bruno", "b", "123");
		User u3 = new User("Allan", "a", "123");
		User u4 = new User("BrunoT", "bt", "123");
		
		ArrayList<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		
		ArrayList<User> payers = new ArrayList<User>();
		ArrayList<User> receivers = new ArrayList<User>();
		payers.add(u1);
		receivers.add(u2);
		receivers.add(u3);
		receivers.add(u4);
		
		ArrayList<User> payers1 = new ArrayList<User>();
		ArrayList<User> receivers1 = new ArrayList<User>();
//		payers1.add(u1);
		payers1.add(u2);
		receivers1.add(u2);
		receivers1.add(u3);
		receivers1.add(u4);
		
		Expense ex1 = new Expense(payers1, receivers1, 15.0, "Almoço");
		expenses.add(ex1);
		
		Expense ex = new Expense(payers, receivers, 15.0, "Breja");
		expenses.add(ex);
		
		FinGroup g = new FinGroup(users, expenses, "Trabalho");
		groups.add(g);
		
		ArrayList<User> users1 = new ArrayList<User>();
		users1.add(u2);
		users1.add(u3);
		users1.add(u4);
		
		FinGroup g1 = new FinGroup(users1, new ArrayList<>(), "USP");
		groups.add(g1);
	}
	
	public void updateTabs(Group grSelected, List listUsers, List listBalance, List listPayments, List listDebits, List listGroups){
		
		if(listGroups.getSelectionIndex()>=0){
			//GroupTitle update
			grSelected.setText(groups.get(listGroups.getSelectionIndex()).getName());
			
			//users tab update
			listUsers.removeAll();
			for (User u : groups.get(listGroups.getSelectionIndex()).getUsers()) {
				listUsers.add(u.getName());
			}
			
			//balances tab update
			listBalance.removeAll();
			HashMap<String, Double> balance = groups.get(listGroups.getSelectionIndex()).getBalances();
			
			for (String name : balance.keySet()) {
				listBalance.add(name+": R$ "+String.format("%.2f",balance.get(name)));
			}
			
			//payments tab update
			listPayments.removeAll();
			for (Expense e : groups.get(listGroups.getSelectionIndex()).getExpenses()) {
				listPayments.add(e.toString());
			}
			
			//debits tab update
			listDebits.removeAll();
			for (String s : groups.get(listGroups.getSelectionIndex()).getDebits()) {
				listDebits.add(s);
			}
		}
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		//mock objects
		createMockObjects();
		
		//test
		
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(700, 470);
		shell.setText("Gerenciador Financeiro");
		
		Group grAllGroups = new Group(shell, SWT.NONE);
		grAllGroups.setText("Seus Grupos");
		grAllGroups.setBounds(10, 34, 153, 141);
		
		List listGroups = new List(grAllGroups, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listGroups.setItems(new String[] {});
		listGroups.setBounds(10, 20, 133, 111);
		
		Group grSelected = new Group(shell, SWT.NONE);
		grSelected.setBounds(195, 34, 462, 306);
		
		TabFolder tabFolder = new TabFolder(grSelected, SWT.NONE);
		tabFolder.setBounds(10, 23, 442, 273);
		
		TabItem tabPayments = new TabItem(tabFolder, SWT.NONE);
		tabPayments.setText("Pagamentos");
		
		List listPayments = new List(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tabPayments.setControl(listPayments);
		
		TabItem tabDebits = new TabItem(tabFolder, SWT.NONE);
		tabDebits.setText("D\u00E9bitos");
		
		List listDebits = new List(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tabDebits.setControl(listDebits);
		
		TabItem tabUsers = new TabItem(tabFolder, SWT.NONE);
		tabUsers.setText("Usu\u00E1rios");
		
		List listUsers = new List(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tabUsers.setControl(listUsers);
		
		TabItem tabBalance = new TabItem(tabFolder, SWT.NONE);
		tabBalance.setText("Balan\u00E7o Geral");
		
		List listBalance = new List(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tabBalance.setControl(listBalance);
		
		Button btnAddDebt = new Button(shell, SWT.NONE);
		btnAddDebt.setBounds(512, 370, 145, 25);
		btnAddDebt.setText("Adiconar Pagamento");
		
		Button btnAddUser = new Button(shell, SWT.NONE);
		btnAddUser.setBounds(210, 370, 145, 25);
		btnAddUser.setText("Criar Usu\u00E1rio");
		
		Button btnNewGroup = new Button(shell, SWT.NONE);
		btnNewGroup.setBounds(361, 370, 145, 25);
		btnNewGroup.setText("Novo Grupo");
		
		//initializations
		//groups list
		for (FinGroup g : groups) {
			listGroups.add(g.getName());
		}
		listGroups.setSelection(0);
		
		updateTabs(grSelected, listUsers, listBalance, listPayments, listDebits, listGroups);
		
		//listeners
		listGroups.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent e) {
						// TODO Auto-generated method stub
						//updates the views on the tabs as another group is selected
						updateTabs(grSelected, listUsers, listBalance,listPayments, listDebits, listGroups);
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
		
		btnAddDebt.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				DialogAddExpense dialog = new DialogAddExpense(shell, groups.get(listGroups.getSelectionIndex()).getUsers());
				Expense expense = dialog.open();
				//if a expense was added, update the view and the group
				if(expense!=null){
					groups.get(listGroups.getSelectionIndex()).getExpenses().add(expense);
					updateTabs(grSelected, listUsers, listBalance,listPayments, listDebits, listGroups);
				}
					
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnAddUser.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				DialogCreateUser dialog = new DialogCreateUser(shell);
				User u = dialog.open();
				if(u!=null){
					groups.get(listGroups.getSelectionIndex()).getUsers().add(u);
					updateTabs(grSelected, listUsers, listBalance, listPayments, listDebits, listGroups);
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnNewGroup.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

	}
}
