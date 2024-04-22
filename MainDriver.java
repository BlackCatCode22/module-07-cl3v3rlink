package ZooLanderApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        HashMap<String, Integer> animalCount = new HashMap<>();
        ArrayList<String> hyenaNames = new ArrayList<>();
        ArrayList<String> lionNames = new ArrayList<>();
        ArrayList<String> tigerNames = new ArrayList<>();
        ArrayList<String> bearNames = new ArrayList<>();

        // Load data from arrivingAnimals.txt
        loadAnimalData(animals, hyenaNames, lionNames, tigerNames, bearNames);

        // Generate unique IDs and assign names
        generateIDsAndNames(animals, hyenaNames, lionNames, tigerNames, bearNames);

        // Write the report
        writeReport(animals, animalCount);

        // Print the report to the console
        printReport(animals, animalCount);
    }

    private static void loadAnimalData(ArrayList<Animal> animals, ArrayList<String> hyenaNames, ArrayList<String> lionNames, ArrayList<String> tigerNames, ArrayList<String> bearNames) {
        String filePath = "./src/arrivingAnimals.txt";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                if (parts.length >= 1) {
                    String ageAndSpecies = parts[0];
                    String birthSeason = parts[1];
                    String animalColor = parts[2];
                    String animalWeight = parts[3];
                    String animLocationA = parts[4];
                    String animLocationB = parts[5];

                    String[] ageSpeciesGender = ageAndSpecies.split(" ");
                    int age = Integer.parseInt(ageSpeciesGender[0]);
                    String species = ageSpeciesGender[4];
                    String gender = ageSpeciesGender[3];

                    String birthday = birthSeason.split(" ")[2];
                    String color = animalColor;
                    String weight = animalWeight;
                    String habitat = animLocationA + ", " + animLocationB;
                    String id = "XX00";

                    Animal myAnimal = new Animal(null, age, species, gender, birthday, color, weight, habitat, id);
                    animals.add(myAnimal);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }

        String aFilePath = "./src/animalNames.txt";
        File aFile = new File(aFilePath);

        try (Scanner scanner = new Scanner(aFile)) {
            while (scanner.hasNextLine()) {
                String aLine = scanner.nextLine();

                if (aLine.contains("Hyena")) {
                    scanner.nextLine();
                    String[] myHyenaNamesArray = scanner.nextLine().split(", ");
                    for (String someName : myHyenaNamesArray)
                        hyenaNames.add(someName);
                }

                if (aLine.contains("Lion")) {
                    scanner.nextLine();
                    String[] myLionsNamesArray = scanner.nextLine().split(", ");
                    for (String someName : myLionsNamesArray)
                        lionNames.add(someName);
                }

                if (aLine.contains("Tiger")) {
                    scanner.nextLine();
                    String[] myTigerNamesArray = scanner.nextLine().split(", ");
                    for (String someName : myTigerNamesArray)
                        tigerNames.add(someName);
                }

                if (aLine.contains("Bear ")) {
                    scanner.nextLine();
                    String[] myBearsNamesArray = scanner.nextLine().split(", ");
                    for (String someName : myBearsNamesArray)
                        bearNames.add(someName);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + aFilePath);
            e.printStackTrace();
        }
    }

    private static void generateIDsAndNames(ArrayList<Animal> animals, ArrayList<String> hyenaNames, ArrayList<String> lionNames, ArrayList<String> tigerNames, ArrayList<String> bearNames) {
        int hyID = 1, liID = 1, tiID = 1, beID = 1;

        for (Animal animal : animals) {
            if (animal.getSpecies().equals("hyena")) {
                animal.setName(hyenaNames.get(0));
                animal.setId("Hye0" + hyID++);
                hyenaNames.remove(0);
            }
            if (animal.getSpecies().equals("lion")) {
                animal.setName(lionNames.get(0));
                animal.setId("Li0" + liID++);
                lionNames.remove(0);
            }
            if (animal.getSpecies().equals("tiger")) {
                animal.setName(tigerNames.get(0));
                animal.setId("Tig0" + tiID++);
                tigerNames.remove(0);
            }
            if (animal.getSpecies().equals("bear")) {
                animal.setName(bearNames.get(0));
                animal.setId("Bea0" + beID++);
                bearNames.remove(0);
            }
            String birthCalc = genBirthDay(animal.getAge(), animal.getBirthday());
            animal.setBirthday(birthCalc);
        }
    }

    private static void writeReport(ArrayList<Animal> animals, HashMap<String, Integer> animalCount) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./src/zooPopulation.txt"));
            String animalReport;
            writer.write("  New Animal Report  \n\n");
            writer.write("Hyena Habitat:");
            int lineNumber = 1;

            for (Animal animal : animals) {
                if (lineNumber == 5) {
                    writer.write("\n\nLion Habitat:");
                }
                if (lineNumber == 9) {
                    writer.write("\n\nTiger Habitat:");
                }
                if (lineNumber == 13) {
                    writer.write("\n\nBear B Air Habitat:");
                }

                lineNumber++;

                Random random = new Random();
                int arrivalDay = random.nextInt(30) + 1;
                int arrivalMonth = random.nextInt(12) + 1;
                int arrivalYear = random.nextInt(5) + 2023;
                String arrivingDate = String.format("%02d", arrivalDay) + "/" + String.format("%02d", arrivalMonth) + "/" + arrivalYear;

                animalReport = ("\n" + animal.getId() + ":" + animal.getName() + " : " + "Birthdate: "
                        + animal.getBirthday() + " : " + animal.getColor() + " : " + animal.getWeight()
                        + " : " + animal.getHabitat()) + " : arriving " + arrivingDate;

                writer.write(animalReport);
            }
            writer.write("\n\n" + "Current Species Count: ");
            for (Animal animal : animals) {
                String animalType = animal.getSpecies();
                animalCount.put(animalType, animalCount.getOrDefault(animalType, 0) + 1);
            }
            writer.write(animalCount.toString());
            writer.write("\n" + "Total Number of Animals: " + Animal.numOfAnimals);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printReport(ArrayList<Animal> animals, HashMap<String, Integer> animalCount) {
        try {
            System.out.println("Animal Report:\n");
            System.out.println("   New Animal Report  \n\n");

            int lineNumber = 1;
            for (Animal animal : animals) {
                if (lineNumber == 5) {
                    System.out.println("\nLion Habitat:");
                }
                if (lineNumber == 9) {
                    System.out.println("\nTiger Habitat:");
                }
                if (lineNumber == 13) {
                    System.out.println("\nBear Habitat:");
                }

                lineNumber++;

                Random random = new Random();
                int arrivalDay = random.nextInt(30) + 1;
                int arrivalMonth = random.nextInt(12) + 1;
                int arrivalYear = random.nextInt(5) + 2023;
                String arrivingDate = String.format("%02d", arrivalDay) + "/" + String.format("%02d", arrivalMonth) + "/" + arrivalYear;

                String animalReport = ("\n" + animal.getId() + ":" + animal.getName() + " : " + "Birthdate: "
                        + animal.getBirthday() + " : " + animal.getColor() + " : " + animal.getWeight()
                        + " : " + animal.getHabitat()) + " : arriving " + arrivingDate;

                System.out.println(animalReport);
            }

            System.out.println("\n\nCurrent Species Count: ");
            for (Animal animal : animals) {
                String animalType = animal.getSpecies();
                animalCount.put(animalType, animalCount.getOrDefault(animalType, 0) + 1);
            }
            System.out.println(animalCount.toString());

            System.out.println("\nTotal Number of Animals: " + Animal.numOfAnimals);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String genBirthDay(int animAge, String animBirthday) {
        Random random = new Random();
        String month = "";
        int day = 0;
        int year = 0;
        int birthYear = 0;
        String birthString = "";

        if (animBirthday.equals("spring")) {
            month = "Feb";
            day = random.nextInt(28) + 1;
            year = random.nextInt(10) + 2010;
        } else if (animBirthday.equals("fall")) {
            month = "Aug";
            day = random.nextInt(31) + 1;
            year = random.nextInt(10) + 2010;
        } else if (animBirthday.equals("winter")) {
            month = "Dec";
            day = random.nextInt(31) + 1;
            year = random.nextInt(10) + 2010;
        } else {
            return "Jun 27 1989";
        }

        birthYear = year - animAge;
        birthString = (month + " " + day + ", " + birthYear).toString();
        return birthString;
    }
}
