import java.util.Arrays;

public class Character extends GameObject {
    public Character(int HP, int DP, int X, int Y, int tid) {
        super(HP, DP, X, Y, tid);
    }

    public void move(GameMap map) {
        //System.out.println("Move");
        int[] oriLocation = {gameLocation()[0], gameLocation()[1]};
        while (true) {
            this.changeXandY(1);
            boolean ok = map.setObject(this);
            if (ok == true) {
                map.removeObject(oriLocation);
                return;
            }else{
                setLocation(oriLocation[0],oriLocation[1]);
            }
        }
    }


}