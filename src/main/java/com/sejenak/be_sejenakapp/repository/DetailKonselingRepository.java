package com.sejenak.be_sejenakapp.repository;

import com.sejenak.be_sejenakapp.vo.DetailKonseling;
import com.sejenak.be_sejenakapp.vo.Konseling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DetailKonselingRepository")
public interface DetailKonselingRepository extends JpaRepository<DetailKonseling, Integer> {
    List<DetailKonseling> findAll();

    DetailKonseling getDetailKonselingById(int id);

}
