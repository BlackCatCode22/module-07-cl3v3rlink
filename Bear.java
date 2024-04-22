package ZooLanderApp;

public class Bear extends Animal {

    int howManyCubs;

    public Bear(String name, int age, String gender, String birthday, String color, String weight, String habitat,
                String id, int howManyCubs) {
        super(name, age, "Bear", gender, birthday, color, weight, habitat, id);
        this.howManyCubs = howManyCubs;

    }

    public int getHowManyCubs() {
        return howManyCubs;
    }

    public void setHowManyCubs(int howManyCubs) {
        this.howManyCubs = howManyCubs;
    }

}