package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Game;
import utilz.LoadSave;

public class LevelManager {
    private Game game;
    private BufferedImage levelCastle;
    private Level levelCastleSolid;

    public LevelManager(Game game) {
	this.game = game;
        levelCastle = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_CASTLE);
        levelCastleSolid = new Level(LoadSave.GetLevelAccess(LoadSave.LEVEL_CASTLE_SOLID));
    }
    
    public void draw(Graphics g) {
        g.drawImage(levelCastle, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
    }
    public void update() {

    }
    public Level getCurrentLevel() {
	return levelCastleSolid;
    }
}
