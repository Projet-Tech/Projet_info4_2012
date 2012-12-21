package fr.ujm.tse.info4.pgammon.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
/**
 * Composant de base pour les liste surchargé graphiquement.
 * @author Jean-Mi
 * @param <T> Classe correspondant aux élement représentés
 */
public class MonochromeListe<T> extends MonochromePanel{
	private static final long serialVersionUID = 1L;
	
	private Collection<T> ref;
	private Vector<T> elements;
	private JList<T> list;
	private JScrollPane scrollpane;
	
	/**
	 * Construit le composant
	 * @param titre : Titre de la fenetre
	 * @param liste : Liste d'élément a representer.
	 * @param cellRenderer : Element s'occupant du l'affichage des composants.
	 */
	public MonochromeListe(String titre, Collection<T> liste, ListCellRenderer<T> cellRenderer) {
		super(titre);
		setLayout(null);
		setOpaque(false);
		ref = liste;
		elements = new Vector<T>(ref);
		list = new JList<T>(elements);
		list.setCellRenderer(cellRenderer);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollpane = new JScrollPane(list);
		scrollpane.setBounds(0,0,getPreferredSize().width,getPreferredSize().height);

		list.setOpaque(false);
		scrollpane.setOpaque(false);
		add(scrollpane);

		setBackground(Color.BLACK);
		list.setBackground(Color.BLACK);
		scrollpane.setBackground(Color.BLACK);

		scrollpane.getViewport().setBackground(null);
		scrollpane.setOpaque(true);
		scrollpane.getViewport().setBorder(null);
		scrollpane.setBorder(null);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		scrollpane.setBounds(5,5+MonochromePanel.TITLE_HEIGHT,getBounds().width-10,getBounds().height-10-MonochromePanel.TITLE_HEIGHT);
		
		super.paintComponent(g);
	}
	
	/**
	 * Recupere la valeur selectionnée de la liste et la renvoie
	 * @return La valeur selectionnée de la liste
	 */
	public T getSelectedValue(){
		return list.getSelectedValue();
	}
	
	/**
	 * Renvoie le composant JList associé a la liste a des fins d'écoute.
	 * @return La Jlist associée
	 */
	public JList<T> getList(){
		return list;
	}
	
	/**
	 * Change les données.
	 * @param listData : nouvelle collection
	 */
	public void setListDatas(Collection<T> listData){
		ref = listData;
		elements = new Vector<T>(ref);
		list.setListData(elements);
		updateUI();
	}
	
	/**
	 * Met a jour la liste apres un changement a partir du CellRenderer correspondant
	 * @param nouveau CellRenderer correspondant
	 */
	public void updateList(ListCellRenderer<T> cr){
		elements = new Vector<T>(ref);
		list.setListData(elements);
		list.setCellRenderer(cr);
		list.repaint();
	}
	
}
