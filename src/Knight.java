public class Knight extends Character {

    public Knight(int HP, int DP, int X, int Y, int tid) {
        super(HP, DP, X, Y, tid);
        symbol = "⚔";
    }

    public void attack(GameObject x) {
        x.underAttack();

    }


}
