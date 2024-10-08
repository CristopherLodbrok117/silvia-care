package com.silvia_care.caregivers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caregivers")
public class CaregiverController {

    private CaregiverService service;

    public CaregiverController(CaregiverService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Caregiver>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{requestedId}")
    public ResponseEntity<Caregiver> findById(@PathVariable Long requestedId){
        Caregiver caregiver = service.findById(requestedId);

        return ResponseEntity.ok(caregiver);
    }

    @GetMapping(params = "name")
    public ResponseEntity<Caregiver> findByName(@RequestParam("name") String requestedName) {
        Caregiver caregiver = service.findByName(requestedName);

        return ResponseEntity.ok(caregiver);
    }



    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Caregiver caregiver){
        Boolean connected = service.login(caregiver);

        return ResponseEntity.ok(connected);
    }
}
