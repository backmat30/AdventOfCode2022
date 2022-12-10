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
    public static void d10Part2(List<String> commands){
        int x = 1;
        int cycle = 0;
        List<List<String>> screen = new ArrayList<>();
        screen.add(new ArrayList<>());

        for(String command: commands){


            String[] commandWords = command.split(" ");
            if(commandWords[0].equals("addx")){
                final int SCREENHEIGHT = screen.size() - 1;

                if(screen.get(SCREENHEIGHT).size() >= x - 1 && screen.get(SCREENHEIGHT).size() <= x + 1){
                    screen.get(SCREENHEIGHT).add("#");
                } else{
                    screen.get(SCREENHEIGHT).add(" ");
                }
                cycle++;
                if(cycle % 40 == 0){
                    screen.add(new ArrayList<>());
                }
            }
            final int SCREENHEIGHT = screen.size() - 1;
            if(screen.get(SCREENHEIGHT).size() >= x - 1 && screen.get(SCREENHEIGHT).size() <= x + 1){
                screen.get(SCREENHEIGHT).add("#");
            } else{
                screen.get(SCREENHEIGHT).add(" ");
            }


            if(commandWords[0].equals("addx")){

                x += Integer.parseInt(commandWords[1]);
            }
            cycle++;
            if(cycle % 40 == 0){
                screen.add(new ArrayList<>());
            }




        }
        System.out.println("\n\n");
        for(List<String> row: screen){
            for(String pix: row){
                System.out.print(pix);
            }
            System.out.println();
        }
    }
}
