package com.hatchetstudios.inventario;

import java.awt.Color;
import java.awt.Graphics;

import com.hatchetstudios.engine.Renderable;
import com.hatchetstudios.engine.Updateble;
import com.hatchetstudios.entities.Player;
import com.hatchetstudios.game.Game;
import com.hatchetstudios.game.GameState;
import com.hatchetstudios.game.screen.Screen;
import com.hatchetstudios.gui.TextBox;

public class Inventario implements Renderable, Updateble {

	private int numSlots = 3;
	private int widthSlot = 64;
	private int widthInventario = numSlots * widthSlot;
	private int initialPosition = (Screen.SCALE_WIDTH / 2) - (widthInventario / 2);
	private int widthImageSlot = 50;

	public static Slot[] slot;

	public static int selectedItem = 0;
	public static boolean status = true;
	public static boolean visible = true;
	public static boolean focus = true;

	public Inventario() {
		slot = new Slot[numSlots];
		for (int i = 0; i < slot.length; i++)
			slot[i] = new Slot();
	}

	public void update() {

	}

	protected void drawCentralizedString(Graphics g, String str, int y) {
		g.drawString(str, Screen.SCALE_WIDTH / 2 - g.getFontMetrics().stringWidth(str) / 2, y);
	}

	protected void fillCentralizedRect(Graphics g, int y, int width, int height) {
		g.fillRect(Screen.SCALE_WIDTH / 2 - width / 2, y, width, height);
	}

	public void render(Graphics g) {
		if (GameState.state == GameState.PLAYING && visible && (!Player.inEvent || Game.uiChest)) {
			int numberMagic = 100;
			Color db = new Color(111, 83, 39);
			Color lb = new Color(190, 163, 115);

			g.setFont(Game.boxFont);

			// g.setColor(db);
			// fillCentralizedRect(g, 570, 500, 130);
			// g.setColor(lb);
			// fillCentralizedRect(g, 575, 490, 120);

			g.setColor(Color.BLACK);
			TextBox.showPopUp(g, Game.boxFont, 570, slot[selectedItem].getShortName(), null);
			// drawCentralizedString(g, "Exemplo de nome de item.", 605);

			g.setFont(Game.inventFont);
			for (int i = 0; i < numSlots; i++) {
				g.setColor(db);
				g.drawRect(initialPosition + i * widthSlot, Screen.SCALE_HEIGHT - numberMagic, widthSlot, widthSlot);
				g.setColor(lb);
				g.fillRect(initialPosition + i * widthSlot + 1, Screen.SCALE_HEIGHT - numberMagic + 1, widthSlot - 1,
						widthSlot - 1);

				g.setColor(Color.BLACK);
				g.drawString(Integer.toString(slot[i].getAmount()), initialPosition + i * widthSlot + widthSlot - 16,
						Screen.SCALE_HEIGHT - numberMagic + widthSlot - 4);
				if (slot[i].getIdentity() != "") {
					g.drawImage(slot[i].getImageSlot(), initialPosition + i * widthSlot + 7,
							Screen.SCALE_HEIGHT - numberMagic, widthImageSlot, widthImageSlot, null);
				}
			}
			// ITEM SELECIONADO
			if (focus) {
				g.setColor(Color.BLACK);
				g.drawRect(initialPosition + selectedItem * widthSlot, Screen.SCALE_HEIGHT - numberMagic, widthSlot,
						widthSlot);
				g.setColor(lb);
				g.fillRect(initialPosition + selectedItem * widthSlot + 1, Screen.SCALE_HEIGHT - numberMagic + 1,
						widthSlot - 1, widthSlot - 1);
				g.setColor(Color.BLACK);
				g.drawString(Integer.toString(slot[selectedItem].getAmount()),
						initialPosition + selectedItem * widthSlot + widthSlot - 16,
						Screen.SCALE_HEIGHT - numberMagic + widthSlot - 4);
				if (slot[selectedItem].getIdentity() != "") {
					g.drawImage(slot[selectedItem].getImageSlot(), initialPosition + selectedItem * widthSlot + 7,
							Screen.SCALE_HEIGHT - numberMagic, widthImageSlot, widthImageSlot, null);
				}
			}
			if (Warehouse.exchangeInventory) {
				g.setColor(Color.RED);
				g.drawRect(initialPosition + selectedItem * widthSlot, Screen.SCALE_HEIGHT - numberMagic, widthSlot,
						widthSlot);
				g.setColor(lb);
				g.fillRect(initialPosition + selectedItem * widthSlot + 1, Screen.SCALE_HEIGHT - numberMagic + 1,
						widthSlot - 1, widthSlot - 1);
				g.setColor(Color.BLACK);
				g.drawString(Integer.toString(slot[selectedItem].getAmount()),
						initialPosition + selectedItem * widthSlot + widthSlot - 16,
						Screen.SCALE_HEIGHT - numberMagic + widthSlot - 4);
				if (slot[selectedItem].getIdentity() != "") {
					g.drawImage(slot[selectedItem].getImageSlot(), initialPosition + selectedItem * widthSlot + 7,
							Screen.SCALE_HEIGHT - numberMagic, widthImageSlot, widthImageSlot, null);
				}
			}
		}

	}
	
	public int getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(int value) {
		selectedItem = value;
	}
	
	public int getNumSlots() {
		return numSlots;
	}

	public int getWidthImageSlot() {
		return widthImageSlot;
	}

	public void setWidthImageSlot(int widthImageSlot) {
		this.widthImageSlot = widthImageSlot;
	}

}
