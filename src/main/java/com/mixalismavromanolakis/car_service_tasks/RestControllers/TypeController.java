package com.mixalismavromanolakis.car_service_tasks.RestControllers;

import com.mixalismavromanolakis.car_service_tasks.DTO.TypeDTO;
import com.mixalismavromanolakis.car_service_tasks.Services.TypeService;
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
@Tag(name = "Type Management System", description = "Operations pertaining to types in Type Management System")
public class TypeController {

    @Autowired
    TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @Operation(summary = "View a list of available types")
    @GetMapping(value = "/types", produces = "application/json")
    public ResponseEntity<List<TypeDTO>> getAllTypes() {

        List<TypeDTO> allTypesDTO = typeService.getAllTypes();
        return new ResponseEntity<List<TypeDTO>>(allTypesDTO, HttpStatus.OK);
    }
}
