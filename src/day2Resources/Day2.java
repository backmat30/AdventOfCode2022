package day2Resources;

import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static void d2Part1(List<String> rounds){
        int score = 0;
        ArrayList<Integer> enemy = new ArrayList<>();
        ArrayList<Integer> you = new ArrayList<>();

        for(String round: rounds){
            if(round.contains("A")){enemy.add(1);}
            if(round.contains("B")){enemy.add(2);}
            if(round.contains("C")){enemy.add(3);}

            if(round.contains("X")){you.add(1);}
            if(round.contains("Y")){you.add(2);}
            if(round.contains("Z")){you.add(3);}
        }

        for(int i = 0; i < rounds.size(); i++){
            score += you.get(i);
            if(enemy.get(i) % 3 + 1 == you.get(i)){
                score += 6;
            }
            else if(enemy.get(i) == you.get(i)){
                score += 3;
            }
        }
        System.out.println("answer is: " + score);
    }

    public static void d2Part2(List<String> rounds) {
        int score = 0;


        for(String round: rounds){
            int enemyNum = 0;
            if(round.contains("A")){enemyNum = 1;}
            if(round.contains("B")){enemyNum = 2;}
            if(round.contains("C")){enemyNum = 3;}

            if(round.contains("X")){
                if(enemyNum == 1){score += 3;}
                else{
                    score += enemyNum - 1;
                }
            }
            else if(round.contains("Y")){
                score += enemyNum + 3;
            }
            else{
                score += enemyNum % 3 + 7;
            }
        }

        System.out.println(score);
    }
}
