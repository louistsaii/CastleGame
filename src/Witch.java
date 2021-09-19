public class Witch extends Character {
    public Witch(int HP, int DP, int X, int Y, int tid) {
        super(HP, DP, X, Y, tid);
        symbol = "❉";
    }

    public void heal(GameObject x, int y) {
        x.underHeal(y);
    }

}
