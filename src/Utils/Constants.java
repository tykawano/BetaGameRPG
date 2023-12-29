package Utils;

public class Constants {
    public static class PlayerConstants{
        public static final int idleDown = 0;
        public static final int walkDown = 1;
        public static final int runDown = 2;
        public static final int chopDown = 3;
        public static final int slashDown = 4;
        public static final int rollDown = 5;
        public static final int idleRight = 6;
        public static final int walkRight = 7;
        public static final int runRight = 8;
        public static final int rollRight = 9;
        public static final int chopRight = 10;
        public static final int slashRight = 11;
        public static final int idleLeft = 12;
        public static final int walkLeft = 13;
        public static final int runLeft = 14;
        public static final int rollLeft = 15;
        public static final int chopLeft = 16;
        public static final int slashLeft = 17;
        public static final int idleUp = 18;
        public static final int walkUp = 19;
        public static final int runUp = 20;
        public static final int chopUp = 21;
        public static final int slashUp = 22;
        public static final int rollUp = 23;
        public static final int death = 24;

        public static int GetPlayerActionFrame(int player_action){
            return switch (player_action) {
                case idleDown, idleRight, idleLeft, idleUp, death -> 11;
                case walkDown, walkRight, walkLeft, walkUp, runDown, runRight, runLeft, runUp, rollDown, rollUp -> 7;
                case slashDown, slashUp -> 6;
                case rollRight, rollLeft -> 5;
                case slashRight, slashLeft -> 4;
                case chopDown, chopRight, chopLeft, chopUp -> 3;
                default -> 1;
            };
        }


    }
}
