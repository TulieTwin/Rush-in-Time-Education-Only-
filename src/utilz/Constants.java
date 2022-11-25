package utilz;

public class Constants {
    public static class Direction{
        public static final int DOWN = 0;
        public static final int RIGHT = 1;
        public static final int UP = 2;
        public static final int LEFT = 3;
        public static final int ATDOWN = 0;
        public static final int ATRIGHT = 2;
        public static final int ATUP = 1;
        public static final int ATLEFT = 3;
    }
    public static class PlayerConstants{
        public static final int WALKDOWN = 0;
        public static final int WALKRIGHT = 1;
        public static final int WALKUP = 2;
        public static final int WALKLEFT = 3;
        public static final int ATTACKDOWN = 0;
        public static final int ATTACKRIGHT = 1;
        public static final int ATTACKUP = 2;
        public static final int ATTACKLEFT = 3;
        public static final int IDLE = 4;
        public static final int RUNNING = 5;
        public static final int ATTACK = 6;
        
        public static int GetSpriteAmount(int player_action){
            switch(player_action){
                case WALKDOWN:
                    return 4;
                case WALKRIGHT:
                    return 4;
                case WALKUP:
                    return 4;
                case WALKLEFT:
                    return 4;
                case RUNNING:
                    return 4;
                case ATTACK:
                    return 4;
                default:
                    return 1;
            }
        }
    }
}
