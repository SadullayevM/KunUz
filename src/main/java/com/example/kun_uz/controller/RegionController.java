package com.example.kun_uz.controller;

import com.example.kun_uz.dto.RegionDTO;
import com.example.kun_uz.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @PostMapping("")
    public ResponseEntity<RegionDTO> create(@RequestBody RegionDTO dto){
        return ResponseEntity.ok(regionService.add(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateById(@PathVariable("id") Integer id,
                                              @RequestBody RegionDTO dto){
        return ResponseEntity.ok(regionService.update(id, dto));
    }
}
