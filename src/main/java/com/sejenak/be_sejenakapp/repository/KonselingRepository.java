package com.sejenak.be_sejenakapp.repository;

import com.sejenak.be_sejenakapp.vo.Konseling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("KonselingRepository")
public interface KonselingRepository extends JpaRepository<Konseling, Integer> {

    List<Konseling> findAll();

    Konseling getKonselingById(int id);
    @Query("SELECT k FROM Konseling k WHERE k.userId = :userId")
    List<Konseling> getKonselingByUserId(@Param("userId") int userId);
}
