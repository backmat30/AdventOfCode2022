package day9Resources;

import java.util.ArrayList;
import java.util.List;

public class Day9 {
    public static void d9Part1(List<String> moves){
        List<Integer> tailXList = new ArrayList<>();
        List<Integer> tailYList = new ArrayList<>();

        int headX = 0;
        int headY = 0;
        int tailX = 0;
        int tailY = 0;
        tailXList.add(tailX);
        tailYList.add(tailY);

        for(String move: moves){
            String[] splitMove = move.split(" ");
//            System.out.println("===" + splitMove[0] + splitMove[1] + "===");
            for(int i = 0; i < Integer.parseInt(splitMove[1]); i++) {
                switch (splitMove[0]) {
                    case "U":
                        headY += 1;
                        break;
                    case "R":
                        headX += 1;
                        break;
                    case "D":
                        headY -= 1;
                        break;
                    case "L":
                        headX -= 1;
                        break;
                }

                int xDist = headX - tailX;
                int yDist = headY - tailY;
                if(xDist > 1){
                    tailX += 1;
                    if(yDist > 0){
                        tailY += 1;
                    } else if (yDist < 0) {
                        tailY -= 1;
                    }
                }
                else if(xDist < -1){
                    tailX -= 1;
                    if(yDist > 0){
                        tailY += 1;
                    } else if (yDist < 0) {
                        tailY -= 1;
                    }
                }


                xDist = headX - tailX;
                yDist = headY - tailY;
                if(yDist > 1){
                    tailY += 1;
                    if(xDist > 0){
                        tailX += 1;
                    } else if (xDist < 0) {
                        tailX -= 1;
                    }
                }
                else if(yDist < -1){
                    tailY -= 1;
                    if(xDist > 0){
                        tailX += 1;
                    } else if (xDist < 0) {
                        tailX -= 1;
                    }
                }
//                System.out.println(tailX + ", " + tailY + " - " + headX + ", " + headY);
                boolean newVal = true;
                for(int j = 0; j < tailXList.size(); j++){
                    if(tailXList.get(j) == tailX && tailYList.get(j) == tailY){
                        newVal = false;
                    }
                }
                if(newVal){
                    tailXList.add(tailX);
                    tailYList.add(tailY);
                }

            }
        }
        System.out.println(tailXList.size());
    }

    public static void d9Part2(List<String> x){

    }
}
