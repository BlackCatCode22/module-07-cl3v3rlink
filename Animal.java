package ZooLanderApp;

public class Animal {

    String name;
    int age;
    String species;
    String gender;
    String birthday;
    String color;
    String weight;
    String habitat;
    String id;

    // Global variable specific to Animal class

    public static int numOfAnimals = 0;

    public Animal(String name, int age, String species, String gender, String birthday, String color, String weight,
                  String habitat, String id) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.gender = gender;
        this.birthday = birthday;
        this.color = color;
        this.weight = weight;
        this.habitat = habitat;
        this.id = id;
        numOfAnimals++;
    }

    // Getters

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getColor() {
        return color;
    }

    public String getWeight() {
        return weight;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getId() {
        return id;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setId(String id) {
        this.id = id;
    }

}