package day4Resources;

import java.util.ArrayList;
import java.util.List;

public class Day4 {
    public static void d4Part1(List<String> zones){
        int counter = 0;
        ArrayList<Integer[]> elf1 = new ArrayList<>();
        ArrayList<Integer[]> elf2 = new ArrayList<>();
        for(String zone: zones){
            int start = Integer.parseInt(zone.substring(0, zone.indexOf("-")));
            int end = Integer.parseInt(zone.substring(zone.indexOf("-") + 1, zone.indexOf(",")));
            Integer[] elf1Range = {start, end};
            elf1.add(elf1Range);

            zone = zone.substring(zone.indexOf(",") + 1);
            start = Integer.parseInt(zone.substring(0, zone.indexOf("-")));
            end = Integer.parseInt(zone.substring(zone.indexOf("-") + 1));
            Integer[] elf2Range = {start, end};
            elf2.add(elf2Range);
        }

        for(int i = 0; i < elf1.size(); i++){
            Integer[] elf1Zone = elf1.get(i);
            Integer[] elf2Zone = elf2.get(i);
            if((elf1Zone[0] >= elf2Zone[0] && elf1Zone[1] <= elf2Zone[1]) ||
                    (elf1Zone[0] <= elf2Zone[0] && elf1Zone[1] >= elf2Zone[1])){
                counter += 1;
            }
        }
        System.out.println(counter);
    }

    public static void d4Part2(List<String> zones){
        int counter = 0;
        ArrayList<Integer[]> elf1 = new ArrayList<>();
        ArrayList<Integer[]> elf2 = new ArrayList<>();
        for(String zone: zones){
            int start = Integer.parseInt(zone.substring(0, zone.indexOf("-")));
            int end = Integer.parseInt(zone.substring(zone.indexOf("-") + 1, zone.indexOf(",")));
            Integer[] elf1Range = {start, end};
            elf1.add(elf1Range);

            zone = zone.substring(zone.indexOf(",") + 1);
            start = Integer.parseInt(zone.substring(0, zone.indexOf("-")));
            end = Integer.parseInt(zone.substring(zone.indexOf("-") + 1));
            Integer[] elf2Range = {start, end};
            elf2.add(elf2Range);
        }

        for(int i = 0; i < elf1.size(); i++){
            Integer[] elf1Zone = elf1.get(i);
            Integer[] elf2Zone = elf2.get(i);
            if((elf1Zone[0] <= elf2Zone[0]  && elf1Zone[1] >= elf2Zone[0]) ||
                    (elf2Zone[0] <= elf1Zone[0] && elf2Zone[1] >= elf1Zone[0])){
                counter += 1;
            }
        }
        System.out.println(counter);
    }
}
//---abc---
//---------
