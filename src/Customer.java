import java.io.Serializable;

public class Customer implements Serializable {
    private final String name;
    private final String id;

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}