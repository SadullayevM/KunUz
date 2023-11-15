package com.example.kun_uz.service;

import com.example.kun_uz.dto.ProfileDTO;
import com.example.kun_uz.entity.ProfileEntity;
import com.example.kun_uz.enums.ProfileStatus;
import com.example.kun_uz.exp.AppBadRuquestException;
import com.example.kun_uz.repository.ProfileRepository;
import com.example.kun_uz.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public ProfileDTO create(ProfileDTO dto){
        //TODO checking profile exists

        Optional<ProfileEntity> byEmail = profileRepository.findByEmail(dto.getEmail());
        if (byEmail.isPresent()){
            throw new AppBadRuquestException("profile already exists");
        }
        Optional<ProfileEntity> byPhone = profileRepository.findByPhone(dto.getPhone());
        if (byPhone.isPresent()){
            throw new AppBadRuquestException("profile already exists");
        }

        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setPassword(MD5Util.Encode(dto.getPassword()));
        entity.setPhone(dto.getPhone());
        profileRepository.save(entity);

        dto.setId(entity.getId());
        dto.setCretedDate(entity.getCreatedDate());
        return dto;
    }

    public Boolean update(Integer profileId, ProfileDTO dto){
        ProfileEntity entity = get(profileId);
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        profileRepository.save(entity);
        return Boolean.TRUE;
    }

    public Boolean updateDetail(Integer profileId, ProfileDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findById(profileId);
        if (optional.isEmpty()){
            throw new AppBadRuquestException("Profile not found");
        }
        int row = profileRepository.updateDetail(profileId, dto.getName(), dto.getSurname());
        return Boolean.TRUE;
    }
    public List<ProfileDTO> getList(){
        List<ProfileEntity> entityList = profileRepository.findAllByVisible(Boolean.TRUE);
        List<ProfileDTO> dtoList = new LinkedList<>();
        entityList.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });
        return dtoList;
    }
    public Boolean delete(Integer id) {
        int row = profileRepository.delete(id);
        return row == 1;
    }
    public ProfileEntity get(Integer profileId){
        Optional<ProfileEntity> optional = profileRepository.findById(profileId);
        if (optional.isEmpty()){
            throw new AppBadRuquestException("Profile not found");
        }
        return optional.get();
    }
    public ProfileDTO toDTO(ProfileEntity entity) {
        ProfileDTO dto = new ProfileDTO();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setRole(entity.getRole());
        dto.setProfileStatus(entity.getStatus());
        dto.setRole(entity.getRole());
        dto.setCretedDate(entity.getCreatedDate());
        dto.setPhone(entity.getPhone());
        dto.setEmail(dto.getEmail());
        return dto;
    }
}
