package ZooLanderApp;

public class Hyena extends Animal {

    int spots;

    public Hyena(String name, int age, String gender, String birthday, String color, String weight, String habitat,
                 String id, int spots) {
        super(name, age, "Hyena", gender, birthday, color, weight, habitat, id);
        this.spots = spots;
    }

    public int getSpots() {
        return spots;
    }

    public void setSpots(int spots) {
        this.spots = spots;
    }

}