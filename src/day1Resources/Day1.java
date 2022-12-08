package day1Resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {
    public static void day1Part1(List<String> elfFood){
        int maxCalories = 0;
        int currentSupply = 0;
        for(String food: elfFood){
            if(!food.isEmpty()){
                currentSupply += Integer.parseInt(food);
            }
            else{
                if(currentSupply > maxCalories){
                    maxCalories = currentSupply;
                }
                currentSupply = 0;
            }
        }
        System.out.println(maxCalories);

    }
    public static void day1Part2(List<String> elfFood){
        ArrayList<Integer> caloriesPerElf = new ArrayList<Integer>();
        int currentSupply = 0;
        for(String food: elfFood){
            if(!food.isEmpty()){
                currentSupply += Integer.parseInt(food);
            }
            else{
                caloriesPerElf.add(currentSupply);
                currentSupply = 0;
            }
        }
        Collections.sort(caloriesPerElf);
        Collections.reverse(caloriesPerElf);

        System.out.println(caloriesPerElf.get(0) + caloriesPerElf.get(1) + caloriesPerElf.get(2));
    }
}
