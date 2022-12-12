package day11Resources;

import java.util.ArrayList;
import java.util.List;

public class Day11 {
    public static void d11Part1(List<String> monkeyInfo){
        //creates original set of monkeys
        List<Monkey> monkeys = new ArrayList<>();
        for(int i = 1; i < monkeyInfo.size(); i += 7){
            List<String> currentMonkeyInfo = new ArrayList<>();
            for(int j = 0; j < 5; j++){
                currentMonkeyInfo.add(monkeyInfo.get(i + j));
            }

            monkeys.add(createMonkey(currentMonkeyInfo));
        }

        List<Integer> inspections = new ArrayList<>();
        for(int i = 0; i < monkeys.size(); i++){
            inspections.add(0);
        }

        for(int turn = 1; turn <= 20; turn++){
            for(int i = 0; i < monkeys.size(); i++){
                for(long item: monkeys.get(i).getItems()){
                    long result = doOperation(item, monkeys.get(i).getOperation());
                    result /= 3;
                    if(result % monkeys.get(i).getTestCase() == 0){
                        monkeys.get(monkeys.get(i).getTrueMonkey()).addItem(result);
                    }
                    else{
                        monkeys.get(monkeys.get(i).getFalseMonkey()).addItem(result);
                    }

                    inspections.set(i, inspections.get(i) + 1);
                }
                monkeys.get(i).setItems(new ArrayList<>());

            }
        }
        int top = inspections.get(0);
        int second = top;
        for(int inspection: inspections){
            if(inspection > top){
                second = top;
                top = inspection;
            }
        }
        System.out.println(top*second);

    }

    public static void d11Part2(List<String> monkeyInfo){
        //creates original set of monkeys
        List<Monkey> monkeys = new ArrayList<>();
        for(int i = 1; i < monkeyInfo.size(); i += 7){
            List<String> currentMonkeyInfo = new ArrayList<>();
            for(int j = 0; j < 5; j++){
                currentMonkeyInfo.add(monkeyInfo.get(i + j));
            }

            monkeys.add(createMonkey(currentMonkeyInfo));
        }

        int lcm = monkeys.get(0).getTestCase();
        for(int i = 1; i < monkeys.size(); i++){
            lcm *= monkeys.get(i).getTestCase();
        }

        List<Long> inspections = new ArrayList<>();
        for(int i = 0; i < monkeys.size(); i++){
            inspections.add((long)0);
        }

        for(int turn = 1; turn <= 10000; turn++){
            for(int i = 0; i < monkeys.size(); i++){
                for(long item: monkeys.get(i).getItems()){
                    long result = item % lcm;
                     result = doOperation(result, monkeys.get(i).getOperation());
                    if(result % monkeys.get(i).getTestCase() == 0){
                        monkeys.get(monkeys.get(i).getTrueMonkey()).addItem(result);
                    }
                    else{
                        monkeys.get(monkeys.get(i).getFalseMonkey()).addItem(result);
                    }

                    inspections.set(i, inspections.get(i) + 1);
                }
                monkeys.get(i).setItems(new ArrayList<>());

            }

            if(turn == 20 || turn == 1000){
                System.out.println("====Turn " + turn + "====");
                for(long inspection: inspections){
                    System.out.println(inspection);
                }
                System.out.println("\n");
            }
        }
        long top = inspections.get(0);
        long second = top;
        for(long inspection: inspections){
            System.out.println(inspection);
            if(inspection > top){
                second = top;
                top = inspection;
            }
        }
        System.out.println(top*second);
    }

    public static Monkey createMonkey(List<String> monkeyInfo){
        List<Long> items = new ArrayList<>();
        String operation;
        int testCase;
        int trueMonkey;
        int falseMonkey;

        String[] itemLine = monkeyInfo.get(0).trim().split(" ");
        for(int i = 2; i < itemLine.length; i++){
            if(itemLine[i].contains(",")) {
                items.add(Long.parseLong(itemLine[i].substring(0, itemLine[i].indexOf(","))));
            }else{
                items.add(Long.parseLong(itemLine[i]));
            }
        }

        operation = monkeyInfo.get(1).substring(23);

        String[] testLine = monkeyInfo.get(2).trim().split(" ");
        testCase = Integer.parseInt(testLine[3]);

        String[] trueLine = monkeyInfo.get(3).trim().split(" ");
        trueMonkey = Integer.parseInt(trueLine[5]);

        String[] falseLine = monkeyInfo.get(4).trim().split(" ");
        falseMonkey = Integer.parseInt(falseLine[5]);

        return new Monkey(items, operation, testCase, trueMonkey, falseMonkey);
    }

    public static long doOperation(long item, String operation){
        String[] operationWords = operation.split(" ");
        if(operation.contains("*")){
            if(operationWords[1].equals("old")){
                return (long)(item * item);
            }
            else{
                return item * Integer.parseInt(operationWords[1]);
            }
        }
        else if(operation.contains("+")){
            return item + Integer.parseInt(operationWords[1]);
        }

        return item;
    }
}
