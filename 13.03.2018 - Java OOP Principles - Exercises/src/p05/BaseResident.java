package p05;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public abstract class BaseResident implements Identifiable {
    private String name;
    private String id;

    protected BaseResident(String name, String id) {
        this.setName(name);
        this.setId(id);
    }

    @Override
    public String getId() {
        return id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setId(String id) {
        this.id = id;
    }
}