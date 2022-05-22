package tree;

import java.util.Objects;

public class FloorCeil<T> {

    public T floor;
    public T ceil;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FloorCeil)) return false;
        FloorCeil<?> floorCeil = (FloorCeil<?>) o;
        return floor.equals(floorCeil.floor) && ceil.equals(floorCeil.ceil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floor, ceil);
    }
}
