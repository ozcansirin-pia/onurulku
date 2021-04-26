package garage.service.impl;

import garage.dto.ParkDto;
import garage.enums.VehicleType;
import garage.service.GarageService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {

    private static final String SLOT_NUMBER_DOES_NOT_EXISTS = "Ticket Slot number does not exists!";
    private static final String VEHICLE_PLATE_ALREADY_EXISTS = "Vehicle plate already exists!";
    List<ParkDto> parks;

    GarageServiceImpl(){
        this.parks = new ArrayList<>(10);
    }

    @Override
    public String newPark(String plate, String color, VehicleType vehicleType) {
        StringBuilder status = new StringBuilder();

        if (parks.parallelStream().anyMatch(park -> park.getPlate().equals(plate))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, VEHICLE_PLATE_ALREADY_EXISTS);
        }

        if (!(parks.size()+vehicleType.getCode()>10)) {
            for (int i=0 ; i<vehicleType.getCode() ; i++) {
                parks.add(new ParkDto(plate, color, vehicleType.getCode()));
            }
            status.append(vehicleType.getDetail()).append(" allocated ").append(vehicleType.getCode()).append(" slot(s).")
                    .append(" Slot Number: ").append(parks.size() - vehicleType.getCode() + 1);
        }
        else {
            status.append("Garage is full.");
        }
        return status.toString();
    }

    @Override
    public String leave(int leave) {
        if (parks.size()<leave){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, SLOT_NUMBER_DOES_NOT_EXISTS);
        }
        String plateNumber = parks.get(leave-1).getPlate();
        parks.removeIf(park -> park.getPlate().equals(plateNumber));
        return new StringBuilder("Leave: ").append(leave).append(" PlateNumber: ").append(plateNumber).toString();
    }

    @Override
    public String status() {
        StringBuilder status = new StringBuilder();
        String plateNumber = "";

        for(int i = 0 ; i<parks.size() ; i++) {
            if (!plateNumber.equals(parks.get(i).getPlate())){
                if (i != 0) {
                    status.append(" ] }, ");
                }
                plateNumber = parks.get(i).getPlate();
                status.append(parks.get(i).toString()).append(" - Slot Number(s): { ").append(" [ ").append(i+1);
            }
            else {
                status.append(", ").append(i+1);
            }
        }
        if (parks.size()>0){
            status.append(" ] } ");
        }

        return status.toString();
    }
}
