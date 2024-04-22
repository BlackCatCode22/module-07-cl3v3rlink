package ZooLanderApp;

public class Lion extends Animal {

    String maneColor;

    public Lion(String name, int age, String gender, String birthday, String color, String weight, String habitat,
                String id, String maneColor) {
        super(name, age, "Lion", gender, birthday, color, weight, habitat, id);
        this.maneColor = maneColor;
    }

    public String getManeColor() {
        return maneColor;
    }

    public void setManeColor(String maneColor) {
        this.maneColor = maneColor;
    }

}