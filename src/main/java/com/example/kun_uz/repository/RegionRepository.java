package com.example.kun_uz.repository;

import com.example.kun_uz.entity.RegionEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends CrudRepository<RegionEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE RegionEntity r SET r.orderNumber =:orderNumber, r.nameEn =:nameEn, r.nameRu =:nameRu, r.nameUz =:nameUz WHERE r.id =:id")
    int updateById(@Param("id") Integer id,@Param("orderNumber") Integer orderNumber,@Param("nameEn") String nameEn,@Param("nameRu") String nameRu,@Param("nameUz") String nameUz);
}
