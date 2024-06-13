package com.mixalismavromanolakis.car_service_tasks.RestControllers;

import com.mixalismavromanolakis.car_service_tasks.DTO.StatusDTO;
import com.mixalismavromanolakis.car_service_tasks.Services.StatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Status Management System", description = "Operations pertaining to statuses in Status Management System")
public class StatusController {

    @Autowired
    StatusService statusService;

    @Operation(summary = "View a list of available statuses")
    @GetMapping(value = "/status", produces = "application/json")
    public ResponseEntity<List<StatusDTO>> getAllStatus() {

        List<StatusDTO> allStatusDTO = statusService.getAllStatus();
        return new ResponseEntity<List<StatusDTO>>(allStatusDTO, HttpStatus.OK);
    }
}
