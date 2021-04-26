package garage.service;

import garage.enums.VehicleType;
import org.springframework.stereotype.Service;

@Service
public interface GarageService {

    String newPark(String plate, String color, VehicleType type);

    String leave(int leave);

    String status();
}
