import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {

        GameMap map = new GameMap(9);

        // A Team : Castle , Knight , Witch
        Team ta = new Team(0, 0, map, 0);
        // B Team : Castle , Knight , Witch
        Team tb = new Team(8, 8, map, 1);

        System.out.println("=============== START ===============");

        // show game info
        System.out.println(ta);
        System.out.print(map);
        System.out.println(tb + "\n\n");

        int round = 0;
        for (boolean roundA = true; ; round++) {
            if (roundA) {
                System.out.println("round TA: " + round);
                ta.go();
                roundA = false;
            } else {
                System.out.println("round TB: " + round);
                tb.go();
                roundA = true;
            }
            if(ta.getCastleHP()<0){
                System.out.println(ta);
                System.out.print(map);
                System.out.println(tb + "\n\n");
                System.out.println("Team B wins");
                break;
            }else if(tb.getCastleHP()<0){
                System.out.println(ta);
                System.out.print(map);
                System.out.println(tb + "\n\n");
                System.out.println("Team A wins");
                break;
            }
            // show game info
            System.out.println(ta);
            System.out.print(map);
            System.out.println(tb + "\n\n");


        }

        //...


    }

    public String toString() {
        String x = "Practice_0725";
        return x;
    }
}








