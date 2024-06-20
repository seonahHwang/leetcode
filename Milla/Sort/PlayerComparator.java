package Milla.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class PlayerComparator {
    public static void main(String[] args) {
        /*
        * 5
        amy 100
        david 100
        heraldo 50
        aakansha 75
        aleksa 150
        Sample Output

        aleksa 150
        amy 100
        david 100
        aakansha 75
        heraldo 50
        * */
        Player[] player = new Player[5];
        Checker checker = new Checker();

        player[0] = new Player("amy",100);
        player[1] = new Player("david",100);
        player[2] = new Player("heraldo",50);
        player[3] = new Player("aakansha",75);
        player[4] = new Player("aleksa",150);

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        if(a.score != b.score){
            return b.score - a.score; //내림차순 a > b 음수
        }
        return a.name.compareTo(b.name);
    }
}
