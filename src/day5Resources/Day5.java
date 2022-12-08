package day5Resources;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Day5 {
    public static void d5Part1(List<String> cratesInput, List<String> moves){
        //init starting crate positions
        List<List<String>> cratePos = new ArrayList<>();
        cratePos = setCrates(cratesInput);
        //loops through all given moves
        for(String move: moves){
            //pulls needed values out of the given move
            String[] moveWords = move.split(" ");
            int numMoved = Integer.parseInt(moveWords[1]);
            int takenFrom = Integer.parseInt(moveWords[3]);
            int givenTo = Integer.parseInt(moveWords[5]);

            //gathers crates that will be picked up and moved to another stack
            List<String> cratesBeingMoved = new ArrayList<>();
            for(int i = 1; i <= numMoved; i++){
                //since .remove() returns the item being removed, we can remove a crate from the current pile and
                //add it to the list of crates being moved
                cratesBeingMoved.add(cratePos.get(takenFrom - 1).remove(cratePos.get(takenFrom - 1).size() - 1));
            }
            //moves crates to new stack, first in first out
            for(String crate: cratesBeingMoved){
                cratePos.get(givenTo - 1).add(crate);
            }
        }
        //prints final crate arrangement
        for(List<String> stack: cratePos){
            System.out.println(stack);
        }
    }

    public static void d5Part2(List<String> cratesInput, List<String> moves){
        List<List<String>> cratePos = new ArrayList<>();
        cratePos = setCrates(cratesInput);
        for(String move: moves){
            String[] moveWords = move.split(" ");
            int numMoved = Integer.parseInt(moveWords[1]);
            int takenFrom = Integer.parseInt(moveWords[3]);
            int givenTo = Integer.parseInt(moveWords[5]);

            List<String> cratesBeingMoved = new ArrayList<>();
            for(int i = numMoved; i > 0; i--){
                cratesBeingMoved.add(cratePos.get(takenFrom - 1).remove(cratePos.get(takenFrom - 1).size() - i));
            }
            for(String crate: cratesBeingMoved){
                cratePos.get(givenTo - 1).add(crate);
            }
        }
        for(List<String> stack: cratePos){
            System.out.println(stack);
        }
    }
    //takes the lines of crates as input, then assigns them to a temporary 2d ArrayList and rotates the list
    //allowing for easier access to stacks
    private static @NotNull List<List<String>> setCrates(List<String> input){
        //init lists
        List<List<String>> temp = new ArrayList<>();
        List<List<String>> output = new ArrayList<>();
        //pulls values from the input string and creates a 2D list
        for(String crate: input){
            List<String> row = new ArrayList<>();
            for(int i = 0; i < crate.length(); i+= 4){
                row.add(crate.substring(i+1,i+2));
            }
            temp.add(row);
        }
        //sets output to be the same as temp, rotated 90 degrees clockwise
        for(int i = temp.size() - 1; i >= 0; i--){
            for(int j = 0; j < temp.get(i).size(); j++){
                if(j > output.size() - 1){
                    output.add(new ArrayList<String>());
                }
                //makes sure empty boxes aren't added from the spaces in temp
                if(!temp.get(i).get(j).equals(" ")) {
                    output.get(j).add(temp.get(i).get(j));
                }
            }
        }
        return output;
    }
}
