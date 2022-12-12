package day11Resources;

import java.util.ArrayList;
import java.util.List;

public class Monkey {
    private List<Long> items = new ArrayList<>();
    private String operation;
    private int testCase;
    private int trueMonkey;
    private int falseMonkey;

    public Monkey(List<Long> items, String operation, int testCase, int trueMonkey, int falseMonkey){
        this.items = items;
        this.operation = operation;
        this.testCase = testCase;
        this.trueMonkey = trueMonkey;
        this.falseMonkey = falseMonkey;
    }

    public List<Long> getItems() {
        return items;
    }

    public void setItems(List<Long> items){
        this.items = items;
    }

    public void addItem(long item){
        items.add(item);
    }

    public void removeItem(int item){
        items.remove(items.indexOf(item));
    }

    public String getOperation() {
        return operation;
    }

    public int getTestCase() {
        return testCase;
    }

    public int getTrueMonkey() {
        return trueMonkey;
    }

    public int getFalseMonkey() {
        return falseMonkey;
    }

    @Override
    public String toString(){
        return items.toString()
                + "\n" + operation
                + " " + testCase
                + " " + trueMonkey
                + " " + falseMonkey;
    }
}
