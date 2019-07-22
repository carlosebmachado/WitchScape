package com.bakerystudios.entities;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.bakerystudios.engine.Updateble;
import com.bakerystudios.game.Game;

public class Boy extends Entity implements Updateble {
	
	public boolean enter;
	public boolean event;
	
	private ArrayList[] esqueletoDialogue;
	private Anotacao anotacaoDialogue;

	@SuppressWarnings("unchecked")
	public Boy(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		ArrayList[] esqueletoDialogue = new ArrayList[3];
		for (int i = 0; i < esqueletoDialogue.length; i++)
			esqueletoDialogue[i] = new ArrayList<String>();
		esqueletoDialogue[0].add("Oi mo�o!");
		esqueletoDialogue[0].add("Voc� poderia me ajduar?");
		esqueletoDialogue[1].add("Eu estava brincando aqui com minha bola,");
		esqueletoDialogue[1].add("Mas sem querer deixei ela cair no cercado");
		esqueletoDialogue[1].add("dessa senhora, e ela n�o quer me devolver...");
		esqueletoDialogue[2].add("Nossa, voc� � muito gentil!!!");
		esqueletoDialogue[2].add("Vou ficar esperando aqui.");
		anotacaoDialogue = new Anotacao(0, 600, 0, 0, null, true, esqueletoDialogue);
	}

	@Override
	public void update() {
		if(x == Game.player.getX() && y + 16 == Game.player.getY() && Game.player.getDir() == Game.player.UP_DIR) {
			if(enter) {
				event = true;
			}
		}
		
	}

	public boolean isEnter() {
		return enter;
	}

	public void setEnter(boolean enter) {
		this.enter = enter;
	}

	public boolean isEvent() {
		return event;
	}

	public void setEvent(boolean event) {
		this.event = event;
	}
	
}
