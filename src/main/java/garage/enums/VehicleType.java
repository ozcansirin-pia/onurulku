package garage.enums;

public enum VehicleType {
    Car(1, "Car"),
    Jeep(2, "Jeep"),
    Truck(4, "Truck");

    private Integer code;
    private String detail;

    VehicleType(Integer code, String detail) {
        this.code = code;
        this.detail = detail;
    }

    public static VehicleType fromValue(int code) {
        for (VehicleType value: values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
