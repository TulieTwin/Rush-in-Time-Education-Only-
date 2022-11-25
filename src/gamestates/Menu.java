package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class Menu extends State implements Statemethods{
    private BufferedImage menuBG;
    private Font font;
    public Menu(Game game){
	super(game);
    }
    @Override
    public void update() {

    }
    @Override
    public void draw(Graphics g) {
        menuBG = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_BG);
        g.drawImage(menuBG, 0, 0,Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
	g.setColor(Color.white);
        g.drawString("Press Enter to Start", 310, 500);
        font = new Font("SansSerif",Font.BOLD,22);
        g.setFont(font);
	g.drawString("RUSH IN TIME", 275, 200);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_ENTER)
		Gamestate.state = Gamestate.PLAYING;
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
