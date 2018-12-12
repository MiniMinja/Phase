package com.miniminja.phase;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

import com.miniminja.phase.CardManipulator.CardManipulator;

import Mindow.*;

public class CardTester {
	
	public static class CardDrawer extends Drawer{

		public void draw(Graphics g) {
			
		}

		public void tick() {
			
		}
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1));
		BufferedImage newCard = CardManipulator.applyText("CardDefault.cf", nums);
		Mindow m = Mindow.getDefault();
		Drawer.setDrawer(new CardDrawer() {
			public void draw(Graphics g) {
				g.drawImage(newCard, 0, 0, 100, 100, null);
			}
		});
		Thread job = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(12);
					m.render();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		job.start();
	}
}
