package Utils;

public class Constants {
    public static class PlayerConstants{
        public static final int idleDown = 0;
        public static final int green = 1;
        public static final int white = 2;
        public static final int red = 3;
        public static final int blue = 4;
        public static final int walkDown = 5;
        public static final int runDown = 6;
        public static final int chopDown = 7;
        public static final int slashDown = 8;
        public static final int rollDown = 9;
        public static final int idleRight = 10;
        public static final int walkRight = 11;
        public static final int runRight = 12;
        public static final int rollRight = 13;
        public static final int chopRight = 14;
        public static final int slashRight = 15;
        public static final int idleLeft = 16;
        public static final int walkLeft = 17;
        public static final int runLeft = 18;
        public static final int rollLeft = 19;
        public static final int chopLeft = 20;
        public static final int slashLeft = 21;
        public static final int idleUp = 22;
        public static final int walkUp = 23;
        public static final int runUp = 24;
        public static final int chopUp = 25;
        public static final int slashUp = 26;
        public static final int rollUp = 27;
        public static final int death = 28;

        public static int GetPlayerActionFrame(int player_action){
            return switch (player_action) {
                case green, white, blue,red -> 23;
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
