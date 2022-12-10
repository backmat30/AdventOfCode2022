package day10Resources;

import java.util.ArrayList;
import java.util.List;

public class Day10 {
    public static void d10Part1(List<String> commands){
        int x = 1;
        int cycle = 1;
        int totalSignal = 0;

        for(String command: commands){
            if((cycle - 20) % 40 == 0){
                totalSignal += x * cycle;
            }

            String[] commandWords = command.split(" ");
            if(commandWords[0].equals("addx")){
                cycle++;
                if((cycle - 20) % 40 == 0){
                    totalSignal += x * cycle;
                }
                x += Integer.parseInt(commandWords[1]);

            }
            cycle++;



        }
        System.out.println(totalSignal);
    }
}
