public class GameObject {

    private int HP;
    private int DP;
    private int X;
    private int Y;
    private int team = 0; // team-A : 0  , team-B : 0
    String symbol = "⚑";

    public GameObject(int HP, int DP, int X, int Y, int tid) {
        this.HP = HP;
        this.DP = DP;
        this.X = X;
        this.Y = Y;
        this.team = tid;
    }

    public void underAttack() {
        HP = HP - DP;
    }

    public void underHeal(int x) {
        HP = HP + x;
    }

    public int[] gameLocation() {
        int[] x = new int[2];
        x[0] = X;
        x[1] = Y;
        return x;
    }

    public int getHP() {
        return HP;
    }

    public void setLocation(int x, int y){
        X=x;
        Y=y;
    }
//
//    public void changeXandY(int range) {
//
//        int max = range * 2 + 1;
//        int rx = (int) (Math.random() * max) - range;
//        int ry = (int) (Math.random() * max) - range;
//
//        X = X + rx;
//        Y = Y + ry;
//
//    }

    public void changeXandY(int range) {

        int[] mx = {1, 0, -1, 0};
        int[] my = {0, 1, 0, -1};

        double r = Math.random();
        int dir = -1;

        if (team == 0) {
            if (r < 0.4) {
                dir = 0;
            } else if (r < 0.8) {
                dir = 1;
            } else if (r < 0.9) {
                dir = 2;
            } else {
                dir = 3;
            }

        } else {
            if (r < 0.1) {
                dir = 0;
            } else if (r < 0.2) {
                dir = 1;
            } else if (r < 0.6) {
                dir = 2;
            } else {
                dir = 3;
            }
        }

//        System.out.println("DIR" + dir);
        X = X + mx[dir] * range;
        Y = Y + my[dir] * range;
    }


    public String toString() {
        if (team == 0) {
            return "." + symbol + ".";
        } else {
            return " " + symbol + " ";
        }
    }//        System.out.print("\033[93;100m"+" A "+"\033[m");

    //        System.out.print("\033[93;104m"+" A "+"\033[m");
//        System.out.print("\033[93;100m"+" A "+"\033[m");
    public String showInfo() {
        //⚑:100
        return this.toString() + ":" + HP; // ⚑  ⚔ ❉
    }

    public int getTID() {
        return team;
    }
}

