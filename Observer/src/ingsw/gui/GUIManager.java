package ingsw.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ingsw.observer.Product;
import ingsw.observer.ProductsList;
import ingsw.observer.Store;
import ingsw.observer.Type;
import ingsw.state.DispatchManager;

public class GUIManager {

	private	ProductsList productList;
	private SellWindowMonitor sellWindowMonitor;
	private ManagerUI storeManager;
	private Store store;
	private DispatchManager dispatch; 
	private DispatchUI dispatchUI;
	
	public GUIManager() {
		initManager();
	}
	
	private  void initManager() {
	
		Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension d;
		
		store = new Store();
		dispatch = new DispatchManager();
		
		if(size.width < 1025)
			d = new Dimension(size.width/2, size.height/2);
		else
			d = new Dimension(size.width/4, size.height/6);
		
		storeManager = new ManagerUI(this);
		storeManager.setMinimumSize(d);
		storeManager.setLocation(size.width/2 - storeManager.getWidth()/2, size.height/2 - storeManager.getHeight()/2);
		
		productList = new ProductsList(store);
		productList.setMinimumSize(new Dimension(size.width/4, size.height/2));
		productList.setLocation(storeManager.getX() - productList.getWidth(), size.height/2 - productList.getHeight()/2);		
		
		sellWindowMonitor = new SellWindowMonitor(dispatch);
		sellWindowMonitor.setMinimumSize(new Dimension(size.width/4, size.height/2));
		sellWindowMonitor.setLocation(storeManager.getX()+storeManager.getWidth(), size.height/2 - sellWindowMonitor.getHeight()/2);
		sellWindowMonitor.setVisible(true);
	}
	
	public void addProduct(Product product) {
		store.addProduct(product);
	}	

	public void showList() {
		productList.setVisible(!productList.isVisible());
	}	
	
	public void showSellWindow() {
		sellWindowMonitor.setVisible(!sellWindowMonitor.isVisible());
	}

	public void removeObject() {

		if (productList.selected() != null && !productList.selected().getType().equals(Type.NONE)) {
			Integer[] items = new Integer[productList.selected().getAmount()];
			int i = 0;
			while (i < productList.selected().getAmount())
				items[i++] = i;
			JComboBox<Integer> amount = new JComboBox<>(items);

			JPanel myPanel = new JPanel(new GridLayout(0, 1));

			myPanel.add(new JLabel("Amount of " + productList.selected().getName() + " " + productList.selected().getModel() + " to sell:"));
			myPanel.add(amount);

			Object[] optionsE = { "Ok", "Cancel" };
			int selection = JOptionPane.showOptionDialog(null, myPanel, "Remove Product(s)", JOptionPane.YES_OPTION,
					JOptionPane.DEFAULT_OPTION, null, optionsE, optionsE[0]);
			if(selection == 0) {
				store.removeProduct(productList.selected(), (Integer)amount.getSelectedItem());
				dispatchUI = new DispatchUI(this);
				dispatchUI.setSize(storeManager.getSize());
				dispatchUI.setLocationRelativeTo(storeManager);
			}			
		}
		else {
			JOptionPane.showMessageDialog(null, "INVALID selection", "Remove Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	

	// for Dispatch Interface
	
	public void startDispatch() {
		dispatch.initialize();
	}
	
	public void process() {
		dispatch.work();
	}
	
	public void send() {
		dispatch.startShipment();
	}
	
	public void finalize() {
		dispatch.finalize();
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUIManager();
			}
		});
	}
}
