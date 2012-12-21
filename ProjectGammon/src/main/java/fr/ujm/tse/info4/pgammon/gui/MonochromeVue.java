package fr.ujm.tse.info4.pgammon.gui;

import java.util.SortedSet;

import javax.swing.JPanel;

public class MonochromeVue extends JPanel {
	private static final long serialVersionUID = -5240761849241606403L;
	private JPanel animationPanel;
	
	public MonochromeVue() {
		build();
	}
	
	private void build(){
		this.setLayout(null);
		animationPanel = new JPanel();
		animationPanel.setLayout(null);
		animationPanel.setBounds(0,0,800,600);
		animationPanel.setOpaque(false);
		add(animationPanel);
	}


	private void setAnimation(TranstionAnimeeBase animation){
		animation.setBounds(animationPanel.getBounds());
		animationPanel.removeAll();
		animationPanel.add(animation);
	}
	
	/**
	 * Affiche une transition avec les textes en parametres
	 * @param titre Texte du bandeau principal
	 * @param text Texte de l'exterieur
	 */
	public void afficherTransition(String titre, String text){
		ChangementTourAnimation tourAnimation = new ChangementTourAnimation(titre, text);
		tourAnimation.start();
		setAnimation(tourAnimation);
	}
	
	/**
	 * Affiche une fenetre avec des boutons permetant d'interagir avec l'utilisateur
	 * @param titre Texte principal
	 * @param reponses Liste des labels des boutons
	 * @return renvoie la FenetreDemandeAnimationBase créé. Ce composant peut etre
	 * écouté pour les retours
	 */
	public FenetreDemandeAnimationBase afficherFenetreDemande(String titre,SortedSet<String> reponses){
		FenetreDemandeAnimationBase fenetreDemande = new FenetreDemandeAnimationBase(titre,reponses);
		setAnimation(fenetreDemande);
		fenetreDemande.start();
		return fenetreDemande;
	}
	
	/**
	 * Affiche une fenetre simple permetant d'informer l'utilisateur
	 * @param titre Texte principal
	 * @param subTitle Sous description
	 * @return renvoie la FenetreDemandeAnimationBase créé. Ce composant peut etre
	 * écouté pour la fermeture de la fenetre
	 */
	public FenetreDemandeAnimationBase afficherFenetreDemande(String titre,String subTitle){
		FenetreDemandeAnimationBase fenetreDemande = new FenetreDemandeAnimationBase(titre,subTitle);
		setAnimation(fenetreDemande);
		fenetreDemande.start();
		return fenetreDemande;
	}
}
