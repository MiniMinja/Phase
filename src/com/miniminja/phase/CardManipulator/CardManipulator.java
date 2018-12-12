package com.miniminja.phase.CardManipulator;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

import com.miniminja.ImageManipulator.*;

public class CardManipulator {
	private static final String default_alphabet_path = "Alphabet/Alphabet.png";
	private static final String default_card_path = "CardFiles";
	private static final int title_size = 8;
	private static final double[] title_rect = {40/ 100., 35 / 100., 200, 100};
	private static final int desc_size = 6;
	private static final double[] desc_rect = {35 / 100., 60 /100., 400, 200};
	private static BufferedImage card_default = ImageGrabber.getImage(default_card_path+"/CardTemplate.png");
	
	
	public static BufferedImage applyText(String filePath, ArrayList<Integer> nums) {
		TextManipulator.setChars(default_alphabet_path);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(default_card_path+"/"+filePath));
			String title = br.readLine();
			String desc = br.readLine();
			while(desc.indexOf("%") != -1) desc = desc.replaceFirst("%", nums.remove(0)+"");
			
			BufferedImage ret = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
			Graphics g = ret.getGraphics();
			g.drawImage(card_default, 0, 0, ret.getWidth(), ret.getHeight(), null);
			g.setColor(Color.black);
			TextManipulator.drawTextBox(g, title, title_size, 
					(int) (ret.getWidth() * title_rect[0]), (int) (ret.getWidth() * title_rect[1]),
					(int) title_rect[2], (int) title_rect[3]);
			//g.drawRect((int) (ret.getWidth() * title_rect[0]), (int) (ret.getWidth() * title_rect[1]), (int) title_rect[2], (int) title_rect[3]);
			TextManipulator.drawTextBox(g, desc, desc_size,
					(int) (ret.getWidth() * desc_rect[0]), (int) (ret.getWidth() * desc_rect[1]),
					(int) desc_rect[2], (int) desc_rect[3]);
			//g.drawRect((int) (ret.getWidth() * desc_rect[0]), (int) (ret.getWidth() * desc_rect[1]), (int) desc_rect[2], (int) desc_rect[3]);
			br.close();
			return ret;
			
		} catch (IOException e) {
			System.out.println("Some Error with closing BufferedReader");
			return null;
		}
	}
}
