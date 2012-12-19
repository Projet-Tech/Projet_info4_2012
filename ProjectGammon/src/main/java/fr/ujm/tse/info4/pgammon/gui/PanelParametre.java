package fr.ujm.tse.info4.pgammon.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fr.ujm.tse.info4.pgammon.controleur.ControleurIntermediairePartie;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;

public class PanelParametre extends MonochromePanel{
	
	private static final long serialVersionUID = -4599011779523529733L;
	
	private MonochromeIconButton plus_partie;
	private MonochromeIconButton moins_partie;
	private MonochromeIconButton infinite_partie;
	private MonochromeIconButton plus_temps;
	private MonochromeIconButton moins_temps;
	private MonochromeIconButton infinite_temps;
	
	public static final String imgparties 	= "images/parties.png";
	public static final String imgtime 	= "images/time.png";

	private ImageIcon iconeparties;
	private ImageIcon iconetime;
	
	private MonochromeLabel lab_parties;
	private MonochromeLabel lab_temps;
	
	private JLabel text_parties;
	private JLabel text_temps;
	
	private MonochromeCheckbox videau;
	
	
	private int nbParties;
	private int nbTemps;

	public PanelParametre(){
		super("Paramètres");
		
		build();
		
	}
	
	public void build(){
		
		//récupération de l'image
		try{
			iconeparties = new ImageIcon(imgparties);
			iconetime = new ImageIcon(imgtime);
		}catch(Exception err){
			System.err.println(err);
		}
		
		nbParties = 3;
		nbTemps = 0;
		
		text_parties = new JLabel();
		text_parties.setText("nombre de partie pour la session");
		text_parties.setForeground(new Color(0xCCCCCC));
		text_parties.setBounds(20, 30, 300, 50);
		add(text_parties);
		
		text_temps = new JLabel();
		text_temps.setText("limitation du temps par tour en seconde");
		text_temps.setForeground(new Color(0xCCCCCC));
		text_temps.setBounds(20, 150, 300, 50);
		add(text_temps);
		
		lab_parties = new MonochromeLabel(new Integer(nbParties).toString());
		lab_parties.setBounds(80, 80, 80, 40);
		add(lab_parties);
		
		lab_temps = new MonochromeLabel(new Integer(nbTemps).toString());
		lab_temps.setBounds(80, 200, 80, 40);
		add(lab_temps);
		
		
			plus_partie = new MonochromeIconButton(IconMonochromeType.SMALL_PLUS,"MonochromeIconButton","NOIR");
			plus_partie.setSizeSmall();
			plus_partie.setBounds(180, 80, plus_partie.getPreferredSize().width, plus_partie.getPreferredSize().height);
			add(plus_partie);
	
			moins_partie = new MonochromeIconButton(IconMonochromeType.SMALL_MOINS,"MonochromeIconButton","NOIR");
			moins_partie.setSizeSmall();
			moins_partie.setBounds(230, 80, moins_partie.getPreferredSize().width, moins_partie.getPreferredSize().height);
			add(moins_partie);

			infinite_partie = new MonochromeIconButton(IconMonochromeType.SMALL_INFINITE,"MonochromeIconButton","NOIR");
			infinite_partie.setSizeSmall();
			infinite_partie.setBounds(280, 80, infinite_partie.getPreferredSize().width, infinite_partie.getPreferredSize().height);
			add(infinite_partie);
			
			plus_temps = new MonochromeIconButton(IconMonochromeType.SMALL_PLUS,"MonochromeIconButton","NOIR");
			plus_temps.setSizeSmall();
			plus_temps.setBounds(180, 200, plus_temps.getPreferredSize().width, plus_temps.getPreferredSize().height);
			add(plus_temps);
			
			
			moins_temps = new MonochromeIconButton(IconMonochromeType.SMALL_MOINS,"MonochromeIconButton","NOIR");
			moins_temps.setSizeSmall();
			moins_temps.setBounds(230, 200, moins_temps.getPreferredSize().width, moins_temps.getPreferredSize().height);
			add(moins_temps);
			
			
			infinite_temps = new MonochromeIconButton(IconMonochromeType.SMALL_INFINITE,"MonochromeIconButton","NOIR");
			infinite_temps.setSizeSmall();
			infinite_temps.setBounds(280, 200, infinite_temps.getPreferredSize().width, infinite_temps.getPreferredSize().height);
			add(infinite_temps);
			
			videau = new MonochromeCheckbox("Utiliser le videau");
			videau.setBounds(100, 270, 150, 50);
			add(videau);
			
			listenerplus_partie();
			listenermoins_partie();
			listenerinfinite_partie();
			listenerplus_Temps();
			listenermoins_Temps();
			listenerinfinite_Temps();
			
			
	}
	
	public void changerValeurNbTemps(int i){
		if(i == 0){
			lab_temps.setText("\u221E");
		}else{
			lab_temps.setText(new Integer(i).toString());
		}
		
	}
	
	private void listenerplus_Temps()
	{
		plus_temps.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}		
			@Override
			public void mouseExited(MouseEvent e) {}			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				nbTemps ++;
				changerValeurNbTemps(nbTemps);
			}
		});
	}
	
	private void listenermoins_Temps()
	{
		moins_temps.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}		
			@Override
			public void mouseExited(MouseEvent e) {}			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nbTemps > 1){
					nbTemps --;
					changerValeurNbTemps(nbTemps);
				}
			}
		});
	}
	
	private void listenerinfinite_Temps()
	{
		infinite_temps.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}		
			@Override
			public void mouseExited(MouseEvent e) {}			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				nbTemps = 0;
				changerValeurNbTemps(nbTemps);
			}
		});
	}
	
	
	public void changerValeurNbPartie(int i){
		if(i == 0){
			lab_parties.setText("\u221E");
		}else{
			lab_parties.setText(new Integer(i).toString());
		}
		
		
	}
	
	private void listenerplus_partie()
	{
		plus_partie.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}		
			@Override
			public void mouseExited(MouseEvent e) {}			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				nbParties ++;
				changerValeurNbPartie(nbParties);
			}
		});
	}
	
	private void listenermoins_partie()
	{
		moins_partie.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}		
			@Override
			public void mouseExited(MouseEvent e) {}			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nbParties > 1){
					nbParties --;
					changerValeurNbPartie(nbParties);
				}
			}
		});
	}
	
	private void listenerinfinite_partie()
	{
		infinite_partie.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}		
			@Override
			public void mouseExited(MouseEvent e) {}			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				nbParties = 0;
				changerValeurNbPartie(nbParties);
			}
		});
	}
	
	
	
	public int getNbParties() {
		return nbParties;
	}

	public int getNbTemps() {
		return nbTemps;
	}

	public MonochromeIconButton getPlus_partie() {
		return plus_partie;
	}

	public void setPlus_partie(MonochromeIconButton plus_partie) {
		this.plus_partie = plus_partie;
	}

	public MonochromeIconButton getMoins_partie() {
		return moins_partie;
	}

	public void setMoins_partie(MonochromeIconButton moins_partie) {
		this.moins_partie = moins_partie;
	}

	public MonochromeIconButton getInfinite_partie() {
		return infinite_partie;
	}

	public void setInfinite_partie(MonochromeIconButton infinite_partie) {
		this.infinite_partie = infinite_partie;
	}

	public MonochromeIconButton getPlus_temps() {
		return plus_temps;
	}

	public void setPlus_temps(MonochromeIconButton plus_temps) {
		this.plus_temps = plus_temps;
	}

	public MonochromeIconButton getMoins_temps() {
		return moins_temps;
	}

	public void setMoins_temps(MonochromeIconButton moins_temps) {
		this.moins_temps = moins_temps;
	}

	public MonochromeIconButton getInfinite_temps() {
		return infinite_temps;
	}

	public void setInfinite_temps(MonochromeIconButton infinite_temps) {
		this.infinite_temps = infinite_temps;
	}

	public MonochromeLabel getLab_parties() {
		return lab_parties;
	}

	public void setLab_parties(MonochromeLabel lab_parties) {
		this.lab_parties = lab_parties;
	}

	public MonochromeLabel getLab_temps() {
		return lab_temps;
	}

	public void setLab_temps(MonochromeLabel lab_temps) {
		this.lab_temps = lab_temps;
	}

	public JLabel getText_parties() {
		return text_parties;
	}

	public void setText_parties(JLabel text_parties) {
		this.text_parties = text_parties;
	}

	public JLabel getText_temps() {
		return text_temps;
	}

	public void setText_temps(JLabel text_temps) {
		this.text_temps = text_temps;
	}

	public MonochromeCheckbox getVideau() {
		return videau;
	}

	public void setVideau(MonochromeCheckbox videau) {
		this.videau = videau;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(iconeparties.getImage(),20,75,this);
		g.drawImage(iconetime.getImage(),20,194,this);
	}

}
