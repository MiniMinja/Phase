package com.miniminja.phase.CardManipulator;

import java.awt.image.BufferedImage;

import com.miniminja.phase.Sprites.Caster;

public abstract class Card {
	private BufferedImage cardImage;
	private String title;
	private String desc;
	
	public Card(BufferedImage image, String title, String desc) {
		this.cardImage = image;
		this.title = title;
		this.desc = desc;
	}
	
	public BufferedImage getImage() {
		return cardImage;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return desc;
	}
	
	public abstract void action(Caster Caster);
}
