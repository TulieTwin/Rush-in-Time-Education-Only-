package levels;

public class Level {
    private int[][] levelData;

    public Level(int[][] lvlData) {
	this.levelData = lvlData;
    }

    public int[][] getLevelData() {
	return levelData;
    }
}
