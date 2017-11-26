package ingsw.observer;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ProductsList extends JFrame implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Store store;
	private JList<Product> pList;
	private JScrollPane scrollPane;
	
	public ProductsList(Store store) {
		this.store = store;
		pList = new JList<>();
		pList.setLayoutOrientation(JList.VERTICAL);
		pList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.store.subscribeObserver(this);
		readData();
		initWindow();
	}
	
	private void readData() {
		DefaultListModel<Product> model = new DefaultListModel<>();
		for(ingsw.observer.Type type : store.getProducts().keySet()) {
			Product p = new Product();
			p.setModel("");
			p.setName(type.toString());
			model.addElement(p);
			for(Product product : store.getProducts().get(type)) {
				model.addElement(product);
				p.setPrice(p.getPrice() + product.getPrice()*product.getAmount());
				p.add(product.getAmount());
			}
		}
		
		pList.setModel(model);
	}

	private void initWindow() {
		setResizable(false);
		setTitle("Products List");
		scrollPane = new JScrollPane(pList);
		add(scrollPane);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void update(Subject subject) {
		if(store == subject) {
			readData();
		}
	}
	
	@Override
	public void setVisible(boolean b) {
		if(!b) store.unSubscribeObserver(this);
		else
			store.subscribeObserver(this);
		super.setVisible(b);
	}
	
	public Product selected() {
		return pList.getSelectedValue();
	}
}
