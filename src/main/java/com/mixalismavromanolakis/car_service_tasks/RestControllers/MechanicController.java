package com.mixalismavromanolakis.car_service_tasks.RestControllers;

import com.mixalismavromanolakis.car_service_tasks.DTO.MechanicDTO;
import com.mixalismavromanolakis.car_service_tasks.Entities.Mechanic;
import com.mixalismavromanolakis.car_service_tasks.Services.MechanicService;
import com.mixalismavromanolakis.car_service_tasks.UIConverter.UIConverter;
import com.mixalismavromanolakis.car_service_tasks.UIConverter.UIObjects.UIMechanic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@Tag(name = "Mechanic Management System", description = "Operations pertaining to mechanics in Mechanic Management System")
public class MechanicController {

    @Autowired
    MechanicService mechanicService;

    @Autowired
    UIConverter UIConverter;

    public MechanicController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @Operation(summary = "View a list of available mechanics")
    @GetMapping(value = "/mechanics", produces = "application/json")
    public ResponseEntity<List<MechanicDTO>> getAllMechanics() {

        List<MechanicDTO> allMechanicsDTO = mechanicService.getAllMechanics();
        return new ResponseEntity<List<MechanicDTO>>(allMechanicsDTO, HttpStatus.OK);
    }

    @Operation(summary = "Get a mechanic by first name")
    @GetMapping(value = "/mechanic/firstName/{firstName}", produces = "application/json")
    public ResponseEntity<MechanicDTO> getMechanicByFirstName(@PathVariable String firstName) {

        Mechanic mechanicDTO = mechanicService.findByFirstName(firstName);
        if (mechanicDTO != null) {
            Mechanic mechanic = mechanicDTO;
            MechanicDTO ssmechanicDTO = new MechanicDTO(mechanic);
            return new ResponseEntity<MechanicDTO>(ssmechanicDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No mechanic with first name: " + firstName + " was found.");
        }
    }

    @Operation(summary = "Get a mechanic by last name")
    @GetMapping(value = "mechanic/lastName/{lastName}", produces = "application/json")
    public ResponseEntity<MechanicDTO> getMechanicByLastName(@PathVariable String lastName) {

        Mechanic mechanicDTO = mechanicService.findByLastName(lastName);
        if (mechanicDTO != null) {
            Mechanic mechanic = mechanicDTO;
            MechanicDTO ssmechanicDTO = new MechanicDTO(mechanic);
            return new ResponseEntity<MechanicDTO>(ssmechanicDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No mechanic with last name: " + lastName + " was found.");
        }
    }

    @Operation(summary = "Get a mechanic by email address")
    @GetMapping(value = "mechanic/emailAddress/{emailAddress}", produces = "application/json")
    public ResponseEntity<MechanicDTO> getMechanicByEmailAddress(@PathVariable String emailAddress) {

        Mechanic mechanicDTO = mechanicService.findByEmailAddress(emailAddress);
        if (mechanicDTO != null) {
            Mechanic mechanic = mechanicDTO;
            MechanicDTO ssmechanicDTO = new MechanicDTO(mechanic);
            return new ResponseEntity<MechanicDTO>(ssmechanicDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No mechanic with the email address: " + emailAddress + " was found.");
        }
    }

    @Operation(summary = "Add a new mechanic")
    @PostMapping(value = "add-new-mechanic", consumes = "application/json")
    public ResponseEntity<UIMechanic> createMechanic(@RequestBody MechanicDTO mechanicDTO) {

        Mechanic mechanic = mechanicService.saveMechanic(mechanicDTO);
        UIMechanic uiMechanic = UIConverter.convertMechanicResponse(mechanic);
        return new ResponseEntity<>(uiMechanic, HttpStatus.OK);
    }

    @Operation(summary = "Delete a mechanic by ID")
    @DeleteMapping("/mechanic/{mechanicId}")
    public void deleteMechanicById(@PathVariable Integer mechanicId) {

        mechanicService.deleteMechanicById(mechanicId);
    }

    @Operation(summary = "Update a mechanic by ID")
    @PutMapping(value = "/update-mechanic/{mechanicId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mechanic> updateMechanicById(@PathVariable(name = "mechanicId") Integer mechanicId, @RequestBody MechanicDTO mechanicDTO) {

        Mechanic t = mechanicService.getMechanicById(mechanicId);
        if (t != null) {
            Mechanic mechanic = mechanicService.updateMechanicById(mechanicId, mechanicDTO);//todo save
            return new ResponseEntity<Mechanic>(mechanic, HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find project with the id: " + mechanicId);
        }
    }
}
