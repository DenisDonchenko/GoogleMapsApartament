package org.map.apartament.repository;

import org.map.apartament.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    @Query("select photo from photo photo where photo.flat.id =:flat_id")
    List<Photo> findPhotoByFlatId(@Param("flat_id") Integer id);
}
