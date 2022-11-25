package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Direction.*;
import static utilz.HelpMethods.*;

import utilz.LoadSave;
import main.Game;

public class Player extends Entity{
    private BufferedImage[][] heroWalkAni;
    private BufferedImage[][] heroAttack;
    private BufferedImage[] heroIdle;
    private int aniTick, aniIndex;
    private int playerAction = IDLE;
    private int playerDirection = 0;
    private int playerATDirection = 0;
    private boolean left, up, right, down, attacking = false;
    private final int aniSpeed = 20;
    private final float playerSpeed = 1f;
    private int[][] lvlData;
    private float xDrawOffset = 0 * Game.SCALE;
    private float yDrawOffset = 10 * Game.SCALE;
    
    public Player(float x, float y, int width, int height){
        super(x, y, width, height);
        loadAnimations();
        initHitbox(x, y, 16 * Game.SCALE, 16 * Game.SCALE);
    }
    
    public void update(){
        updatePos();
        updateAnimationTick();
        setAnimation();
    }
    
    public void render(Graphics g){
        if(playerAction == IDLE && attacking == false){
            g.drawImage(heroIdle[playerDirection], (int)(hitbox.x-xDrawOffset), (int)(hitbox.y-yDrawOffset), width, height, null);
        }
        else if(attacking){
            g.drawImage(heroAttack[aniIndex][playerATDirection], (int)((hitbox.x-xDrawOffset)-16), (int)(hitbox.y-yDrawOffset), width*2, height, null);
        }
        else{
            g.drawImage(heroWalkAni[aniIndex][playerDirection], (int)(hitbox.x-xDrawOffset), (int)(hitbox.y-yDrawOffset), width, height, null);
        }
    }
    
    private void updateAnimationTick() {
        aniTick++;
        if(aniTick>=aniSpeed){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(playerAction)){
                aniIndex = 0;
                attacking = false;
            }
        }
    }
    public void updatePos(){
        float xSpeed = 0, ySpeed = 0;
        if(!attacking){
            if(left && !right){
                xSpeed = -playerSpeed;
                playerDirection = LEFT;
                playerATDirection = ATLEFT;
            }
            else if(right && !left){
                xSpeed = playerSpeed;
                playerDirection = RIGHT;
                playerATDirection = ATRIGHT;
            }
            if(up && !down){
                ySpeed = -playerSpeed;
                playerDirection = UP;
                playerATDirection = ATUP;
            }
            else if(down && !up){
                ySpeed = playerSpeed;
                playerDirection = DOWN;
                playerATDirection = ATDOWN;
            }
            if (CanMoveHere(hitbox.x + xSpeed, hitbox.y + ySpeed, hitbox.width, hitbox.height, lvlData)) {
		hitbox.x += xSpeed;
		hitbox.y += ySpeed;
            }
        }
    }
    
    private void resetAniTick() {
	aniTick = 0;
	aniIndex = 0;
    }
    
    private void setAnimation(){
        int startAni = playerAction;
        if((up|down|left|right) == true)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
        if(attacking)
            playerAction = ATTACK;
        if (startAni != playerAction)
            resetAniTick(); 
    }
    private void loadAnimations(){
            BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
            heroWalkAni = new BufferedImage[4][4];
            for(int i=0; i<heroWalkAni.length; i++)
                for(int j=0; j<heroWalkAni[i].length; j++)
                    heroWalkAni[i][j] = img.getSubimage(i*16, j*32, 16, 32);
            heroAttack = new BufferedImage[4][4];
            for(int i=0; i<heroAttack.length; i++)
                for(int j=0; j<heroAttack[i].length; j++)
                    heroAttack[i][j] = img.getSubimage(i*32, j*32+128, 32, 32);
            heroIdle = new BufferedImage[4];
            for(int i=0; i<heroIdle.length; i++)
                    heroIdle[i] = img.getSubimage(0, i*32, 16, 32);
    }
    public void loadLvlData(int[][] lvlData) {
	this.lvlData = lvlData;
    }
    public void resetDirBooleans(){
        left = false;
        right = false;
        up = false;
        down = false;
    }
    public void setAttacking(boolean attacking) {
	this.attacking = attacking;
    }
    public boolean getLeft() {
        return left;
    }
    public boolean getUp() {
        return up;
    }
    public boolean getRight() {
        return right;
    }
    public boolean getDown() {
        return down;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }
    public void setUp(boolean up) {
        this.up = up;
    }
    public void setRight(boolean right) {
        this.right = right;
    }
    public void setDown(boolean down) {
        this.down = down;
    }
}
