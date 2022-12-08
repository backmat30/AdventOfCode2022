package day6Resources;

import java.util.ArrayList;
import java.util.List;

public class Day6 {
    public static void d6Part1(List<String> input){
        List<Character> signal = new ArrayList<>();
        for(char letter: input.get(0).toCharArray()){
            signal.add(letter);
        }
        for(int i = 3; i < signal.size(); i++){
            boolean allDiffer = false;
            List<Character> start = new ArrayList<>();
            for(int j = 3; j >= 0; j--) {
                start.add(signal.get(i - j));
            }

            for(int j = 0; j < start.size(); j++){
                char testLetter = start.remove(j);
                if(start.contains(testLetter)){
                    break;
                }
                start.add(j, testLetter);
                if(j == start.size() - 1){
                    allDiffer = true;
                }
            }
            if(allDiffer){
                System.out.println(i + 1);
                break;
            }
        }

    }
    public static void d6Part2(List<String> input){
        List<Character> signal = new ArrayList<>();
        for(char letter: input.get(0).toCharArray()){
            signal.add(letter);
        }
        for(int i = 13; i < signal.size(); i++){
            boolean allDiffer = false;
            List<Character> start = new ArrayList<>();
            for(int j = 13; j >= 0; j--) {
                start.add(signal.get(i - j));
            }

            for(int j = 0; j < 14; j++){
                char testLetter = start.remove(j);
                if(start.contains(testLetter)){
                    break;
                }
                start.add(j, testLetter);
                if(j == 13){
                    allDiffer = true;
                }
            }
            if(allDiffer){
                System.out.println(i + 1);
                break;
            }
        }

    }
}
