package fr.ujm.tse.info4.pgammon.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AvatarList extends JPanel{
	private static final long serialVersionUID = 4047846163448859090L;
	private OpaqueBG bg;
	
	public AvatarList() {
		build();
	}

	private void build() {
		setPreferredSize(new Dimension(450,350));
		setOpaque(false);
		setLayout(null);
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(0,3,10,10));
		pane.setOpaque(false);
		
		JScrollPane scroll = new JScrollPane(pane);
		scroll.setBounds(0,0,getPreferredSize().width,getPreferredSize().height - 50);
		scroll.getViewport().setBackground(new Color(0x000000));
		scroll.setBorder(null);
		scroll.setBounds(200,100,450,276);
		
		for(Avatar avatar : Avatar.values()){
			ImageAvatar img = new ImageAvatar(avatar,true);
			img.setPreferredSize(new Dimension(128,128));
			pane.add(img);
			img.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispatchEvent(e);close();}
			});
		}
		
		MonochromeButton closeBtn = new MonochromeButton("Annuler");
		closeBtn.setBounds(450, 400, 200, 40);
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {close();}
		});
		bg = new OpaqueBG();
		bg.setBounds(getBounds());

		add(closeBtn);
		add(scroll);
		add(bg);
	}
	
	public void close(){
		setVisible(false);
	}
	
	@Override
	public void setPreferredSize(Dimension preferredSize) {
		super.setPreferredSize(preferredSize);
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		bg.setBounds(0,0, width, height);
	}

	
}
