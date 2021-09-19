import java.util.ArrayList;

public class Team {
    private GameObject castle;
    private ArrayList<Character> pieces;
    private GameMap map;

    public Team(int x, int y, GameMap map, int tid) {
        this.map = map;
        // x-2 ~ x+2
        pieces = new ArrayList<>();
        // castle
        castle = new GameObject(100, 15, x, y, tid);
        while (map.setObject(castle) == false) {
            castle = new GameObject(100, 15, x, y, tid);
            castle.changeXandY(3);
        }

        // knight
        Knight a1 = new Knight(100, 10, x, y, tid);
        while (map.setObject(a1) == false) {
            a1 = new Knight(100, 10, x, y, tid);
            a1.changeXandY(4);
        }


        // witch
        Witch w1 = new Witch(100, 20, x, y, tid);
        while (map.setObject(w1) == false) {
            w1 = new Witch(100, 20, x, y, tid);
            w1.changeXandY(4);
        }

        pieces.add(a1);
        pieces.add(w1);
    }

    public void go() {

        // choose one character randomly from pieces
        double chance = Math.random();

        for (Character piece : pieces) {
            if (chance > 0.7) {
                if (piece instanceof Knight) {
                    //attack first, if no enemies, then move
                    ArrayList<GameObject> enemies = map.getEnemy(piece);
                    if (enemies.size() == 0) {
                        System.out.println("Knight move");
                        piece.move(map);
                        break;
                    } else {
                        System.out.println("Knight attack");
                        int random = (int) (Math.random() * enemies.size());
                        GameObject target = enemies.get(random);
                        ((Knight) piece).attack(target);

                    }
                }

                // piece.move();
            } else {
                if (piece instanceof Witch) {
                    ArrayList<GameObject> friends = map.getFriends(piece);
                    if (friends.size() == 0) {
                        System.out.println("Witch move");
                        piece.move(map);
                        break;
                    } else {
                        System.out.println("Witch heal");
                        int random = (int) (Math.random() * friends.size());
                        GameObject target = friends.get(random);
                        ((Witch) piece).heal(target, 20);
                    }
                }
            }
        }

        // remove died pieces from team
        for( int i=pieces.size()-1 ; i>=0 ; i--){
            if( pieces.get(i).getHP()<1){
                map.removeObject(pieces.get(i).gameLocation());
                pieces.remove(i) ;
            }
        }



    }

    public String toString() {
        String info = castle.showInfo();
        info += "\n";
        for (Character piece : pieces) {
            info += piece.showInfo() + "  ";
        }
        return info;
    }

    public int getCastleHP(){
        return castle.getHP();
    }

}
