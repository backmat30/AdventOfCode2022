package day7Resources;

public class Directory {
    private String name;
    private int size;
    private Directory outer;
    public Directory(){
        name = "/";
        size = 0;
    }
    public Directory(Directory outer, String name){
        this.name = name;
        size = 0;
        this.outer = outer;
    }

    public Directory getOuter() {
        return outer;
    }

    public int getSize() {
        return size;
    }

    public void addSize(int size) {
        this.size += size;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        if(outer != null)
            return "Name: " + name + " Size: " + size + " Parent: " + outer.getName();
        return "Name: " + name + " Size: " + size + " Parent: none";
    }

    public boolean compare(Directory directory){
        if(outer != null)
            return name.equals(directory.getName()) && outer.compare(directory.getOuter());
        return name.equals(directory.getName());
    }
}
