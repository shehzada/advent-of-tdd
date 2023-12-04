package org.advent.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.nio.file.Files.lines;

/**
 * Elf that is assigned calories
 */
public class Elf implements Comparable<Elf> {

    private int totalCalories = 0;

    /**
     * Calories carried by the Elf
     *
     * @return total calories
     */
    public int getTotalCalories() {
        return totalCalories;
    }

    /**
     * Adds calories to this elf for carrying
     *
     * @param calories to add to total count for this elf
     */
    public void addCalories(int calories) {
        totalCalories += calories;
    }

    @Override
    public int compareTo(Elf that) {
        return this.getTotalCalories() - that.getTotalCalories();
    }

    public List<Elf> getTotalCaloriesPerElfFromInput() {
        String inputFile = "C:\\Users\\Shehzad Ashraf\\IdeaProjects\\advent-of-tdd_all\\src\\main\\resources\\day1-elf-calories.txt";
        List<Elf> elves = new ArrayList<>();
        elves.add(new Elf());
        try {
            Files.lines(Paths.get(inputFile))
                    .forEach(line -> {
                        if (line.trim().isEmpty()) {
                            elves.add(new Elf());
                        } else {
                            int value = Integer.parseInt(line);
                            elves.get(elves.size() -1).addCalories(value);
                        }
                    });

            IntStream.range(0, elves.size()).forEach(index ->
                    System.out.println("Total for Elve " + (index + 1) + ": " + elves.get(index).getTotalCalories()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elves;
    }
}