package day3Resources;

import java.util.List;

public class Day3 {
    public static void d3Part1(List<String> rucksacks){
        int total = 0;
        for(String rucksack: rucksacks){
            String comp1 = rucksack.substring(0, rucksack.length() / 2);
            String comp2 = rucksack.substring(rucksack.length() / 2);

            for(int i = 0; i < comp1.length(); i++){
                char currentItem = comp1.charAt(i);
                if(comp2.indexOf(currentItem) > -1){
                    int value = currentItem;
                    if(value > 96) value -= 96;
                    else if (value > 64) value -= 38;
                    total += value;
                    break;
                }
            }
        }
        System.out.println(total);
    }

    public static void d3Part2(List<String> rucksacks){
        int total = 0;
        for(int i = 0; i < rucksacks.size(); i += 3){
            String elf1 = rucksacks.get(i);
            String elf2 = rucksacks.get(i+1);
            String elf3 = rucksacks.get(i+2);

            //loops through elf1 looking for a character that is shared between all 3 elves
            for(int a = 0; a < elf1.length(); a++){
                char currentItem = elf1.charAt(a);
                //checks if the letter at the current index occurs in elf2 and elf3
                if(elf2.indexOf(currentItem) > -1 && elf3.indexOf(currentItem) > -1){
                    //value is set to currentItems ASCII code in decimal
                    int value = currentItem;
                    //a - z is 97 - 122, so it subtracts 96 from the value to switch to 1-26
                    if(value > 96) value -= 96;
                    else if (value > 64) value -= 38;
                    total += value;
                    break;
                }
            }
        }
        System.out.println(total);
    }
}
