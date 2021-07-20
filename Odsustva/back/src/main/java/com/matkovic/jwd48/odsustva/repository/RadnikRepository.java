package com.matkovic.jwd48.odsustva.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matkovic.jwd48.odsustva.model.Radnik;

@Repository
public interface RadnikRepository extends JpaRepository<Radnik,Long>{
	
	Radnik findOneById(Long id);

    @Query("SELECT z FROM Radnik z WHERE " +
            "(:jmbg = NULL OR :jmbg = '' OR (z.jmbg LIKE %:jmbg%)) AND " +
            "(:odeljenjeId = NULL OR z.odeljenje.id = :odeljenjeId)")
	Page<Radnik> search(@Param("odeljenjeId") Long odeljenjeId, @Param("jmbg") String jmbg, Pageable pageable);
    
//    
//    @Query("SELECT SUM(z.bodovi) FROM Zadatak z WHERE (:sprintId != NULL AND z.sprint.id = :sprintId)")
//    Integer sumaBodovaPoSprintu(@Param("sprintId") Long sprintId);
}
