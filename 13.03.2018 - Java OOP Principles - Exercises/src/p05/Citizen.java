package p05;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class Citizen extends BaseResident{
    private int age;

    protected Citizen(String name, int age , String id) {
        super(name, id);
        this.setAge(age);
    }

    private void setAge(int age) {
        this.age = age;
    }
}