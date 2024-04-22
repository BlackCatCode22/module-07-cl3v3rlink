package ZooLanderApp;

public class Tiger extends Animal {

    int stripes;

    public Tiger(String name, int age, String gender, String birthday, String color, String weight, String habitat,
                 String id, int stripes) {
        super(name, age, "Tiger", gender, birthday, color, weight, habitat, id);
        this.stripes = stripes;
    }

    public int getStripes() {
        return stripes;
    }

    public void setStripes(int stripes) {
        this.stripes = stripes;
    }
}