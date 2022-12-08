package day7Resources;

import java.util.*;

public class Day7 {
    public static void d7Part1(List<String> commandLine){
        List<Directory> directories = new ArrayList<>();
        Map<Directory, Directory> directoryMap = new LinkedHashMap<>();
        //creates the base directory for "/"
        Directory base = new Directory();
        //instantiates list
        directories.add(base);
        //instantiates hashmap
        directoryMap.put(base, null);

        Directory currentDirectory = base;
        //reads each command
        for(String line : commandLine){
            //splits the line into each word so sizes and names are easier to access
            String[] lineWords = line.split(" ");
            if (line.equals("$ cd ..")) {   //goes back 1 layer
                //list backtrack
                for(Directory directory: directories){
                    if(currentDirectory.getOuter() != null && directory.compare(currentDirectory.getOuter())){
                        currentDirectory = directory;
                        break;
                    }
                }
                //hashmap backtrack
                if(currentDirectory.getOuter() != null){
                    currentDirectory = directoryMap.get(currentDirectory);
                }

            } else if (line.contains("dir ")) {     //adds a new directory
                Directory newDir = new Directory(currentDirectory, lineWords[1]);
                //adding new directory to list
                boolean isNew = true;
                for(Directory directory: directories){
                    isNew = !directory.compare(newDir);
                }
                if(isNew)
                    directories.add(newDir);

                //adding new directory to hashmap
                if(!directoryMap.containsKey(newDir)){
                    directoryMap.put(newDir, currentDirectory);
                }
            } else if(line.contains("$ cd")){       //opens given directory
                for(Directory directory: directories){
                    if(lineWords[2].equals(directory.getName()) && directory.getOuter() != null && currentDirectory == directory.getOuter()){
                        currentDirectory = directory;
                        break;
                    }
                }
                currentDirectory = directoryMap.get(new Directory(currentDirectory, lineWords[2]));
                System.out.println(currentDirectory);
            } else if (!line.contains("$ ")) {
                int fileSize = Integer.parseInt(lineWords[0]);
                currentDirectory.addSize(fileSize);
                //list add file size
                Directory tempDirectory = currentDirectory;
                while(tempDirectory.getOuter() != null){
                    for(Directory directory: directories){
                        if(directory.compare(tempDirectory.getOuter())){
                            directory.addSize(fileSize);
                            tempDirectory = tempDirectory.getOuter();
                            break;
                        }
                    }
                }
                tempDirectory = currentDirectory;
                //hashmap add file size
                while(directoryMap.get(tempDirectory) != null){
                    directoryMap.get(tempDirectory).addSize(fileSize);
                    tempDirectory = directoryMap.get(tempDirectory);
                }
            }
         }
        int total = 0;
        for (Directory directory: directories){
            if(directory.getSize() <= 100000){
                total += directory.getSize();
            }
        }
        System.out.println("List: " + total);
        total = 0;
        for(Map.Entry<Directory, Directory> entry: directoryMap.entrySet()){
            Directory x = entry.getKey();
            if(x.getSize() <= 100000){
                total += x.getSize();
            }
        }
        System.out.println("Hashmap: " + total);
    }
    public static void d7Part2(List<String> commandLine){
        List<Directory> directories = new ArrayList<>();
        directories.add(new Directory());

        Directory currentDirectory = directories.get(0);
        for(String line : commandLine){
            String[] lineWords = line.split(" ");
            if (line.equals("$ cd ..")) {
                for(Directory directory: directories){
                    if(currentDirectory.getOuter() != null && directory.compare(currentDirectory.getOuter())){
                        currentDirectory = directory;
                        break;
                    }
                }

            } else if (line.contains("dir ")) {
                Directory newDir = new Directory(currentDirectory, lineWords[1]);
                boolean isNew = true;
                for(Directory directory: directories){
                    isNew = !directory.compare(newDir);
                }
                if(isNew)
                    directories.add(newDir);
            } else if(line.contains("$ cd")){
                for(Directory directory: directories){
                    if(lineWords[2].equals(directory.getName()) && directory.getOuter() != null && currentDirectory == directory.getOuter()){
                        currentDirectory = directory;
                        break;
                    }
                }
            } else if (!line.contains("$ ")) {
                int fileSize = Integer.parseInt(lineWords[0]);
                currentDirectory.addSize(fileSize);
                Directory tempDirectory = currentDirectory;
                while(tempDirectory.getOuter() != null){
                    for(Directory directory: directories){
                        if(directory.compare(tempDirectory.getOuter())){
                            directory.addSize(fileSize);
                            tempDirectory = tempDirectory.getOuter();
                            break;
                        }
                    }
                }
            }
        }

        int freeSpace = 70000000 - directories.get(0).getSize();
        int neededRoom = 30000000 - freeSpace;

        int minSize = directories.get(0).getSize();
        for(Directory directory: directories){
            int fileSize = directory.getSize();
            if(fileSize >= neededRoom && fileSize < minSize){
                minSize = fileSize;
            }
        }
        System.out.println(minSize);
    }
}
