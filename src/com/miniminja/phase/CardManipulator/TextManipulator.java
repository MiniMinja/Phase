package com.miniminja.phase.CardManipulator;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TextManipulator {
	public static String textPath = "Alphabet/Alphabet.png";
	public static int chars = 46;
	public static int[] text_dimensions = {6, 9};
	public static char[] quickConversion = {
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9', '!', ',', '.', '\'', '\"',
			':', '-', '#', '(', ')'
	};
	public static BufferedImage[] charas = getChars();
	
	public static BufferedImage[] getChars() {
		BufferedImage[] charas = new BufferedImage[chars];
		BufferedImage spread = CardManipulator.getImage(textPath);
		int index = 0;
		//45x48
		for(int i = 0;i<spread.getHeight() / text_dimensions[1];i++) {
			for(int j = 0;j<spread.getWidth() / text_dimensions[0];j++) {
				BufferedImage subImage = new BufferedImage(text_dimensions[0], text_dimensions[1], BufferedImage.TYPE_INT_ARGB);
				Graphics g = subImage.getGraphics();
				g.drawImage(spread.getSubimage(j * text_dimensions[0], i * text_dimensions[1], text_dimensions[0], text_dimensions[1]), 0, 0, null);
				System.out.println(index);
				charas[index++] = subImage;
				if(index >= chars) return charas;
			}
		}
		return charas;
	}
	public static void drawTextBox(Graphics g, String text, int scale, int x, int y, int width, int height) {
		text = text.toLowerCase();
		StringTokenizer st = new StringTokenizer(text);
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics textG = image.getGraphics();
		int row = 0;
		{
			StringBuilder sb = new StringBuilder();
			String toAdd = st.nextToken();
			char[] carr = sb.toString().toCharArray();
			for(int j = 0;j<carr.length;j++) {
				char c = carr[j];
				if(c == ' ') continue;
				textG.drawImage(getText(c), j * text_dimensions[0] * scale, row * text_dimensions[1] * scale, text_dimensions[0] * scale, text_dimensions[1] * scale, null);
			}
			row++;
			sb = new StringBuilder(toAdd +" ");
		}    
		g.drawImage(image, x, y, null);
	}
	
	public static BufferedImage getText(char c) {
		int index = 0;
		while(quickConversion[index] != c) index++;
		return charas[index];
	}
}
