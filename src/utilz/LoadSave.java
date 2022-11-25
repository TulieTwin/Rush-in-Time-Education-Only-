package utilz;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

import main.Game;

public class LoadSave {
    public static final String PLAYER_ATLAS = "character.png";
    public static final String LEVEL_CASTLE = "map/Level.png";
    public static final String LEVEL_CASTLE_SOLID = "map/LevelSolid.text";
    public static final String LEVEL_BG = "map/Castle.png";

    public static BufferedImage GetSpriteAtlas(String fileName){
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/"+fileName);
        try{
            img = ImageIO.read(is);
            
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                is.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return img;
    }
    public static int[][] GetLevelAccess(String fileName) {
	int[][] lvlData = new int[Game.TILES_IN_WIDTH][Game.TILES_IN_HEIGHT];
        try{
            InputStream is = LoadSave.class.getResourceAsStream("/"+fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while(col<Game.TILES_IN_WIDTH && row<Game.TILES_IN_HEIGHT){
                String line = br.readLine();
                while(col < Game.TILES_IN_WIDTH){
                    String number[] = line.split(",");
                    int num = Integer.parseInt(number[col]);
                    if(num == -1){
                        num = 0;
                    }
                        lvlData[col][row] = num;
                    col++;
                }
                if(col == Game.TILES_IN_WIDTH){
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("getAccess");
        for(int i=0; i<lvlData.length; i++){
            for(int j=0; j<lvlData[i].length; j++){
                System.out.print(lvlData[i][j]+" ");
            }
            System.out.println();
        }
        return lvlData;
    }
}