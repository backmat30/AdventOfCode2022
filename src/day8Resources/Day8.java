package day8Resources;

import java.util.ArrayList;
import java.util.List;

public class Day8 {
    public static void d8Part1(List<String> input){
        List<List<Integer>> forest = new ArrayList<>();
        List<List<Boolean>> visibilityChart = new ArrayList<>();
        for(String line: input){
            List<Integer> row = new ArrayList<>();
            List<Boolean> visibilityRow = new ArrayList<>();
            for(char num: line.toCharArray()){
                row.add((int)num - 48);
                visibilityRow.add(false);
            }
            forest.add(row);
            visibilityChart.add(visibilityRow);
        }

        int totalVisible = forest.size() * 2 + forest.get(0).size() * 2 - 4;
        List<Boolean> topAndBottom = new ArrayList<>();
        for(boolean tree: visibilityChart.get(0)){
            topAndBottom.add(true);
        }
        visibilityChart.set(0, topAndBottom);
        visibilityChart.set(visibilityChart.size() - 1, topAndBottom);
        for(List<Boolean> row: visibilityChart){
            row.set(0, true);
            row.set(row.size()-1, true);
        }


        for(int i = 0; i < forest.size(); i++){
            final int RIGHTBOUND = forest.get(i).size() - 1;
            int tallestLeft = forest.get(i).get(0);
            int tallestRight = forest.get(i).get(RIGHTBOUND);
            for(int j = 0; j <= RIGHTBOUND; j++){
                if(forest.get(i).get(j) > tallestLeft){
                    if(!visibilityChart.get(i).get(j))
                        totalVisible += 1;
                    tallestLeft = forest.get(i).get(j);
                    visibilityChart.get(i).set(j, true);
                }
                if(forest.get(i).get(RIGHTBOUND - j) > tallestRight){
                    if(!visibilityChart.get(i).get(RIGHTBOUND - j))
                        totalVisible += 1;
                    tallestRight = forest.get(i).get(RIGHTBOUND - j);
                    visibilityChart.get(i).set(RIGHTBOUND - j, true);
                }
            }
        }

        for(int i = 0; i < forest.get(0).size(); i++){
            final int BOTTOMBOUND = forest.size() - 1;
            int tallestTop = forest.get(0).get(i);
            int tallestBottom = forest.get(BOTTOMBOUND).get(i);
            for(int j = 0; j < forest.size(); j++){
                if(tallestTop != 9 && forest.get(j).get(i) > tallestTop){
                    if(!visibilityChart.get(j).get(i))
                        totalVisible += 1;
                    tallestTop = forest.get(j).get(i);
                    visibilityChart.get(j).set(i, true);
                }
                if(tallestBottom != 9 && forest.get(BOTTOMBOUND - j).get(i) > tallestBottom){
                    if(!visibilityChart.get(BOTTOMBOUND - j).get(i))
                        totalVisible += 1;
                    tallestBottom = forest.get(BOTTOMBOUND - j).get(i);
                    visibilityChart.get(BOTTOMBOUND - j).set(i, true);
                }
            }
        }


        System.out.println(totalVisible);
    }

    public static void d8Part2(List<String> input){
        List<List<Integer>> forest = new ArrayList<>();
        for(String line: input){
            List<Integer> row = new ArrayList<>();
            for(char num: line.toCharArray()){
                row.add((int)num - 48);
            }
            forest.add(row);
        }

        List<List<Integer>> visibilityScores = new ArrayList<>();
        for(int i = 1; i < forest.size() - 1; i++){
            List<Integer> rowScore = new ArrayList<>();
            for(int j = 1; j < forest.get(i).size() - 1; j++){
                int left = -1;
                int right = -1;
                int top = -1;
                int bottom = -1;
                int currentHeight = forest.get(i).get(j);

                for(int k = 1; k < forest.size(); k++){
                    if(left == -1){
                        if(j-k <= 0){
                            left = k;
                        }
                        else if(forest.get(i).get(j-k) >= currentHeight) {
                            left = k;
                            System.out.println(k);
                        }
                    }
                    if(right == -1){
                        if(j+k >= forest.get(i).size() - 1) {
                            right = k;
                        }
                        else if(forest.get(i).get(j+k) >= currentHeight){
                            right = k;
                        }
                    }
                    if(top == -1){
                        if(i-k <=  0) {
                            top = k;
                        }
                        else if(forest.get(i-k).get(j) >= currentHeight){
                            top = k;
                        }
                    }
                    if(bottom == -1){
                        if(i+k >= forest.size() - 1){
                            bottom = k;
                        }
                        else if(forest.get(i+k).get(j) >= currentHeight) {
                            bottom = k;
                        }
                    }
                }
                rowScore.add(left*right*top*bottom);
            }
            visibilityScores.add(rowScore);
        }
        int highScore = 0;
        for(List<Integer> row: visibilityScores){
            for(int score: row){
                if(score > highScore){
                    highScore = score;
                }
            }
        }
        System.out.println(highScore);
    }
}
