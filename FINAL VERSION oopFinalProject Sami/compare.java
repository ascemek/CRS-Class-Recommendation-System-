import java.util.Objects;

public class Plane{

    private final String name;
    private final String model;
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
            compare plane = (compare) o;
        return Objects.equals(name, plane.name) && Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model);
    }

    public static void main(String[] args) {
        Plane[][] planes1 
  = new Plane[][] { new Plane[]{new Plane("Plane 1", "A320")}, new Plane[]{new Plane("Plane 2", "B738") }};
Plane[][] planes2 
  = new Plane[][] { new Plane[]{new Plane("Plane 1", "A320")}, new Plane[]{new Plane("Plane 2", "B738") }};
    }
}
