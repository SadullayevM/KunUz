package com.example.kun_uz.controller;

import com.example.kun_uz.dto.ProfileDTO;
import com.example.kun_uz.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping("")
    public ResponseEntity<ProfileDTO> create(@RequestBody ProfileDTO dto){
        return ResponseEntity.ok(profileService.create(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@RequestBody ProfileDTO dto,
                                         @PathVariable("id") Integer id){
        return ResponseEntity.ok(profileService.update(id, dto));
    }
    @PutMapping("/detail/{id}")
    public ResponseEntity<Boolean> updateDetail(@PathVariable("id") Integer profileId,
                                                @RequestBody ProfileDTO dto){
        return ResponseEntity.ok(profileService.updateDetail(profileId, dto));
    }
    @GetMapping("")
    public ResponseEntity<List<ProfileDTO>> getList(){
        return ResponseEntity.ok(profileService.getList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id){
        return ResponseEntity.ok(profileService.delete(id));
    }
}
