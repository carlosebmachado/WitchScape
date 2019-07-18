package com.bakerystudios.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.bakerystudios.entities.EventManager;
import com.bakerystudios.entities.Player;
import com.bakerystudios.game.GameState;
import com.bakerystudios.gui.menu.MainMenu;
import com.bakerystudios.gui.menu.MenuState;

public class MenuInput extends Input {

	@Override
	public void keyPressed(KeyEvent e) {
		// BASIC KEYS
		// ---------------------------------------------------------------------
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {

		}

		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			if (GameState.state == GameState.MENU) {
				
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			if (GameState.state == GameState.MENU) {
				
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (GameState.state == GameState.MENU) {
				MainMenu.enter = true;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (GameState.state == GameState.PLAYING && !Player.inEvent) {
				EventManager.esc = true;
				GameState.state = GameState.MENU;
				MenuState.state = MenuState.PAUSE;
			}
			if (GameState.state == GameState.MENU) {
				EventManager.esc = true;
				GameState.state = GameState.PLAYING;
			}
		}

		// OTHER KEYS
		// ---------------------------------------------------------------------

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// BASIC KEYS
		// ---------------------------------------------------------------------
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {

		}

		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			if (GameState.state == GameState.MENU) {
				
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			if (GameState.state == GameState.MENU) {
				
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (GameState.state == GameState.MENU) {
				
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if(GameState.state == GameState.PLAYING) {
				EventManager.esc = false;
			}
		}

		// OTHER KEYS
		// ---------------------------------------------------------------------

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
