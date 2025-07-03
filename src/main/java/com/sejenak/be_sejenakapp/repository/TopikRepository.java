package com.sejenak.be_sejenakapp.repository;

import com.sejenak.be_sejenakapp.vo.Pengguna;
import com.sejenak.be_sejenakapp.vo.Topik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TopikRepository")
public interface TopikRepository extends JpaRepository<Topik, Integer> {
    Topik getTopikById(int id);
    List<Topik> findAll();

}
