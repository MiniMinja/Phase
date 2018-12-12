package com.miniminja.phase.CardManipulator;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class CardManipulator {
	private static String default_card_path = "CardFiles";
	private static BufferedImage card_default = getImage(default_card_path+"/CardTemplate.png");
	
	public static BufferedImage getImage(String filePath) {
		BufferedImage ret = null;
		try { 
			ret = ImageIO.read(new File(filePath));
		}catch(IOException e) {
			System.out.println("Card not found!");
		}
		return ret;
	}
	
	public static BufferedImage applyText(String filePath, ArrayList<Integer> nums) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(default_card_path+"/"+filePath));
			String title = br.readLine();
			String desc = br.readLine();
			
			BufferedImage ret = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
			Graphics g = ret.getGraphics();
			g.drawImage(card_default, 0, 0, ret.getWidth(), ret.getHeight(), null);
			TextManipulator.drawTextBox(g, "abcde fghij klmno", 5, 200, 200, 300, 1000);
			br.close();
			return ret;
			
		} catch (IOException e) {
			System.out.println("Some Error with closing BufferedReader");
			return null;
		}
	}
}