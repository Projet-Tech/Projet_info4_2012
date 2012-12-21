package fr.ujm.tse.info4.pgammon.gui;

import javax.swing.JLabel;

/**
 * Extention du label du design.
 * @author Jean-Mi
 *
 */
public class MonochromeLabel extends MonochromeButton{
	private static final long serialVersionUID = 1L;
	String text;
	JLabel label;

	/**
	 * Nouveau MonochromeLabel.
	 */
	public MonochromeLabel(){
		super();
	}
	/**
	 * Nouveau MonochromeLabel.
	 * @param str text contenu.
	 */
	public MonochromeLabel(String str) {
		super(str);
	}
}
