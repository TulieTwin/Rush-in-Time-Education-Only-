package main;

import inputs.keyBoardInput;
import inputs.mouseInput;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import static main.Game.GAME_WIDTH;
import static main.Game.GAME_HEIGHT;

public class gamePanel extends JPanel{
    private mouseInput mouseInput;
    private Game game;
    
    public gamePanel(Game game){
        this.game = game;
        setPanelSize();
        mouseInput = new mouseInput(this);
        addKeyListener(new keyBoardInput(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }
    
    private void setPanelSize(){
        Dimension size = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        setPreferredSize(size);
    }
    public void updateGame(){
        
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }
    
    public Game getGame(){
        return game;
    }
}
