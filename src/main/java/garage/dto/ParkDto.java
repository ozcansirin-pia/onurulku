package garage.dto;

import java.io.Serializable;

public class ParkDto implements Serializable {

    public ParkDto(String plate, String color, int size) {
        this.plate = plate;
        this.color = color;
        this.size = size;
    }

    private String plate;
    private String color;
    private int size;

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "plate='" + plate + '\'' + ", color='" + color + '\'' + ", size=" + size + '}';
    }
}
