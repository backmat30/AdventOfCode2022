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
        //initial values
        int x = 1;
        int cycle = 0;
        //2D list simulating the screen
        List<List<String>> screen = new ArrayList<>();
        screen.add(new ArrayList<>());

        //runs each command
        for(String command: commands){

            //splits command into the action and amount
            String[] commandWords = command.split(" ");
            if(commandWords[0].equals("addx")){
                //SCREENHEIGHT constant to reduce clutter when grabbing the current row being made
                final int SCREENHEIGHT = screen.size() - 1;

                //checks if the value being added is within the "sprite" x
                if(screen.get(SCREENHEIGHT).size() >= x - 1 && screen.get(SCREENHEIGHT).size() <= x + 1){
                    screen.get(SCREENHEIGHT).add("█");
                } else{
                    screen.get(SCREENHEIGHT).add(" ");
                }
                //cycles then checks if it is the end of a row
                cycle++;
                if(cycle % 40 == 0){
                    screen.add(new ArrayList<>());
                }
            }
            //see lines 55-63
            final int SCREENHEIGHT = screen.size() - 1;
            if(screen.get(SCREENHEIGHT).size() >= x - 1 && screen.get(SCREENHEIGHT).size() <= x + 1){
                screen.get(SCREENHEIGHT).add("█");
            } else{
                screen.get(SCREENHEIGHT).add(" ");
            }

            //moves the position of the sprite if the command given is addx
            if(commandWords[0].equals("addx")){

                x += Integer.parseInt(commandWords[1]);
            }
            //see lines 64-68
            cycle++;
            if(cycle % 40 == 0){
                screen.add(new ArrayList<>());
            }




        }
        //output
        for(List<String> row: screen){
            for(String pix: row){
                System.out.print(pix);
            }
            System.out.println();
        }
    }
}
