package com.sejenak.be_sejenakapp.repository;

import com.sejenak.be_sejenakapp.vo.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("PenggunaRepository")
public interface PenggunaRepository extends JpaRepository<Pengguna, Integer> {
    Pengguna getUserByUsername(String usrname);

    List<Pengguna> findAll();

    Pengguna getPenggunaById(int id);
    Pengguna findByUsernameAndPassword(String username, String password);

}
