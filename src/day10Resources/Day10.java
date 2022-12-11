package day10Resources;

import java.util.ArrayList;
import java.util.List;

public class Day10 {
    public static void d10Part1(List<String> commands){
        //defines starting variables
        int x = 1;
        int cycle = 1;
        int totalSignal = 0;

        //cycles through the list of commands
        for(String command: commands){
            //each critical value needed can be modelled on the line 40x + 20, so finds if the cycle is 20 away from a multiple of 40
            if((cycle - 20) % 40 == 0){
                totalSignal += x * cycle;
            }
            //pulls apart the command into the command given and the amount added (if applicable)
            String[] commandWords = command.split(" ");
            if(commandWords[0].equals("addx")){
                //adds another cycle since addx takes 2 cycles
                cycle++;
                //re-checks if it's a critical cycle (see line 15)
                if((cycle - 20) % 40 == 0){
                    totalSignal += x * cycle;
                }
                //changes x by the given amount
                x += Integer.parseInt(commandWords[1]);

            }
            //continues the cycle no matter the command
            cycle++;



        }
        //output
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
                    screen.get(SCREENHEIGHT).add("█");
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
                screen.get(SCREENHEIGHT).add("█");
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
        for(List<String> row: screen){
            for(String pix: row){
                System.out.print(pix);
            }
            System.out.println();
        }
    }
}
