package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import main.gamePanel;
import gamestates.Gamestate;

public class mouseInput implements MouseListener,MouseMotionListener {
    private gamePanel gamePanel;
    public mouseInput(gamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        switch(Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().mouseClicked(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().mouseClicked(e);
                break;
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        //
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        //
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        //
    }
    @Override
    public void mouseExited(MouseEvent e) {
        //
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        //
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }  
}
