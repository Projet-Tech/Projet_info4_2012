package fr.ujm.tse.info4.pgammon.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;

import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MonochromeLabel extends MonochromeButton{
	private static final long serialVersionUID = 1L;
	String text;
	JLabel label;
	public MonochromeLabel(){
		super();
	}

	public MonochromeLabel(String str) {

		super(str);
	
	}
}
