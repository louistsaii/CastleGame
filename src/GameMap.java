import java.util.ArrayList;
import java.util.Arrays;

class GameMap {
    /*




     */


    private GameObject[][] map;

    public GameMap(int size) {
        map = new GameObject[size][size];
    }

    public GameObject getObject(int x, int y) {
        if (x < 0 || y < 0 || x >= map.length || y >= map.length) {
            return null;
        }
        return map[x][y];
    }

    public String toString() {
//        String y = "========Map========";
        String y = "";
        //        System.out.print("\033[93;100m"+" A "+"\033[m");
//        System.out.print("\033[93;104m"+" A "+"\033[m");
//        System.out.print("\033[93;100m"+" A "+"\033[m");


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                String sym = "   ";
                if (map[i][j] != null) {
                    sym = "" + map[i][j];
                }
                if ((i + j) % 2 == 0) {
                    System.out.print("\033[93;100m" + sym + "\033[m");
                } else {
                    System.out.print("\033[93;104m" + sym + "\033[m");
                }
            }
            System.out.println();
        }
        return y;
    }

    public void removeObject(int[] location) {
        map[location[0]][location[1]] = null;
    }

    public boolean setObject(GameObject obj) {
        int[] loc = obj.gameLocation();
        if (loc[0] < 0 || loc[1] < 0) {
            return false;
        }
        if (loc[0] >= map.length || loc[1] >= map.length) {
            return false;
        }
        if (map[loc[0]][loc[1]] != null) {
            return false;
        }
        map[loc[0]][loc[1]] = obj;

        return true;
    }

    public int getEdgeLength() {
        return map.length;
    }

    public ArrayList<GameObject> getEnemy(GameObject a1) {
        return getNeighbors(a1,false);
    }

    public ArrayList<GameObject> getFriends(GameObject a1) {
        return getNeighbors(a1,true);
    }


    public ArrayList<GameObject> getNeighbors(GameObject a1, boolean isFriend) {
        ArrayList<GameObject> a = new ArrayList<>();
        int[] x = a1.gameLocation();
        int X = x[0];
        int Y = x[1];
        for (int i = X - 1; i < X + 2; i++) {
            for (int j = Y - 1; j < Y + 2; j++) {
                if(i==X && j==Y){
                    continue;
                }
                if (i < 0 || j < 0 || i > 8 || j > 8) {
                    continue;
                }
                if (isFriend == false) {
                    if (map[i][j] != null) {
                        if (map[i][j].getTID() != a1.getTID()) {
                            a.add(map[i][j]);
                        }
                    }
                } else {
                    if (map[i][j] != null && map[i][j] instanceof Knight) {
                        if (map[i][j].getTID() == a1.getTID()) {
                            a.add(map[i][j]);
                        }
                    }
                }

            }
        }
        return a;
    }

}
