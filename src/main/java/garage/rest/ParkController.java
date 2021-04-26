package garage.rest;

import garage.enums.VehicleType;
import garage.rest.response.ResponseViewModel;
import garage.service.GarageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import garage.enums.ResponseStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@Api(value = "Garage Operations")
@Tag(name = "Garage", description = "The Garage Operations API")
public class ParkController {

    private final GarageService garageService;

    @Autowired
    public ParkController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping("/park")
    @ApiOperation("new parks add")
    public ResponseEntity<ResponseViewModel> newPark(@RequestParam(required = true, name = "plate") String plate,
                        @RequestParam(required = true, name = "color") String color,
                        @RequestParam(required = true, name = "type") VehicleType type) throws Exception {
        ResponseEntity<ResponseViewModel> responseEntity;
        try {
            responseEntity = ResponseEntity.status(200).body(new ResponseViewModel(200,ResponseStatus.SUCCESS, Optional.empty(), this.garageService.newPark(plate, color, type)));
        }
        catch (ResponseStatusException ex){
            responseEntity = ResponseEntity.status(400).body(new ResponseViewModel(400,ResponseStatus.SUCCESS, Optional.of(ex.getMessage()), ""));
        }
        return responseEntity;
    }

    @GetMapping("/leave")
    @ApiOperation("park leave")
    public ResponseEntity<ResponseViewModel> leave(@RequestParam(required = true, name = "leave") int leave) throws Exception {
        ResponseEntity<ResponseViewModel> responseEntity;
        try {
            responseEntity = ResponseEntity.status(200).body(new ResponseViewModel(200,ResponseStatus.SUCCESS, Optional.empty(), this.garageService.leave(leave)));
        }
        catch (ResponseStatusException ex){
            responseEntity = ResponseEntity.status(400).body(new ResponseViewModel(400,ResponseStatus.SUCCESS, Optional.of(ex.getMessage()), ""));
        }
        return responseEntity;
    }

    @GetMapping("/status")
    @ApiOperation("park status")
    public ResponseEntity<ResponseViewModel> status() throws Exception {
        return ResponseEntity.status(200).body(new ResponseViewModel(200,ResponseStatus.SUCCESS, Optional.empty(), this.garageService.status()));
    }
}
