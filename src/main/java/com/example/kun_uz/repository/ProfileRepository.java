package com.example.kun_uz.repository;

import com.example.kun_uz.entity.ProfileEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends CrudRepository<ProfileEntity, Integer> {
    Optional<ProfileEntity> findByEmail(String email);

    Optional<ProfileEntity> findByPhone(String phone);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ProfileEntity p SET p.name =:name AND p.surname =:surname WHERE p.id =:id", nativeQuery = true)
    int updateDetail(@Param("id") Integer profileId,@Param("name") String name, @Param("surname") String surname);

    /*@Transactional
    @Modifying
    @Query(value = "SELECT * FROM ProfileEntity p WHERE p.visible = true", nativeQuery = true)*/
    List<ProfileEntity> findAllByVisible(Boolean visible);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Profile SET visible = false WHERE id =:id", nativeQuery = true)
    int delete(@Param("id") Integer id);
}
