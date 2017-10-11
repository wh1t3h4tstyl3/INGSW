package af.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class StartBoard extends JPanel implements ItemListener, ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel cards; // a panel that uses CardLayout
	final static String BMWPANEL = "BMW";
	final static String FIATPANEL = "FIAT";
	final static String CITROENPANEL = "CITROEN";
	
	private AbstractFactory factory;
	
	private JButton berlina;
	private JButton utilitaria;
	private JButton suv;
	
	private JButton utilitaria1;
	private JButton utilitaria2;
	private JButton utilitaria3;
	private JButton suv1;
	private JButton suv2;
	private JButton berlina1;
	private JButton berlina2;
	
	private String brand;
	
	public StartBoard() {
		super(new GridLayout(2, 1));
		brand = "BMW";
		factory = new BMWFactory();
		addComponentToPane();
	}
	
	public void addComponentToPane() {
		//Put the JComboBox in a JPanel to get a nicer look.
				JPanel comboBoxPane = new JPanel(); //use FlowLayout
				String comboBoxItems[] = { BMWPANEL, FIATPANEL, CITROENPANEL };
				JComboBox<Object> cb = new JComboBox<Object>(comboBoxItems);
				cb.setEditable(false);
				cb.addItemListener(this);
				comboBoxPane.add(cb);

				//Create the "cards".
				JPanel card1 = new JPanel();
				berlina = new JButton("BERLINA");
				berlina.addActionListener(this);
				card1.add(berlina);
				utilitaria = new JButton("UTILITARIA");
				utilitaria.addActionListener(this);
				card1.add(utilitaria);
				suv = new JButton("SUV");
				suv.addActionListener(this);
				card1.add(suv);
				
				JPanel card2 = new JPanel();
				utilitaria1 = new JButton(factory.makeStringUtilitaria1());
				card2.add(utilitaria1);
				utilitaria2 = new JButton(factory.makeStringUtilitaria2());
				card2.add(utilitaria2);
				utilitaria3 = new JButton(factory.makeStringUtilitaria3());
				card2.add(utilitaria3);
				
				JPanel card3 = new JPanel();
				suv1 = new JButton(factory.makeStringSuv1());
				card3.add(suv1);
				suv2 = new JButton(factory.makeStringSuv2());
				card3.add(suv2);
				
				JPanel card4 = new JPanel();
				berlina1 = new JButton(factory.makeStringBerlina1());
				card4.add(berlina1);
				berlina2 = new JButton(factory.makeStringBerlina2());
				card4.add(berlina2);
				
				//Create the panel that contains the "cards".
				cards = new JPanel(new CardLayout());
				cards.add(card1, "TYPES");
				cards.add(card2, "UTILITARIE");
				cards.add(card3, "SUV");
				cards.add(card4, "BERLINA");
				
				setPreferredSize(new Dimension(1366, 768));
				add(comboBoxPane);
				add(cards);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		brand = (String) e.getItem();
		if(brand.equals(BMWPANEL)) factory = new BMWFactory();
		
		else if(brand.equals(FIATPANEL)) factory = new FIATFactory();
		
		else if(brand.equals(CITROENPANEL)) factory = new CITROENFactory();
		
		utilitaria1.setText(factory.makeStringUtilitaria1());
		utilitaria2.setText(factory.makeStringUtilitaria2());
		utilitaria3.setText(factory.makeStringUtilitaria3());
		
		suv1.setText(factory.makeStringSuv1());
		suv2.setText(factory.makeStringSuv2());
		
		berlina1.setText(factory.makeStringBerlina1());
		berlina2.setText(factory.makeStringBerlina2());
		
		CardLayout c = (CardLayout) cards.getLayout();
		c.show(cards, "TYPES");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == berlina ) {
			CardLayout c = (CardLayout) cards.getLayout();
			c.show(cards, "BERLINA");
		}
		
		else if(e.getSource() == utilitaria ) {
			CardLayout c = (CardLayout) cards.getLayout();
			c.show(cards, "UTILITARIE");
			if(brand.equals(BMWPANEL)) {
				utilitaria1.setVisible(false);
				utilitaria3.setVisible(false);
			}
			else {
				utilitaria1.setVisible(true);
				utilitaria3.setVisible(true);
			}
		}
		
		else if(e.getSource() == suv ) {
			CardLayout c = (CardLayout) cards.getLayout();
			c.show(cards, "SUV");
		}
	
	}
}
