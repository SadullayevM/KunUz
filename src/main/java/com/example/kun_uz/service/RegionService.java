package com.example.kun_uz.service;

import com.example.kun_uz.dto.RegionDTO;
import com.example.kun_uz.entity.RegionEntity;
import com.example.kun_uz.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public RegionDTO add(RegionDTO dto){
        RegionEntity entity = new RegionEntity();
        entity.setOrderNumber(dto.getOrderNumber());
        entity.setNameEn(dto.getNameEn());
        entity.setNameRu(dto.getNameRu());
        entity.setNameUz(dto.getNameUz());
        entity.setCreatedDate(LocalDateTime.now());
        regionRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public Boolean update(Integer id, RegionDTO dto){
        int row = regionRepository.updateById(id, dto.getOrderNumber(), dto.getNameEn(), dto.getNameRu(), dto.getNameUz());
        return row == 1;
    }
}
