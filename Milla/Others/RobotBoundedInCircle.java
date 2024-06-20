package Milla.Others;

public class RobotBoundedInCircle {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
        System.out.println(isRobotBounded("GG"));
        System.out.println(isRobotBounded("GL"));
    }
    public static boolean isRobotBounded(String instructions) {
        int direction[][] = {{0,1},{1,0},{0,-1},{-1,0}}; //북동남서
        int curDir = 0;
        int x = 0;
        int y = 0;
        for (char c : instructions.toCharArray()){
            if(c == 'G'){
                x += direction[curDir][0];
                y += direction[curDir][1];
            }else if(c == 'L'){
                if(curDir == 0) curDir = 3;
                else curDir--;
            }else {
                if(curDir == 3) curDir = 0;
                else curDir++;
            }
        }
        return x == 0 && y == 0 || curDir != 0;
    }
}
