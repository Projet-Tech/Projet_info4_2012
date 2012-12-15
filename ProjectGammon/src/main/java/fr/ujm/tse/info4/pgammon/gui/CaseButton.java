package fr.ujm.tse.info4.pgammon.gui;

import javax.swing.JButton;

import fr.ujm.tse.info4.pgammon.models.Case;

public class CaseButton extends JButton{
	private static final long serialVersionUID = 6276324191590405443L;
	private Case c;
	/**
	 * @param _case Case a associer au bouton.
	 */
	public CaseButton(Case _case){
		c = _case;
	}

	
	
	/**
	 * 
	 * @return Renvoie la Case associée
	 */
	public Case getCase() {
		return c;
	}

	public void setCase(Case _case) {
		c = _case;
	}
	
}
